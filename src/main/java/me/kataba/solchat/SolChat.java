package me.kataba.solchat;

import com.google.inject.Inject;
import com.velocitypowered.api.event.EventTask;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.PlayerChatEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ServerConnection;
import net.kyori.adventure.text.Component;
import org.slf4j.Logger;

import java.util.Collection;
import java.util.Optional;

@Plugin(id = "solchat", name = "SolChat", version = "1.6", url = "https://kataba.me", description = "Translate Romaji chat to Japanese", authors = {
		"katabame (https://kataba.me)" })
public class SolChat {
	private final ProxyServer server;
	private final Logger logger;

	@Inject
	public SolChat(ProxyServer server, Logger logger) {
		this.server = server;
		this.logger = logger;
		logger.info("Started SolChat");
	}

	@Subscribe
	public EventTask onPlayerChat(PlayerChatEvent event) {
		return EventTask.async(() -> {
			Optional<ServerConnection> currentServer = event.getPlayer().getCurrentServer();
			if (currentServer.isEmpty()) {
				return;
			}

			Kana kana = new Kana();
			Kanji kanji = new Kanji();
			String originalMessage = event.getMessage();
			Player sender = event.getPlayer();
			Collection<Player> recipients = server.getAllPlayers();

			String kanaText = kana.Convert(originalMessage);
			String kanjiText = kanji.Convert(kanaText);
			String message = String.format("[%s] %s: %s (%s)",
					currentServer.get().getServerInfo().getName(),
					sender.getUsername(), originalMessage, kanjiText);
			// sender.getGameProfile().getName(),

			for (Player player : recipients) {
				player.sendMessage(Component.text(message));
			}

			event.setResult(PlayerChatEvent.ChatResult.denied());
			logger.info(message);
		});
	}
}
