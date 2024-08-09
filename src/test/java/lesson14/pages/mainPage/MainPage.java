package lesson14.pages.mainPage;

import lesson14.pages.mainPage.abstractions.BasePage;
import lesson14.pages.mainPage.objects.CookieWrapper;
import lesson14.pages.mainPage.objects.PayWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage  {

    //Элемент Cookie
    @FindBy(className = "cookie__wrapper")
    private CookieWrapper cookieWrapper;

    //Элемент оплаты
    @FindBy(xpath = "//div[@class=\"pay__wrapper\"]")
    private PayWrapper payWrapper;


    //Ссылочный элемент для iframe (еще не понял, как можно проверять visibility Iframe, если он реализован как Page Object
    @FindBy(xpath = "//iframe[@class=\"bepaid-iframe\"]")
    private WebElement bePaidIframe;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //GET
    public PayWrapper getPayWrapper(){
        return payWrapper;
    }

    public CookieWrapper getCookieWrapper() {
        return cookieWrapper;
    }

    //Метод переключения на фрейм
    public BePaidIframe switchingTOPaidIframe() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(bePaidIframe));
        return new BePaidIframe(driver);
    }
}
