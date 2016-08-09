package multiThreadingExample;

public class Test {
public static void main(String[] args) {
	Ticket tiket=new Ticket("piao");
	SaleTicket t1=new SaleTicket(tiket);
	SaleTicket t2=new SaleTicket(tiket);
	SaleTicket t3=new SaleTicket(tiket);
	Thread th1=new Thread(t1);
	Thread th2=new Thread(t2);
	Thread th3=new Thread(t3);
	th1.start();
	th2.start();
	th3.start();
	try {
		th1.join();
		th2.join();
		th3.join();
	} catch (Exception e) {
		// TODO: handle exception
		e.getStackTrace();
	}
}
}
