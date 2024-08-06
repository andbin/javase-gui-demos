/*
 * SPDX-FileCopyrightText: Copyright 2024 Andrea Binello ("andbin")
 * SPDX-License-Identifier: MIT-0
 */

package guidemos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

import javax.swing.Icon;

public class DemoLaunchIcon implements Icon {
    private static final Color GREEN = new Color(0, 210, 0);

    private final int size;
    private final float hsize;
    private final float tradius;

    public DemoLaunchIcon(int size) {
        this.size = size;
        this.hsize = size / 2.0F;
        this.tradius = size * 0.26F;
    }

    @Override
    public int getIconHeight() {
        return size;
    }

    @Override
    public int getIconWidth() {
        return size;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;

        Path2D.Float triangle = new Path2D.Float();
        triangle.moveTo(x + hsize + tradius        , y + hsize);
        triangle.lineTo(x + hsize + tradius * -0.5F, y + hsize + tradius * +0.866F);
        triangle.lineTo(x + hsize + tradius * -0.5F, y + hsize + tradius * -0.866F);
        triangle.closePath();

        Color oldColor = g2d.getColor();
        Object oldAntialiasing = g2d.getRenderingHint(RenderingHints.KEY_ANTIALIASING);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(c.isEnabled() ? GREEN : Color.GRAY);
        g2d.fillOval(x, y, size, size);
        g2d.setColor(c.isEnabled() ? Color.WHITE : Color.LIGHT_GRAY);
        g2d.fill(triangle);

        g2d.setColor(oldColor);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, oldAntialiasing);
    }
}
