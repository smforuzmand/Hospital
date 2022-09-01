package jdbc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class DataBaseCredential {

    // the purpose of this class is to read our properties file;


    private String url;
    private String userName;
    private String password;

// Now we gonna make a method a constructor to read the properties file so the next step is to read thouse files
    // the properties file has a different class that we can call them from jvc
// we also are going to set the singleton design pattern in this class to strengthen the security.


    //1.
    public static DataBaseCredential instance;

    public static DataBaseCredential getInstance() {
        if(instance==null) throw new IllegalArgumentException("please provide the initializer");
        return instance;
    }

    // Once we call the initializer . it assists us to create an instance for that class , here is access to credential information
    public static void Initializer(String url) {

        instance = new DataBaseCredential();
        instance.loadProperties(Paths.get(url));


    }



    private void loadProperties(Path path){
        Properties properties = new Properties();
        //we need to call a method for this object to load the information from our file, and also we need t define path
        try {
            properties.load(Files.newBufferedReader(path));
            //after loading the path we need to retrive the information of it, so we're going to use the get information

            userName = properties.getProperty("username");
            password = properties.getProperty("password");
            url = properties.getProperty("url");


        } catch (IOException e) {
            e.printStackTrace();
        }

        //before using the singleton and getinstance method to call the information
        // System.out.println(userName + password + URL);


    }

    private DataBaseCredential() {
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "DataBaseCredential{" +
                "URL='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
