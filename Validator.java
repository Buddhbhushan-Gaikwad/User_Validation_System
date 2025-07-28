package User_Validation_System;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class Validator {

    public static void validate(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);

            // NotNull
            if (field.isAnnotationPresent(NotNull.class)) {
                if (value == null) {
                    throw new Exception(field.getName() + " cannot be null");
                }
            }

            // Length
            if (field.isAnnotationPresent(Length.class)) {
                Length length = field.getAnnotation(Length.class);
                if (value instanceof String str) {
                    if (str.length() < length.min() || str.length() > length.max()) {
                        throw new Exception(field.getName() + " must be between " +
                                length.min() + " and " + length.max() + " characters");
                    }
                }
            }

            // Email
            if (field.isAnnotationPresent(Email.class)) {
                String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
                if (value instanceof String str) {
                    if (!Pattern.matches(emailRegex, str)) {
                        throw new Exception(field.getName() + " is not a valid email");
                    }
                }
            }
        }

        System.out.println("✅ All validations passed!");
    }
}
