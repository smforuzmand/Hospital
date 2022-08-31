package jdbc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class DataBAseCredential {

    // the purpose of this class is to read our properties file;


    private String URL;
    private String userName;
    private String password;

// Now we gonna make a method a constructor to read the properties file so the next step is to read thouse files
    // the properties file has a different class that we can call them from jvc


    public DataBAseCredential() {


        Path path = Paths.get("dataBase/mySQL.properties");

        Properties properties = new Properties();
        //we need to call a method for this object to load the information from our file and also we need t define path
        try {
            properties.load(Files.newBufferedReader(path));
            //after loading the path we need to retrive the information of it so we gonna use the get information

            userName=properties.getProperty("username");
            password=properties.getProperty("password");
            URL=properties.getProperty("url");


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(userName + password + URL);

    }


    public String getURL() {
        return URL;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
