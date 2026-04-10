# Level 2 – Debugger Basics (≈ 12 minutes)

**Concepts**: breakpoints, stepping over/into/out, variable inspection, tracking changing state, logic bugs.

We reuse the Level 1 project. You will debug with breakpoints and stepping, not only console output.

---

## 1. Bring the bugs back (without losing your fixes)

You should still have:

- `CalculatorExercises.java`
- `LoopExercises.java`
- `Main.java`

**If you have not already (see Level 1, section 8):** comment out your Level 1 fixes in `divide`, `sumFirstThree`, and `countUpTo` so the original buggy lines run again. Keep the commented fix code in the file so you can **uncomment it later** instead of retyping.

**Arrays in OnlineGDB:** you usually cannot inspect array elements or lengths in the Variables panel. The starter `sumFirstThree` includes a local `numberCount` so you can see how many elements the array has while debugging.

---

## 2. Set your first breakpoint

1. Open `Main.java`.
2. Click in the gutter on the line:
   - `int result = CalculatorExercises.divide(10, 0);`
3. You should see a **red dot** (breakpoint) next to that line.

Start the debugger:

1. Click **Debug**.
2. Click the green **Start** button.
3. When execution pauses, the debugger is stopped at your breakpoint.

---

## 3. Step over, then Continue

When paused at the breakpoint:

1. Look at the **Variables/Locals** panel for `args` and any locals.
2. Click **Step Over** once on the `divide` line.
3. Click **Continue** so the program runs forward. In OnlineGDB, stepping alone may not surface the failure you expect; **Continue** lets execution run until the exception or the next breakpoint.

If an exception appears:

- Note the **line** where execution stops.
- Compare to the stack trace you saw in Level 1.

Repeat with a breakpoint on `return a / b;` inside `CalculatorExercises.divide`:

1. Click **Debug**, then the green **Start** button.
2. Inspect `a` and `b` in the Variables panel right before the division.

---

## 4. Fix `divide` before the next exercise

**Before you go on to section 5:** restore your `divide` fix so dividing by zero no longer crashes (uncomment your Level 1 fix or re-apply it). Run with **Run** once to confirm the program reaches the `sumFirstThree` section.

If `divide` still throws, you will not reach the next breakpoint in `main`.

---

## 5. Step into `sumFirstThree`

Practice **Step Into** and **Step Out** with `sumFirstThree`:

1. Set a breakpoint in `Main.main` on:
   - `int sum = CalculatorExercises.sumFirstThree(nums);`
2. Click **Debug**, then the green **Start** button.
3. When paused on this line, click **Step Into**.

You should now be inside `CalculatorExercises.sumFirstThree`.

While stepping through the loop:

1. Watch **`numberCount`**, `i`, and `total` in the Variables panel (not `numbers.length` or array slots).
2. Use **Step Over** to run each iteration.
3. Notice when `i` is no longer a valid index.

In OnlineGDB, skip watch expressions and rely on **Variables/Locals**.

When you understand the failure:

1. Click **Stop** to end the debugging session.
2. Uncomment your Level 1 fix for `sumFirstThree` (or re-apply it) so short arrays do not crash and the first three elements are summed when present.

---

## 6. Logic bug: `countUpTo`

1. Set a breakpoint in `Main` on:
   - `int count = LoopExercises.countUpTo(5);`
2. Click **Debug**, then the green **Start** button.
3. When paused, click **Step Into** to enter `countUpTo`.
4. Use **Step Over** through the loop.

Observe:

- How many times does the loop run?
- What are the values of `i` and `count` at each step?

Then uncomment your Level 1 fix for `countUpTo` (or re-apply it) so the result matches what you expect.

Re-run with the debugger to confirm.

---

## 7. After the debugger exercises

Uncomment any remaining commented Level 1 fixes so `divide`, `sumFirstThree`, and `countUpTo` are all corrected and the program runs cleanly. You should not need to redo Level 1 from scratch.

---

## 8. Compare debugger vs print debugging

Briefly discuss or think about:

- When was the debugger **faster** or clearer than `System.out.println`?
- When might print debugging still be useful?
- How did stepping into `sumFirstThree` and `countUpTo` help you see the bug more clearly?

You are now ready for **Level 3** (a new OnlineGDB project with a different `Main.java`).
