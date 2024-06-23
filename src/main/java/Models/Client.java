package Models;

public class Client extends User{

    private String _address;

    private String _city;

    public Client(int id, String name, String password, int seriesPassport, int numberPassword){
        _id = id;
        _name = name;
        _password = password;
        _seriesPassport = seriesPassport;
        _numberPassword = numberPassword;
    }

    public void setAddress(DataBaseSingleton db,String address, String city){
        _address = address;
        _city = city;
    }


}
