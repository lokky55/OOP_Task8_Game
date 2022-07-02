package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Alex", 1);
    Player player2 = new Player(2, "John", 5);
    Player player3 = new Player(3, "Anya", 3);
    Player player4 = new Player(4, "Sveta", 4);
    Player player5 = new Player(5, "Boris", 2);

    @Test
    public void shouldCreateNewPlayers() {
        Collection<Player> playersList = new ArrayList<>();
        playersList.add(player1);
        playersList.add(player2);
        Collection<Player> actual = game.findAll();
        Collection<Player> expected = List.of(player1, player2);
        Assertions.assertEquals(expected, actual);
    }

// пример из лекции
//    Product product1 = new Product();
//    Product product2 = new Product();
//    Collection<Product> productsList = new ArrayList<>();
//        productsList.add(product1);
//        productsList.add(product2);
//
//    Collection<Product> actual = repo.saveAll(productsList);
//    Collection<Product> expected = List.of(product1, product2);
//        Assertions.assertEquals(expected, actual);
}
