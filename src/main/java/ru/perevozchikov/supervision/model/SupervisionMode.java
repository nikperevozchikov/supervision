package ru.perevozchikov.supervision.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "supervisionModes")
//@Data
public class SupervisionMode {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supervision_id_seq")
//    @SequenceGenerator(name = "supervision_id_seq")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "resultOfEvent")
    private String resultOfEvent;


    @OneToMany(mappedBy = "supervisionMode")
    @JsonIgnore
    private List<Organization> organizations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResultOfEvent() {
        return resultOfEvent;
    }

    public void setResultOfEvent(String resultOfEvent) {
        this.resultOfEvent = resultOfEvent;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public SupervisionMode(int id, String name, String resultOfEvent) {
        this.id = id;
        this.name = name;
        this.resultOfEvent = resultOfEvent;
    }

    public SupervisionMode(int id, String name, String resultOfEvent, List<Organization> organizations) {
        this.id = id;
        this.name = name;
        this.resultOfEvent = resultOfEvent;
        this.organizations = organizations;
    }

    public SupervisionMode(String name, String resultOfEvent, List<Organization> organizations) {
        this.name = name;
        this.resultOfEvent = resultOfEvent;
        this.organizations = organizations;
    }

    public SupervisionMode(String name, String resultOfEvent) {
        this.name = name;
        this.resultOfEvent = resultOfEvent;
    }

    public SupervisionMode() {
    }
}
