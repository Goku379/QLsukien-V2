package com.example.qlsukien.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "event_issues")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @Column(nullable = false)
    private String issueDescription;

    @Column(name = "reported_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportedAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date resolvedAt;

    @Temporal(TemporalType.DATE)
    private Date newScheduledDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IssueStatus status = IssueStatus.PENDING;

    // Getters, Setters, and Constructors
    public enum IssueStatus {
        PENDING,   // Vấn đề đang chờ giải quyết
        RESOLVED   // Vấn đề đã được giải quyết
    }
}
