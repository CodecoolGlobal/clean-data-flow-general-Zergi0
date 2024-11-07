package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "html > body > div:nth-of-type(2) > div")
    private WebElement formContainer;

    @FindBy(id = "user")
    private WebElement username;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(css = "button[class*='btn-primary']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public void login(String userNameString, String passwordString) {
        wait.until(ExpectedConditions.visibilityOf(formContainer));
        username.clear();
        username.sendKeys(userNameString);
        password.clear();
        password.sendKeys(passwordString);
        loginButton.click();
    }
}
