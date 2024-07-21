package lesson14.pages.mainPage.objects;

import lesson14.pages.mainPage.abstractions.BaseComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternetPayForm extends BaseComponent {

    @FindBy(id = "internet-phone")
    private WebElement  numberField;
    @FindBy(id = "internet-sum")
    private WebElement moneyField;
    @FindBy(id = "internet-email")
    private WebElement emailField;


    public InternetPayForm(WebElement element) {
        super(element);
    }

    //Get placeholders
    public String getNumberFieldPlaceholder(){
        return numberField.getAttribute("placeholder");
    }

    public String getMoneyFieldPlaceholder(){
        return moneyField.getAttribute("placeholder");
    }

    public String getEmailFieldPlaceholder(){
        return emailField.getAttribute("placeholder");
    }
}
