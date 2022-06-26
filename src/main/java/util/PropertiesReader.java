package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    Properties properties = new Properties();

    public PropertiesReader() {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("src/main/resources/data.properties");
            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public String getDriverName() {
        return properties.getProperty("DRIVER_NAME");
    }

    public String getDriverLocation() {
        return properties.getProperty("DRIVER_LOCATION");
    }

    public String getBaseUrl() {
        return properties.getProperty("BASE_URL");
    }

    public int getDefaultWaitTime() {
        return Integer.parseInt(properties.getProperty("DEFAULT_WAIT_TIME"));
    }

    public String getCorrectEmail() {
        return properties.getProperty("CORRECT_EMAIL");
    }

    public String getIncorrectEmail() {
        return properties.getProperty("INCORRECT_EMAIL");
    }

    public String getCorrectPassword() {
        return properties.getProperty("CORRECT_PASSWORD");
    }

    public String getIncorrectPassword() {
        return properties.getProperty("INCORRECT_PASSWORD");
    }

    public String getHomePageUrl() {
        return properties.getProperty("HOME_PAGE_URL");
    }

    public String getBaseApiUrl() {
        return properties.getProperty("API_BASE_URL");
    }

    public String getApiEndpoint() {
        return properties.getProperty("API_ENDPOINT");
    }

    public int getStatusCode200() {
        return Integer.parseInt(properties.getProperty("API_STATUS_CODE_200"));
    }

    public String getApiResponseBodyName() {
        return properties.getProperty("API_RESPONSE_BODY_NAME");
    }

    public String getApiResponseExpectedName() {
        return properties.getProperty("API_RESPONSE_EXPECTED_NAME");
    }

}
