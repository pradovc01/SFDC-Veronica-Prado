package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Veronica Prado on 8/11/2015.
 */
public abstract class CreateContainer {
    @FindBy(name = "save")
    @CacheLookup
    protected WebElement saveBtn;
    public void clickSaveBtn(){
        saveBtn.click();
    }

}
