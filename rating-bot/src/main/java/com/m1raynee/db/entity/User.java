package com.m1raynee.db.entity;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "system_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NaturalId
    Long telegramId;

    @OneToOne(fetch = FetchType.LAZY)
    Student student;

    public User(Long telegramId) {
        this.telegramId = telegramId;
    }
}
