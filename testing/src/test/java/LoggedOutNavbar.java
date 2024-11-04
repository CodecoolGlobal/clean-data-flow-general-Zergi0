import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedOutNavbar {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "ul")
    private WebElement navbarContainer;

    @FindBy(css = "html > body > div:nth-of-type(1) > nav > div > div > ul > li:nth-of-type(1) > a")
    private WebElement navbarLoginPage;

    @FindBy(css = "html > body > div:nth-of-type(1) > nav > div > div > ul > li:nth-of-type(2) > a")
    private WebElement navbarRegisterPage;

    public LoggedOutNavbar(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void clickNavbarLogin() {
        wait.until(ExpectedConditions.visibilityOf(navbarContainer));
        navbarLoginPage.click();
    }
    public void clickNavbarRegister() {
        wait.until(ExpectedConditions.visibilityOf(navbarContainer));
        navbarRegisterPage.click();
    }

}
