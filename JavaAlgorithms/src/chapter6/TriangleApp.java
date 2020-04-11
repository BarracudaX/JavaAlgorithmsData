package chapter6;

import chapter4.Stack;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

public class TriangleApp {

    private static int theAnswer ;

    private static int theNumber ;

    private static Stack<Param<Integer>> stack = new Stack<>(1_000);

    private static int codePart;

    private static Param<Integer> theseParams;

    private static class Param<T>{
        private final T param;

        private final int returnAddress;

        private Param(T param, int returnAddress) {
            this.param = param;
            this.returnAddress = returnAddress;
        }

        public T getParam() {
            return param;
        }

        public int getReturnAddress() {
            return returnAddress;
        }
    }

    public static void main(String[] args) {
        theNumber = 5;
        recTriangle();
        System.out.println("Answer = "+theAnswer);
    }

    private static void recTriangle() {
        codePart = 1;
        while (step() == false) {

        }
    }

    private static boolean step() {
        switch (codePart){

            case 1 :
                theseParams = new Param<>(theNumber,6);
                stack.push(theseParams);
                codePart = 2;
                break;
            case 2:
                theseParams = stack.peek();
                if (theseParams.getParam() == 1) {
                    theAnswer = 1;
                    codePart = 5;
                }else{
                    codePart = 3;
                }
                break;
            case 3:
                Param<Integer> param = new Param(theseParams.param - 1, 4);
                stack.push(param);
                codePart = 2;
                break;
            case 4:
                theseParams = stack.peek();
                theAnswer = theAnswer + theseParams.getParam();
                codePart = 5;
                break;
            case 5:
                theseParams = stack.peek();
                codePart = theseParams.getReturnAddress();
                stack.pop();
                break;
            case 6:
                return true;
        }
        return false;
    }

}
