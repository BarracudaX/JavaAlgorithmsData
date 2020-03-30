package chapter4;

public class TestDrive {

    public static void main(String[] args) {
        Parse parse = new Parse("3*(4+5)-6/(1+2)");
        System.out.println(new InToPost("3*(4+5)-6/(1+2)").transform());
        System.out.println(parse.evaluate());
    }

}
