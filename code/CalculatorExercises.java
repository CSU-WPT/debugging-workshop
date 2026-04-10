public class CalculatorExercises {
    public static int divide(int a, int b) {
        return a / b;
    }

    public static int sumFirstThree(int[] numbers) {
        int numberCount = (numbers == null) ? 0 : numbers.length;
        int total = 0;
        for (int i = 0; i <= 3; i++) {
            total += numbers[i];
        }
        return total;
    }
}
