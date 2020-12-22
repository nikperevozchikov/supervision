package ru.perevozchikov.supervision.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
//@Data
public class Employee extends User {
    @Column(name = "address", nullable = false)
    private String registrationAddress;

//    @Column(nullable = false)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
//    private LocalDate birthday;


    //    @ManyToOne
//    @JoinColumn
//    @JsonIgnore
//    private Position position;
//
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "position_name", nullable = false)
    private Position position;

//    @ManyToMany
//    @JoinTable(
//            name = "employee_event",
//            joinColumns = {@JoinColumn(name = "employee_id")},
//            inverseJoinColumns = {@JoinColumn(name = "event_name")}
//    )
//    @JsonIgnoreProperties("employees")
//    private List<Event> events;

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Employee() {
    }

    public Employee(String registrationAddress, Position position) {
        this.registrationAddress = registrationAddress;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "registrationAddress='" + registrationAddress + '\'' +
                ", position=" + position +
                '}';
    }
}
