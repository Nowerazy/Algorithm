package action;

public class B extends A {

	public String bString="b";
	{
		System.out.println("我是b代码块");
		System.out.println("--------------------------END");
	}
	static {
		System.out.println("我是b静态代码块");
		System.out.println("--------------------------END");
	}
	public B() {
		// TODO Auto-generated constructor stub
	System.out.println("b的结构体");
	afun();
	System.out.println("--------------------------END");
	}
	 void afun() {
		// TODO Auto-generated method stub
		System.out.println("我是b类方法afun");
		bString="B类方法afun变更bstring值";
		System.out.println("b类方法afun中打印bString值为："+bString);
		System.out.println("--------------------------END");
	}
	
}
