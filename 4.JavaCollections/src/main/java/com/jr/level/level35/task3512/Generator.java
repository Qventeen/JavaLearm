package com.jr.level.level35.task3512;

public class Generator<T> {
    private Class<T> classInfo;

    public Generator(Class<T> classInfo ) {
        this.classInfo = classInfo;
    }

    T newInstance() {
        T result = null;
        try {
            result = classInfo.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
