public class Main {
    public static void main(String[] args) {
        Player alice = new Player("Alice", new int[] {10, 15, 20});
        Player bob = new Player("Bob", new int[] {5, 7});
        Player charlie = new Player("Charlie", new int[] {});

        System.out.println("=== Scoreboard ===");

        printPlayerStats(alice);
        printPlayerStats(bob);
        printPlayerStats(charlie);

        Player mystery = null;
        System.out.println("\nMystery total score (should handle null):");
        int total = ScoreUtils.totalScore(mystery);
        System.out.println("Total: " + total);
    }

    private static void printPlayerStats(Player player) {
        int[] scores = player.getScores();
        int scoreLength = (scores == null) ? 0 : scores.length;

        double avg = ScoreUtils.averageScore(scores);
        int best = ScoreUtils.bestScore(scores);
        int lineTotal = ScoreUtils.totalScore(player);

        System.out.println("Player: " + player.getName());
        System.out.println("  Average: " + avg);
        System.out.println("  Best: " + best);
        System.out.println("  Total: " + lineTotal);
        System.out.println();
    }
}
