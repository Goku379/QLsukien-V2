package com.example.qlsukien.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "event_plans")
public class EventPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "semester_id", referencedColumnName = "id")
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlanStatus status = PlanStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "lead_id", referencedColumnName = "id")
    private User lead;

    @Column(name = "event_count")
    private int eventCount = 0;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt = new Date();

    // Getters, Setters, and Constructors
    public enum PlanStatus {
        PENDING, APPROVED, REJECTED
    }
}

