package com.shymoniak.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shymoniak.lab2.DecisionTreeEntity;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GSON<T> {
    private static final Gson GSON = new Gson();
    private static final GsonBuilder GSON_BUILDER = new GsonBuilder();

    public List<T> readFromFile(File file, Class<T[]> klass) {
        List<T> entityList = null;
        try (FileReader fileReader = new FileReader(file.getPath())) {
            entityList = Arrays.asList(GSON.fromJson(fileReader, klass));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return entityList;
    }

    public void writeIntoFile(File file, List<DecisionTreeEntity> entityList) {
        try (FileWriter fileWriter = new FileWriter(file.getPath())) {
            GSON_BUILDER.setPrettyPrinting().create().toJson(entityList, fileWriter);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
