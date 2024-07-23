package lesson14.pages.mainPage.objects;

import lesson14.pages.mainPage.abstractions.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class PayForm extends BaseComponent {

    //Элементы
    @FindBy(xpath = ".//span[@class = \"select__now\"]")
    private WebElement selectNowSpan;

    @FindBy(xpath = ".//button[@class = \"select__header\"]")
    private WebElement selectButton;

    @FindBy(xpath = ".//ul[@class=\"select__list\"]")
    private WebElement selectUl;

    @FindBy(id = "pay-connection")
    private CommServicesPayForm commServicesPayForm;

    @FindBy(id = "pay-internet")
    private InternetPayForm internetPayForm;

    @FindBy(id = "pay-instalment")
    private InstallmentPayForm installmentPayForm;

    @FindBy(id = "pay-arrears")
    private ArrearsPayForm arrearsPayForm;

    public PayForm(WebElement element) {
        super(element);
    }

    //Get
    public CommServicesPayForm getCommServicesPayForm() {
        return commServicesPayForm;
    }

    public InternetPayForm getInternetPayForm() {
        return internetPayForm;
    }

    public InstallmentPayForm getInstallmentPayForm() {
        return installmentPayForm;
    }

    public ArrearsPayForm getArrearsPayForm() {
        return arrearsPayForm;
    }


    //Метод смены формы для оплаты
    public void changeToForm(String name) {
        if (!Objects.equals(selectNowSpan.getText(), name)) {
            selectButton.click();
            List<WebElement> ulList = selectUl.findElements(By.tagName("p"));
            WebElement p = ulList.stream()
                    .filter(element -> element.getText().equals(name))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Form not Found: " + name));
            p.click();
        }
    }


}
