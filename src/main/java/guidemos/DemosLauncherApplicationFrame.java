/*
 * SPDX-FileCopyrightText: Copyright 2024 Andrea Binello ("andbin")
 * SPDX-License-Identifier: MIT-0
 */

package guidemos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.Exchanger;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

public class DemosLauncherApplicationFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private static final String LAUNCH_DEMO_KEY = "launchDemo";
    private static final KeyStroke ENTER_KEY = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

    private final int size1 = 12;
    private final int size2 = size1 / 2;
    private final Font font = new Font(Font.SANS_SERIF, Font.PLAIN, size1);

    private final Exchanger<Demo> exchanger;
    private Action launchDemoAction;
    private DemosTableModel demosTableModel;
    private JTable table;
    private JTextArea descriptionTextArea;

    public DemosLauncherApplicationFrame(Exchanger<Demo> exchanger) {
        super(DemosCommon.PROJECT_FULL_TITLE);
        this.exchanger = exchanger;

        launchDemoAction = new LaunchDemoAction();
        launchDemoAction.setEnabled(false);

        demosTableModel = new DemosTableModel();

        table = new JTable(demosTableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        table.setFont(font.deriveFont(size1 * 1.15F));
        table.setRowHeight(size1 * 2);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(ENTER_KEY, LAUNCH_DEMO_KEY);
        table.getActionMap().put(LAUNCH_DEMO_KEY, launchDemoAction);
        table.getColumnModel().getColumn(0).setPreferredWidth(size1 * 15);
        table.getColumnModel().getColumn(1).setPreferredWidth(size1 * 25);
        table.getSelectionModel().addListSelectionListener(this::onSelectionChanged);

        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(size1 * 40, size1 * 25));

        descriptionTextArea = new JTextArea(3, 1);
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setFont(table.getFont());
        descriptionTextArea.setLineWrap(true);

        JScrollPane descriptionScrollPane = new JScrollPane(descriptionTextArea);

        JPanel demosPanel = new JPanel(new BorderLayout(0, size2));
        demosPanel.setBorder(BorderFactory.createEmptyBorder(size1, size1, size1, size1));
        demosPanel.add(tableScrollPane, BorderLayout.CENTER);
        demosPanel.add(descriptionScrollPane, BorderLayout.SOUTH);

        JButton launchDemoButton = new JButton(launchDemoAction);
        launchDemoButton.setFont(font.deriveFont(Font.BOLD));
        launchDemoButton.setIconTextGap(size2);
        launchDemoButton.setMargin(new Insets(size2, size2, size2, size2));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, size1, size1, size1));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(launchDemoButton);
        buttonPanel.add(Box.createHorizontalGlue());

        getContentPane().add(demosPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Setups the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);  // centers the frame on the screen
        setVisible(true);
    }

    private Demo getSelectedDemo() {
        int selectedRow = table.getSelectedRow();
        return selectedRow >= 0 ? demosTableModel.getDemo(selectedRow) : null;
    }

    private void onSelectionChanged(ListSelectionEvent lse) {
        Demo demo = getSelectedDemo();

        if (demo != null) {
            launchDemoAction.setEnabled(true);
            descriptionTextArea.setText(demo.getDescription());
        } else {
            launchDemoAction.setEnabled(false);
            descriptionTextArea.setText("");
        }
    }

    private void launchDemo() {
        try {
            exchanger.exchange(getSelectedDemo());
        } catch (InterruptedException e) {
            e.printStackTrace(System.err);
        }

        dispose();
    }


    private class LaunchDemoAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        public LaunchDemoAction() {
            super("LAUNCH DEMO", new DemoLaunchIcon(size1 * 2));
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            launchDemo();
        }
    }
}
