package com.m1raynee.telegram;

import com.m1raynee.telegram.commands.CreateComand;
import com.m1raynee.telegram.commands.InlineSelector;

import io.github.natanimn.telebof.BotClient;

public class Main {
	static final String botToken = System.getenv("RATING_BOT_TOKEN");

	public static void main(String[] args) {
		var bot = new BotClient(botToken);

		bot.addHandler(new Main());
		bot.addHandler(new CreateComand());
		bot.addHandler(new InlineSelector());

		bot.startPolling();
	}
}
