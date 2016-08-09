package multiThreadingExample;

public class ThreadDome implements Runnable {

	int num = 50;
	String str = new String();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			synchronized (str) {
				if (num > 0) {
					try {
						Thread.sleep(40);
					} catch (Exception e) {
						// TODO: handle exception
						e.getMessage();
					}
					str.notify();
					System.out.println(Thread.currentThread().getName()
							+ "当前计时值为：" + num--);
				} else
					break;
			}
		}
	}

}
