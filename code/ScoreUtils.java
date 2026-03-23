public class ScoreUtils {

    // BUG 1: incorrect average calculation (logic bug)
    public static double averageScore(int[] scores) {
        int total = 0;
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }
        // BUG: divides by (length + 1), making average too small
        return (double) total / (scores.length + 1);
    }

    // BUG 2: unexpected control flow when scores is empty
    public static int bestScore(int[] scores) {
        // BUG: returns 0 even if there are negative scores or empty array
        int best = 0;
        for (int score : scores) {
            if (score > best) {
                best = score;
            }
        }
        return best;
    }

    // BUG 3: bad method arguments / null handling
    public static int totalScore(Player player) {
        // BUG: does not guard against null player or null scores
        int sum = 0;
        for (int s : player.getScores()) {
            sum += s;
        }
        return sum;
    }
}

