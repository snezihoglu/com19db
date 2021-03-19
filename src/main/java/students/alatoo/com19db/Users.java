package students.alatoo.com19db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    public Users() {}

    public Users(Integer id, String name, String email, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + email.hashCode() + phoneNumber.hashCode() +address.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (((Users) obj).getName().equals(name))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return name + ":" + email + ";" + phoneNumber +  ";" + address;
    }


}
