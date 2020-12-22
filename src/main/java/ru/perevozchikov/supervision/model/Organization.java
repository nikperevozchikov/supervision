package ru.perevozchikov.supervision.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "organizations")
//@Data
public class Organization {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_id_seq")
//    @SequenceGenerator(name = "organization_id_seq")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "dateFoundation")
    Date dateFoundation;
//    @Column(name = "datetime", nullable = false)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
//    private LocalDate dateFoundation;

    @Column(name = "ogrn")
    private String ogrn;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "event", nullable = false)
    private Event event;


    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "supervisionMode", nullable = false)
    private SupervisionMode supervisionMode;

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

    public Date getDateFoundation() {
        return dateFoundation;
    }

    public void setDateFoundation(Date dateFoundation) {
        this.dateFoundation = dateFoundation;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public SupervisionMode getSupervisionMode() {
        return supervisionMode;
    }

    public void setSupervisionMode(SupervisionMode supervisionMode) {
        this.supervisionMode = supervisionMode;
    }

    public Organization(String name, String ogrn, Event event, Employee employee, SupervisionMode supervisionMode) {
        this.name = name;
        this.ogrn = ogrn;
        this.event = event;
        this.employee = employee;
        this.supervisionMode = supervisionMode;
    }

    public Organization(int id, String name, String ogrn, Event event, Employee employee, SupervisionMode supervisionMode) {
        this.id = id;
        this.name = name;
        this.ogrn = ogrn;
        this.event = event;
        this.employee = employee;
        this.supervisionMode = supervisionMode;
    }

    public Organization(int id, String name, Date dateFoundation, String ogrn, Event event, Employee employee) {
        this.id = id;
        this.name = name;
        this.dateFoundation = dateFoundation;
        this.ogrn = ogrn;
        this.event = event;
        this.employee = employee;
    }

    public Organization(int id, String name, Date dateFoundation, String ogrn, Event event, Employee employee, SupervisionMode supervisionMode) {
        this.id = id;
        this.name = name;
        this.dateFoundation = dateFoundation;
        this.ogrn = ogrn;
        this.event = event;
        this.employee = employee;
        this.supervisionMode = supervisionMode;
    }

    public Organization(String name, Date dateFoundation, String ogrn, Event event, Employee employee, SupervisionMode supervisionMode) {
        this.name = name;
        this.dateFoundation = dateFoundation;
        this.ogrn = ogrn;
        this.event = event;
        this.employee = employee;
        this.supervisionMode = supervisionMode;
    }

    public Organization(String name, Date dateFoundation, String ogrn, Event event, Employee employee) {
        this.name = name;
        this.dateFoundation = dateFoundation;
        this.ogrn = ogrn;
        this.event = event;
        this.employee = employee;
    }

    public Organization() {
    }
}
