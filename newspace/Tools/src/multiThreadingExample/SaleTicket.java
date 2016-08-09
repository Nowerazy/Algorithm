package multiThreadingExample;

public class SaleTicket implements Runnable {
	private Ticket tiket;

	public SaleTicket(Ticket tiket) {
		this.tiket = tiket;
	}

	public Ticket getTiket() {
		return tiket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			synchronized (tiket) {
				try {
					if (tiket.total.get() > 0) {
						tiket.total.getAndDecrement();
						tiket.getSalenum().getAndIncrement();
						System.out.println(Thread.currentThread().getName() + "卖出第"+ tiket.getSalenum().get() + "张票");
						Thread.sleep(100);
					} else {
						break;
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}

	}
}
