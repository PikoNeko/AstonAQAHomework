package lesson13.mtsTests;

import jdk.jfr.Description;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

@DisplayName("Автотесты для сайта mts.by. Проверка блока «Онлайн пополнение без комиссии»")
public class MTSTest {


    private WebDriver driver;
    private WebElement paymentBlock;

    @BeforeEach
    void beforeEachTest() {

        driver = new ChromeDriver();
        String url = "http://mts.by";
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.get(url);
        paymentBlock = driver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]"));
    }

    @AfterEach
    void afterEachTest() {

        driver.quit();
    }

    @ParameterizedTest
    @Description("1. Проверка название указанного блока")
    @ValueSource(strings = {"Онлайн пополнение\n" +
            "без комиссии"})
    void haveCorrectTitle(String text) {

        WebElement subTitle = paymentBlock.findElement(By.xpath("./h2"));
        Assertions.assertEquals(text, subTitle.getText());
    }

    @ParameterizedTest
    @Description("2. Проверка наличия логотипов платёжных систем")
    @ValueSource(strings = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"})
    void presenceOfPaymentLogos(String alt) {

        WebElement paymentLogo = paymentBlock.findElement(By.xpath("./div[@class=\"pay__partners\"]//img[@alt=\"" + alt + "\"]"));
        Assertions.assertTrue(paymentLogo.isDisplayed());
    }

    @ParameterizedTest
    @Description("3. Проверка работы ссылки «Подробнее о сервисе»")
    @ValueSource(strings = {"https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"})
    void moreDetailsLinkWorks(String url) {

        driver.findElement(By.xpath("//button[contains(@class, \"cookie__cancel\")]")).click();
        paymentBlock.findElement(By.xpath(".//a[contains(text(), \"Подробнее о сервисе\")]")).click();
        Assertions.assertEquals(url, driver.getCurrentUrl());
    }

    @ParameterizedTest
    @Description("4. Проверка работы блока, услуги связи")
    //Номер телефона, сумма для пополнения, почта
    @CsvFileSource(resources = "/payCommServicesFormData.csv")
    void blockWorksCommunicationServices(String phoneNumber, String money, String email, boolean isPositive) {
        driver.findElement(By.xpath("//button[contains(@class, \"cookie__cancel\")]")).click();
        WebElement payForms = paymentBlock.findElement(By.xpath("./div[@class=\"pay__form\"]"));

        //Проверяем, выбрана ли нужная нам форма
        if (!Objects.equals(payForms.findElement(By.xpath(".//span[@class=\"select__now\"]")).getText(), "Услуги связи")) {
            payForms.findElement(By.xpath(".//button[@class = \"select__header\"]")).click();
            payForms.findElement(By.xpath(".//p[contains(text(), \"Услуги связи\")]")).click();
        }

        //Заполнение полей формы "Услуги связи"

        //Находим нужную форму
        WebElement payCommServicesForm = payForms.findElement(By.id("pay-connection"));
        //Записываем элементы
        WebElement numberField = payCommServicesForm.findElement(By.id("connection-phone"));
        WebElement moneyField = payCommServicesForm.findElement(By.id("connection-sum"));
        WebElement emailField = payCommServicesForm.findElement(By.id("connection-email"));
        WebElement confirmButton = payCommServicesForm.findElement(By.xpath(".//button[@type=\"submit\"]"));

        //Выполняем ввод и отправку формы
        if (phoneNumber != null) numberField.sendKeys(phoneNumber);
        if (money != null) moneyField.sendKeys(money);
        if (email != null) emailField.sendKeys(email);
        confirmButton.click();

        //Создаем переменные для проверки
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement blockOfPayment = null;

        //Если позитивный тест
        if (isPositive) {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class=\"bepaid-iframe\"]")));
            //Костыль на ожидание загрузки элемента в фрейме (Ох уж этот js)
            blockOfPayment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"app-wrapper__content\"]")));
            Assertions.assertTrue(blockOfPayment.isDisplayed());
        } else {
            //Если негативный тест

            try {
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class=\"bepaid-iframe\"]")));
                blockOfPayment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"app-wrapper__content\"]")));
            } catch (TimeoutException ex) {
                //Проверяем, вдруг у нас что-то записалось
                Assertions.assertNull(blockOfPayment);
            }
        }

    }

}
