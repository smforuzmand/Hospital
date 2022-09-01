package jdbc;

import model.ContactInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbstractDAO {
    protected static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DataBaseCredential.getInstance().getUrl(),
                DataBaseCredential.getInstance().getUserName(),
                DataBaseCredential.instance.getPassword());
    }

    public static ContactInfo mapToContactInfo(ResultSet resultSet) throws SQLException {

        return new ContactInfo(resultSet.getString("id"),
                resultSet.getString("email"),
                resultSet.getString("phone"),
                resultSet.getString("address"));


    }
}
