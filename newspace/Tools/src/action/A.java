package action;

public class A {
	String string="a";
	static {
		System.out.println("我是a静态代码块");
		System.out.println("--------------------------END");
	}
	
	public A() {
		// TODO Auto-generated constructor stub
	System.out.println("a的结构体");
	this.weight="6";
	System.out.println("--------------------------END");
	}
	{
		System.out.println("我是a代码块");
		weight="2";
		System.out.println("--------------------------END");
	}
	String weight = "2.3";
	void afun() {
		// TODO Auto-generated method stub
		System.out.println("我是a类方法afun");
		string="A类方法afun变更string值";
		System.out.println("a类方法afun中打印String值为："+string);
		System.out.println("--------------------------END");
	}
}
