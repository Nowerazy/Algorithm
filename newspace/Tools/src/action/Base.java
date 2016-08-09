package action;


public class Base {

	public int i =2;
	public Base(){
		System.out.println(i);
		displlay();
		System.out.println(this.getClass());
		
	}
	public void displlay(){
		System.out.println(i);
	}
}
