package com.cwetz.discord.commands;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public abstract class Command extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentDisplay().contains("`/")) {
            TextChannel channel = event.getTextChannel();

            channel.sendMessage(new MessageBuilder().append("Hullo!").build()).complete();
        }
    }
}
