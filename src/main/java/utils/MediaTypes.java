package utils;

import entity.media.Media;
import entity.media.type.MediaType;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MediaTypes {

    private static final String PACKAGE_NAME = "entity.media";

    public static List<String> getAllMediaTypes() {
        Reflections reflections = new Reflections(PACKAGE_NAME);
        Set<Class<?>> annotationClasses = reflections.getTypesAnnotatedWith(MediaType.class);
        List<String> mediaTypeNames = new ArrayList<>();

        for (Class<?> annotationClass : annotationClasses) {
            mediaTypeNames.add(annotationClass.getAnnotation(MediaType.class).name());
            // annotationClass.getSimpleName();
        }

        return mediaTypeNames;
    }


}
