package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UsersTable_StepDefinitions {

    UsersPage usersPage = new UsersPage();

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> actualNames) {

        //System.out.println("names.toString() = " + actualNames.toString());

        List<WebElement> webElements = usersPage.tableHeaders;
        //List<WebElement> webElements = Driver.getDriver().findElements(By.xpath("//th"));
        List<String> expectedNames = BrowserUtils.getElementsText(webElements);

        Assert.assertEquals(actualNames, expectedNames);

    }


}
