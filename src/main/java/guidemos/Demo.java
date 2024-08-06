/*
 * SPDX-FileCopyrightText: Copyright 2024 Andrea Binello ("andbin")
 * SPDX-License-Identifier: MIT-0
 */

package guidemos;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class Demo {
    private static final MethodType mainType = MethodType.methodType(void.class, String[].class);

    private final DemoCategory category;
    private final Class<?> mainClass;
    private final String name;
    private final String description;

    public Demo(DemoCategory category, Class<?> mainClass) {
        this.category = category;
        this.mainClass = mainClass;
        this.name = readStringField(mainClass, "NAME");
        this.description = readStringField(mainClass, "DESCRIPTION");
    }

    public DemoCategory getCategory() {
        return category;
    }

    public String getCategoryName() {
        return category.toString();
    }

    public Class<?> getMainClass() {
        return mainClass;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void launch() throws Throwable {
        MethodHandle mainHandle = MethodHandles.publicLookup().findStatic(mainClass, "main", mainType);
        mainHandle.invokeExact(new String[0]);
    }

    private static String readStringField(Class<?> mainClass, String staticFieldName) {
        try {
            MethodHandle fieldHandle = MethodHandles.publicLookup().findStaticGetter(mainClass, staticFieldName, String.class);
            return (String) fieldHandle.invokeExact();
        } catch (Throwable e) {
            e.printStackTrace(System.err);
            return null;
        }
    }
}
