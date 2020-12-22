package ru.perevozchikov.supervision.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "events")
//@Data
public class Event {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_seq")
//    @SequenceGenerator(name = "event_id_seq")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "dateOfEvent")
    Date dateOfEvent;
//    @Column(name = "datetime")//, nullable = false)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
//    private LocalDateTime dateOfEvent;

    @Column(name = "resultOfEvent")//, nullable = false)
    private String resultOfEvent;

    @OneToMany(mappedBy = "event")
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

    public Date getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(Date dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
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

    public Event(String name, String resultOfEvent) {
        this.name = name;
        this.resultOfEvent = resultOfEvent;
    }

    public Event(String name, String resultOfEvent, List<Organization> organizations) {
        this.name = name;
        this.resultOfEvent = resultOfEvent;
        this.organizations = organizations;
    }

    public Event(int id, String name, String resultOfEvent) {
        this.id = id;
        this.name = name;
        this.resultOfEvent = resultOfEvent;
    }

    public Event(int id, String name, String resultOfEvent, List<Organization> organizations) {
        this.id = id;
        this.name = name;
        this.resultOfEvent = resultOfEvent;
        this.organizations = organizations;
    }

    public Event(int id, String name, Date dateOfEvent, String resultOfEvent) {
        this.id = id;
        this.name = name;
        this.dateOfEvent = dateOfEvent;
        this.resultOfEvent = resultOfEvent;
    }

    public Event(int id, String name, Date dateOfEvent, String resultOfEvent, List<Organization> organizations) {
        this.id = id;
        this.name = name;
        this.dateOfEvent = dateOfEvent;
        this.resultOfEvent = resultOfEvent;
        this.organizations = organizations;
    }

    public Event(String name, Date dateOfEvent, String resultOfEvent, List<Organization> organizations) {
        this.name = name;
        this.dateOfEvent = dateOfEvent;
        this.resultOfEvent = resultOfEvent;
        this.organizations = organizations;
    }

    public Event(String name, Date dateOfEvent, String resultOfEvent) {
        this.name = name;
        this.dateOfEvent = dateOfEvent;
        this.resultOfEvent = resultOfEvent;
    }

    public Event() {
    }
    //    @ManyToMany
//    @JoinTable(
//            name = "employee_event",
//            joinColumns = {@JoinColumn(name = "event_name")},
//            inverseJoinColumns = {@JoinColumn(name = "employee_id")}
//    )
//    @JsonIgnoreProperties("events")
//    private List<Employee> employees;

}
