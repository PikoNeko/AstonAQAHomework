package lesson14.pages.mainPage.objects;

import lesson14.pages.mainPage.abstractions.BaseComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookieWrapper extends BaseComponent {

    @FindBy(xpath = ".//button[contains(text(),\"Отклонить\")]")
    private WebElement declineButton;

    protected CookieWrapper(WebElement root) {
        super(root);
    }

    public void declineCookies() {
        declineButton.click();
    }

    public WebElement getDeclineButton() {
        return declineButton;
    }
}
