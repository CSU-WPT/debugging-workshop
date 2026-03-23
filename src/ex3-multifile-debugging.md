# Level 3 – Multi‑File Debugging (≈ 13 minutes)

**Concepts**: stepping between files, multi‑file logic bugs, call stack, unexpected control flow, bad method arguments.

We will work with a tiny “scoreboard” app:

- `GameApp.java` – main program that simulates a few players.
- `Player.java` – represents a player and their scores.
- `ScoreUtils.java` – helper methods with bugs (logic + bad arguments).

---

## 1. Setup the files

Create or open these files and paste in the code.

### `Player.java`

```java
public class Player {
    private String name;
    private int[] scores;

    public Player(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public int[] getScores() {
        return scores;
    }
}
```

### `ScoreUtils.java`

```java
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
```

### `GameApp.java`

```java
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
}
```

Make sure:

- All three files are saved.
- `GameApp.java` contains a `main` method and will be your entry point.

---

## 2. Run and observe

1. Open `GameApp.java`.
2. Click **Run**.

**Expected symptoms**:

- The program may:
  - Print suspicious/incorrect averages.
  - Print wrong best scores (especially for negative or empty sets).
  - Crash with a `NullPointerException` when using the `mystery` player.

Focus on:

- Which output **looks** wrong?
- Where does the stack trace say the null pointer came from?

---

## 3. Step across files with the debugger

Now use the debugger to see **how control flows** between files.

1. Set a breakpoint on the first line of `main` in `GameApp`.
2. Click **Debug**.
3. When paused, click **Step Over** a few times to:
   - Create the players.
   - Reach the first call to `printPlayerStats`.
4. When you reach `printPlayerStats(alice);`, click **Step Into**.

You should now be in `printPlayerStats`:

1. Step until you reach `double avg = ScoreUtils.averageScore(scores);`.
2. Use **Step Into** to jump into `ScoreUtils.averageScore`.
3. Watch `scores.length`, `total`, and the returned value in the Variables panel.

Answer:

- Why is the average too small?
- Which line in which file is the true bug?

---

## 4. Use the call stack to reason about a crash

Trigger the `NullPointerException` on `mystery`:

1. Set a breakpoint on the line `int total = ScoreUtils.totalScore(mystery);` in `main`.
2. Start **Debug** and let execution run to that breakpoint.
3. **Step Into** to enter `ScoreUtils.totalScore`.
4. When the exception occurs, look at:
   - The **current line**.
   - The **Call Stack** panel.

Questions:

- Which expression is actually null?
- How did that null value get there? (Use the call stack to go “up” one frame.)

Fix `totalScore` so that:

- It **does not crash** when `player` is null or `player.getScores()` is null.
- It returns a reasonable value (for example, `0`) in those cases.

Run again to confirm the crash is gone.

---

## 5. Fix the best score logic

Currently, `bestScore` assumes:

- `best` starts at `0`.
- Any score greater than `0` is the best.

This fails when:

- All scores are negative.
- The array is empty.

Use breakpoints and stepping to:

1. Pause inside `bestScore`.
2. Watch how `best` changes as you loop through `scores`.
3. Decide what should happen when `scores` is empty.

Update `bestScore` to:

- Handle empty arrays gracefully (for example, return `0` or a sentinel like `Integer.MIN_VALUE`).
- Correctly track the maximum value even when all scores are negative.

Re‑run the program and check:

- Do the printed “Best” values now match your expectations?

---

## 6. Reflection (Level 3)

Discuss or write:

- How did stepping **between files** help you understand the bugs?
- When reading a stack trace, how do you choose which frame to investigate first?
- How can you prevent null‑related bugs like the one in `totalScore`?

In **Level 4**, you will tackle a more **layered scenario** that combines several types of bugs.

