/*
 * SPDX-FileCopyrightText: Copyright 2024 Andrea Binello ("andbin")
 * SPDX-License-Identifier: MIT-0
 */

package guidemos.cursors.predefined;

import javax.swing.SwingUtilities;

public class PredefinedCursorsDemo {
    public static final String NAME = "Predefined Cursors Demo";
    public static final String DESCRIPTION = "Shows all the predefined cursors "
            + "provided by the java.awt.Cursor class.";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PredefinedCursorsDemoFrame::new);
    }
}
