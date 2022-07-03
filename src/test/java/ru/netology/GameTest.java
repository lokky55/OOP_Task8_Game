package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Alex", 5);
    Player player2 = new Player(2, "John", 2);
    Player player3 = new Player(3, "Anya", 3);
    Player player4 = new Player(4, "Sveta", 1);
    Player player5 = new Player(5, "Boris", 3);

    @Test
    public void shouldFindNoPlayersCollection() {
        Collection<Player> actual = game.findAll();
        Collection<Player> expected = List.of();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddPlayers() {
        game.add(player1);
        game.add(player2);
        Collection<Player> actual = game.findAll();
        Collection<Player> expected = List.of(player1, player2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindPlayer() {
        game.add(player1);
        game.add(player2);
        Player actual = game.findByName("John");
        Player expected = player2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinFirstPlayer() {
        game.add(player1);
        game.add(player2);
        game.register(player1);
        game.register(player2);
        int actual = game.round("Alex", "John");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {
        game.add(player3);
        game.add(player4);
        game.register(player3);
        game.register(player4);
        int actual = game.round("Sveta", "Anya");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeDraw() {
        game.add(player3);
        game.add(player5);
        game.register(player3);
        game.register(player5);
        int actual = game.round("Anya", "Boris");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindNoPlayer() {
        Player actual = game.findByName("Sonya");
        Player expected = null;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotRegisteredPlayerJohn() {
        game.add(player1);
        game.add(player2);
        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Alex", "John");
        });
    }

    @Test
    public void shouldThrowNotRegisteredPlayerAlex() {
        game.add(player1);
        game.add(player2);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Alex", "John");
        });
    }
}
