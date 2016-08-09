package action;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;


public class Mainer {

	static Queue<Integer> dl=new ArrayBlockingQueue<Integer>(9);
	public static void main(String[] args)throws IOException {
		String aString="java讲义";
		String bString="java讲义";
				System.out.println(aString==bString);
				Scanner scanner=new Scanner(System.in);
		// TODO Auto-generated method stub
//		String  ire="66666666666666666666666666";
//		String ire2="66666666666666666666666666";
//		BigInteger reBigInteger=changeString(ire2).add(changeString(ire));
//		System.out.println(reBigInteger);
//		SortedMap<String,String> map = null ;
//		map = new TreeMap<String,String>() ;	// 通过子类实例化接口对象
//		map.put("D、jiangker","http://www.jiangker.com/") ;
//		map.put("A、mldn","www.mldn.cn") ;
//		map.put("C、zhinangtuan","www.zhinangtuan.net.cn") ;
//		map.put("B、mldnjava","www.mldnjava.cn") ;
//		System.out.print("第一个元素的内容的key：" + map.firstKey());
//		System.out.println("：对应的值：" + map.get(map.firstKey()));
//		System.out.print("最后一个元素的内容的key：" + map.lastKey());
//		System.out.println("：对应的值：" + map.get(map.lastKey()));
//		System.out.println("返回小于指定范围的集合：");
//		for(Map.Entry<String,String> me:map.headMap("B、mldnjava").entrySet()){
//			System.out.println("\t|- " + me.getKey() + " --> " + me.getValue()) ;
//		}
//		System.out.println("返回大于指定范围的集合：") ;
//		for(Map.Entry<String,String> me:map.tailMap("B、mldnjava").entrySet()){
//			System.out.println("\t|- " + me.getKey() + " --> " + me.getValue()) ;
//		}
//		System.out.println("部分集合：") ;
//		for(Map.Entry<String,String> me:map.subMap("A、mldn","C、zhinangtuan").entrySet()){
//			System.out.println("\t|- " + me.getKey() + " --> " + me.getValue()) ;
//		}
//		try{
//			
//		}catch(Exception e){
//			
//		}
		String strSrc="45",key="56";
		  try {
	            MessageDigest md5 = MessageDigest.getInstance("MD5");
	            md5.update(strSrc.getBytes("UTF8"));            
	            String result="";
	            byte[] temp;
	            temp=md5.digest(key.getBytes("UTF8"));
	            for (byte b : temp) {
		            System.out.print(b+" ");
				}
	            System.out.println();
	    		for (int i=0; i<temp.length; i++){
	    			result+=Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6);
	    		}
	    		System.out.println(result);    		
	        } catch (NoSuchAlgorithmException e) {        	
	        	e.printStackTrace();        	
	        }catch(Exception e)
	        {          e.printStackTrace();
	        }
		System.out.println(Integer.toHexString(111));
		Thread thread=Thread.currentThread();
		thread.setName("this is a thread");
		System.out.println("当前线程："+thread.getPriority());
	}

}
