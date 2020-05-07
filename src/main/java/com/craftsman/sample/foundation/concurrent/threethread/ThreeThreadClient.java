package com.craftsman.sample.foundation.concurrent.threethread;

class ThreeThreadClient {

    public static volatile Integer LOCK_INT_COUNT=1;
    public static void main(String[] args) {
       new PrintFirst().run();
       new PrintTwo().run();
       new PrintThree().run();
    }

}
