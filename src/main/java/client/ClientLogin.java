package client;

public class ClientLogin { // Объявляем класс ClientLogin
    private String email; // Приватное поле для хранения email
    private String password; // Приватное поле для хранения пароля

    // Конструктор класса ClientLogin для инициализации email и пароля
    public ClientLogin(String email, String password) {
        this.email = email; // Устанавливаем переданный email
        this.password = password; // Устанавливаем переданный пароль
    }

    // Приватный конструктор без параметров
    private ClientLogin() {
    }

    // Геттер для получения email
    public String getEmail() {
        return email; // Возвращаем значение email
    }

    // Геттер для получения пароля
    public String getPassword() {
        return password; // Возвращаем значение пароля
    }

    // Сеттер для установки нового email
    public void setEmail(String email) {
        this.email = email; // Устанавливаем новый email
    }

    // Сеттер для установки нового пароля
    public void setPassword(String password) {
        this.password = password; // Устанавливаем новый пароль
    }
}
