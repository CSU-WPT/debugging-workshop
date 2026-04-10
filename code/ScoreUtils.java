public class ScoreUtils {

    public static double averageScore(int[] scores) {
        int scoreLength = (scores == null) ? 0 : scores.length;
        int total = 0;
        for (int i = 0; i < scoreLength; i++) {
            total += scores[i];
        }
        return (double) total / (scores.length + 1);
    }

    public static int bestScore(int[] scores) {
        int scoreLength = (scores == null) ? 0 : scores.length;
        int best = 0;
        for (int score : scores) {
            if (score > best) {
                best = score;
            }
        }
        return best;
    }

    public static int totalScore(Player player) {
        int[] arr = player.getScores();
        int scoreLength = (arr == null) ? 0 : arr.length;
        int sum = 0;
        for (int s : arr) {
            sum += s;
        }
        return sum;
    }
}
