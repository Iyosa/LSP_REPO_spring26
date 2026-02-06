package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    public static void main(String[] args) {
        String inputFilePath = "data" + File.separator + "products.csv";
        String outputFilePath = "data" + File.separator + "transformed_products.csv";

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputFilePath);

        // Handle Case C: Missing input file [cite: 107, 108]
        if (!inputFile.exists()) {
            System.err.println("Error: Input file '" + inputFilePath + "' not found.");
            return;
        }

        // Ensure data directory exists
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line = reader.readLine();

            // Handle Case B: Empty input file (header only) [cite: 106]
            if (line != null) {
                // Write the required header [cite: 37, 38]
                writer.write("ProductID,Name,Price,Category,PriceRange");
                writer.newLine();

                while ((line = reader.readLine()) != null) {
                    rowsRead++; // Encountered non-header line [cite: 62]

                    if (line.trim().isEmpty()) {
                        rowsSkipped++;
                        continue;
                    }

                    String[] fields = line.split(",");

                    // Skip if not exactly four fields [cite: 48]
                    if (fields.length != 4) {
                        rowsSkipped++;
                        continue;
                    }

                    try {
                        // Trim whitespace around each field [cite: 41]
                        String productID = fields[0].trim();
                        String name = fields[1].trim();
                        String priceStr = fields[2].trim();
                        String category = fields[3].trim();

                        // Validate numeric parsing [cite: 49]
                        Integer.parseInt(productID);
                        double originalPrice = Double.parseDouble(priceStr);

                        // --- TRANSFORMATIONS ---
                        name = name.toUpperCase(); // 1. Uppercase [cite: 23]

                        double finalPrice = originalPrice;
                        if (category.equalsIgnoreCase("Electronics")) {
                            finalPrice = originalPrice * 0.90; // 2. 10% Discount [cite: 24]
                        }

                        // Round-half-up to exactly two decimal places [cite: 42]
                        BigDecimal bd = new BigDecimal(finalPrice).setScale(2, RoundingMode.HALF_UP);
                        finalPrice = bd.doubleValue();

                        // 3. Premium Electronics check [cite: 25, 26, 43]
                        if (category.equalsIgnoreCase("Electronics") && finalPrice > 500.00) {
                            category = "Premium Electronics";
                        }

                        // 4. PriceRange field [cite: 27, 28, 29, 30, 31]
                        String priceRange;
                        if (finalPrice <= 10.00) {
                            priceRange = "Low";
                        } else if (finalPrice <= 100.00) {
                            priceRange = "Medium";
                        } else if (finalPrice <= 500.00) {
                            priceRange = "High";
                        } else {
                            priceRange = "Premium";
                        }

                        // --- LOAD ---
                        String formattedPrice = String.format("%.2f", finalPrice); // [cite: 44]
                        writer.write(String.format("%s,%s,%s,%s,%s",
                                productID, name, formattedPrice, category, priceRange));
                        writer.newLine();

                        rowsTransformed++;

                    } catch (NumberFormatException e) {
                        rowsSkipped++; // Skip if ProductID or Price cannot be parsed [cite: 49]
                    }
                }
            } else {
                // If file is completely empty, create header only [cite: 58, 59]
                writer.write("ProductID,Name,Price,Category,PriceRange");
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error accessing files: " + e.getMessage());
        }

        // --- RUN SUMMARY --- [cite: 60, 61, 62, 63, 64, 65]
        System.out.println("Run Summary:");
        System.out.println("Number of rows read: " + rowsRead);
        System.out.println("Number of rows transformed: " + rowsTransformed);
        System.out.println("Number of rows skipped: " + rowsSkipped);
        System.out.println("Output file path: " + outputFilePath);
    }
}