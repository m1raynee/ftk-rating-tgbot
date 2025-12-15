package com.m1raynee.db.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.m1raynee.db.enums.EventCategory;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "date_time")
    private LocalDateTime eventDateTime;

    private boolean isActive = false;

    @Column(name = "event_category_code", length = 8)
    private EventCategory eventCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = true)
    private Group group;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RatingEntry> ratingEntries;

    public Event(Long id, String name, LocalDateTime eventDateTime, Group group) {
        this.id = id;
        this.name = name;
        this.eventDateTime = eventDateTime;
        this.group = group;
    }
}
