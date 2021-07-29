package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public LandingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user_count")
    public WebElement numberOfUsers;

    @FindBy(xpath = "//a[@id='navbarDropdown']/span")
    public WebElement userNameHeader;
}
