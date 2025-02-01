package com.tutorialsninja.dataproviders;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class RegistrationDataProvider {
	@DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() throws IOException, CsvException {
        String csvFile = "src/test/resources/testdata/registration_data.csv";
        CSVReader reader = new CSVReader(new FileReader(csvFile));
        List<String[]> data = reader.readAll();
        reader.close();
        
        Object[][] testData = new Object[data.size() - 1][7]; // Skip header
        for(int i = 1; i < data.size(); i++) {
            testData[i - 1] = data.get(i);
        }
        return testData;
    }

}
