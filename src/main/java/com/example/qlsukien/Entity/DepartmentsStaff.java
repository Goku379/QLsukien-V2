package com.example.qlsukien.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "departments_staff")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentsStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "joined_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinedAt = new Date();

    // Getters, Setters, and Constructors
}
