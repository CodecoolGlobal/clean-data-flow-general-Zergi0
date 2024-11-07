package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "html > body > div:nth-of-type(2)")
    private WebElement registerContainer;

    @FindBy(id = "user")
    private WebElement username;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(id = "inputPasswordConfirmation")
    private WebElement confirmPassword;

    @FindBy(css = "button[class$='btn-primary']")
    private WebElement registerButton;

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public void register(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(registerContainer));
        this.username.clear();
        this.username.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
        confirmPassword.clear();
        confirmPassword.sendKeys(password);
        this.registerButton.click();
    }
}
