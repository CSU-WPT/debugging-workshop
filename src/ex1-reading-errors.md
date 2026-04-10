# Level 1 – Reading Errors (≈ 10 minutes)

**Concepts**: compile‑time vs runtime errors, error messages, stack traces, print debugging vs debugger.

We will start with two small files:

- `CalculatorExercises.java`
- `LoopExercises.java`

---

## 1. Setup the files

Create or open these files in OnlineGDB and paste in the code below.

### `CalculatorExercises.java`

```java
public class CalculatorExercises {
    public static int divide(int a, int b) {
        return a / b;
    }

    public static int sumFirstThree(int[] numbers) {
        int numberCount = (numbers == null) ? 0 : numbers.length;
        int total = 0;
        for (int i = 0; i <= 3; i++) {
            total += numbers[i];
        }
        return total;
    }
}
```

### `LoopExercises.java`

```java
public class LoopExercises {
    public static int countUpTo(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            count++;
        }
        return count;
    }
}
```

### `Main.java`

Replace the contents of `Main.java` with:

```java
public class Main {
    public static void main(String[] args) {
        // Example 1: division
        System.out.println("Trying division...");
        int result = CalculatorExercises.divide(10, 0);
        System.out.println("Result: " + result);

        // Example 2: sum first three
        int[] nums = {1, 2};
        System.out.println("Trying sumFirstThree...");
        int sum = CalculatorExercises.sumFirstThree(nums);
        System.out.println("Sum: " + sum);

        // Example 3: loop
        System.out.println("Trying countUpTo(5)...");
        int count = LoopExercises.countUpTo(5);
        System.out.println("Count: " + count);
    }
}
```

---

## 2. Run and observe

1. Open `Main.java`.
2. Click **Run** (not Debug yet).
3. Watch the **Console** output and error messages.

**Expected symptoms**:

- The program should **throw a runtime error** (an exception) on the division line.
- You should see a **stack trace** in the console mentioning:
  - The type of exception.
  - The line number in `CalculatorExercises.java`.
  - The line number in `Main.java` where it was called.

If you fix that and run again, you will later see:

- Another exception from `sumFirstThree`.
- A **logic bug**: `countUpTo(5)` prints the wrong count but does not crash.

---

## 3. Read the error messages

Focus on the first failure (division by zero):

1. Look for the **exception type** (e.g., `java.lang.ArithmeticException`).
2. Find the **message** (e.g., `/ by zero`).
3. Find the **topmost** line from **your code** in the stack trace:
   - It should show `CalculatorExercises.divide` with a line number.
   - It should show `Main.main` with a line number.

Answer (to yourself or a neighbor):

- **Is this a compile‑time error or a runtime error? Why?**
- **Which line in which file is the “root cause” line?**

---

## 4. Quick detective work (no debugger yet)

Without changing anything, ask:

- Why might `b` be zero in `divide`?
- Why might `sumFirstThree` hit an out‑of‑bounds index?

Use **print debugging**:

1. Add `System.out.println("a=" + a + ", b=" + b);` at the start of `divide`.
2. Add `System.out.println("numbers length=" + numbers.length);` at the start of `sumFirstThree`.
3. Run again and see the printed values before the crash.

---

## 5. Fix the obvious runtime bugs

Make the program **stop crashing**, but don’t worry about perfect logic yet.

Suggested changes (try on your own first):

- In `divide`, guard against `b == 0`:
  - Print an error and return 0, or
  - Throw a more descriptive exception.
- In `sumFirstThree`, handle arrays with fewer than 3 elements.

Once you have fixed the crashes:

1. Comment out or remove the temporary `println` calls you added.
2. Run again and confirm there are **no exceptions**.

---

## 6. Find the logic bug

Now focus on `LoopExercises.countUpTo(5)`:

1. What do you **expect** `countUpTo(5)` to return?
2. What does it actually print?
3. Is this a compile‑time error, runtime error, or logic bug?

You can:

- Add a `println` inside the loop to print `i` each time.
- Or (in the next Level) use the debugger to step through it.

---

## 7. Wrap‑up questions (Level 1)

Discuss:

- **What is the difference between a compile‑time error and a runtime exception?**
- **How does the stack trace help you find the root cause?**
- **When is print debugging helpful, and when might it be slower than using a debugger?**

---

## 8. Before Level 2

You will practice the same program again with the **debugger** in Level 2.

**Before you start Level 2**, comment out your Level 1 fixes in `divide`, `sumFirstThree`, and `countUpTo` (use `//` or `/* */`) so the **buggy behavior returns**. In Level 2 you will uncomment those fixes again after the debugger exercises so you do not repeat the same edits from scratch.

