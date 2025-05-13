
package com.example.myFirstProject.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="employee")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="department")
    private String department;

    //  required by jpa
    public Employee() {
    }

    public Employee(int id, String name, String email,String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;

    }

}

;