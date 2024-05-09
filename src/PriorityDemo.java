public class PriorityDemo {
    public static void main(String[] args) {
        Priority mt1 = new Priority("High priority thread");
        Priority mt2 = new Priority("Thread with low priority");
        Priority mt3 = new Priority("Thread #1 with normal priority");
        Priority mt4 = new Priority("Thread #2 with normal priority");
        Priority mt5 = new Priority("Thread #3 with normal priority");

        mt1.thread.setPriority(Thread.MAX_PRIORITY);
        mt2.thread.setPriority(Thread.MIN_PRIORITY);
        mt3.thread.setPriority(Thread.NORM_PRIORITY);
        mt4.thread.setPriority(Thread.NORM_PRIORITY);
        mt5.thread.setPriority(Thread.NORM_PRIORITY);

        try {
            mt1.thread.start();
            mt2.thread.start();
            mt3.thread.start();
            mt4.thread.start();
            mt5.thread.start();

            mt1.thread.join();
            mt2.thread.join();
            mt3.thread.join();
            mt4.thread.join();
            mt5.thread.join();
        } catch (InterruptedException e) {
            System.out.println("The main thread was interrupted.");
        }

        System.out.println("High priority thread count: " + mt1.count);
        System.out.println("Low priority thread count: " + mt2.count);
        System.out.println("Normal priority thread #1 count: " + mt3.count);
        System.out.println("Normal priority thread #2 count: " + mt4.count);
        System.out.println("Normal priority thread #3 count: " + mt5.count);
    }
}
