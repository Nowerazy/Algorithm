package multiThreadingExample;

import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {
	public String name;
	public AtomicInteger total=new AtomicInteger(90);
	private AtomicInteger salenum=new AtomicInteger(0);
	
	public Ticket(String name) {
		super();
		this.name = name;
	}
	public AtomicInteger getSalenum() {
		return salenum;
	}
	public void setSalenum(AtomicInteger salenum) {
		this.salenum = salenum;
	}
	
}
