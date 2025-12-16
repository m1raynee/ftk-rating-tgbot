package com.m1raynee.telegram.commands;

import java.util.List;

import com.m1raynee.db.HibernateConfiguration;
import com.m1raynee.db.entity.Student;

import io.github.natanimn.telebof.BotContext;
import io.github.natanimn.telebof.annotations.InlineHandler;
import io.github.natanimn.telebof.types.inline.InlineQueryResult;
import io.github.natanimn.telebof.types.inline.InlineQueryResultArticle;
import io.github.natanimn.telebof.types.input.InputTextMessageContent;
import io.github.natanimn.telebof.types.updates.InlineQuery;

public class InlineSelector {
    @InlineHandler(filter = (context, query) -> {
    })
    void studentSelection(BotContext context, InlineQuery query) {
        var name = query.query.substring("create student ".length());
        if (name == "") {
            var result = new InlineQueryResultArticle("null", "Создание ученика...",
                    new InputTextMessageContent("Ничего не введено"))
                    .description("Начните вводить имя ученика");

            context.answerInlineQuery(query.id, new InlineQueryResult[] { result }).exec();
            return;
        }

        var sessionFactory = HibernateConfiguration.getSessionFactory();
        sessionFactory.inSession(session -> {
            List<Student> alikes = session.createSelectionQuery(
                    "from Student where name like :name limit(5)", Student.class)
                    .setParameter("name", name)
                    .getResultList();

        });

    }
}
