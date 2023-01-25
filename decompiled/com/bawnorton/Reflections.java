package com.bawnorton;

import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.util.HashSet;
import java.util.Set;

public class Reflections {
    static org.reflections.Reflections reflections = new org.reflections.Reflections(new ConfigurationBuilder()
            .setScanners(new SubTypesScanner(false), new ResourcesScanner())
            .addUrls(ClasspathHelper.forJavaClassPath())
            .filterInputsBy(new FilterBuilder()));


    public static Set<Class<?>> getSubTypesOf(Class<?> type) {
        return new HashSet<>(reflections.getSubTypesOf(type));
    }

    public static Set<Class<?>> getAllSubTypesOf(Class<?> type) {
        Set<Class<?>> currentSubTypes = getSubTypesOf(type);
        Set<Class<?>> subTypes = new HashSet<>(currentSubTypes);
        for (Class<?> subType : currentSubTypes) {
            subTypes.addAll(getAllSubTypesOf(subType));
        }
        return subTypes;
    }
}
