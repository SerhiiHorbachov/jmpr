package com.jmpr;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectMapper {

    public ObjectMapper() {
    }

    /**
     * @param content
     * @param valueType
     * @param <T>
     * @return
     */
    public <T> T readToObject(String content, Class<T> valueType) {
        Constructor<?>[] declaredConstructors = valueType.getDeclaredConstructors();
        Constructor<?> cnst = declaredConstructors[0];
        cnst.setAccessible(true);

        T instance;

        //TODO: handle exceptions mode gracefully
        try {
            instance = (T) cnst.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return instance;
    }
}
