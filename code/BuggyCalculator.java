public class BuggyCalculator {

    // Intentionally buggy method: sometimes crashes, sometimes returns wrong result
    public static int divide(int a, int b) {
        // BUG 1: possible division by zero (runtime error)
        return a / b;
    }

    public static int sumFirstThree(int[] numbers) {
        // BUG 2: potential ArrayIndexOutOfBoundsException
        int total = 0;
        for (int i = 0; i <= 3; i++) { // off‑by‑one AND assumes at least 4 elements
            total += numbers[i];
        }
        return total;
    }
}

