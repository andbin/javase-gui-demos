/*
 * SPDX-FileCopyrightText: Copyright 2024 Andrea Binello ("andbin")
 * SPDX-License-Identifier: MIT-0
 */

package guidemos.cursors.predefined;

import javax.swing.JFrame;

import guidemos.DemosCommon;

public class PredefinedCursorsDemoFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    public PredefinedCursorsDemoFrame() {
        super(PredefinedCursorsDemo.NAME + DemosCommon.TITLE_SUFFIX);

        add(new PredefinedCursorsDemoPanel());

        // Setups the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);  // centers the frame on the screen
        setVisible(true);
    }
}
