# Solutions & Fixes

This section shows one set of possible fixes for the workshop exercises.  
Your exact solutions may differ slightly as long as they:

- Remove the crashes.
- Produce correct behavior.
- Keep the code readable.

---

## Level 1 – Reading Errors

### `BuggyCalculator.divide`

One reasonable fix:

```java
public static int divide(int a, int b) {
    if (b == 0) {
        // FIX: prevent division by zero and return a safe default
        System.out.println("Cannot divide " + a + " by zero.");
        return 0; // or throw new IllegalArgumentException("b must not be zero");
    }
    return a / b;
}
```

### `BuggyCalculator.sumFirstThree`

Handle short arrays safely:

```java
public static int sumFirstThree(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
        // FIX: handle null or empty arrays without throwing an exception
        return 0;
    }

    int limit = Math.min(3, numbers.length);
    int total = 0;
    for (int i = 0; i < limit; i++) {
        // FIX: stop before we run past the end of the array
        total += numbers[i];
    }
    return total;
}
```

### `BuggyLoop.countUpTo`

If the intent is to count how many numbers from 1 to `n` (inclusive):

```java
public static int countUpTo(int n) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
        // FIX: loop up to and including n so the count matches the intent
        count++;
    }
    return count;
}
```

---

## Level 2 – Debugger Basics

The key fixes here are the same as Level 1, but discovered using:

- Breakpoints.
- Stepping.
- Variable inspection.

See the Level 1 solutions above.

---

## Level 3 – Multi‑File Debugging

### `ScoreUtils.averageScore`

Correct the average calculation:

```java
public static double averageScore(int[] scores) {
    if (scores == null || scores.length == 0) {
        // FIX: avoid dividing by zero and define a default average
        return 0.0;
    }

    int total = 0;
    for (int score : scores) {
        total += score;
    }
    // FIX: divide by the correct length to get an accurate average
    return (double) total / scores.length;
}
```

### `ScoreUtils.bestScore`

Handle empty arrays and negative scores:

```java
public static int bestScore(int[] scores) {
    if (scores == null || scores.length == 0) {
        // FIX: define behavior for empty or null score lists
        return 0; // or throw an exception, depending on requirements
    }

    int best = scores[0];
    for (int i = 1; i < scores.length; i++) {
        // FIX: compare all elements starting from index 1
        if (scores[i] > best) {
            best = scores[i];
        }
    }
    return best;
}
```

### `ScoreUtils.totalScore`

Defensive null handling:

```java
public static int totalScore(Player player) {
    if (player == null || player.getScores() == null) {
        // FIX: return a safe default when player or scores are missing
        return 0;
    }

    int sum = 0;
    for (int s : player.getScores()) {
        sum += s;
    }
    return sum;
}
```

---

## Level 4 – Layered Bugs

### `InputParser.parseLevel`

A safer implementation:

```java
public static int parseLevel(String input) {
    if (input == null) {
        // FIX: handle null input by falling back to level 1
        return 1; // default level
    }

    String trimmed = input.trim(); // e.g., "level: 4"
    String[] parts = trimmed.split(":");
    if (parts.length < 2) {
        // FIX: validate the basic "label:number" format
        return 1; // or throw new IllegalArgumentException("Invalid level format");
    }

    String numberPart = parts[1].trim();

    try {
        // FIX: trim and safely parse the numeric part
        return Integer.parseInt(numberPart);
    } catch (NumberFormatException e) {
        // FIX: use a safe default when parsing fails instead of crashing
        return 1;
    }
}
```

### `LevelLoader.loadEnemiesForLevel`

Return a non‑null array:

```java
public static int[] loadEnemiesForLevel(int level) {
    if (level == 1) {
        return new int[] {2, 3};
    } else if (level == 2) {
        return new int[] {4, 4, 5};
    } else if (level == 3) {
        return new int[] {10};
    } else {
        // FIX: return an empty array instead of null for unknown levels
        return new int[0];
    }
}
```

### `LevelLoader.computeDifficulty`

Fix the off‑by‑one and null handling:

```java
public static int computeDifficulty(int[] enemies) {
    if (enemies == null || enemies.length == 0) {
        // FIX: define a difficulty of 0 when there are no enemies
        return 0;
    }

    int difficulty = 0;
    for (int i = 0; i < enemies.length; i++) {
        // FIX: stop at enemies.length - 1 to avoid going out of bounds
        difficulty += enemies[i] * (i + 1);
    }
    return difficulty;
}
```

---

## Putting it all together

After applying these fixes:

- The programs should compile and run without exceptions.
- The scoreboard should report sensible averages, best scores, and totals.
- The level loader should parse inputs, avoid null issues, and compute difficulty correctly.

If your results differ, use the debugger again to:

- Set breakpoints in the fixed methods.
- Step through and verify that variable values match your expectations.

