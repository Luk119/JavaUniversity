package laboratory10.Task1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] sizes = {10, 1000, 100000};
        for (int size : sizes) {
            System.out.println("Testing with size: " + size);
            Sorter sorter = new Sorter(size);
            sorter.setDebug(true);

            sorter.doBubbleSort();
            sorter.doInsertionSort();
            sorter.doQuickSort();
            sorter.doJavaSort();
            sorter.doCountingSort();
            sorter.doPriorityQueue();
            System.out.println();
        }

        Sorter sortFile = new Sorter("laboratory10/Task1/input.txt");
        sortFile.setDebug(true);

        sortFile.doBubbleSort();
        sortFile.doInsertionSort();
        sortFile.doQuickSort();
        sortFile.doJavaSort();
        sortFile.doCountingSort();
        sortFile.doPriorityQueue();

        sortFile.saveAs("laboratory10/Task1/sorted.txt");
        System.out.println();
        System.out.println("posortowana tablica z pliku 'input.txt': ");
        sortFile.readFromFile("laboratory10/Task1/sorted.txt");
    }
}

