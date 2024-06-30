package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    protected int _id;

    protected String _name;

    protected String _password;

    protected String _Passport;


    protected static PreparedStatement statement;

    protected static ResultSet resultSet;

    public int getId(){
        return _id;
    }

}
