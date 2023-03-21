package me.kataba.solchat;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Kanji {
	private final HttpClient client = HttpClient.newHttpClient();
	public String Convert(String kana) {
		StringBuilder result = new StringBuilder();
		String text = URLEncoder.encode(kana.replaceAll("\\p{javaSpaceChar}}", ","), StandardCharsets.UTF_8);
		HttpRequest request = HttpRequest.newBuilder(
			URI.create("http://www.google.com/transliterate?langpair=ja-Hira%7Cja&text=" + text))
			.header("accept", "application/json").build();
		try {
			String response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)).body();
			for(JsonElement json : JsonParser.parseString(response).getAsJsonArray())
			{
				result.append(json.getAsJsonArray().get(1).getAsJsonArray().get(0).getAsString().trim());
			}
		} catch (IOException | InterruptedException | JsonParseException exception) {
			return kana;
		}
		return result.toString();
	}
}
