package org.example.pattern.singleton;

import java.util.Objects;

public class SingletonStudentService {

    private static volatile SingletonStudentService instance;

    private SingletonStudentService() {}

    public static SingletonStudentService getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (SingletonEmployeeService.class) {
                if (Objects.isNull(instance)) {
                    instance = new SingletonStudentService();
                }
            }
        }
        return instance;
    }
}
