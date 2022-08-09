package org.example;

import com.pengrad.telegrambot.*;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import com.typesafe.config.*;

public class Main {
    public static void main(String[] args) {
        Config conf = ConfigFactory.load();
        System.out.println("Start bot");
        TelegramBot bot = new TelegramBot(conf.getString("bot.token"));

// Register for updates
        bot.setUpdatesListener(updates -> {
            updates.forEach(update -> {
                String respMessage = Bot.message(update.message().text());
                long chatId = update.message().chat().id();
                SendResponse response = bot.execute(new SendMessage(chatId, respMessage));
            });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });

// Send messages
    }
}