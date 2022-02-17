package java_thread;

public class ThreadJoin2 {
    public static void main(String[] args) {
        Thread1 gc = new Thread1();
        gc.setDaemon(true);
        gc.start();

        int requiredMemory = 0;

        for(int i = 0; i < 20; i++) {
            requiredMemory = (int) (Math.random() * 10) * 20;

            if(gc.freeMemory() < requiredMemory
                    || gc.freeMemory() < gc.totalMemory() * 0.4) {
                gc.interrupt();

                try {
                    gc.join(100); // gc가 수행될 시간 확보
                } catch(InterruptedException e) {}
            }

            gc.usedMemory += requiredMemory;
            System.out.println("usedMemory : " + gc.usedMemory);
        }
    }
}
