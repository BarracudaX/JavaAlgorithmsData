package chapter4;

/**
 * Transforms infix arithmetic expression to post arithmetic expresion
 */
public class InToPost {

    private final Stack<Character> stack ;

    private final String infixEx;

    public InToPost(String expression) {
        stack = new Stack<>(expression.length());
        this.infixEx = expression;
    }

    public String transform(){
        StringBuilder builder = new StringBuilder();
        //"3×(4+5)–6/(1+2)"
        for (int i = 0; i < infixEx.length(); i++) {
            char ch = infixEx.charAt(i);
            if (ch == '+' || ch == '-') {
                gotOperator(ch, 1,builder);
            } else if (ch == '*' || ch == '/') {
                gotOperator(ch, 2,builder);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                gotParenthesis(builder);
            }else{
                builder.append(ch);
            }
        }

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.toString();
    }

    private void gotParenthesis(StringBuilder builder) {
        while (!stack.isEmpty()) {
            Character previous = stack.pop();
            if (previous == '(') {
                break;
            }
            builder.append(previous);
        }
    }

    private void gotOperator(char ch, int priority,StringBuilder builder) {
        while (!stack.isEmpty()) {
            char previous = stack.pop();

            if (previous == '(') {
                stack.push(previous);
                break;
            }

            int priority2 = (previous == '+' || previous == '-') ? 1 : 2;

            if (priority2 < priority) {
                stack.push(previous);
                break;
            }else{
                builder.append(previous);
            }
        }
        stack.push(ch);
    }


}
