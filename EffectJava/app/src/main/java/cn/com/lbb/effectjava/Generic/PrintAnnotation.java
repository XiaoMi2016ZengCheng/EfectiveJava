package cn.com.lbb.effectjava.Generic;// Use of asSubclass to safely cast to a bounded type token - Page 146

import java.lang.annotation.*;
import java.lang.reflect.*;

public class PrintAnnotation {
    // Use of asSubclass to safely cast to a bounded type token
    static Annotation getAnnotation(AnnotatedElement element,
                                    String annotationTypeName) {
        Class<?> annotationType = null; // Unbounded type token
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        return element.getAnnotation(
                annotationType.asSubclass(Annotation.class));
    }

    // Test program to print named annotation of named class
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println(
                    "Usage: java PrintAnnotation <class> <annotation>");
            System.exit(1);
        }
        String className = args[0];
        String annotationTypeName = args[1];
        Class<?> klass = Class.forName(className);
        System.out.println(getAnnotation(klass, annotationTypeName));
    }

    static Annotation getAnnotationTest(AnnotatedElement element,//测试方法,使用强制类型转换,目前没搞懂和上面的区别
                                        String annotationTypeName) {
        Class<?> annotationType = null; // Unbounded type token
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        Class<? extends Annotation> annoType = (Class<? extends Annotation>) annotationType;
        return element.getAnnotation(
                annoType);
    }
}
