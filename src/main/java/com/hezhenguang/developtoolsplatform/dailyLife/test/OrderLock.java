package com.hezhenguang.developtoolsplatform.dailyLife.test;

import javax.naming.InsufficientResourcesException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 解决死锁版本
class Account {
    private int money;

    public Account(int money) {
        this.money = money;
    }

    public void debit(int amount) {
        System.out.println("after debit " + amount + " " + this.money + " -> " + (this.money-amount));
        this.money -= amount;
    }

    public void credit(int amount) {
        System.out.println("after credit " + amount + " " + this.money + " -> " + (this.money+amount));
        this.money += amount;
    }

    public int get() {
        return this.money;
    }
}

public class OrderLock {
    private static final Object tieLock = new Object();

    public void transferMoney( Account fromAcct,  Account toAcct,  int amount)
            throws InsufficientResourcesException {
        class Helper {
            public void transfer() throws InsufficientResourcesException {
                if (fromAcct.get() < amount)
                    throw new InsufficientResourcesException();
                else {
                    fromAcct.debit(amount);
                    toAcct.credit(amount);
                }
            }
        }

        // 转账双方共用这两个账户的对象，否则无法通过下面方式排序下面的锁顺序
        int fromHash = System.identityHashCode(fromAcct);
        int toHash = System.identityHashCode(toAcct);
        System.out.println(Thread.currentThread().getName()+"线程fromHash="+fromHash+"toHash="+toHash);
        if (fromHash < toHash) {
            synchronized (fromAcct) {
                synchronized (toAcct) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAcct) {
                synchronized (fromAcct) {
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (fromAcct) {
                    synchronized (toAcct) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }

    class MyThread implements Runnable {
        private Account fromAcct;
        private Account toAcct;
        private int amount;

        public MyThread(Account fromAcct, Account toAcct, int amount) {
            this.fromAcct = fromAcct;
            this.toAcct = toAcct;
            this.amount = amount;
        }


        @Override
        public void run() {
            try {
                transferMoney(this.fromAcct, this.toAcct, this.amount);
            } catch (InsufficientResourcesException e) {
                System.out.println("操作失败");
            }
        }

    }

    public static void main(String[] args) {
        // 转账双方共用这两个账户对象
        Account fromAcct = new Account(100);
        Account toAcct = new Account(230);
        System.out.println(System.identityHashCode(fromAcct));
        System.out.println(System.identityHashCode(toAcct));

        OrderLock orderLock = new OrderLock();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            if ((i & 1) == 0)
                threadPool.execute(orderLock.new MyThread(fromAcct, toAcct, 10));
                // 注：转账的账户变成了toAcct，被转账的账户变成了fromAcct
            else threadPool.execute(orderLock.new MyThread(toAcct, fromAcct, 10));
        }
    }
}