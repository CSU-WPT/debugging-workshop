# Workshop Overview (≈ 5 minutes)

**Total time goal: ≈ 50 minutes**

- **Start Guide** – 5 minutes (already completed)
- **Level 1 – Reading Errors** – 10 minutes
- **Level 2 – Debugger Basics** – 12 minutes
- **Level 3 – Multi‑File Debugging** – 13 minutes
- **Level 4 – Layered Bugs** – 10 minutes (stretch / as time allows)

---

## Goals

By the end of this workshop, you should be comfortable with:

- **Finding and understanding**:
  - Compile‑time errors
  - Runtime exceptions
  - Logic bugs (wrong behavior, no crash)
- **Using the debugger** (not just `System.out.println`):
  - Setting and using **breakpoints**
  - **Stepping over / into / out of** methods
  - Inspecting **variables** and **object state**
  - Reading the **call stack** to trace where a bug starts
- **Working with multiple files**:
  - Stepping into helper classes
  - Following control flow across files
  - Fixing one bug without introducing another

---

## Structure and pacing

Each Level follows a similar pattern:

1. **Setup** – copy/paste the starter code into the right file(s).
2. **Run and observe** – see what error or wrong behavior appears.
3. **Investigate** – use the debugger (and sometimes print statements) to narrow down the issue.
4. **Fix** – change the code to correct the bug.
5. **Reflect** – short questions to connect the bug to a concept.

**Instructor suggestion**:

- Pause briefly between Levels to:
  - Ask a couple of check‑in questions.
  - Share a “live” debugging demo if many students are stuck.

Solutions for all Levels are collected in the **Solutions & Fixes** chapter so you can review them after class (or use them as backup during class).

