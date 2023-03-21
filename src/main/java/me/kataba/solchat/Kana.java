package me.kataba.solchat;

import java.util.*;

public class Kana {
	private static StringBuilder result;
	private static List<String> previous;
	private static List<String> processed;

	private static void output(String text, String _current, List<String> _previous) {
		result.append(text);
		processed.addAll(_previous);
		processed.add(_current);
		previous.clear();
	}

	private static void output(String _current, List<String> _previous) {
		for (String text : _previous) {
			result.append(text);
		}
		result.append(_current);
		processed.addAll(_previous);
		processed.add(_current);
		previous.clear();
	}

	private static String previous(Integer index) {
		try {
			return previous.get(previous.size() - 1 - index).toLowerCase();
		} catch (IndexOutOfBoundsException exception) {
			return "";
		}
	}

	public String Convert(String text) {
		result = new StringBuilder();

		for (String sentence : text.split("\\p{javaSpaceChar}+")) {
			previous = new ArrayList<>();
			processed = new ArrayList<>();

			if (sentence.toLowerCase().startsWith("http")) {
				output(sentence, sentence, previous);
				continue;
			}

			for (String character : sentence.split("")) {
				String current = character.toLowerCase();

				if (current.equals("a")) {
					switch (previous(0)) {
						case "h" -> {
							switch (previous(1)) {
								case "c" -> output("ちゃ", current, previous);
								case "d" -> output("でゃ", current, previous);
								case "s" -> output("しゃ", current, previous);
								case "t" -> output("てゃ", current, previous);
								case "w" -> output("うぁ", current, previous);
								case "" -> output("は", current, previous);
							}
						}
						case "k" -> {
							switch (previous(1)) {
								case "l", "x" -> output("ヵ", current, previous);
								case "" -> output("か", current, previous);
							}
						}
						case "s" -> {
							switch (previous(1)) {
								case "t" -> output("つぁ", current, previous);
								case "" -> output("さ", current, previous);
							}
						}
						case "w" -> {
							switch (previous(1)) {
								case "d" -> output("どぁ", current, previous);
								case "g" -> output("ぐぁ", current, previous);
								case "h" -> output("ふぁ", current, previous);
								case "k" -> output("くぁ", current, previous);
								case "l", "x" -> output("ゎ", current, previous);
								case "s" -> output("すぁ", current, previous);
								case "t" -> output("とぁ", current, previous);
								case "z" -> output("ずぁ", current, previous);
								case "" -> output("わ", current, previous);
							}
						}
						case "y" -> {
							switch (previous(1)) {
								case "b" -> output("びゃ", current, previous);
								case "c", "t" -> output("ちゃ", current, previous);
								case "d" -> output("ぢゃ", current, previous);
								case "f" -> output("ふゃ", current, previous);
								case "g" -> output("ぎゃ", current, previous);
								case "h" -> output("ひゃ", current, previous);
								case "j", "z" -> output("じゃ", current, previous);
								case "k" -> output("きゃ", current, previous);
								case "l", "x" -> output("ゃ", current, previous);
								case "m" -> output("みゃ", current, previous);
								case "n" -> output("にゃ", current, previous);
								case "p" -> output("ぴゃ", current, previous);
								case "r" -> output("りゃ", current, previous);
								case "s" -> output("しゃ", current, previous);
								case "v" -> output("ゔゃ", current, previous);
								case "" -> output("や", current, previous);
							}
						}
						case "b" -> output("ば", current, previous);
						case "c" -> output("か", current, previous);
						case "d" -> output("だ", current, previous);
						case "f" -> output("ふぁ", current, previous);
						case "g" -> output("が", current, previous);
						case "j" -> output("じゃ", current, previous);
						case "l", "x" -> output("ぁ", current, previous);
						case "m" -> output("ま", current, previous);
						case "n" -> output("な", current, previous);
						case "p" -> output("ぱ", current, previous);
						case "q" -> output("くぁ", current, previous);
						case "r" -> output("ら", current, previous);
						case "t" -> output("た", current, previous);
						case "v" -> output("ゔぁ", current, previous);
						case "z" -> output("ざ", current, previous);
						case "" -> output("あ", current, previous);
					}
					continue;
				}

				if (current.equals("i")) {
					switch (previous(0)) {
						case "h" -> {
							switch (previous(1)) {
								case "c" -> output("ち", current, previous);
								case "d" -> output("でぃ", current, previous);
								case "s" -> output("し", current, previous);
								case "t" -> output("てぃ", current, previous);
								case "w" -> output("うぃ", current, previous);
								case "" -> output("ひ", current, previous);
							}
						}
						case "s" -> {
							switch (previous(1)) {
								case "t" -> output("つぃ", current, previous);
								case "" -> output("し", current, previous);
							}
						}
						case "w" -> {
							switch (previous(1)) {
								case "d" -> output("どぃ", current, previous);
								case "g" -> output("ぐぃ", current, previous);
								case "h" -> output("ふぃ", current, previous);
								case "k" -> output("くぃ", current, previous);
								case "s" -> output("すぃ", current, previous);
								case "t" -> output("とぃ", current, previous);
								case "z" -> output("ずぃ", current, previous);
								case "" -> output("うぃ", current, previous);
							}
						}
						case "y" -> {
							switch (previous(1)) {
								case "b" -> output("びぃ", current, previous);
								case "c", "t" -> output("ちぃ", current, previous);
								case "d" -> output("ぢぃ", current, previous);
								case "g" -> output("ぎぃ", current, previous);
								case "h" -> output("ひぃ", current, previous);
								case "j", "z" -> output("じぃ", current, previous);
								case "k" -> output("きぃ", current, previous);
								case "l", "x" -> output("ぃ", current, previous);
								case "m" -> output("みぃ", current, previous);
								case "n" -> output("にぃ", current, previous);
								case "p" -> output("ぴぃ", current, previous);
								case "r" -> output("りぃ", current, previous);
								case "s" -> output("しぃ", current, previous);
								case "v" -> output("ゔぃ", current, previous);
								case "w" -> output("ゐ", current, previous);
							}
						}
						case "'" -> {
							switch (previous(1)) {
								case "d" -> output("でぃ", current, previous);
								case "t" -> output("てぃ", current, previous);
							}
						}
						case "b" -> output("び", current, previous);
						case "c" -> output("し", current, previous);
						case "d" -> output("ぢ", current, previous);
						case "f" -> output("ふぃ", current, previous);
						case "g" -> output("ぎ", current, previous);
						case "j", "z" -> output("じ", current, previous);
						case "k" -> output("き", current, previous);
						case "l", "x" -> output("ぃ", current, previous);
						case "m" -> output("み", current, previous);
						case "n" -> output("に", current, previous);
						case "p" -> output("ぴ", current, previous);
						case "q" -> output("くぃ", current, previous);
						case "r" -> output("り", current, previous);
						case "t" -> output("ち", current, previous);
						case "v" -> output("ゔぃ", current, previous);
						case "" -> output("い", current, previous);
					}
					continue;
				}

				if (current.equals("u")) {
					switch (previous(0)) {
						case "h" -> {
							switch (previous(1)) {
								case "c" -> output("ちゅ", current, previous);
								case "d" -> output("でゅ", current, previous);
								case "s" -> output("しゅ", current, previous);
								case "t" -> output("てゅ", current, previous);
								case "w" -> output("う", current, previous);
								case "" -> output("ふ", current, previous);
							}
						}
						case "s" -> {
							switch (previous(1)) {
								case "t" -> {
									switch (previous(2)) {
										case "l", "x" -> output("っ", current, previous);
										case "" -> output("つ", current, previous);
									}
								}
								case "" -> output("す", current, previous);
							}
						}
						case "t" -> {
							switch (previous(1)) {
								case "l", "x" -> output("っ", current, previous);
								case "" -> output("つ", current, previous);
							}
						}
						case "w" -> {
							switch (previous(1)) {
								case "d" -> output("どぅ", current, previous);
								case "g" -> output("ぐぅ", current, previous);
								case "k" -> output("くぅ", current, previous);
								case "s" -> output("すぅ", current, previous);
								case "t" -> output("とぅ", current, previous);
								case "z" -> output("ずぅ", current, previous);
								case "" -> output("う", current, previous);
							}
						}
						case "y" -> {
							switch (previous(1)) {
								case "w" -> {
									if (previous(2).equals("h")) {
										output("ひゅ", current, previous);
									}
								}
								case "'" -> {
									switch (previous(2)) {
										case "d" -> output("でゅ", current, previous);
										case "t" -> output("てゅ", current, previous);
									}
								}
								case "b" -> output("びゅ", current, previous);
								case "c", "t" -> output("ちゅ", current, previous);
								case "d" -> output("ぢゅ", current, previous);
								case "f" -> output("ふゅ", current, previous);
								case "g" -> output("ぎゅ", current, previous);
								case "h" -> output("ひゅ", current, previous);
								case "j", "z" -> output("じゅ", current, previous);
								case "k" -> output("きゅ", current, previous);
								case "l", "x" -> output("ゅ", current, previous);
								case "m" -> output("みゅ", current, previous);
								case "n" -> output("にゅ", current, previous);
								case "p" -> output("ぴゅ", current, previous);
								case "r" -> output("りゅ", current, previous);
								case "s" -> output("しゅ", current, previous);
								case "v" -> output("ゔゅ", current, previous);
								case "" -> output("ゆ", current, previous);
							}
						}
						case "'" -> {
							switch (previous(1)) {
								case "d" -> output("どぅ", current, previous);
								case "t" -> output("とぅ", current, previous);
							}
						}
						case "b" -> output("ぶ", current, previous);
						case "c", "k", "q" -> output("く", current, previous);
						case "d" -> output("づ", current, previous);
						case "f" -> output("ふ", current, previous);
						case "g" -> output("ぐ", current, previous);
						case "j" -> output("じゅ", current, previous);
						case "l", "x" -> output("ぅ", current, previous);
						case "m" -> output("む", current, previous);
						case "n" -> output("ぬ", current, previous);
						case "p" -> output("ぷ", current, previous);
						case "r" -> output("る", current, previous);
						case "v" -> output("ゔ", current, previous);
						case "z" -> output("ず", current, previous);
						case "" -> output("う", current, previous);
					}
					continue;
				}

				if (current.equals("e")) {
					switch (previous(0)) {
						case "h" -> {
							switch (previous(1)) {
								case "c" -> output("ちぇ", current, previous);
								case "d" -> output("でぇ", current, previous);
								case "s" -> output("しぇ", current, previous);
								case "t" -> output("てぇ", current, previous);
								case "w" -> output("うぇ", current, previous);
								case "" -> output("へ", current, previous);
							}
						}
						case "k" -> {
							switch (previous(1)) {
								case "l", "x" -> output("ヶ", current, previous);
								case "" -> output("け", current, previous);
							}
						}
						case "s" -> {
							switch (previous(1)) {
								case "t" -> output("つぇ", current, previous);
								case "" -> output("せ", current, previous);
							}
						}
						case "w" -> {
							switch (previous(1)) {
								case "d" -> output("どぇ", current, previous);
								case "g" -> output("ぐぇ", current, previous);
								case "h" -> output("ふぇ", current, previous);
								case "k" -> output("くぇ", current, previous);
								case "s" -> output("すぇ", current, previous);
								case "t" -> output("とぇ", current, previous);
								case "z" -> output("ずぇ", current, previous);
								case "" -> output("うぇ", current, previous);
							}
						}
						case "y" -> {
							switch (previous(1)) {
								case "b" -> output("びぇ", current, previous);
								case "c", "t" -> output("ちぇ", current, previous);
								case "d" -> output("ぢぇ", current, previous);
								case "g" -> output("ぎぇ", current, previous);
								case "h" -> output("ひぇ", current, previous);
								case "j", "z" -> output("じぇ", current, previous);
								case "k" -> output("きぇ", current, previous);
								case "l", "x" -> output("ぇ", current, previous);
								case "m" -> output("みぇ", current, previous);
								case "n" -> output("にぇ", current, previous);
								case "p" -> output("ぴぇ", current, previous);
								case "r" -> output("りぇ", current, previous);
								case "s" -> output("しぇ", current, previous);
								case "v" -> output("ゔぇ", current, previous);
								case "w" -> output("ゑ", current, previous);
								case "" -> output("いぇ", current, previous);
							}
						}
						case "b" -> output("べ", current, previous);
						case "c" -> output("せ", current, previous);
						case "d" -> output("で", current, previous);
						case "f" -> output("ふぇ", current, previous);
						case "g" -> output("げ", current, previous);
						case "j" -> output("じぇ", current, previous);
						case "l", "x" -> output("ぇ", current, previous);
						case "m" -> output("め", current, previous);
						case "n" -> output("ね", current, previous);
						case "p" -> output("ぺ", current, previous);
						case "q" -> output("くぇ", current, previous);
						case "r" -> output("れ", current, previous);
						case "t" -> output("て", current, previous);
						case "v" -> output("ゔぇ", current, previous);
						case "z" -> output("ぜ", current, previous);
						case "" -> output("え", current, previous);
					}
					continue;
				}

				if (current.equals("o")) {
					switch (previous(0)) {
						case "h" -> {
							switch (previous(1)) {
								case "c" -> output("ちょ", current, previous);
								case "d" -> output("でょ", current, previous);
								case "s" -> output("しょ", current, previous);
								case "t" -> output("てょ", current, previous);
								case "w" -> output("うぉ", current, previous);
								case "" -> output("ほ", current, previous);
							}
						}
						case "s" -> {
							switch (previous(1)) {
								case "t" -> output("つぉ", current, previous);
								case "" -> output("そ", current, previous);
							}
						}
						case "w" -> {
							switch (previous(1)) {
								case "d" -> output("どぉ", current, previous);
								case "g" -> output("ぐぉ", current, previous);
								case "h" -> output("ふぉ", current, previous);
								case "k" -> output("くぉ", current, previous);
								case "s" -> output("すぉ", current, previous);
								case "t" -> output("とぉ", current, previous);
								case "z" -> output("ずぉ", current, previous);
								case "" -> output("を", current, previous);
							}
						}
						case "y" -> {
							switch (previous(1)) {
								case "b" -> output("びょ", current, previous);
								case "c", "t" -> output("ちょ", current, previous);
								case "d" -> output("ぢょ", current, previous);
								case "f" -> output("ふょ", current, previous);
								case "g" -> output("ぎょ", current, previous);
								case "h" -> output("ひょ", current, previous);
								case "j", "z" -> output("じょ", current, previous);
								case "k" -> output("きょ", current, previous);
								case "l", "x" -> output("ょ", current, previous);
								case "m" -> output("みょ", current, previous);
								case "n" -> output("にょ", current, previous);
								case "p" -> output("ぴょ", current, previous);
								case "r" -> output("りょ", current, previous);
								case "s" -> output("しょ", current, previous);
								case "v" -> output("ゔょ", current, previous);
								case "" -> output("よ", current, previous);
							}
						}
						case "b" -> output("ぼ", current, previous);
						case "c", "k" -> output("こ", current, previous);
						case "d" -> output("ど", current, previous);
						case "f" -> output("ふぉ", current, previous);
						case "g" -> output("ご", current, previous);
						case "j" -> output("じょ", current, previous);
						case "l", "x" -> output("ぉ", current, previous);
						case "m" -> output("も", current, previous);
						case "n" -> output("の", current, previous);
						case "p" -> output("ぽ", current, previous);
						case "q" -> output("くぉ", current, previous);
						case "r" -> output("ろ", current, previous);
						case "t" -> output("と", current, previous);
						case "v" -> output("ゔぉ", current, previous);
						case "z" -> output("ぞ", current, previous);
						case "" -> output("お", current, previous);
					}
					continue;
				}

				if (current.matches("[^a-z']")) {
					switch (current) {
						case "[" -> output("「", current, previous);
						case "]" -> output("」", current, previous);
						case "," -> output("、", current, previous);
						case "." -> output("。", current, previous);
						case "-" -> output("ー", current, previous);
						case "~" -> output("～", current, previous);
						case "?" -> output("？", current, previous);
						case "!" -> output("！", current, previous);
					}
					continue;
				}

				if (previous(0).equals("n")) {
					if (List.of("n", "'").contains(current)) {
						output("ん", current, previous);
						continue;
					}

					if (!current.equals("y")) {
						result.append("ん");
						processed.addAll(previous);
						previous.clear();
						previous.add(current);
						continue;
					}
				}

				if (previous(0).equals("x") && current.equals("'")) {
					output("ん", current, previous);
					continue;
				}

				if (previous.size() + processed.size() + current.length() == sentence.length()) {
					output(current, previous);
					continue;
				}

				if (current.equals(previous(0))) {
					output(current, previous);
					continue;
				}

				previous.add(character);
			}

			result.append(" ");
		}

		return result.toString().trim();
	}
}
