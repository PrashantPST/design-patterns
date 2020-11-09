package behavioral.strategy;


interface ISort {

    void sort(int[] input);
}

class BubbleSort implements ISort {

    @Override
    public void sort(int[] input) {
        // Do inefficient sorting in order n squared
    }
}

class MergeSort implements ISort {

    @Override
    public void sort(int[] input) {
        // Do efficient sorting in nlogn
    }
}

class Context {

    private ISort howDoISort;

    public Context(ISort howDoISort) {
        this.howDoISort = howDoISort;
    }

    // Context receives the data from its client
    // and passes it on to the strategy object.
    void sort(int[] numbers) {
        howDoISort.sort(numbers);
    }

    // We can change the sorting algorithm using this setter
    public void setHowDoISort(ISort howDoISort) {
        this.howDoISort = howDoISort;
    }
}

public class Strategy {
    public static void main(String[] args) {
        int[] numbers = new int[1000];

            // Choose the sorting strategy
            BubbleSort bubbleSort = new BubbleSort();
            MergeSort mergeSort = new MergeSort();

            // Context receives the strategy object
            Context context = new Context(bubbleSort);

            // Sort the numbers
            context.sort(numbers);

            context.setHowDoISort(mergeSort);
            context.sort(numbers);

            // Do remaining work
    }
}

/*
This decoupling of the client and the algorithms, allows us to vary the algorithms independent of the client.

java.util.Comparator has the method compare which allows the user to define the algorithm or strategy to compare two objects of the same type.
 */