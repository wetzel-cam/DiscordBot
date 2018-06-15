package com.cwetz.discord;

import com.cwetz.discord.commands.AssignRoleCmd;
import com.cwetz.discord.util.SettingsManager;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.EventListener;

public class Bot implements EventListener {
    private static JDA api;

    public static void main(String[] args) {
        SettingsManager.getInstance().clean();
        JDABuilder jdaBuilder = new JDABuilder(AccountType.BOT).setToken(SettingsManager.getInstance()
                .getSettings().getBotToken());
        jdaBuilder.addEventListener(new AssignRoleCmd());
        jdaBuilder.addEventListener(new Bot());

        try {
            api = jdaBuilder.buildAsync();
        } catch (Exception e) {}
    }

    @Override
    public void onEvent(Event event) {
        if (event instanceof ReadyEvent) {
//            System.out.println("Bot up and ready to go");
            TextChannel generalTextChannel = api.getGuildById("344310333307092993").getDefaultChannel();
            generalTextChannel.sendMessage(new MessageBuilder().append("Booted and ready to go!").build()).complete();
        }
    }
}
