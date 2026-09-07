package string.assignment_problems;

public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int len = original.length();
        int score = 0;
        int mismatchPos = -1;
        char expChar = ' ';
        char actChar = ' ';

        for (int i = 0; i < len; i++) {
            char c1 = original.charAt(i);
            char c2 = typed.charAt(i);

            if (c1 == c2) {
                score++;
            } else if (mismatchPos == -1) {
                mismatchPos = i + 1;
                expChar = c1;
                actChar = c2;
            }
        }

        double pct = ((double) score / len) * 100;

        System.out.print("Matched: " + score + "/" + len + " | Accuracy: " + String.format("%.2f", pct) + "% | ");

        if (mismatchPos == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.println("First Mismatch at position " + mismatchPos + " ('" + expChar + "' vs '" + actChar + "')");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
