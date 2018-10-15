package pages;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "lst-ib")
    WebElement searchField;

    @FindBy(xpath = "//div[@class='g']")
    WebElement results;


    Wait<WebDriver> wait = new WebDriverWait(Hooks.driver,4,1000);


    public void fillSearchField(String item){

        wait.until(ExpectedConditions.visibilityOf(searchField));

        searchField.sendKeys(item);
        searchField.submit();
    }


    public void checkSearchResult(String item){

        wait.until(ExpectedConditions.visibilityOf(results));

        String desiredText = item;
        String actualText = results.findElement(By.xpath("//*[text()='"+desiredText+"']")).getText();

        Assert.assertEquals(actualText,desiredText);

        System.out.println(actualText + " is actualText");
        System.out.println(desiredText + " is desiredText");
    }
}
