package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pracownicy")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pracownika", nullable = false)
    private int workerId;
    @Column(name = "imie")
    private String name;
    @Column(name = "nazwisko")
    private String lastName;
    @Column(name = "kolor_oczu")
    private String eyeColor;
    @Column(name = "wzrost")
    private int height;
    @Column(name = "plec", length = 1)
    private String gender;
    @Column(name = "telefon")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "PESEL")
    private String personalIdentityl;
    @Column(name = "data_urodzin")
    private LocalDate birthdate;
    @ManyToOne
    @JoinColumn(name = "id_stanowiska")
    private Standing standing;
    @Column(name = "wynagrodzenie")
    private int salary;
    @ManyToOne
    @JoinColumn(name = "id_firmy")
    private Company company;

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalIdentityl() {
        return personalIdentityl;
    }

    public void setPersonalIdentityl(String personalIdentityl) {
        this.personalIdentityl = personalIdentityl;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Standing getStanding() {
        return standing;
    }

    public void setStanding(Standing standing) {
        this.standing = standing;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "workerId=" + workerId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", height=" + height +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", personalIdentityl='" + personalIdentityl + '\'' +
                ", birthdate=" + birthdate +
                ", standing=" + standing +
                ", salary=" + salary +
                ", company=" + company +
                '}';
    }
}
