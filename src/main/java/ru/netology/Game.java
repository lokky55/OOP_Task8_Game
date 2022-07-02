package ru.netology;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

    private Collection<Player> players; // Создаем коллекцию игрок

    public Game() {                      // создаю новый список в классе
        this.players = new ArrayList<>();
    }

    public void register(Player player) {
        player.isRegistered = true;
    }

    public Collection<Player> findAll() {
        return players;
    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName() == playerName) {
                return player;
            } else {
                throw new NotRegisteredException("Player: " + playerName + " is not registered!");
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1.isRegistered && player2.isRegistered) {
            if (player1.getStrength() > player2.getStrength()) {
                return 1;
            }
            if (player1.getStrength() < player2.getStrength()) {
                return 2;
            }
        }
        return 0;
    }

}
