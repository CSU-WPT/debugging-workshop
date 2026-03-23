public class InputParser {

    // Parses level from an input string like "level:3"
    public static int parseLevel(String input) {
        // BUG 1: assumes the string always has "level:" and a valid number
        String[] parts = input.split(":");
        String numberPart = parts[1]; // can throw if input is wrong

        // BUG 2: doesn't trim spaces, can cause NumberFormatException
        return Integer.parseInt(numberPart);
    }
}

