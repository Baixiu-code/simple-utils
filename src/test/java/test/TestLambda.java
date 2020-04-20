package test;

public class TestLambda {

    @FunctionalInterface
    interface IAdd{
        int add(int a, int b);
    }


    int testLambda(IAdd lambdaTest, int a , int b) {
        return lambdaTest.add(a,b);
    }

    public static void main(String[] args) {
        TestLambda testLambda = new TestLambda();

        int result = testLambda.testLambda(
                (a,b) -> a + b
                , 1, 2);
        System.out.println(result);
    }
}
