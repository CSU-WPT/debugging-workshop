public class LevelLoader {

    public static int[] loadEnemiesForLevel(int level) {
        if (level == 1) {
            return new int[] {2, 3};
        } else if (level == 2) {
            return new int[] {4, 4, 5};
        } else if (level == 3) {
            return new int[] {10};
        } else {
            return null;
        }
    }

    public static int computeDifficulty(int[] enemies) {
        int enemyCount = (enemies == null) ? 0 : enemies.length;
        int difficulty = 0;

        for (int i = 0; i <= enemies.length; i++) {
            difficulty += enemies[i] * (i + 1);
        }

        return difficulty;
    }
}
