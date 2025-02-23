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
//        try {
//            CSVParser parser = CSVParser.parse(new FileReader(filename), format);
//            List<CSVRecord> records = parser.getRecords();
//
//            records.forEach(record -> {
//                try {
//                    Recipe recipe = new Recipe();
//
//                    recipe.setCookingMinutes(Integer.parseInt(record.get("Cooking Minutes")));
//                    recipe.setDairyFree(Boolean.parseBoolean(record.get("Dairy Free")));
//                    recipe.setGlutenFree(Boolean.parseBoolean(record.get("Gluten Free")));
//                    recipe.setInstructions(record.get("Instructions"));
//                    recipe.setPreparationMinutes(Double.parseDouble(record.get("Preparation Minutes")));
//                    recipe.setPricePerServing(Double.parseDouble(record.get("Price Per Serving")));
//                    recipe.setReadyInMinutes(Integer.parseInt(record.get("Ready In Minutes")));
//                    recipe.setServings(Integer.parseInt(record.get("Servings")));
//                    recipe.setSpoonacularScore(Double.parseDouble(record.get("Spoonacular Score")));
//                    recipe.setTitle(record.get("Title"));
//                    recipe.setVegan(Boolean.parseBoolean(record.get("Vegan")));
//                    recipe.setVegetarian(Boolean.parseBoolean(record.get("Vegetarian")));
//
//                    recipeList.add(recipe);
//                } catch (NullPointerException | IllegalArgumentException e) {
//                    System.err.println("Error processing record: " + record + "\n" + e);
//                }
//            });
//        } catch (IOException e) {
//            System.err.println("Error while reading and parsing " + filename + "\n" + e);
//        }
//        return recipeList;
//    }
//}
