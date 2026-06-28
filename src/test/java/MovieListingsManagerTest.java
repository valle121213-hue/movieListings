import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieListingsManagerTest {


    //  Пустой
    @Test
    public void shouldReturnEmptyList() {
        MovieListingsManager manager = new MovieListingsManager();

        String[] expected = {};

        assertArrayEquals(expected, manager.returnAll());
    }

    // Добавление одного фильма
    @Test
    public void shouldAddOneMovie() {
        MovieListingsManager manager = new MovieListingsManager();

        manager.add("Джентельмены");

        String[] expected = {"Джентельмены"};

        assertArrayEquals(expected, manager.returnAll());
    }

    // Добавление двух фильмов
    @Test
    public void shouldAddTwoMovies() {
        MovieListingsManager manager = new MovieListingsManager();

        manager.add("Джентельмены");
        manager.add("Вперед");


        String[] expected = {"Джентельмены","Вперед"};


        assertArrayEquals(expected, manager.returnAll());
    }

//  Возвращение всего массива
    @Test
    public void shouldReturnAllMovies() {
        MovieListingsManager manager = new MovieListingsManager();

        manager.add("Бэтмен");
        manager.add("Джентельмены");
        manager.add("Тролли");
        ;

        String[] expected = {
                "Бэтмен",
                "Джентельмены",
                "Тролли"

        };

        assertArrayEquals(expected, manager.returnAll());
    }

    // Лимит 5,  а список меньше по колличсетву
    @Test
    public void shouldReturnLastMoviesLimitLessThanFive() {
        MovieListingsManager manager = new MovieListingsManager();

        manager.add("Бэтмен");
        manager.add("Джентельмены");
        manager.add("Вперед");
        manager.add("Номер один");

        String[] expected = {
                "Номер один",
                "Вперед",
                "Джентельмены",
                "Бэтмен",
        };

        assertArrayEquals(expected, manager.findLast());
    }

    // Лимит 5,  а список больше по колличсетву
    @Test
    public void shouldReturnLastMoviesLimitLongThanFive() {
        MovieListingsManager manager = new MovieListingsManager();

        manager.add("Бэтмен");
        manager.add("Джентельмены");
        manager.add("Вперед");
        manager.add("Номер один");
        manager.add("Тролли");
        manager.add("Бетмен");
        manager.add("Оно");
        manager.add("Майкл");

        String[] expected = {
                "Майкл",
                "Оно",
                "Бетмен",
                "Тролли",
                "Номер один",

        };

        assertArrayEquals(expected, manager.findLast());
    }

    // Лимит 5 и массив 5
    @Test
    public void shouldReturnMovieListingQualsLimit() {
        MovieListingsManager manager = new MovieListingsManager();

        manager.add("Номер один");
        manager.add("Тролли");
        manager.add("Бетмен");
        manager.add("Оно");
        manager.add("Майкл");

        String[] expected = {
                "Майкл",
                "Оно",
                "Бетмен",
                "Тролли",
                "Номер один",

        };

        assertArrayEquals(expected, manager.findLast());
    }
// Лимит 5 и массив пустой

    @Test
    public void shouldReturnMovieListing0WithLimit() {
        MovieListingsManager manager = new MovieListingsManager();

        String[] expected = {};

        assertArrayEquals(expected, manager.findLast());
    }


    // Произвольный лимит
// Лимит 4
    @Test
    public void shouldReturnMovieListingWithClientLimit() {
        MovieListingsManager manager = new MovieListingsManager(4);

        manager.add("Номер один");
        manager.add("Тролли");
        manager.add("Бетмен");
        manager.add("Оно");
        manager.add("Майкл");

        String[] expected = {
                "Майкл",
                "Оно",
                "Бетмен",
                "Тролли",

        };

        assertArrayEquals(expected, manager.findLast());
    }
    // Лимит 6, больше лимита по умолчанию
    @Test
    public void shouldReturnMovieListingWithClientLimit6() {
        MovieListingsManager manager = new MovieListingsManager(6);

        manager.add("Номер один");
        manager.add("Тролли");
        manager.add("Дым");
        manager.add("Оно");
        manager.add("Майкл");
        manager.add("Бетмен");
        manager.add("Дом на холме");
        manager.add("Яма");


        String[] expected = {
                "Яма",
                "Дом на холме",
                "Бетмен",
                "Майкл",
                "Оно",
                "Дым",

        };

        assertArrayEquals(expected, manager.findLast());
    }

}
