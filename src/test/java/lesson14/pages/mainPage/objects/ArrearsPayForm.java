package lesson14.pages.mainPage.objects;

import lesson14.pages.mainPage.abstractions.BaseComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArrearsPayForm extends BaseComponent {

    @FindBy(id = "score-arrears")
    private WebElement scoreField;

    @FindBy(id = "arrears-sum")
    private WebElement moneyField;

    @FindBy(id = "arrears-email")
    private WebElement emailField;


    public ArrearsPayForm(WebElement element) {
        super(element);
    }

    //Get placeholder
    public String getScoreFieldPlaceholder(){
        return scoreField.getAttribute("placeholder");
    }

    public String getMoneyFieldPlaceholder(){
        return moneyField.getAttribute("placeholder");
    }
    public String getEmailFieldPlaceholder(){
        return emailField.getAttribute("placeholder");
    }
}
