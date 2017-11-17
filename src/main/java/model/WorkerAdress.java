package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pracownicy_adresy")
public class WorkerAdress {

    @OneToOne
    @JoinColumn(name="id_pracownika", nullable=false)
    private Worker worker;
    @OneToOne
    @JoinColumn(name="id_adresu", nullable=false)
    private Address address;
    @Column(name = "od")
    private LocalDate from;
    @Column(name = "do")
    private LocalDate to;

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "WorkerAdress{" +
                "worker=" + worker +
                ", address=" + address +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
