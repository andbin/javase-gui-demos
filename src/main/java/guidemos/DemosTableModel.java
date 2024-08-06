/*
 * SPDX-FileCopyrightText: Copyright 2024 Andrea Binello ("andbin")
 * SPDX-License-Identifier: MIT-0
 */

package guidemos;

import javax.swing.table.AbstractTableModel;

public class DemosTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    private final String[] columnNames = { "Category", "Name" };

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return Demos.array.length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Demo demo = Demos.array[rowIndex];

        switch (columnIndex) {
        case 0: return demo.getCategoryName();
        case 1: return demo.getName();
        }

        return null;
    }

    public Demo getDemo(int rowIndex) {
        return Demos.array[rowIndex];
    }
}
