package config;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Log4j2
public class ConfigurationProperties {
    public static final String API_URL;
    public static final String REPO_PATH;
    public static final String API_VERSION;
    public static final String API_TOKEN;
    private static final Properties configuration;

    static {
        configuration = new Properties();
        try {
            InputStream file = Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.properties");
            configuration.load(file);
            if (file != null) file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        API_URL = getProperty("api_url");
        REPO_PATH = getProperty("repo_path");
        API_VERSION = getProperty("api_version");
        API_TOKEN = getProperty("api_token");

        log.info("Initializing project with configuration: ");
        log.info(String.format("API url: %s", API_URL));
        log.info(String.format("Repo path: %s", REPO_PATH));
    }

    private ConfigurationProperties() {
    }

    public static String getFullURL() {
        return API_URL + REPO_PATH;
    }

    public static String getProperty(String key) {
        if (System.getProperty(key) == null || System.getProperty(key).isEmpty()) {
            return configuration.getProperty(key);
        } else {
            return System.getProperty(key);
        }
    }
}