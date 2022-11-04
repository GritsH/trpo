package by.novikgrits.webapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Objects;

public class User {
    @Id
    private Integer id;
    @Column("role")
    private String roleName;
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;
    @Column("email")
    private String email;
    @Column("password")
    private String password;
    @Column("phone")
    private Integer phone;
    @Column("passport_number")
    private String passportNumber;

    public User(String roleName,
                String firstName, String lastName,
                String email, String password,
                Integer phone, String passportNumber) {
        this.roleName = roleName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.passportNumber = passportNumber;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(roleName, user.roleName) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(phone, user.phone) && Objects.equals(passportNumber, user.passportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, firstName, lastName, email, password, phone, passportNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }
}
