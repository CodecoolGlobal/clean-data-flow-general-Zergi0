package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navbar {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "ul[class='navbar-nav col-12']")
    private WebElement navbarContainer;

    @FindBy(css = "li[class$='me-3'] a[class='nav-link']")
    private WebElement listPageLinkButton;

    @FindBy(css = "li[class='nav-item'] a[class='nav-link']")
    private WebElement dataEntryPageLinkButton;

    @FindBy(css = "li[class$='ms-auto'] a[class='nav-link']")
    private WebElement logoutButton;

    public Navbar(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.visibilityOf(navbarContainer));
        logoutButton.click();
    }

    public void clickListPage() {
        wait.until(ExpectedConditions.visibilityOf(navbarContainer));
        listPageLinkButton.click();
    }

    public void clickDataEntryPage() {
        wait.until(ExpectedConditions.visibilityOf(navbarContainer));
        dataEntryPageLinkButton.click();
    }
}
