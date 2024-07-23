package lesson14.pages.mainPage;

import lesson14.pages.mainPage.abstractions.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BePaidIframe extends BasePage {

    @FindBy(xpath = "//div[@class = \"pay-description__cost\"]//span[contains(text(),\"BYN\")]")
    private WebElement descriptionCost;

    @FindBy(xpath = "//div[@class = \"pay-description__text\"]//span[contains(text(),\"Оплата\")]")
    private WebElement descriptionPhoneNumber;

    @FindBy(xpath = "//button[contains(text(), \" Оплатить\")]")
    private WebElement submitButton;

    @FindBy(xpath = "//input[@formcontrolname =  \"creditCard\"]/../label")
    private WebElement cardNumberFieldTitle;

    @FindBy(xpath = "//input[@formcontrolname = \"expirationDate\"]/../label")
    private WebElement expirationDateFieldTitle;

    @FindBy(xpath = "//input[@formcontrolname = \"cvc\"]/../label")
    private WebElement cvcFieldTitle;

    @FindBy(xpath = "//input[@formcontrolname = \"holder\"]/../label")
    private WebElement holderFieldTitle;

    @FindBy(xpath = "//div[contains(@class, \"cards-brands__container\")]")
    private WebElement cardBrandsContainer;


    public BePaidIframe(WebDriver driver) {
        super(driver);
    }

    //GET
    public WebElement getDescriptionCost() {
        return descriptionCost;
    }

    public WebElement getDescriptionPhoneNumber() {
        return descriptionPhoneNumber;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    //Get title text
    public String getCardNumberFieldTitleText() {
        return cardNumberFieldTitle.getText();
    }

    public String getExpirationDateFieldTitleText() {
        return expirationDateFieldTitle.getText();
    }

    public String getCvcFieldTitleText() {
        return cvcFieldTitle.getText();
    }

    public String getHolderFieldTitleText() {
        return holderFieldTitle.getText();
    }

    //Поиск и возвращение картинки по src
    public WebElement getCardBrandsContainerImgBySrc(String src){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        List<WebElement> imgList = cardBrandsContainer.findElements(By.tagName("img"));

        return wait.until(ExpectedConditions.visibilityOf(imgList.stream()
                .filter(img -> img.getAttribute("src").equals(src)).findAny()
                .orElseThrow(() -> new NoSuchElementException("Logo not found: " + src))));
    }


    //Waiting for heavy elements to load (submit button on bottom of iframe);
    public void waitToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(submitButton));
    }
}
