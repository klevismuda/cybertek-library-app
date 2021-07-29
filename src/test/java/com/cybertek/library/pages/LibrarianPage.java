package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibrarianPage {
    public LibrarianPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Users")
    public WebElement usersLink;

    @FindBy(linkText = "Dashboard")
    public WebElement dashboardLink;

    @FindBy(linkText = "Books")
    public WebElement booksLink;




}
