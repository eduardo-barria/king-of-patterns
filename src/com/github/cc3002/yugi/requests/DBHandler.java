package com.github.cc3002.yugi.requests;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DBHandler {

  private static final String BASE_URL = "https://yugioh.fandom.com/wiki/Special:Ask/"
      + "-5B-5BClass-201::Official-5D-5D-20-5B-5B"
      + "$query/"
      + "-3FEnglish-20name%3D/"
      + "-3FJapanese-20name/"
      + "-3FPrimary-20type/"
      + "-3FSecondary-20type/"
      + "-3FAttribute%3D-5B-5BAttribute-5D-5D/"
      + "-3FType%3D-5B-5BType-5D-5D/"
      + "-3FStars-20string%3D-5B-5BLevel-5D-5D-2F-20-5B-5BRank-5D-5D/"
      + "-3FATK-20string%3D-5B-5BATK-5D-5D/"
      + "-3FDEF-20string%3D-5B-5BDEF-5D-5D/"
      + "mainlabel%3D-2D/"
      + "offset%3D50/"
      + "limit%3D50/"
      + "format%3Dcsv";

  public static String searchByExactName(String name) throws IOException {
    return queryDB(name);
  }

  public static String searchByCardType(CardType type) throws IOException {
    return switch (type) {
      case EFFECT_MONSTER -> queryDB("Card-20type::Effect-20Monster-5D-5D");
      case TRAP_CARD -> queryDB("Card-20type::Trap-20Card-5D-5D");
      case SPELL_CARD -> queryDB("Card-20type::Spell-20Card-5D-5D");
      case MONSTER_CARD -> queryDB("Card-20type::Monster-20Card-5D-5D");
      case PENDULUM_MONSTER -> queryDB("Card-20type::Pendulum-20Monster-5D-5D");
    };
  }

  private static String queryDB(String query) throws IOException {
    URL url = new URL(BASE_URL.replace("$query", query.replace(" ", "-20")));
    var queryResult = new StringBuilder();
    try (var scanner = new Scanner(url.openStream(), StandardCharsets.UTF_8.toString())) {
      while (scanner.hasNextLine()) {
        queryResult.append(scanner.nextLine()).append("\n");
      }
    }
    return queryResult.toString();
  }
}
