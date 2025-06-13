import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EcommerceScraper {

    public static void main(String[] args) {
        // URL of the e-commerce website (Replace with the actual URL)
        String url = "https://example-ecommerce.com/products";

        // Output CSV file
        String csvFile = "products.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            // Writing the header to the CSV file
            writer.write("Product Name,Price,Rating\n");

            // Connect to the website and get the document
            Document document = Jsoup.connect(url).get();

            // Select the elements containing product information
            Elements products = document.select(".product-item"); // Update selector as per the website's structure

            for (Element product : products) {
                String name = product.select(".product-name").text(); // Update selector
                String price = product.select(".product-price").text(); // Update selector
                String rating = product.select(".product-rating").text(); // Update selector

                // Write product information to the CSV
                writer.write(String.format("%s,%s,%s\n", name, price, rating));
            }

            System.out.println("Product information has been extracted and saved to " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
XML
<dependency>
    <groupId>org.jsoup</groupId>
    <artifactId>jsoup</artifactId>
    <version>1.14.3</version> <!-- Check for the latest version -->
</dependency>
