public class BuggyLoop {

    // Intentionally buggy method: tries to count from 1 to n
    public static int countUpTo(int n) {
        int count = 0;
        // BUG 3: incorrect loop condition, never reaches n
        for (int i = 1; i < n; i++) {
            count++;
        }
        return count;
    }
}

