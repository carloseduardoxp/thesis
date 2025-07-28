class BagFetcher extends Thread {
    private String bag;

    public BagFetcher(String bag) {
        this.bag = bag;
    }

    @Override
    public void run() {
        // Fetch the bag here
        System.out.println("Fetching: " + bag);
    }
}

public class Main {
    public static void main(String[] args) {
        String[] bags = {"Bag1", "Bag2", "Bag3"};

        for (String bag : bags) {
            new BagFetcher(bag).start();
        }
    }
}
