package com.shymoniak.tools;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GSONFileReader<T> {
    private static final Gson GSON = new Gson();

    public List<T> readFromFile(File file, Class<T[]> klass) {
        List<T> entityList = null;
        try (FileReader fileReader = new FileReader(file.getPath())) {
            entityList = Arrays.asList(GSON.fromJson(fileReader, klass));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return entityList;
    }
}