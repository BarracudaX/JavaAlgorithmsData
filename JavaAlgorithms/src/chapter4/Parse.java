package chapter4;

public class Parse {

    private final String expression;

    private final Stack<Double> stack ;

    public Parse(String expression) {
        this.expression = new InToPost(expression).transform();

        this.stack = new Stack<>(this.expression.length());

    }

    public double evaluate(){
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch >= '0' && ch <= '9') {
                stack.push(Double.parseDouble(String.valueOf(ch)));
            }else{
                double num2 = stack.pop();
                double num1 = stack.pop();
                if (ch == '+') {
                    stack.push(num1 + num2);
                } else if (ch == '-') {
                    stack.push(num1 - num2);
                } else if (ch == '*') {
                    stack.push(num1 * num2);
                } else if (ch == '/') {
                    stack.push(num1/num2);
                }
            }
        }
        return stack.pop();
    }

}
