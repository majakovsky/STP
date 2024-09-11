### Задача 1

Используя APIJDBC и любую реляционную базу данных (H2/Postgres), выполните следующие запросы:
•	Создать таблицу movies со столбцами: 
  - id
  - title
  - genre
  - year
  Если таблица movies уже существует, надо ее удалить
•	Добавить любые 4 записи в таблицу MOVIES
•	Обновить одну запись (используйте PreparedStatement)
•	Удалить запись по id
•	Искать по году
•	Искать по жанру
•	Искать по названию

Все запросы надо выполнять непосредственно в методе main.Надо Использовать одно соединение для выполнения всех запросов. 

### Задача 2

Создайте класс MovieDAOImpl, который будет выполнять основные операции с базой данных для таблицы movies. Структура этой таблицы описана в задаче 1. В конструктор класса MovieDAOImpl передаётся объект, представляющий открытое соединение с базой данных. Также создайте класс Movie, который будет представлять одну строку в таблице movies. Этот класс вы будете использовать при создании класса MovieDAOImpl.Класс MovieDAOImpl должен реализовывать следующий интерфейс:

```java
import java.util.List;
import java.util.Optional;
public interface MovieDAO {
  void createTable();
  void deleteTable();
  void createMovie(final Movie movie);
  void deleteMovie(int id);
  void updateMoviesTitle(int id, String newTitle);
  Movie findMovieById(int id);
  List<Movie>findByTitle(String title);
List<Movie>findByGenre(String genre);
List<Movie>findByYear(int year);
}
```
