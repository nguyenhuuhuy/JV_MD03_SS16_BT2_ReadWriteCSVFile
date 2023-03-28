package demo.bt2;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvWriterCountry {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    private static final String FINE_HEADER =" id,   code,   name";

    public static void writeCsvFile(String fileName){
        Country country1 = new Country(1,"DL","COlobia");
        Country country2 = new Country(2,"DL","Yasso");
        Country country3 = new Country(3,"DL","Youne");
        Country country4 = new Country(4,"DL","Teemo");

        List<Country> countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);
        countries.add(country4);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);

            fileWriter.append(FINE_HEADER);

            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Country country : countries){
                fileWriter.append(String.valueOf(country.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(country.getCode());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(country.getName());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("đã được viết thêm!");
        } catch (IOException e) {
            System.out.println("không tìm thấy file!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Lỗi không ghi được vào file!");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String fileName = "src/demo/bt2/countries.csv";
        writeCsvFile(fileName);
    }
}
