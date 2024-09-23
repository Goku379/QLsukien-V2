package com.example.qlsukien.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "approval_roles")
public class ApprovalRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String roleName;

    @Column(nullable = false, unique = true)
    private int approvalOrder;

    // Getters, Setters, and Constructors
}
