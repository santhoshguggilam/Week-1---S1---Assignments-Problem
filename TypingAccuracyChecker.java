public class TypingAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int firstMismatch = -1;

        int length = Math.min(original.length(), typed.length());

        for (int i = 0; i < length; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            }
            else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        // Handle extra/missing characters
        if (original.length() != typed.length()) {

            if (firstMismatch == -1) {
                firstMismatch = length;
            }
        }

        double accuracy =
                (matched * 100.0) / original.length();

        System.out.printf(
            "Matched: %d/%d | Accuracy: %.2f%%",
            matched,
            original.length(),
            accuracy
        );

        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        }
        else {
            System.out.print(
                " | First Mismatch at position "
                + (firstMismatch + 1)
            );

            if (firstMismatch < original.length()
                    && firstMismatch < typed.length()) {

                System.out.println(
                    " ('" + original.charAt(firstMismatch)
                    + "' vs '" + typed.charAt(firstMismatch) + "')"
                );

            }
            else {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        String original = "hello world";
        String typed = "hello worlt";

        checkTypingAccuracy(original, typed);
    }
}
