public class InputParser {

    public static int parseLevel(String input) {
        String[] parts = input.split(":");
        String numberPart = parts[1];

        return Integer.parseInt(numberPart);
    }
}
