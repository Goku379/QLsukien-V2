package com.example.qlsukien.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "event_participants")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ParticipantStatus status = ParticipantStatus.REGISTERED;

    @Column(name = "registered_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt = new Date();

    @Column(name = "attended_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date attendedAt;

    // Getters, Setters, and Constructors
    public enum ParticipantStatus {
        REGISTERED, // Đã đăng ký tham gia sự kiện
        ATTENDED,   // Đã tham gia sự kiện
        CANCELED    // Đã hủy tham gia sự kiện
    }
}
