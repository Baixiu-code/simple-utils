package com.craftsman.sample.foundation.pattern.pubsub;

import java.util.LinkedList;

public class MainClient {
    public static void main(String[] args) {
        Storage storage=new Storage();
        LinkedList<Object> linkedList=new LinkedList<>();
        linkedList.add("object1");
        linkedList.add("object1");
        linkedList.add("object1");
        linkedList.add("object1");
        linkedList.add("object1");
        linkedList.add("object1");
        storage.setList(linkedList);
        Thread producer=new Producer(storage);
        Thread consumer=new Consumer(storage);
        producer.run();
        consumer.run();

    }
}
