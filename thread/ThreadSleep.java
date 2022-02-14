public class ThreadSleep {
    public static void main(String[] args) {
        ThreadSleep1 th1 = new ThreadSleep1();
        ThreadSleep2 th2 = new ThreadSleep2();

        th1.start();
        th2.start();

        for (int i = 0; i < 30; i++) {
            try {
                th1.sleep(5000); // Thread.sleep(5000)으로 작성해야 맞음
            } catch (InterruptedException e) {
            }
        }

        System.out.print("<<main 종료>>");
    }
}

class ThreadSleep1 extends Thread{
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
        System.out.print("<<th1 종료>>");
    }
}

class ThreadSleep2 extends Thread{
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
        System.out.print("<<th2 종료>>");
    }
}
