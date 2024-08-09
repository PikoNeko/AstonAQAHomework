package lesson14.pages.mainPage.objects;

import lesson14.pages.mainPage.abstractions.BaseComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommServicesPayForm extends BaseComponent {

    @FindBy(id = "connection-phone")
    private WebElement numberField;

    @FindBy(id = "connection-sum")
    private WebElement moneyField;

    @FindBy(id = "connection-email")
    private WebElement emailField;

    @FindBy(xpath = ".//button[@type = \"submit\"]")
    private WebElement submitButton;

    public CommServicesPayForm(WebElement element) {
        super(element);
    }


    //Get
    public WebElement getSubmitButton(){
        return submitButton;
    }

    //Get placeholders
    public String getNumberFieldPlaceholder() {
        return numberField.getAttribute("placeholder");
    }

    public String getMoneyFieldPlaceholder() {
        return moneyField.getAttribute("placeholder");
    }

    public String getEmailFieldPlaceholder() {
        return emailField.getAttribute("placeholder");
    }


    //Set value in fields
    public void setNumberField(String text) {
        numberField.sendKeys(text);
    }

    public void setMoneyField(String text) {
        moneyField.sendKeys(text);
    }

    public void setEmailField(String text) {
        emailField.sendKeys(text);
    }

    //Fill and confirm form
    public void sendForm(String phoneNumber, String money, String email) {
        setNumberField(phoneNumber);
        setMoneyField(money);
        setEmailField(email);
        getSubmitButton().click();
    }

}
