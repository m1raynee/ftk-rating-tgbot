package com.m1raynee.db.entity;

import java.time.LocalDateTime;

import com.m1raynee.db.enums.RatingEntryType;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "rating_entries")
public class RatingEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pointsAwarded;
    private LocalDateTime dateAwarded = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "entry_type_code", length = 8)
    private RatingEntryType ratingType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "awarded_by_student_id", nullable = false)
    private Student awardedByStudent;

    public RatingEntry(int pointsAwarded, Event event, Student student, RatingEntryType ratingType,
            Student awardedByStudent) {
        this.pointsAwarded = pointsAwarded;
        this.event = event;
        this.student = student;
        this.ratingType = ratingType;
        this.awardedByStudent = awardedByStudent;
    }
}
