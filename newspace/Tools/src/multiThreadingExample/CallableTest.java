package multiThreadingExample;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable<Integer> {

	private int times =8;
	private int amount;
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		while (times>0) {
			System.out.println("计时中。。。。。"+Thread.currentThread());
			amount++;
			times--;
			Thread.sleep(1000);
		}
		return amount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallableTest test = new CallableTest();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(test);
		new Thread(futureTask,"第二个进程").start();
		while(!futureTask.isDone()){
			try {
				System.out.println("查看计时器。。。"+Thread.currentThread());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		System.out.println("查看计时try暂时结束"+Thread.currentThread());
		int amount;
		try {
			amount =futureTask.get();
			System.out.println("计时完成，最终返回的结果为："+amount+Thread.currentThread());
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (ExecutionException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
