package mutithreding;

public class Example1 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start();
        myThread2.start();
    }
}
class MyThread1 extends Thread{
    public void run(){
        for (int i = 1; i <= 1000; i++){
            System.out.println(i);
        }
    }
}
class MyThread2 extends Thread{
    public void run(){
        for (int i = 1000; i > 0; i--){
            System.out.println(i);
        }
    }
}
