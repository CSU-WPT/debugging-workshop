# Introduction

This book supports a 50-minute, hands-on Java debugging workshop for students who are still building debugging confidence.

You will use a small multi-file Java program and debug it in progressive levels. Each level focuses on practical workflow: run, observe, investigate, fix, re-run.

By the end of the workshop, students should be able to:

- Distinguish compile-time, runtime, and logic bugs.
- Read exception messages and stack traces to find root causes.
- Use breakpoints, step controls, variable inspection, and call stack navigation.
- Debug across multiple files and method calls.
- Fix one bug while checking that other behavior still works.

Workshop flow:

1. **Start Guide**: set up OnlineGDB and debugging controls.
2. **Workshop Overview**: timing for each section.
3. **Level 1–4**: progressive debugging exercises.
4. **Solutions**: standby reference for instructor/students.

Starter source files for copy/paste live under `code/levels-1-2/` (Levels 1–2) and `code/levels-3-4/` (Levels 3–4). Each folder is its own OnlineGDB project; both use `Main.java` as the entry point.

This is designed to be active. Students should spend most of the session debugging code, not just reading.
