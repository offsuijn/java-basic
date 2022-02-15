import javax.swing.*;

public class ThreadInterrupt2 {
    public static void main(String[] args) {
        ThreadEx1 th1 = new ThreadEx1();
        th1.start();

        String input = JOptionPane.showInputDialog("입력하세요 : ");
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt();
        System.out.println("isInterrupted() : " + th1.isInterrupted());
    }
}

class ThreadEx1 extends Thread {
    @Override
    public void run() {
        int i = 10;

        while(i != 0 && !isInterrupted()) {
            System.out.println(i--);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}
