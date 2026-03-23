public class LevelLoader {

    // Returns an array of enemy counts for the given level.
    public static int[] loadEnemiesForLevel(int level) {
        if (level == 1) {
            return new int[] {2, 3};
        } else if (level == 2) {
            return new int[] {4, 4, 5};
        } else if (level == 3) {
            return new int[] {10};
        } else {
            // BUG 3: unexpected control flow – returns null instead of empty array
            return null;
        }
    }

    // Computes a "difficulty" score from enemy counts.
    public static int computeDifficulty(int[] enemies) {
        int difficulty = 0;

        // BUG 4: off‑by‑one and assumes enemies is never null
        for (int i = 0; i <= enemies.length; i++) {
            difficulty += enemies[i] * (i + 1);
        }

        return difficulty;
    }
}

