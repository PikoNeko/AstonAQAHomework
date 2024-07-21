package lesson14.pages.mainPage.objects;

import lesson14.pages.mainPage.abstractions.BaseComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InstallmentPayForm extends BaseComponent {

    @FindBy(id = "score-instalment")
    private WebElement scoreField;

    @FindBy(id = "instalment-sum")
    private WebElement moneyField;

    @FindBy(id = "instalment-email")
    private WebElement emailFIed;


    public InstallmentPayForm(WebElement element) {
        super(element);
    }

    //Get Placeholder
    public String getScoreFieldPlaceholder() {
        return scoreField.getAttribute("placeholder");
    }
    public String getMoneyFieldPlaceholder() {
        return moneyField.getAttribute("placeholder");
    }
    public String getEmailFieldPlaceholder() {
        return emailFIed.getAttribute("placeholder");
    }
}
