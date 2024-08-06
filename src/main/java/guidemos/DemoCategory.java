/*
 * SPDX-FileCopyrightText: Copyright 2024 Andrea Binello ("andbin")
 * SPDX-License-Identifier: MIT-0
 */

package guidemos;

public enum DemoCategory {
    ;

    private final String name;

    DemoCategory(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
