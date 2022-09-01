package jdbc;

import dao.ContactInfoDao;
import model.ContactInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactInfoDaoJdbcImpl extends AbstractDAO implements ContactInfoDao {

    // first of we have created the get connection in the implementation methods but after a while we concluded that it is better to extract it as a seprate method
    //here in the class named getConnection() but now we are going to move it to another class consider it as a Util but how?
    //we highlight the method then right click then choose extract superclass afterward select those methods that you are willing to shift them all into seprate class


    @Override
    public ContactInfo create(ContactInfo contactInfo) {


        int rowsAffected = Integer.MIN_VALUE;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contact_info (id, email, phone, address) VALUES (?, ? ,?, ?)");


            preparedStatement.setString(1, contactInfo.getId());
            preparedStatement.setString(2, contactInfo.getEmail());
            preparedStatement.setString(3, contactInfo.getPhone());
            preparedStatement.setString(4, contactInfo.getAddress());
            rowsAffected = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (rowsAffected == 1) {
            return contactInfo;
        } else
            return null;


    }


    @Override
    public Optional<ContactInfo> findById(String id) {
        Optional<ContactInfo> found = Optional.empty();

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contact_info WHERE id = ?");

            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                found = Optional.of(mapToContactInfo(resultSet));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found;
    }

    @Override
    public Optional<ContactInfo> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<ContactInfo> findAll() {
        //now it is time to implement the jdbc through out java , first we need to define a collection to  store the data that we gather through this method.
        //second we need to connect our method to the database how?
        //third we gonna answer to that 'HOW' by something we have implemented through singleton
        //forth we are going to do Prepared Statement
        //fifth then we need to store the results of our query in a Resultset
        //sixth they are going to run a method(While) to grab the information
        List<ContactInfo> infoList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

                    /*DriverManager.getConnection(DataBaseCredential.getInstance().getUrl(),
                    DataBaseCredential.getInstance().getUserName(),
                    DataBaseCredential.getInstance().getPassword());*/

            //In the PreparedStatement we are going to prepare a query through our connection to the sql
            preparedStatement = connection.prepareStatement("SELECT * FROM contact_info");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //we are going to run a repetitive task for all rows
                // we also need to make a method to help us do this method easily in a better way
                infoList.add(mapToContactInfo(resultSet));

            }

        } catch (SQLException e) {
            e.printStackTrace();

            // now we need to close all open sessions of application due to our database considerations;
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);


            }

            return infoList;
        }
    }

    @Override
    public Optional<ContactInfo> findByID(String s) {
        return Optional.empty();
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
