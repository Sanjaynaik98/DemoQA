package com.demoqa.webautomation.utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// Helper method to read data from JSON and convert it to a 2D Object array
	private Object[][] getDataFromJson(String filePath) throws IOException {
		DataReader dataReader = new DataReader();
		List<HashMap<String, String>> data = dataReader.getJsonDataToMap(filePath);

		System.out.println("Data read from JSON: " + data);

		Object[][] dataArray = new Object[data.size()][1];
		for (int i = 0; i < data.size(); i++) {
			dataArray[i][0] = data.get(i); // Each row contains a single HashMap
		}

		return dataArray;
	}

	// DataProvider for valid data

	@DataProvider(name = "validFormData")
	public Object[][] getValidFormData() throws IOException {
		return getDataFromJson(System.getProperty("user.dir") + "\\Test-Data\\formValidData.json");
	}

	@DataProvider(name = "registrationFormValidData")
	public Object[][] getRegistrationFormValidData() throws IOException {
		return getDataFromJson(System.getProperty("user.dir") + "\\Test-Data\\registrationFormValidData.json");
	}

	@DataProvider(name = "preDefinedWebTableData")
	public Object[][] getPredefinedWebTableData() throws IOException {
		return getDataFromJson(System.getProperty("user.dir") + "\\Test-Data\\preDefinedWebTableData.json");
	}

	@DataProvider(name = "editData")
	public Object[][] getEditData() throws IOException {
		return getDataFromJson(System.getProperty("user.dir") + "\\Test-Data\\editData.json");
	}

	@DataProvider(name = "validName")
	public Object[][] getValidName() throws IOException {
		return getDataFromJson(System.getProperty("user.dir") + "\\Test-Data\\validName.json");
	}
	
	@DataProvider(name = "editWithValidName")
	public Object[][] getEditWithValidName() throws IOException {

	    Object[][] editData = getEditData();      // HashMap from editData.json
	    Object[][] validName = getValidName();    // HashMap from validName.json

	    int size = Math.min(editData.length, validName.length);
	    Object[][] combined = new Object[size][2];

	    for (int i = 0; i < size; i++) {
	        combined[i][0] = editData[i][0];     // Edit record HashMap
	        combined[i][1] = validName[i][0];    // Valid name HashMap
	    }

	    return combined;
	}


}
