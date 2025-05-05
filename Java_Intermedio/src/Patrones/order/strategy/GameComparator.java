package Patrones.order.strategy;

import java.util.Comparator;

public class GameComparator {

    public static Comparator<Game> byName()
    {
        return Comparator.comparing(Game::getName);
    }

    public static Comparator<Game> byPrice()
    {
        return Comparator.comparing(Game::getPrice);
    }

    public static Comparator<Game> byDuration()
    {
        return Comparator.comparing(Game::getDuration);
    }

}
