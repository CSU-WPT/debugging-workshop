public class GameApp {
    public static void main(String[] args) {
        Player alice = new Player("Alice", new int[] {10, 15, 20});
        Player bob = new Player("Bob", new int[] {5, 7});
        Player charlie = new Player("Charlie", new int[] {}); // empty scores

        System.out.println("=== Scoreboard ===");

        printPlayerStats(alice);
        printPlayerStats(bob);
        printPlayerStats(charlie);

        // Intentionally pass a null player to show a null‑related bug
        Player mystery = null;
        System.out.println("\nMystery total score (should handle null):");
        int total = ScoreUtils.totalScore(mystery);
        System.out.println("Total: " + total);

        // Level Loader demo for Level 4
        demoLevels();
    }

    private static void printPlayerStats(Player player) {
        int[] scores = player.getScores();

        double avg = ScoreUtils.averageScore(scores);
        int best = ScoreUtils.bestScore(scores);
        int total = ScoreUtils.totalScore(player);

        System.out.println("Player: " + player.getName());
        System.out.println("  Average: " + avg);
        System.out.println("  Best: " + best);
        System.out.println("  Total: " + total);
        System.out.println();
    }

    private static void demoLevels() {
        System.out.println("=== Level Loader Demo ===");

        String input = "level: 4"; // note the space before 4
        System.out.println("Parsing input: \"" + input + "\"");

        int level = InputParser.parseLevel(input);
        System.out.println("Parsed level: " + level);

        int[] enemies = LevelLoader.loadEnemiesForLevel(level);
        int difficulty = LevelLoader.computeDifficulty(enemies);

        System.out.println("Total difficulty for level " + level + ": " + difficulty);
    }
}

