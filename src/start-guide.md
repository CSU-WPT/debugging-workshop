# Start Guide (≈ 5 minutes)

This workshop uses **OnlineGDB** - a free, modern, browser-based IDE that supports **multiple Java files** and a Java debugger with no paywall.

You can follow these steps on any computer with a web browser.

---

## 1. Open the IDE

1. Open your browser and go to `https://www.onlinegdb.com/online_java_compiler`.
2. You should see a Java file named `Main.java` in the editor and a **Run** and **Debug** button near the top.

**Instructor note (1 min)**: Make sure everyone is on the site and sees the Java editor.

---

## 2. Create the project layout

For **Project A** (Levels 1-2), create only these files:

1. Click **New File**.
2. Name the file exactly: `CalculatorExercises.java`.
3. Repeat and create these files as well:
   - `LoopExercises.java`
4. Keep the default `Main.java` file for now – we will replace its contents later.

OnlineGDB saves these files in the temporary project in your browser.

For **Project B** (Levels 3-4), create a **new** OnlineGDB Java project. OnlineGDB expects the program entry point in a file named **`Main.java`** with `public class Main`.

Add these files:

- `Main.java`
- `Player.java`
- `ScoreUtils.java`
- `LevelLoader.java`
- `InputParser.java`

---

## 3. How to paste in the starter code

Each exercise chapter in this workshop includes **copy‑paste‑ready** code blocks.

For each file:

1. Click the file tab at the top (for example `CalculatorExercises.java`).
2. Select all existing code in the editor and delete it.
3. Copy the corresponding code block from the workshop and paste it into the editor.
4. Press **Ctrl+S** (or use the **Save** icon) to save that file.

**Tip**: Double‑check the file name at the top of the editor matches the heading above the code block in the book.

---

## 4. Running the program

OnlineGDB runs the file that contains `public static void main(String[] args)`.
In this workshop:

- Project A (Levels 1-2) uses `Main.java`.
- Project B (Levels 3-4) also uses `Main.java` (in a separate OnlineGDB project).

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

1. Open the file that contains `main` in your current project.
2. Click in the **gutter** (the narrow column to the left of the line numbers) next to the line where you want execution to pause.
   - A **red dot** appears - this is a **breakpoint**.
3. Click the **Debug** button at the top.
4. Then click the green **Start** button to begin execution.
5. When execution reaches a breakpoint, the debugger pauses at that point.

---

## 6. Stepping through code

When the program is paused on a breakpoint, use the debugger controls near the console area (not above the editor, in OnlineGDB):

- **Step Over**: runs the current line and stops at the next line **in the same method**.
  - Use this when you do **not** need to go inside a method call.
- **Step Into**: jumps into the method being called on the current line.
  - Use this to enter helper methods in **other files/classes**.
- **Step Out**: runs the rest of the current method and returns to the caller.
  - Use this to quickly leave a method once you understand it.

You can also press **Continue** to run until the next breakpoint or program exit.

---

## 7. Inspecting variables and call stack

When stopped on a breakpoint:

- **Variables / Locals panel**:
  - Shows the values of local variables in the current method.
  - Expands objects so you can see their fields (for example, `player.name`, `player.score`).

**Arrays in OnlineGDB**: the debugger often does **not** show array elements or `array.length` in a useful way. When you need to inspect a length or a derived value during debugging, assign it to a **local `int`** (for example `int scoreLength = scores == null ? 0 : scores.length;`) and watch that variable. This workshop’s starter code uses that pattern where it matters.
- **Call stack**:
  - Shows the chain of method calls that led to the current line.
  - Clicking on a stack frame jumps to that frame’s source (often in another file).
- **Console**:
  - Shows printed output (`System.out.println`) and error messages.
  - Useful for comparing **print debugging** with debugger‑based debugging.

Note on watch expressions:

- In OnlineGDB, watch behavior is limited.
- In IDEs like IntelliJ IDEA or VS Code, watch expressions are more reliable for tracking values such as `scores.length` or `i`.

---

## 8. If something goes wrong

If the debugger seems stuck or weird:

1. Click **Stop** to end the current run.
2. Re‑click **Debug**.
3. Click the green **Start** button again.
4. Make sure your breakpoints are on executable lines (not on blank lines or comments).

If the code doesn’t look like this book:

1. Re‑copy the code from the chapter into the right file.
2. Confirm the file name and class name match exactly.

Once everyone can set a breakpoint and step a line in `Main.java`, you are ready for **Level 1**.

