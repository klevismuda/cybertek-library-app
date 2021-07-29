package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.LibraryLogin;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {

    LibraryLogin libraryLogin = new LibraryLogin();
    LandingPage landingPage = new LandingPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String libUrl = ConfigurationReader.getProperty("libUrl");
        Driver.getDriver().get(libUrl);
    }
    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        libraryLogin.userName.sendKeys("librarian13@library");
        libraryLogin.password.sendKeys("9rf6axdD");
        libraryLogin.submitButton.click();
    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        String actualDashboard = Driver.getDriver().getTitle();
        String expectedDashboard = "Login - Library";
        Assert.assertEquals(actualDashboard, expectedDashboard);
    }

    @When("I login as a student")
    public void iLoginAsAStudent() {
        libraryLogin.userName.sendKeys("student30@library");
        libraryLogin.password.sendKeys("IaT9YI0I");
        libraryLogin.submitButton.click();

    }
    @When("I enter username {string}")
    public void i_enter_username(String string) {
        libraryLogin.userName.sendKeys(string);
    }
    @When("I enter password {string}")
    public void i_enter_password(String string) {
        libraryLogin.password.sendKeys(string);
    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {
        libraryLogin.submitButton.click();
    }


    @Then("there should be {int} users")
    public void there_should_be_users(Integer int1) {
        BrowserUtils.wait(3);
        String exp = String.valueOf(int1);
        String act = landingPage.numberOfUsers.getText();
        Assert.assertEquals(exp, act);
    }

    @When("I login using {string} and {string}")
    public void i_login_using_and(String username, String password) {
        libraryLogin.userName.sendKeys(username);
        libraryLogin.password.sendKeys(password);
        libraryLogin.submitButton.click();
    }

    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String actualHeader) {
        BrowserUtils.waitForVisibility(landingPage.userNameHeader, 5);
        String expectedHeader = landingPage.userNameHeader.getText();
        System.out.println("expectedHeader = " + expectedHeader);

        Assert.assertEquals(expectedHeader, actualHeader);

    }





}
