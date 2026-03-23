# Level 2 – Debugger Basics (≈ 12 minutes)

**Concepts**: breakpoints, stepping over/into/out, variable inspection, tracking changing state, logic bugs.

We will reuse the Level 1 code, but now solve the bugs **with the debugger** instead of just reading messages.

---

## 1. Confirm your code

You should still have:

- `BuggyCalculator.java`
- `BuggyLoop.java`
- `Main.java`

If you already fixed the code in Level 1, **temporarily undo those fixes** (or paste the original versions from Level 1) so that:

- `divide` can still divide by zero.
- `sumFirstThree` still loops to `i <= 3`.
- `countUpTo` still uses `for (int i = 1; i < n; i++)`.

We want the bugs back so we can practice debugging them.

---

## 2. Set your first breakpoint

1. Open `Main.java`.
2. Click in the gutter on the line:
   - `int result = BuggyCalculator.divide(10, 0);`
3. You should see a **red dot** (breakpoint) next to that line.

Start the debugger:

1. Click **Debug**.
2. When execution pauses, the breakpoint line will be highlighted.

---

## 3. Step over and inspect variables

When paused at the breakpoint:

1. Look at the **Variables/Locals** panel:
   - You should see `args` and any local variables.
2. Click **Step Over**:
   - This executes the `divide` call and **moves to the next line** (or throws an exception).

If an exception is thrown:

- Notice how the debugger shows the **line that crashed**.
- Compare to the stack trace from Level 1.

Repeat, but this time:

1. Set a breakpoint inside `BuggyCalculator.divide`, on the line `return a / b;`.
2. Start **Debug** again.
3. The debugger will stop inside `divide`.

Use the debugger to answer:

- What are the values of `a` and `b` right before the division?
- What happens if `b` is zero?

---

## 4. Step into another method

Practice **Step Into** and **Step Out** with `sumFirstThree`:

1. Set a breakpoint in `Main.main` on:
   - `int sum = BuggyCalculator.sumFirstThree(nums);`
2. Start **Debug**.
3. When paused on this line, click **Step Into**.

You should now be inside `BuggyCalculator.sumFirstThree`.

While stepping through the loop:

1. Watch `i`, `total`, and `numbers.length` in the Variables panel.
2. Use **Step Over** to run each iteration.
3. Notice when `i` becomes an invalid index.

Optional: add a **Watch** expression (if available) for `numbers[i]`.

When you understand why it crashes:

1. Click **Stop** to end the debugging session.
2. Fix `sumFirstThree` so it:
   - Does not crash when the array is short.
   - Still correctly sums up to the first 3 items when they exist.

---

## 5. Debugging a logic bug with stepping

Now fix `BuggyLoop.countUpTo` **using the debugger**, not just by staring at the code.

1. Set a breakpoint in `Main` on:
   - `int count = BuggyLoop.countUpTo(5);`
2. Click **Debug**.
3. When paused, click **Step Into** to enter `countUpTo`.
4. Use **Step Over** to step through each loop iteration.

Observe:

- How many times does the loop run?
- What are the values of `i` and `count` at each step?

Use this observation to:

1. Decide what the loop *should* do.
2. Update the loop condition so `countUpTo(5)` returns the expected value.

Re‑run with the debugger to confirm the fix.

---

## 6. Compare debugger vs print debugging

Briefly discuss or think about:

- When was the debugger **faster** or clearer than `System.out.println`?
- When might print debugging still be useful?
- How did stepping into `sumFirstThree` and `countUpTo` help you see the bug more clearly?

You are now ready to debug across **multiple files and classes** in **Level 3**.

