package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * ETLPipeline implements a simple Extract-Transform-Load process for product
 * data.
 * It reads from data/products.csv and outputs to data/transformed_products.csv.
 */
public class ETLPipeline {

    public static void main(String[] args) {
        String inputFilePath = "data" + File.separator + "products.csv";
        String outputFilePath = "data" + File.separator + "transformed_products.csv";
        
        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputFilePath);
        
        [span_0](start_span)[span_1](start_span)// Handle Case C: Missing input file[span_0](end_span)[span_1](end_span)
        if (!inputFile.exists()) {
            System.err.println("Error: Input file '" + inputFilePath + "' not found.");
            return; 
        }

        // Ensure data directory exists for output
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line = reader.readLine();
            
            [span_2](start_span)[span_3](start_span)// Handle Case B: Empty input file (header only)[span_2](end_span)[span_3](end_span)
            if (line != null) {
                [span_4](start_span)// Write the required header[span_4](end_span)
                writer.write("ProductID,Name,Price,Category,PriceRange");
                writer.newLine();
                
                // Process data rows
                while ((line = reader.readLine()) != null) {
                    [span_5](start_span)rowsRead++;[span_5](end_span)
                    
                    [span_6](start_span)// Skip blank lines[span_6](end_span)
                    if (line.trim().isEmpty()) {
                        rowsSkipped++;
                        continue;
                    }

                    String[] fields = line.split(",");
                    
                    [span_7](start_span)[span_8](start_span)// Skip if not exactly four fields[span_7](end_span)[span_8](end_span)
                    if (fields.length != 4) {
                        rowsSkipped++;
                        continue;
                    }

                    try {
                        [span_9](start_span)// Trim whitespace around fields[span_9](end_span)
                        String productID = fields[0].trim();
                        String name = fields[1].trim();
                        String priceStr = fields[2].trim();
                        String category = fields[3].trim();

                        [span_10](start_span)// Validate numeric parsing[span_10](end_span)
                        Integer.parseInt(productID);
                        double originalPrice = Double.parseDouble(priceStr);

                        // --- TRANSFORMATIONS ---
                        
                        [span_11](start_span)// 1. Convert name to UPPERCASE[span_11](end_span)
                        name = name.toUpperCase();

                        [span_12](start_span)// 2. Apply 10% discount to Electronics[span_12](end_span)
                        double finalPrice = originalPrice;
                        if (category.equalsIgnoreCase("Electronics")) {
                            finalPrice = originalPrice * 0.90;
                        }

                        [span_13](start_span)[span_14](start_span)// Rounding: Round-half-up to exactly two decimal places[span_13](end_span)[span_14](end_span)
                        BigDecimal bd = new BigDecimal(finalPrice).setScale(2, RoundingMode.HALF_UP);
                        finalPrice = bd.doubleValue();

                        [span_15](start_span)[span_16](start_span)// 3. Change to Premium Electronics if > $500.00 and was Electronics[span_15](end_span)[span_16](end_span)
                        if (category.equalsIgnoreCase("Electronics") && finalPrice > 500.00) {
                            category = "Premium Electronics";
                        }

                        [span_17](start_span)[span_18](start_span)// 4. Add PriceRange based on final rounded price[span_17](end_span)[span_18](end_span)
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
                        
                        [span_19](start_span)[span_20](start_span)// Write formatted output[span_19](end_span)[span_20](end_span)
                        String formattedPrice = String.format("%.2f", finalPrice);
                        writer.write(String.format("%s,%s,%s,%s,%s", 
                                     productID, name, formattedPrice, category, priceRange));
                        writer.newLine();
                        
                        [span_21](start_span)rowsTransformed++;[span_21](end_span)

                    } catch (NumberFormatException e) {
                        [span_22](start_span)// Skip if ProductID or Price cannot be parsed[span_22](end_span)
                        rowsSkipped++;
                    }
                }
            } else {
                [span_23](start_span)// If file is completely empty (no header), requirement implies creating header only[span_23](end_span)
                writer.write("ProductID,Name,Price,Category,PriceRange");
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error accessing files: " + e.getMessage());
        }

        [span_24](start_span)// --- RUN SUMMARY ---[span_24](end_span)
        System.out.println("Run Summary:");
        System.out.println("Number of rows read: " + rowsRead);
        System.out.println("Number of rows transformed: " + rowsTransformed);
        System.out.println("Number of rows skipped: " + rowsSkipped);
        System.out.println("Output file path: " + outputFilePath);
    }
}
