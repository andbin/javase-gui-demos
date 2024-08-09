/*
 * SPDX-FileCopyrightText: Copyright 2024 Andrea Binello ("andbin")
 * SPDX-License-Identifier: MIT-0
 */

package guidemos.cursors.predefined;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PredefinedCursorsDemoPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private static final Color BACK_COLOR = new Color(240, 240, 240);
    private static final Color BORDER_COLOR = new Color(96, 96, 96);

    private final int size1 = 12;
    private final Font font = new Font(Font.SANS_SERIF, Font.PLAIN, size1);

    public PredefinedCursorsDemoPanel() {
        setBackground(BACK_COLOR);
        setBorder(BorderFactory.createEmptyBorder(size1, size1, size1, size1));
        setLayout(new GridLayout(0, 3, size1, size1));
        setOpaque(true);

        addCursorBox("CROSSHAIR_CURSOR", Cursor.CROSSHAIR_CURSOR);
        addCursorBox("DEFAULT_CURSOR", Cursor.DEFAULT_CURSOR);
        addCursorBox("E_RESIZE_CURSOR", Cursor.E_RESIZE_CURSOR);
        addCursorBox("HAND_CURSOR", Cursor.HAND_CURSOR);
        addCursorBox("MOVE_CURSOR", Cursor.MOVE_CURSOR);
        addCursorBox("NE_RESIZE_CURSOR", Cursor.NE_RESIZE_CURSOR);
        addCursorBox("NW_RESIZE_CURSOR", Cursor.NW_RESIZE_CURSOR);
        addCursorBox("N_RESIZE_CURSOR", Cursor.N_RESIZE_CURSOR);
        addCursorBox("SE_RESIZE_CURSOR", Cursor.SE_RESIZE_CURSOR);
        addCursorBox("SW_RESIZE_CURSOR", Cursor.SW_RESIZE_CURSOR);
        addCursorBox("S_RESIZE_CURSOR", Cursor.S_RESIZE_CURSOR);
        addCursorBox("TEXT_CURSOR", Cursor.TEXT_CURSOR);
        addCursorBox("WAIT_CURSOR", Cursor.WAIT_CURSOR);
        addCursorBox("W_RESIZE_CURSOR", Cursor.W_RESIZE_CURSOR);
    }

    private void addCursorBox(String title, int cursorType) {
        JLabel cursorLabel = new JLabel(" " + title);
        cursorLabel.setBackground(Color.WHITE);
        cursorLabel.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1));
        cursorLabel.setCursor(Cursor.getPredefinedCursor(cursorType));
        cursorLabel.setFont(font);
        cursorLabel.setForeground(Color.BLACK);
        cursorLabel.setHorizontalAlignment(SwingConstants.LEFT);
        cursorLabel.setOpaque(true);
        cursorLabel.setPreferredSize(new Dimension(size1 * 13, size1 * 5));
        cursorLabel.setVerticalAlignment(SwingConstants.TOP);

        add(cursorLabel);
    }
}
