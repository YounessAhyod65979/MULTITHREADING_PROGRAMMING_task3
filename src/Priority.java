public class Priority implements Runnable {
    int count;
    Thread thread;
    static volatile boolean stop = false;
    static String currentName;

    Priority(String name) {
        thread = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    public void run() {
        System.out.println(thread.getName() + " starts to operate");
        do {
            count++;
            if (!currentName.equals(thread.getName())) {
                currentName = thread.getName();
                System.out.println(currentName + " is executed");
            }
        } while (!stop && count < 10000000);
        stop = true;
        System.out.println("\n" + thread.getName() + " finishes running");
    }
}

