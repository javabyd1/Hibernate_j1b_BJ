package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stanowiska")
public class Standing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stanowiska")
    private int standingId;
    @Column(name = "nazwa")
    private String name;

    @OneToMany(mappedBy="standing", cascade = CascadeType.ALL)
    private List<Worker> workers;

    public int getStandingId() {
        return standingId;
    }

    public void setStandingId(int standingId) {
        this.standingId = standingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "Standing{" +
                "standingId=" + standingId +
                ", name='" + name + '\'' +
                ", workers=" + workers +
                '}';
    }
}
