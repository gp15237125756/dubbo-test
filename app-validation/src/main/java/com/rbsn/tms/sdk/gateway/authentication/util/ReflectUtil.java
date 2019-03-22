package com.rbsn.tms.sdk.gateway.authentication.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class ReflectUtil {

    public static Map<String, Field> getBeanPropertyFields(Class cl) {
        HashMap properties;
        for (properties = new HashMap(); cl != null; cl = cl.getSuperclass()) {
            Field[] fields = cl.getDeclaredFields();
            Field[] arr$ = fields;
            int len$ = fields.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                Field field = arr$[i$];
                if (!Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    properties.put(field.getName(), field);
                }
            }
        }

        return properties;
    }

    public static Map<String, Method> getBeanPropertyReadMethods(Class cl) {
        HashMap properties;
        for (properties = new HashMap(); cl != null; cl = cl.getSuperclass()) {
            Method[] methods = cl.getDeclaredMethods();
            Method[] arr$ = methods;
            int len$ = methods.length;
            for (int i$ = 0; i$ < len$; ++i$) {
                Method method = arr$[i$];
                if (isBeanPropertyReadMethod(method)) {
                    method.setAccessible(true);
                    String property = getPropertyNameFromBeanReadMethod(method);
                    properties.put(property, method);
                }
            }
        }

        return properties;
    }

    public static boolean isBeanPropertyReadMethod(Method method) {
        return method != null && Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType() != Void.TYPE && method.getDeclaringClass() != Object.class && method.getParameterTypes().length == 0 && (method.getName().startsWith("get") && method.getName().length() > 3 || method.getName().startsWith("is") && method.getName().length() > 2);
    }

    public static String getPropertyNameFromBeanReadMethod(Method method) {
        if (isBeanPropertyReadMethod(method)) {
            if (method.getName().startsWith("get")) {
                return method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
            }

            if (method.getName().startsWith("is")) {
                return method.getName().substring(2, 3).toLowerCase() + method.getName().substring(3);
            }
        }

        return null;
    }
}
