package multiThreadingExample;

public class Info {
	String printStr = "i think this.";
    int i = 0;

//    public void print() {
//        if (i < printStr.length()) {
//            System.out.println(Thread.currentThread().getName() + "  print   "
//                    + printStr.charAt(i));
//            i++;
//        }
//    }
    public void print(String g) {
        if (i < 13) {
            System.out.println(Thread.currentThread().getName() + g+"  print   "
                    + i);
            i++;
        }
    }

}
