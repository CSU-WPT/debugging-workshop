public class Main {
    public static void main(String[] args) {
        System.out.println("Trying division...");
        int result = CalculatorExercises.divide(10, 0);
        System.out.println("Result: " + result);

        int[] nums = {1, 2};
        System.out.println("Trying sumFirstThree...");
        int sum = CalculatorExercises.sumFirstThree(nums);
        System.out.println("Sum: " + sum);

        System.out.println("Trying countUpTo(5)...");
        int count = LoopExercises.countUpTo(5);
        System.out.println("Count: " + count);
    }
}
