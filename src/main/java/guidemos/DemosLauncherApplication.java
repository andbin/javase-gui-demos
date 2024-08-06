/*
 * SPDX-FileCopyrightText: Copyright 2024 Andrea Binello ("andbin")
 * SPDX-License-Identifier: MIT-0
 */

package guidemos;

import java.awt.Font;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.Exchanger;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class DemosLauncherApplication {
    public static void main(String[] args) {
        Exchanger<Demo> exchanger = new Exchanger<>();

        SwingUtilities.invokeLater(() -> new DemosLauncherApplicationFrame(exchanger));

        Demo demo;

        try {
            demo = exchanger.exchange(null);
        } catch (InterruptedException e) {
            SwingUtilities.invokeLater(() -> showException(e));
            return;
        }

        try {
            demo.launch();
        } catch (Throwable e) {
            SwingUtilities.invokeLater(() -> showException(e));
        }
    }

    private static void showException(Throwable e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));

        JTextArea textArea = new JTextArea(sw.toString(), 20, 100);
        textArea.setEditable(false);
        textArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        textArea.setTabSize(4);

        JOptionPane.showMessageDialog(null, new JScrollPane(textArea),
                "Launcher Error" + DemosCommon.TITLE_SUFFIX, JOptionPane.ERROR_MESSAGE);
    }
}
