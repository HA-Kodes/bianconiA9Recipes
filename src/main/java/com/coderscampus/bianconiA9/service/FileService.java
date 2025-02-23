package com.coderscampus.bianconiA9.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Service
public class FileService {
    private String filename;

    public FileService() {
    }

    public FileService(String filename) {
        this.filename = "recipes.txt";
    }

    public Iterable<CSVRecord> readFile() throws IOException {
        Reader reader = new FileReader(filename);

        String[] HEADERS = {"Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", "Preparation Minutes", "Price Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan", "Vegetarian"};

        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .setSkipHeaderRecord(true)
                .setTrim(true).setQuote('"')
                .setEscape('\\')
                .setIgnoreSurroundingSpaces(true)
                .build();

        return format.parse(reader);
    }
}