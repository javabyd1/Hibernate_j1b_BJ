package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "firmy")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_firmy", nullable = false)
    private int companyId;
    @Column(name = "nazwa")
    private String name;
    @Column(name = "ulica")
    private String street;
    @Column(name = "numer_domu")
    private String home_number;
    @Column(name = "numer_mieszkania")
    private String flat_number;
    @Column(name = "nip")
    private String nip;
    @OneToMany(mappedBy="company", cascade = CascadeType.ALL)
    private List<Worker> workers;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHome_number() {
        return home_number;
    }

    public void setHome_number(String home_number) {
        this.home_number = home_number;
    }

    public String getFlat_number() {
        return flat_number;
    }

    public void setFlat_number(String flat_number) {
        this.flat_number = flat_number;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", home_number='" + home_number + '\'' +
                ", flat_number='" + flat_number + '\'' +
                ", nip='" + nip + '\'' +
                '}';
    }
}
