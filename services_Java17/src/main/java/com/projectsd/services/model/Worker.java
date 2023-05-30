package com.projectsd.services.model;

import com.projectsd.services.enumeration.Job;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "WORKERS")
public class Worker extends User {

    private Job job;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer customer;

    public Worker(String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, Job job) {
        super(firstName, lastName, email, phoneNumber, dateOfBirth);
        this.job = job;
    }
}
