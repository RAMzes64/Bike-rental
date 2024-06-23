package Models;

abstract class User {
    protected int _id;

    protected String _name;

    protected String _password;

    protected int _seriesPassport;

    protected int _numberPassport;

    public int getId(){
        return _id;
    }
}
