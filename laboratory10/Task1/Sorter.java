package laboratory10.Task1;

import java.io.*;
import java.util.*;

public class Sorter {
    private int[] data; //inty do sortowania
    private boolean debug = false;
    private long comparisons, assignments; //porównania i przypisania

    //wczytywanie z pliku
    public Sorter(String fileName) throws IOException {
        File file = new File(fileName);
        if (file.exists()) {
            loadFromFile(fileName);
        } else {
            throw new FileNotFoundException("Plik " + fileName + " nie istnieje.");
        }
    }

    public Sorter(int n) throws IOException {
        generateRandomData(n, "laboratory10/Task1/test.txt");
    }

    private void loadFromFile(String fileName) throws IOException {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Integer.parseInt(line.trim()));
            }
        }
        data = list.stream().mapToInt(i -> i).toArray();
    }

    private void generateRandomData(int n, String fileName) throws IOException {
        Random rand = new Random();
        data = new int[n];
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < n; i++) {
                data[i] = rand.nextInt(100); //liczby od 0 do 99
                writer.write(data[i] + "\n");
            }
        }
    }

    public void readFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = "r";
             while (line != null){
                line = reader.readLine();
                System.out.println(line);
            }
        }
    }

    public void saveAs(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int num : data) {
                writer.write(num + "\n");
            }
        }
    }

    public void setDebug(boolean b) {
        debug = b;
    }

    private void resetMetrics() {
        comparisons = 0;
        assignments = 0;
    }

    private void logMetrics(String algorithm, long startTime, long endTime) {
        if (debug) {
            long duration = endTime - startTime;
            if(duration > 1000000){
                System.out.printf("%s | %d | %d ms | %d comparisons | %d assignments%n",
                        algorithm, data.length, duration/1000000, comparisons, assignments);
            }else{
                System.out.printf("%s | %d | %d ns | %d comparisons | %d assignments%n",
                        algorithm, data.length, duration, comparisons, assignments);
            }

        }
    }

    public void doBubbleSort() {
        resetMetrics();
        long startTime = System.nanoTime();

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                comparisons++;
                if (data[j] > data[j + 1]) {
                    assignments += 3;
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        logMetrics("BubbleSort", startTime, endTime);
    }

    public void doInsertionSort() {
        resetMetrics();
        long startTime = System.nanoTime();

        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            assignments++;
            int j = i - 1;

            while (j >= 0 && data[j] > key) {
                comparisons++;
                assignments++;
                data[j + 1] = data[j];
                j--;
            }
            comparisons++;
            data[j + 1] = key;
            assignments++;
        }

        long endTime = System.nanoTime();
        logMetrics("InsertionSort", startTime, endTime);
    }

    public void doQuickSort() {
        resetMetrics();
        long startTime = System.nanoTime();
        quickSort(0, data.length - 1);
        long endTime = System.nanoTime();
        logMetrics("QuickSort", startTime, endTime);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = data[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisons++;
            if (data[j] < pivot) {
                i++;
                assignments += 3;
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        assignments += 3;
        int temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;

        return i + 1;
    }

    public void doJavaSort() {
        resetMetrics();
        long startTime = System.nanoTime();
        Arrays.sort(data);
        long endTime = System.nanoTime();
        logMetrics("JavaSort", startTime, endTime);
    }

    public void doCountingSort() {
        resetMetrics();
        long startTime = System.nanoTime();

        int max = Arrays.stream(data).max().orElse(0);
        int[] count = new int[max + 1];
        int[] output = new int[data.length];

        for (int num : data) {
            count[num]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = data.length - 1; i >= 0; i--) {
            output[count[data[i]] - 1] = data[i];
            count[data[i]]--;
        }
        System.arraycopy(output, 0, data, 0, data.length);
        long endTime = System.nanoTime();
        logMetrics("CountingSort", startTime, endTime);
    }

    public void doPriorityQueue() {
        resetMetrics();
        long startTime = System.nanoTime();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : data) {
            queue.add(num);
        }

        int index = 0;
        while (!queue.isEmpty()) {
            data[index++] = queue.poll();
        }
        long endTime = System.nanoTime();
        logMetrics("PriorityQueueSort", startTime, endTime);
    }
}
