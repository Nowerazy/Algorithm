package multiThreadingExample;

public class AlterTurn {
	private static Object LOCK = new Object();
    static Info info = new Info(); // 互斥资源
    static int flag = 1; // false for a ,true for b

    public static void main(String[] args) {
        // 两个线程 交替打印字符串
        Thread a = new Thread() {
            public void run() {
                while (info.i < info.printStr.length())
                    synchronized (LOCK) {
                        {
                            if ( flag==1) {
                                flag = 2;
                                info.print("a");
                                LOCK.notifyAll();// 在这里虽然唤醒了另一个线程b，但锁并没有释放
                            }else {
								try {
                                    LOCK.wait();// 在wait后的瞬间线程b得到锁
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
							}
                            
                        }
                    }
                
            };
        };
        Thread b = new Thread() {
            public void run() {
                while (info.i < info.printStr.length())
                    synchronized (LOCK) {
                        {
                        	if ( flag==2) {
                                flag = 3;
                                info.print("b");
                                LOCK.notifyAll();// 在这里虽然唤醒了另一个线程b，但锁并没有释放
                            }else {
								try {
                                    LOCK.wait();// 在wait后的瞬间线程b得到锁
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
							}
                        }
                    }
            };
        };
        Thread c = new Thread() {
            public void run() {
                while (info.i < info.printStr.length())
                    synchronized (LOCK) {
                        {
                        	if ( flag==3) {
                                flag = 1;
                                info.print("c");
                                LOCK.notifyAll();// 在这里虽然唤醒了另一个线程b，但锁并没有释放
                            }else {
								try {
                                    LOCK.wait();// 在wait后的瞬间线程b得到锁
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
							}
                        }
                    }
            };
        };
        a.start();
        b.start();
        c.start();
        try {
			a.join();
			b.join();
            c.join();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
    }


}
