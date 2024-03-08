import client.ClientFaker;
import client.ClientSteps;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import client.Client;

import java.util.concurrent.TimeUnit;

public class ConstructorTest {
    private WebDriver driver; // Объявляем переменную driver для управления браузером
    private Client client; // Объявляем переменную client для хранения данных пользователя
    private String accessToken; // Объявляем переменную accessToken для хранения токена доступа


    // Метод запускается перед каждым тестом
    @Before
    public void setUp() {
        // Устанавливаем путь к драйверу Chrome (chromedriver.exe) или Yandex (yandexdriver.exe)
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        // Создаем экземпляр драйвера Chrome
        driver = new ChromeDriver();
        // Открываем базовый URL
        driver.get(ClientSteps.baseURL);
        // Устанавливаем базовый URL для REST-запросов
        RestAssured.baseURI = ClientSteps.baseURL;
        // Генерируем случайного пользователя
        client = ClientFaker.getRandomClient();
        // Регистрируем нового пользователя и извлекаем токен доступа
        accessToken = ClientSteps.createNewClient(client).then().extract().path("accessToken");
        // Максимизируем окно браузера
        driver.manage().window().maximize();
        // Устанавливаем неявное ожидание на 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // Тест на переход к разделу "Булки" на главной странице
    @Test
    @DisplayName("Переход к разделу Булки на главной странице")
    public void bunSectionTest() {
        MainPage mainPage = new MainPage(driver); // Создаем экземпляр MainPage
        mainPage.clickSauceButton(); // Нажимаем кнопку "Соусы"
        mainPage.clickBunButton(); // Нажимаем кнопку "Булки"
        String text = mainPage.getBunTabLocator(); // Получаем текст раздела меню
        Assert.assertEquals("Булки", text); // Проверяем, что текст соответствует ожидаемому
    }

    // Тест на переход к разделу "Соусы" на главной странице
    @Test
    @DisplayName("Переход к разделу Соусы на главной странице")
    public void sauceSectionTest() {
        MainPage mainPage = new MainPage(driver); // Создаем экземпляр MainPage
        mainPage.clickSauceButton(); // Нажимаем кнопку "Соусы"
        String text = mainPage.getBunTabLocator(); // Получаем текст раздела меню
        Assert.assertEquals("Соусы", text); // Проверяем, что текст соответствует ожидаемому
    }

    // Тест на переход к разделу "Начинки" на главной странице
    @Test
    @DisplayName("Переход к разделу Начинки на главной странице")
    public void fillingSectionTest() {
        MainPage mainPage = new MainPage(driver); // Создаем экземпляр MainPage
        mainPage.clickFillingButton(); // Нажимаем кнопку "Начинки"
        String text = mainPage.getBunTabLocator(); // Получаем текст раздела меню
        Assert.assertEquals("Начинки", text); // Проверяем, что текст соответствует ожидаемому
    }

    // Метод, выполняемый после каждого теста
    @After
    public void tearDown() {
        // Закрываем драйвер
        driver.quit();
        // Если токен доступа был получен, удаляем пользователя
        if (accessToken != null) {
            ClientSteps.deleteClient(accessToken);
        }
    }
}
