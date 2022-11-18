package by.novikgrits.webapp.model;

import java.util.Objects;

public class User {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String roleName;
    private String phone;
    private String passportData;

    public User(String email, String password, String firstName, String lastName, String roleName, String phone, String passportData) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleName = roleName;
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

    public String getRoleName() {
        return roleName;
    }


    public String getPhone() {
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

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setPhone(String phone) {
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
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(roleName, user.roleName) && Objects.equals(phone, user.phone) && Objects.equals(passportData, user.passportData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, firstName, lastName, roleName, phone, passportData);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roleId=" + roleName +
                ", phone=" + phone +
                ", passportData='" + passportData + '\'' +
                '}';
    }
}
