package test;

public interface TestDefault {
    default void printTest(){
        System.out.println("testDefault");
    }
}
