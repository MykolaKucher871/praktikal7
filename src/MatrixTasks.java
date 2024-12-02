import java.util.Random;
import java.util.Scanner;

public class MatrixTasks {

    // Завдання 1
    public static void task1() {
        int[][] pyramid = new int[5][];
        for (int i = 0; i < pyramid.length; i++) {
            pyramid[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                pyramid[i][j] = i + j + 1;
            }
        }

        System.out.println("Піраміда у звичайному порядку:");
        for (int[] row : pyramid) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println("\nПіраміда у зворотному порядку:");
        for (int i = pyramid.length - 1; i >= 0; i--) {
            for (int j = pyramid[i].length - 1; j >= 0; j--) {
                System.out.print(pyramid[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Завдання 2
    public static void task2() {
        Random random = new Random();
        int rows = 4, cols = 4;
        double[][] array = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = random.nextDouble() * 10;
            }
        }

        System.out.println("Оригінальний масив:");
        printArray(array);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i % 2 != 0 || j % 2 != 0) {
                    array[i][j] = Math.sqrt(array[i][j]);
                }
            }
        }

        System.out.println("\nМодифікований масив:");
        printArray(array);
    }

    private static void printArray(double[][] array) {
        for (double[] row : array) {
            for (double value : row) {
                System.out.printf("%.2f ", value);
            }
            System.out.println();
        }
    }

    // Завдання 3
    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        int size = 5;
        int[][] matrix = new int[size][size];

        System.out.println("Введіть елементи матриці 5x5:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int determinant = calculateDeterminant(matrix, size);
        System.out.println("Визначник: " + determinant);
    }

    private static int calculateDeterminant(int[][] matrix, int n) {
        if (n == 1) return matrix[0][0];

        int determinant = 0;
        int sign = 1;

        for (int f = 0; f < n; f++) {
            int[][] temp = new int[n - 1][n - 1];
            for (int i = 1; i < n; i++) {
                int colIndex = 0;
                for (int j = 0; j < n; j++) {
                    if (j != f) {
                        temp[i - 1][colIndex++] = matrix[i][j];
                    }
                }
            }
            determinant += sign * matrix[0][f] * calculateDeterminant(temp, n - 1);
            sign = -sign;
        }

        return determinant;
    }

    // Завдання 4
    public static void task4() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмір матриці: ");
        int size = scanner.nextInt();

        int[][] matrix = new int[size][size];
        Random random = new Random();

        System.out.println("Матриця:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(20) - 10;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Введіть номер рядка: ");
        int row = scanner.nextInt() - 1;
        System.out.print("Введіть номер стовпця: ");
        int col = scanner.nextInt() - 1;

        int[][] minor = getMinor(matrix, row, col);
        System.out.println("Мінор:");
        for (int[] minorRow : minor) {
            for (int value : minorRow) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getMinor(int[][] matrix, int row, int col) {
        int size = matrix.length;
        int[][] minor = new int[size - 1][size - 1];
        int minorRow = 0, minorCol;

        for (int i = 0; i < size; i++) {
            if (i == row) continue;
            minorCol = 0;
            for (int j = 0; j < size; j++) {
                if (j == col) continue;
                minor[minorRow][minorCol++] = matrix[i][j];
            }
            minorRow++;
        }

        return minor;
    }

    // Завдання 5
    public static void task5() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмір матриці: ");
        int size = scanner.nextInt();

        int[][] matrix = new int[size][size];
        Random random = new Random();

        System.out.println("Оригінальна матриця:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(20) - 10;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int[][] transposed = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        System.out.println("Транспонована матриця:");
        for (int[] row : transposed) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Оберіть завдання (1-5):");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> task1();
            case 2 -> task2();
            case 3 -> task3();
            case 4 -> task4();
            case 5 -> task5();
            default -> System.out.println("Некоректний вибір!");
        }
    }
}
