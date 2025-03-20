package gr.uom.demo1.models;

public class User {
    private String email;
    private int am;

    public User(String email, int am) {
        this.email = email;
        this.am = am;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAm() {
        return am;
    }

    public void setAm(int am) {
        this.am = am;
    }
}
