package com.jjara.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class IndexPage {

    private final static String filePath = "public/index.html";
    private static String index = null;

    public static String getIndex(final String title, final String description, final String stackTech, final String gitRepo, final String swaggerLink) {
        if (index == null) {
            var classLoader = IndexPage.class.getClassLoader();
            var inputStream = classLoader.getResourceAsStream(filePath);
            index = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
            index = index
                    .replaceAll("\\[TITLE\\]", title)
                    .replaceAll("\\[DESCRIPTION\\]", description)
                    .replaceAll("\\[TECH_STACK\\]", stackTech)
                    .replaceAll("\\[GIT_REPO\\]", gitRepo)
                    .replaceAll("\\[SWAGGER_LINK\\]", swaggerLink);
        }
        return index;
    }
}
