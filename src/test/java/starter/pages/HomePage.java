package starter.pages;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



@DefaultUrl("http://www.etsy.com")                      // <1>
public class HomePage extends PageObject {              // <2>


    @FindBy(css = "button[value='Search']")
    WebElement searchButton;

    @FindBy(css = "#gdpr-single-choice-overlay > div > div.wt-overlay__footer.wt-pt-xs-3 > div:nth-child(2) > button")
    WebElement cookiesButton;



    public void searchFor(String keywords) {

        if(cookiesButton.isDisplayed())
            cookiesButton.click();

        $("#global-enhancements-search-query").sendKeys(keywords);          // <3>
        searchButton.click();                           // <4>
    }

}
