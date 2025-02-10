package com.application.SAGVRest;

import java.util.function.Consumer;

public class Prueba {
    public static void main(String[] args) {

        Consumer<String> consumer = (param)->{
            System.out.println(param);
        };
        consumer.accept("Jorge");
    }
}
