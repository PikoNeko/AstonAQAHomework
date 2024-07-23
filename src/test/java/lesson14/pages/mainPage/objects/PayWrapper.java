package lesson14.pages.mainPage.objects;

import lesson14.pages.mainPage.abstractions.BaseComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class PayWrapper extends BaseComponent {

    @FindBy( xpath = ".//div[@class = \"pay__form\"]")
    private PayForm payForm;


    public PayWrapper(WebElement element) {
        super(element);
    }

    public PayForm getPayForm(){
        return payForm;
    }
}
