package com.example.qlsukien.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "event_approval_workflow")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_plan_id", referencedColumnName = "id")
    private EventPlan eventPlan;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private ApprovalRole role;

    @ManyToOne
    @JoinColumn(name = "approved_by", referencedColumnName = "id")
    private User approvedBy;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApprovalStatus status = ApprovalStatus.PENDING;

    @Column(name = "approved_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedAt;

    @Column
    private String comments;

    // Getters, Setters, and Constructors
    public enum ApprovalStatus {
        PENDING,   // Đang chờ phê duyệt
        APPROVED,  // Đã được phê duyệt
        REJECTED;  // Bị từ chối
    }
}
