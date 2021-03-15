package com.snack.learning.spring.autowired;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                Object o = null;
                try {
                    o = type.newInstance();
                    field.set(userController, o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(userController.getUserService());
    }
}
