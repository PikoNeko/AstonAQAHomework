package lesson14;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lesson14.pages.mainPage.BePaidIframe;
import lesson14.pages.mainPage.MainPage;
import lesson14.pages.mainPage.objects.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Автотесты для сайта mts.by. Проверка блока «Онлайн пополнение без комиссии»")
public class MTSReplenishmentTest {

    private WebDriver driver;
    private MainPage mainPage;
    private PayForm payForm;
    @BeforeEach
    void beforeEachTest() {

        Allure.step("Открываем браузер.");
        driver = new ChromeDriver();
        String url = "https://mts.by";
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().window().maximize();

        Allure.step(String.format("Переходим на сайт: %s", url));
        driver.get(url);

        mainPage = new MainPage(driver);
        CookieWrapper cookieWrapper = mainPage.getCookieWrapper();
        cookieWrapper.declineCookies();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Ожидаем
        wait.until(ExpectedConditions.invisibilityOf(cookieWrapper.getDeclineButton()));

        Allure.step("Переходим к блоку <Онлайн пополнение без комиссии>");
        payForm = mainPage.getPayWrapper().getPayForm();

    }

    @AfterEach
    void afterEachTest() {
        Allure.step("Закрываем браузер.");
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        driver.quit();
    }

    @DisplayName("1. Проверка надписей в незаполненных полях оплаты услуг")
    @Nested
    class Placeholders {


        @ParameterizedTest
        @DisplayName("1.1 Услуги связи")
        @CsvSource({"Услуги связи, Номер телефона, Сумма, E-mail для отправки чека"})
        void commServicesCheck(String formName, String phNumberPlaceholder, String moneyPlaceholder, String emailPlaceholder) {

            //Сменяемся на форму
            formChange(formName);

            //Записываем ссылку на нужную форму
            CommServicesPayForm commServicesPayForm = payForm.getCommServicesPayForm();

            Allure.step("Проверяем Placeholders");
            //Проверяем
            assertAll("Проверка placeholders",
                    () -> assertEquals(commServicesPayForm.getNumberFieldPlaceholder(), phNumberPlaceholder),
                    () -> assertEquals(commServicesPayForm.getMoneyFieldPlaceholder(), moneyPlaceholder),
                    () -> assertEquals(commServicesPayForm.getEmailFieldPlaceholder(), emailPlaceholder));
        }

        @ParameterizedTest
        @DisplayName("1.2 Домашний интернет")
        @CsvSource({"Домашний интернет, Номер абонента, Сумма, E-mail для отправки чека"})
        void homeInternetCheck(String formName, String phNumberPlaceholder, String moneyPlaceholder, String emailPlaceholder) {

            //Сменяемся на форму
            formChange(formName);

            //Записываем ссылку на нужную форму
            InternetPayForm internetPayForm = payForm.getInternetPayForm();

            Allure.step("Проверяем Placeholders");
            //Проверяем
            assertAll("Проверка placeholders",
                    () -> assertEquals(internetPayForm.getNumberFieldPlaceholder(), phNumberPlaceholder),
                    () -> assertEquals(internetPayForm.getMoneyFieldPlaceholder(), moneyPlaceholder),
                    () -> assertEquals(internetPayForm.getEmailFieldPlaceholder(), emailPlaceholder));
        }

        @ParameterizedTest
        @DisplayName("1.3 Рассрочка")
        @CsvSource({"Рассрочка, Номер счета на 44, Сумма, E-mail для отправки чека"})
        void installmentCheck(String formName, String scorePlaceholder, String moneyPlaceholder, String emailPlaceholder) {


            //Сменяемся на форму
            formChange(formName);

            //Записываем ссылку на нужную форму
            InstallmentPayForm installmentPayForm = payForm.getInstallmentPayForm();

            Allure.step("Проверяем Placeholders");
            //Проверяем
            assertAll("Проверка placeholders",
                    () -> assertEquals(installmentPayForm.getScoreFieldPlaceholder(), scorePlaceholder),
                    () -> assertEquals(installmentPayForm.getMoneyFieldPlaceholder(), moneyPlaceholder),
                    () -> assertEquals(installmentPayForm.getEmailFieldPlaceholder(), emailPlaceholder));
        }


        @ParameterizedTest
        @DisplayName("1.4 Задолженность")
        @CsvSource({"Задолженность, Номер счета на 2073, Сумма, E-mail для отправки чека"})
        void arrearsCheck(String formName, String scorePlaceholder, String moneyPlaceholder, String emailPlaceholder) {


            //Сменяемся на форму
            formChange(formName);

            //Записываем ссылку на нужную форму
            ArrearsPayForm arrearsPayForm = payForm.getArrearsPayForm();

            Allure.step("Проверяем Placeholders");
            //Проверяем
            assertAll("Проверка placeholders",
                    () -> assertEquals(arrearsPayForm.getScoreFieldPlaceholder(), scorePlaceholder),
                    () -> assertEquals(arrearsPayForm.getMoneyFieldPlaceholder(), moneyPlaceholder),
                    () -> assertEquals(arrearsPayForm.getEmailFieldPlaceholder(), emailPlaceholder));
        }

    }

