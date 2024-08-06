/*
 * SPDX-FileCopyrightText: Copyright 2024 Andrea Binello ("andbin")
 * SPDX-License-Identifier: MIT-0
 */

package guidemos;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DemosCommon {
    public static final String PROJECT_TITLE = "JavaSE GUI Demos";
    public static final String PROJECT_VERSION;
    public static final String PROJECT_FULL_TITLE;
    public static final String TITLE_SUFFIX = " – " + PROJECT_TITLE;

    static {
        String version = null;

        try {
            Properties projectInfo = readProjectInfo();
            version = getEffectiveValue(projectInfo, "project.version");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        PROJECT_VERSION = version;
        PROJECT_FULL_TITLE = version != null ? PROJECT_TITLE + " v." + version : PROJECT_TITLE;
    }

    private DemosCommon() {}

    private static Properties readProjectInfo() throws IOException {
        try (InputStream is = DemosCommon.class.getResourceAsStream("/project-info.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            return properties;
        }
    }

    private static String getEffectiveValue(Properties properties, String key) {
        String value = properties.getProperty(key);
        return value != null && !value.contains("${") ? value : null;
    }
}
