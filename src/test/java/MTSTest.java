import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Автотесты для сайта mts.by. Проверка блока «Онлайн пополнение без комиссии»")
public class MTSTest {


    private WebDriver driver;

    @BeforeAll
    static void beforeAllTests(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver-win64/chromedriver.exe");

    }
    @BeforeEach
    void beforeEachTest(){
        driver = new ChromeDriver();
    }
    @AfterEach
    void afterEachTest(){
        driver.quit();
    }

    @ParameterizedTest
    @Description("1. Проверка название указанного блока")
    @ValueSource(strings = {"Онлайн пополнение\n" +
            "без комиссии"})
    void haveCorrectTitle(String text) {
        driver.get("http://mts.by");
        text.length();
    }

    @Test
    @Description("2. Проверка наличия логотипов платёжных систем")
    void presenceOfPaymentLogos() {

    }

    @Test
    @Description("3. Проверка работы ссылки «Подробнее о сервисе»")
    void moreDetailsLinkWorks() {

    }

    @Test
    @Description("4. Проверка работы блока, услуги связи")
    void blockWorksComServices() {

    }

}
