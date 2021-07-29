package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LibrarianPage;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageNavigation_StepDefinition {


    LibrarianPage librarianPage = new LibrarianPage();
    UsersPage usersPage = new UsersPage();


    @Then("I click on {string} link")
    public void i_click_on_link(String string) {
       BrowserUtils.waitForVisibility(librarianPage.usersLink, 15);
      switch (string.toLowerCase()){
          case "dashboard":
              librarianPage.dashboardLink.click();
              break;
          case "users":
              librarianPage.usersLink.click();
              break;
          case "books":
              librarianPage.booksLink.click();
              break;

      }

    }
    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer expected) {
        BrowserUtils.waitForVisibility(usersPage.showRecords, 5);
        String actual = new Select(usersPage.showRecords).getFirstSelectedOption().getText();
        Assert.assertEquals(expected+"", actual);

    }
    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> actualTexts) {

        Select select = new Select(usersPage.showRecords);
        List<WebElement> webElements = select.getOptions();

        List<String> expectedText = BrowserUtils.getElementsText(webElements);

        Assert.assertEquals(actualTexts, expectedText);

    }

}
