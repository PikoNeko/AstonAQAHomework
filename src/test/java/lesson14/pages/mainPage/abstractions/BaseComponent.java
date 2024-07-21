package lesson14.pages.mainPage.abstractions;

import io.appium.java_client.pagefactory.Widget;
import org.openqa.selenium.WebElement;

//Для использования своих классов как элементов (До создания своих собственных фабрик для элементов я еще не дорос)
public abstract class BaseComponent extends Widget {

    protected BaseComponent(WebElement root){
        super(root);
    }
}
