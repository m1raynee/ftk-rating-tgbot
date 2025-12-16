package com.m1raynee.telegram.commands;

import org.hibernate.Hibernate;

import com.m1raynee.db.HibernateConfiguration;

import io.github.natanimn.telebof.BotContext;
import io.github.natanimn.telebof.annotations.CallbackHandler;
import io.github.natanimn.telebof.annotations.MessageHandler;
import io.github.natanimn.telebof.types.keyboard.InlineKeyboardButton;
import io.github.natanimn.telebof.types.keyboard.InlineKeyboardMarkup;
import io.github.natanimn.telebof.types.updates.Message;
import io.github.natanimn.telebof.types.updates.CallbackQuery;

public class CreateComand {
    @MessageHandler(commands = "create")
    void create(BotContext context, Message message) {
        var keyboard = new InlineKeyboardMarkup();

        keyboard.addKeyboard(new InlineKeyboardButton("Ученик")
                .switchInlineQueryCurrentChat(""));
        keyboard.addKeyboard(new InlineKeyboardButton("Группа")
                .switchInlineQueryCurrentChat(""));
        keyboard.addKeyboard(new InlineKeyboardButton("Событие")
                .switchInlineQueryCurrentChat(""));
        keyboard.addKeyboard(new InlineKeyboardButton("Занятие")
                .switchInlineQueryCurrentChat(""));

        context.sendMessage(message.chat.id, "Выберите создаваемую сущность:")
                .replyMarkup(keyboard)
                .exec();
    }

    @CallbackHandler(regex = "create-")
    void createButton(BotContext context, CallbackQuery callback) {
        context.answerCallbackQuery(callback.id).exec();

        System.out.println(callback.data);

        var entity = callback.data.split("-", 2)[1];

        switch (entity) {
            case "student":
                break;

            default:
                break;
        }

        context.editMessageText(entity, callback.message.chat.id, callback.message.message_id)
                .exec();
    }
}
