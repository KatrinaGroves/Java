package com.discord.insulter;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

class InsulterClient {

	public static void main(String[] args) {
		DiscordApi dapi = new DiscordApiBuilder().setToken(InsultToken.getToken()).login().join();
		dapi.addMessageCreateListener(event -> {
			if (event.getMessageContent().toLowerCase().contains("bruh")) {
				event.getChannel().sendMessage(InsultDAO.addInsults());
			}
		});
	}
}
