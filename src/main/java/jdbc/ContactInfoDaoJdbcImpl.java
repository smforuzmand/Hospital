package jdbc;

import dao.ContactInfoDao;
import model.ContactInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactInfoDaoJdbcImpl implements ContactInfoDao {


    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DataBaseCredential.getInstance().getURL(),
                DataBaseCredential.getInstance().getUserName(),
                DataBaseCredential.instance.getPassword());
    }


    public static ContactInfo mapToContactInfo(ResultSet resultSet) throws SQLException {

        return new ContactInfo(resultSet.getString("id"),
                resultSet.getString("email"),
                resultSet.getString("phone"),
                resultSet.getString("address"));


    }

    @Override
    public Optional<ContactInfo> findById(String id) {
        Optional<ContactInfo> found = Optional.empty();

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contact_info WHERE id = ?");

            preparedStatement.setString(1, id);
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){

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
    public ContactInfo create(ContactInfo contactInfo) {
        return null;
    }

    @Override
    public List<ContactInfo> findAll() {
        //now it is time to implement the jdbc through out java , first we need to define a collection to  store the data that we gather through this method.
        //second we need to connect our method to the database how?
        //third we gonna answer to that 'HOW' by something we have implemented through singleton
//forth we are going to do Prepared Statement
        //fifth then we need to store the results of our query in a Resultset
//sixth the we are going to run a method(While) to grab the information
        List<ContactInfo> infoList = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DataBaseCredential.getInstance().getURL(),
                    DataBaseCredential.getInstance().getUserName(),
                    DataBaseCredential.getInstance().getPassword());

            //In the PreparedStatement we are going to prepare a query through our connection to the sql
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contact_info");
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                //we are going to run a repetitive task for all rows
                // we also need to make a method to help us do this method easily in a better way
                infoList.add(new ContactInfo(resultSet.getString("id"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("address")));


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return infoList;
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
