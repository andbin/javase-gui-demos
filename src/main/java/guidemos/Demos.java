/*
 * SPDX-FileCopyrightText: Copyright 2024 Andrea Binello ("andbin")
 * SPDX-License-Identifier: MIT-0
 */

package guidemos;

import static guidemos.DemoCategory.CURSORS;

public class Demos {
    public static final Demo[] array = {
            new Demo(CURSORS, guidemos.cursors.predefined.PredefinedCursorsDemo.class),
    };

    private Demos() {}
}
