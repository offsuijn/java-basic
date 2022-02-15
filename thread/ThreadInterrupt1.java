import javax.swing.*;

public class ThreadInterrupt1 {
    public static void main(String[] args) {
        ThreadEx th1 = new ThreadEx();
        th1.start();

        String input = JOptionPane.showInputDialog("입력하세요 : ");
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt();
        System.out.println("isInterrupted() : " + th1.isInterrupted());
    }
}

class ThreadEx extends Thread {
    @Override
    public void run() {
        int i = 10;

        while(i != 0 && !isInterrupted()) {
            System.out.println(i--);
            for(long x = 0; x < 2500000L; x++);
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}
