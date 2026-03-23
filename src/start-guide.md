# Start Guide (≈ 5 minutes)

This workshop uses **OnlineGDB** – a free, modern, browser‑based IDE that supports **multiple Java files** and a full **debugger** (breakpoints, stepping, variable watch, call stack) with no paywall.

You can follow these steps on any computer with a web browser.

---

## 1. Open the IDE

1. Open your browser and go to `https://www.onlinegdb.com/online_java_compiler`.
2. You should see a Java file named `Main.java` in the main editor and a **Run** and **Debug** button at the top.

**Instructor note (1 min)**: Make sure everyone is on the site and sees the Java editor.

---

## 2. Create the project layout

We will work with several small Java files.

1. In the **File** panel (left side), click **New File**.
2. Name the file exactly: `BuggyCalculator.java`.
3. Repeat and create these files as well:
   - `BuggyLoop.java`
   - `GameApp.java`
   - `Player.java`
   - `ScoreUtils.java`
   - `LevelLoader.java`
   - `InputParser.java`
4. Keep the default `Main.java` file for now – we will replace its contents later.

OnlineGDB saves these files in the temporary project in your browser.

---

## 3. How to paste in the starter code

Each exercise chapter in this workshop includes **copy‑paste‑ready** code blocks.

For each file:

1. Click the file name in the left panel (for example `BuggyCalculator.java`).
2. Select all existing code in the editor and delete it.
3. Copy the corresponding code block from the workshop and paste it into the editor.
4. Press **Ctrl+S** (or use the **Save** icon) to save that file.

**Tip**: Double‑check the file name at the top of the editor matches the heading above the code block in the book.

---

## 4. Running the program

OnlineGDB runs whichever file contains the `public static void main(String[] args)` method.  
In this workshop, **`Main.java`** (or **`GameApp.java`**, when specified) will be the entry point.

To run:

1. Make sure the correct main file (for example `Main.java`) is open in the editor.
2. Click the **Run** button at the top.
3. Watch the **Console** panel at the bottom for:
   - Program output
   - Error messages
   - Stack traces (when exceptions occur)

If the program doesn’t compile, error messages will appear in the console with line numbers.

---

## 5. Starting a debugging session

To start the debugger in OnlineGDB:

1. Open the file that contains `main` (for example `Main.java` or `GameApp.java`).
2. Click in the **gutter** (the narrow column to the left of the line numbers) next to the line where you want execution to pause.
   - A **red dot** appears – this is a **breakpoint**.
3. Click the **Debug** button at the top.
4. When the program hits a breakpoint, it will pause and highlight the current line.

---

## 6. Stepping through code

When the program is paused on a breakpoint, use the toolbar buttons above the editor:

- **Step Over**: runs the current line and stops at the next line in the same method.
  - Use this when you do **not** need to go inside a method call.
- **Step Into**: jumps into the method being called on the current line.
  - Use this to enter helper methods in **other files/classes**.
- **Step Out**: runs the rest of the current method and returns to the caller.
  - Use this to quickly leave a method once you understand it.

You can also press **Continue** to run until the next breakpoint or program exit.

---

## 7. Inspecting variables, watches, and call stack

When stopped on a breakpoint:

- **Variables / Locals panel**:
  - Shows the values of local variables in the current method.
  - Expands objects so you can see their fields (for example, `player.name`, `player.score`).
- **Watch expressions**:
  - Use the **Watch** panel (if visible) to add an expression (e.g., `scores.size()`) and track its value as you step.
- **Call stack**:
  - Shows the chain of method calls that led to the current line.
  - Clicking on a stack frame jumps to that frame’s source (often in another file).
- **Console**:
  - Shows printed output (`System.out.println`) and error messages.
  - Useful for comparing **print debugging** with debugger‑based debugging.

You will use all of these while working through the Levels in this workshop.

---

## 8. If something goes wrong

If the debugger seems stuck or weird:

1. Click **Stop** to end the current run.
2. Re‑click **Debug**.
3. Make sure your breakpoints are on executable lines (not on blank lines or comments).

If the code doesn’t look like this book:

1. Re‑copy the code from the chapter into the right file.
2. Confirm the file name and class name match exactly.

Once everyone can set a breakpoint and step a line in `Main.java`, you are ready for **Level 1**.

