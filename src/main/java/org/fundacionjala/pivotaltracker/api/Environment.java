package org.fundacionjala.pivotaltracker.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by LourdesVillca on 8/31/2016.
 */
public class Environment {

    private static final String CONFIG = "config.properties";

    private static final String AUTHENTICATION_TOKEN = "authentication.token";

    private static Environment environment;

    private Properties properties;

    private Environment() {
        File file = new File(CONFIG);
        try (FileReader fileReader = new FileReader(file)) {
            properties = new Properties();
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Environment getInstance(){
        if(environment == null){
            environment = new Environment();
        }
        return environment;
    }

    public String getEnv(String env) {
        return properties.getProperty(env);
    }

    public String getBaseUri() {
        return getEnv("authentication.baseURI");
    }


    public String getProxy() {
        return getEnv("authentication.proxy");
    }

    public String getToken() {
        return getEnv(AUTHENTICATION_TOKEN);
    }
}
