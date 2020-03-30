package chapter4;

public class BracketChecker {

    public static void check(String string) {
        Stack<Character> brackets = new Stack<>(string.length());

        int position = 1;

        for (char c : string.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                brackets.push(c);
            } else if (c == ']' || c == ')' || c == '}') {

                if (brackets.isEmpty()) {
                    throw new IllegalArgumentException("Redundant closing bracket " + c + " at position " + position);
                }

                Character lastBracket = brackets.pop();

                if (
                        (lastBracket == '[' && c != ']') ||
                        (lastBracket == '{' && c != '}') ||
                        (lastBracket == '(' && c != ')')
                ) {
                    throw new IllegalArgumentException(
                            "The bracket " + lastBracket + " is not properly closed." +
                                    "Trying to close it with not matching bracket " + c + " at position " + position);
                }
            }
            position = position + 1;
        }

        if (!brackets.isEmpty()) {
            throw new IllegalArgumentException("Unclosed bracket/s left.");
        }

    }

}
