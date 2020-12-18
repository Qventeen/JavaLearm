package com.jr.level.level38.task3804;

public class ExceptionFactory {
    public static <T extends Enum<T>> Throwable getException(Enum<T>  enumException){
        if(enumException != null) {
            String str = enumException.name();
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0)).append(str.substring(1).toLowerCase().replace("_", " "));
            String message = sb.toString();

            if (enumException instanceof ApplicationExceptionMessage) {
                return new Exception(message);
            } else if (enumException instanceof DatabaseExceptionMessage) {
                return new RuntimeException(message);
            } else if (enumException instanceof UserExceptionMessage) {
                return new Error(message);
            }
        }
        return new IllegalArgumentException();
    }
}
