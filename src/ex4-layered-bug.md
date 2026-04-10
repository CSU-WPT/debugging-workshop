# Level 4 – Layered Bugs (≈ 10 minutes, stretch)

**Concepts**: layered bugs, unexpected control flow, combining debugger tools, fixing bugs without breaking other behavior.

This Level uses a small “level loader” that:

- Reads a level number from a (fake) string.
- Loads some enemy counts.
- Computes total difficulty.

The code has:

- A **runtime bug** (exception).
- A **logic bug**.
- A bug where **stepping into another file** is useful.

---

## 1. Setup the files

We’ll add two more files:

- `LevelLoader.java`
- `InputParser.java`

### `InputParser.java`

```java
public class InputParser {

    public static int parseLevel(String input) {
        String[] parts = input.split(":");
        String numberPart = parts[1];

        return Integer.parseInt(numberPart);
    }
}
```

### `LevelLoader.java`

```java
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
```

### Update `Main.java`

Add this method to the bottom of `Main` (inside the class, after `printPlayerStats`):

```java
    private static void demoLevels() {
        System.out.println("=== Level Loader Demo ===");

        String input = "level: 4";
        System.out.println("Parsing input: \"" + input + "\"");

        int level = InputParser.parseLevel(input);
        System.out.println("Parsed level: " + level);

        int[] enemies = LevelLoader.loadEnemiesForLevel(level);
        int enemyCount = (enemies == null) ? 0 : enemies.length;
        int difficulty = LevelLoader.computeDifficulty(enemies);

        System.out.println("Total difficulty for level " + level + ": " + difficulty);
    }
```

`enemyCount` is there so you can inspect length in the debugger (OnlineGDB does not show array length reliably).

Then, in `main`, after the `mystery` player block, add:

```java
        demoLevels();
```

Make sure `Main.java` now:

- Uses `Player`, `ScoreUtils`, `LevelLoader`, and `InputParser`.

---

## 2. Run and observe

1. Open `Main.java`.
2. Click **Run**.

**Expected symptoms**:

- The scoreboard section should behave as in Level 3 (assuming you fixed it).
- The Level Loader demo will likely:
  - Throw a `NumberFormatException` or `NullPointerException`.
  - Or print a strange difficulty.

Look at:

- The **exception type**.
- The **stack trace**: which method and line caused it?

---

## 3. Step through the layered flow

Use the debugger to trace the whole path:

1. Set a breakpoint at the first line of `demoLevels`.
2. Click **Debug**.
3. Click the green **Start** button.
4. When paused:
   - **Step Over** the print statements.
   - Use **Step Into** on `InputParser.parseLevel(input)`.

Inside `parseLevel`:

1. Inspect `input`, `parts`, and `numberPart`.
2. Step line-by-line and identify exactly where and why the first failure happens.

Once you understand the problem, stop debugging and **fix `parseLevel`** to:

- Validate the input format.
- Trim whitespace.
- Return a reasonable default (for example `1`) or throw a clearer exception.

Run again with the debugger to confirm the parsing step works.

---

## 4. Follow the next bug after parse is fixed

Next, set a breakpoint on:

```java
int[] enemies = LevelLoader.loadEnemiesForLevel(level);
```

1. Debug again and **Step Into** `LevelLoader.loadEnemiesForLevel`.
2. For the given `level`, see which branch runs and what it returns.
3. Fix the null issue you observe first.
4. Re-run Debug and Start.
5. Step back to `demoLevels` and then **Step Into** `computeDifficulty`.

Inside `computeDifficulty` (only **after** the null-related issue is fixed):

1. Watch the values of `i`, **`enemyCount`** (the local `int` in `computeDifficulty`), and `difficulty`.
2. See what happens when `i` reaches the same value as `enemyCount`.
3. Use that to isolate the loop issue.

Fix the bugs by:

- Making `loadEnemiesForLevel` return a **non‑null** array, even for unknown levels (for example, an empty `int[]`).
- Adjusting the `for` loop in `computeDifficulty` so it:
  - Does not go out of bounds.
  - Handles `enemies` being null or empty safely.

Re‑run and confirm:

- No exceptions occur.
- The printed difficulty matches your expectations.

---

## 5. Avoid introducing new bugs

After each fix, **re‑run the whole program**, not just the Level Loader demo:

- Check that:
  - The scoreboard output (from Level 3) still looks correct.
  - No new exceptions appear.

This is a realistic part of debugging:

- Fix one bug.
- Run the full program.
- Make sure you didn’t break something else.

---

## 6. Reflection (Level 4)

Short prompts:

- What kinds of bugs did you see in this Level (compile‑time, runtime, logic)?
- How did stepping **into** helper methods (`parseLevel`, `loadEnemiesForLevel`, `computeDifficulty`) help?
- What habits can help avoid layered bugs (e.g., validating inputs, returning empty collections instead of null)?

You can compare your fixes to the suggested ones in **Solutions & Fixes**.

