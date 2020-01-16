package com.deepti.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by deepti on 1/16/20.
 */
public class SearchPage {
    @FindBy(name="q")
    private WebElement query;

    @FindBy(css="input[type='submit']")
    private WebElement submit;

    public void searchFor(String query){
        this.query.sendKeys(query);
        this.submit.click();
    }
}