    @DisplayName("2. Проверка элементов в iframe после заполнения полей в форме <<Услуги связи>>")
    @Nested
    class Iframe {

        @ParameterizedTest
        @DisplayName("2.1 Проверка надписей в полях фрейма")
        @CsvSource({"Услуги связи, 297777777, 30, someEmail@gmail.com, Номер карты, Срок действия, CVC, Имя держателя (как на карте)"})
        void payFrameFieldsCheck(String formName, String phoneNumber, String money, String email, String cardNumber, String expirationDate, String cvc, String holder) {


            //Сменяемся на форму
            formChange(formName);

            sendForm(phoneNumber, money, email);

            //Переключаемся
            BePaidIframe bePaidIframe = mainPage.switchingTOPaidIframe();
            //Ожидаем догрузки
            bePaidIframe.waitToBeVisible();

            //Проверяем
            assertAll("Проверка на тайтлов",
                    () -> assertEquals(bePaidIframe.getCardNumberFieldTitleText(), cardNumber),
                    () -> assertEquals(bePaidIframe.getExpirationDateFieldTitleText(), expirationDate),
                    () -> assertEquals(bePaidIframe.getCvcFieldTitleText(), cvc),
                    () -> assertEquals(bePaidIframe.getHolderFieldTitleText(), holder)
            );
        }

        @ParameterizedTest
        @DisplayName("2.2 Проверка корректности отображения суммы (в том числе на кнопке) и номера телефона")
        @CsvSource({"Услуги связи, 297777777, 30, someEmail@gmail.com"})
        void payFrameSumAndNumberCheck(String formName, String phoneNumber, String money, String email) {


            //Сменяем на форму
            payForm.changeToForm(formName);

            sendForm(phoneNumber, money, email);

            BePaidIframe bePaidIframe = mainPage.switchingTOPaidIframe();
            //Ожидаем догрузки
            bePaidIframe.waitToBeVisible();
            //Приводим к нужному формату
            String moneyFloat = String.format(Locale.US, "%.2f", Float.parseFloat(money));

            //Проверяем
            assertAll("Проверка на соответствии с вводом",
                    () -> assertEquals(moneyFloat + " BYN", bePaidIframe.getDescriptionCost().getText()),
                    () -> assertEquals("Оплата: " + formName + " Номер:375" + phoneNumber, bePaidIframe.getDescriptionPhoneNumber().getText()),
                    () -> assertEquals("Оплатить " + moneyFloat + " BYN", bePaidIframe.getSubmitButton().getText())
            );
        }

        @ParameterizedTest
        @DisplayName("2.3 Проверка отображение иконок платежных систем")
        @CsvFileSource(resources = "/payFrameCardBrandsLogoCheckSource.cvs")
        void payFrameCardBrandsLogoCheck(String formName, String phoneNumber, String money, String email,
                                         String masterCardSource, String visaSource, String belKartSource, String mirSource, String maestroSource) {

            //Сменяем на форму
            payForm.changeToForm(formName);

            sendForm(phoneNumber, money, email);

            //Переключаемся
            BePaidIframe bePaidIframe = mainPage.switchingTOPaidIframe();
            //Ожидаем догрузки
            bePaidIframe.waitToBeVisible();


            Allure.step("Проверяем видимость лого");
            //Проверяем
            assertAll("Проверка видимости лого",
                    () -> assertTrue(bePaidIframe.getCardBrandsContainerImgBySrc(masterCardSource).isDisplayed()),
                    () -> assertTrue(bePaidIframe.getCardBrandsContainerImgBySrc(visaSource).isDisplayed()),
                    () -> assertTrue(bePaidIframe.getCardBrandsContainerImgBySrc(belKartSource).isDisplayed()),
                    () -> assertTrue(bePaidIframe.getCardBrandsContainerImgBySrc(mirSource).isDisplayed()),
                    () -> assertTrue(bePaidIframe.getCardBrandsContainerImgBySrc(maestroSource).isDisplayed())
            );
        }
    }

    @Step("Смена формы")
    void formChange(String formName) {

        Allure.step(String.format("Меняем на форму <%s>", formName));
        //Сменяемся на форму
        payForm.changeToForm(formName);


    }

    @Step("Отправка формы")
    void sendForm(String phoneNumber,String money,String email) {

        //Записываем ссылку на нужную форму
        CommServicesPayForm commServicesPayForm = payForm.getCommServicesPayForm();
        Allure.step("Вводим данные в форму");
        Allure.step("Нажимаем кнопку <Продолжить>");
        //Вводим и отправляем
        commServicesPayForm.sendForm(phoneNumber, money, email);
    }
}
