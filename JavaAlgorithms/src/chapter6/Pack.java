package chapter6;

public class Pack {

    private static int[] weights = new int[]{11,12,11,6,5};

    private static int[] result ;

    public static void main(String[] args) {

        result = new int[weights.length];
        for (int i = 0; i < weights.length; i++) {
            if (knapsack(100, i)) {
                break;
            }
            result = new int[weights.length];
        }

        for (int value : result) {
            if (value != 0) {
                System.out.print(value + ",");
            }
        }

    }

    public static boolean knapsack(int weight,int index){
        if (weight == 0) {
            return true;
        } else if (index == weights.length) {
            return false;
        }

        if (weights[index] > weight) {
            return knapsack(weight, index + 1);
        }else{
            result[index] = weights[index];
            return knapsack(weight - result[index], index + 1);
        }

    }


}
