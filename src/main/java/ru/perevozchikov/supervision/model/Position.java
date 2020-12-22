package ru.perevozchikov.supervision.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "positions")
//@Data
public class Position {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_id_seq")
//    @SequenceGenerator(name = "position_id_seq")
//    private int id;

    @Id
    private String name;

    @OneToMany(mappedBy = "position")
    @JsonIgnore
    private List<Employee> employees;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Position(String name) {
        this.name = name;
    }

    public Position(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public Position() {
    }
}

