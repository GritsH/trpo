package by.novikgrits.webapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Objects;

public class User {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer roleId;
    private Integer phone;
    private String passportData;

    public User(String email, String password, String firstName, String lastName, Integer roleId, Integer phone, String passportData) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleId = roleId;
        this.phone = phone;
        this.passportData = passportData;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getRoleId() {
        return roleId;
    }


    public Integer getPhone() {
        return phone;
    }

    public String getPassportData() {
        return passportData;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(roleId, user.roleId) && Objects.equals(phone, user.phone) && Objects.equals(passportData, user.passportData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, firstName, lastName, roleId, phone, passportData);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roleId=" + roleId +
                ", phone=" + phone +
                ", passportData='" + passportData + '\'' +
                '}';
    }
}
