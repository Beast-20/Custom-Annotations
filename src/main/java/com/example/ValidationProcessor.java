package com.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.annotations.NotBlank;
import com.annotations.Positive;
import com.exceptions.ValidationException;

public class ValidationProcessor {
    public static void validate(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent((Class<? extends Annotation>) NotBlank.class)) {
                validateNotBlankField(obj, field);
            }

            if (field.isAnnotationPresent((Class<? extends Annotation>) Positive.class)) {
                validatePositiveField(obj, field);
            }
        }
    }

    private static void validateNotBlankField(Object obj, Field field) {
        field.setAccessible(true);

        try {
            Object value = field.get(obj);

            if (value == null || (value instanceof String && ((String) value).trim().isEmpty())) {
                throw new ValidationException(field.getName() + " must not be blank");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void validatePositiveField(Object obj, Field field) {
        field.setAccessible(true);

        try {
            Object value = field.get(obj);

            if (value instanceof Number && ((Number) value).doubleValue() <= 0) {
                throw new ValidationException(field.getName() + " must be positive");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
