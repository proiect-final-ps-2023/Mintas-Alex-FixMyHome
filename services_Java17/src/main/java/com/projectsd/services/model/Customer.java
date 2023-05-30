package com.projectsd.services.model;

import com.projectsd.services.enumeration.Housing;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMERS")
public class Customer extends User {

    private Housing housing;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Worker> workers;

    public Customer(String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, Housing housing) {
        super(firstName, lastName, email, phoneNumber, dateOfBirth);
        this.housing = housing;
    }
}
