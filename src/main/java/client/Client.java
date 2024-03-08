package client;

public class Client { // Объявляем публичный класс Client
    private String email; // Объявляем приватное поле для электронной почты
    private String password; // Объявляем приватное поле для пароля
    private String name; // Объявляем приватное поле для имени

    // Конструктор класса для инициализации объекта Client с заданными значениями электронной почты, пароля и имени
    public Client(String email, String password, String name) {
        this.email = email; // Присваиваем значение параметра email полю класса
        this.password = password; // Присваиваем значение параметра password полю класса
        this.name = name; // Присваиваем значение параметра name полю класса
    }

    // Пустой конструктор класса
    public Client() {
    }

    // Геттер для получения значения электронной почты
    public String getEmail() {
        return email; // Возвращаем значение поля email
    }

    // Геттер для получения значения пароля
    public String getPassword() {
        return password; // Возвращаем значение поля password
    }

    // Геттер для получения значения имени
    public String getName() {
        return name; // Возвращаем значение поля name
    }

    // Сеттер для установки значения электронной почты
    public void setEmail(String email) {
        this.email = email; // Устанавливаем значение поля email
    }

    // Сеттер для установки значения пароля
    public void setPassword(String password) {
        this.password = password; // Устанавливаем значение поля password
    }

    // Сеттер для установки значения имени
    public void setName(String name) {
        this.name = name; // Устанавливаем значение поля name
    }
}
