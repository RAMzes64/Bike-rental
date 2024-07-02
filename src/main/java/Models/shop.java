package Models;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class shop {

    private String name;

    private String address;

    private int id;

    public shop(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return name;
    }
}
