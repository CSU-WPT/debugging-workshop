# Level 3 – Multi‑File Debugging (≈ 13 minutes)

**Concepts**: stepping between files, multi‑file logic bugs, call stack, unexpected control flow, bad method arguments.

We will work with a tiny “scoreboard” app:

- `Main.java` – entry point and helpers (`printPlayerStats`).
- `Player.java` – represents a player and their scores.
- `ScoreUtils.java` – helper methods.

OnlineGDB expects the class with `main` to be in **`Main.java`** with `public class Main`. Use a **new** OnlineGDB Java project for Levels 3–4 so you do not have two `main` methods in one project.

---

## 1. Setup the files

Create a **new OnlineGDB Java project** for Level 3. Add these files and paste in the code.

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
```

### `Main.java`

```java
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
```

Make sure:

- All files are saved.
- Only **`Main.java`** contains `public static void main`.

---

## 2. Run and observe

1. Open `Main.java`.
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

1. Set a breakpoint on the first line of `main` in `Main`.
2. Click **Debug**, then the green **Start** button.
3. When paused, click **Step Over** a few times to:
   - Create the players.
   - Reach the first call to `printPlayerStats`.
4. When you reach `printPlayerStats(alice);`, click **Step Into**.

You should now be in `printPlayerStats`:

1. Step until you reach `double avg = ScoreUtils.averageScore(scores);`.
2. Use **Step Into** to jump into `ScoreUtils.averageScore`.
3. In the Variables panel, watch **`scoreLength`**, `total`, and the return value (OnlineGDB does not show array contents reliably).

Answer:

- Why is the average too small?
- Which line in which file is the true bug?

---

## 4. Use the call stack to reason about a crash

Trigger the `NullPointerException` on `mystery`:

1. Set a breakpoint on the line `int total = ScoreUtils.totalScore(mystery);` in `main`.
2. Click **Debug**, then the green **Start** button.
3. Click **Continue** exactly **3** times so execution moves past the three `printPlayerStats` calls and stops on the `mystery` line.
4. When stopped there, click **Step Into** to enter `ScoreUtils.totalScore`.
5. Identify the exact line where the exception occurs, then look at:
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
2. Watch **`scoreLength`** and how `best` changes as you loop through `scores`.
3. Decide what should happen when `scores` is empty.

Update `bestScore` to:

- Handle empty arrays gracefully (for example, return `0` or a sentinel like `Integer.MIN_VALUE`).
- Correctly track the maximum value even when all scores are negative.

Re‑run the program and check:

- Do the printed “Best” values now match your expectations?

---

## 6. Reflection (Level 3)

- How did stepping **between files** help you understand the bugs?
- When reading a stack trace, how do you choose which frame to investigate first?
- How can you prevent null‑related bugs like the one in `totalScore`?

In **Level 4**, you will tackle a more **layered scenario** that combines several types of bugs.
