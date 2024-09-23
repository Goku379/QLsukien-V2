package com.example.qlsukien.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "event_logs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_plan_id", referencedColumnName = "id")
    private EventPlan eventPlan;

    @Column(nullable = false)
    private String action;

    @ManyToOne
    @JoinColumn(name = "performed_by", referencedColumnName = "id")
    private User performedBy;

    @Column(name = "log_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date logDate = new Date();

    @Column
    private String details;

    // Getters, Setters, and Constructors
}
