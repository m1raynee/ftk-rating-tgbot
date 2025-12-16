package com.m1raynee.telegram.commands;

import java.util.HashSet;
import java.util.Set;

import com.m1raynee.db.HibernateConfiguration;

import io.github.natanimn.telebof.filters.CustomFilter;
import io.github.natanimn.telebof.types.updates.Update;

public class AdminFilter implements CustomFilter {
    private static final Set<Long> cache = new HashSet<>();

    public boolean check(Update update) {
        var user_id = update.message.sender_chat.id;
        if (cache.isEmpty()) {
            var sessionFactory = HibernateConfiguration.getSessionFactory();
            sessionFactory.inSession(session -> {

            });
        }
    }
}
