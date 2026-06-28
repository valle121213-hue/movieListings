public class MovieListingsManager {

    // Пустой массив фильмов и перменную Лимит
    private String[] movies = new String[0];
    private int limit;

    //Лимит равен 5
    public MovieListingsManager() {
        this.limit = 5;
    }

    // Лимит можно установить
    public MovieListingsManager(int limit) {
        this.limit = limit;
    }


    // Добавление фильмов: метод
    public void add(String movie) {
        // Новый массив на 1 фильм больше
        String[] tmp = new String[movies.length + 1];

        // Копируем старый массив
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        // Запись нового фильма в ячейку массива (номер -1, так как с 0 номеррация массива)
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    // Метод возврщает весь массив
    public String[] returnAll() {
        return movies;
    }


    // Возвращение фильмов в лимите и обратном порядке
    public String[] findLast() {

        int resultLength;
        // Определяется длина лимита
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }

        String[] result = new String[resultLength];

        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i]; // длина массива -1 = номер индекса послденего, - i = с конца номерация
        }

        return result;
    }


}
