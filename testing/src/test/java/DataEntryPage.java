import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataEntryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "id-card-number")
    private WebElement idCardNumber;

    @FindBy(id = "id-number")
    private WebElement idNumber;

    @FindBy(id = "inputEmail")
    private WebElement email;

    @FindBy(id = "inputPhone")
    private WebElement phoneNumber;

    @FindBy(id = "inputAddress")
    private WebElement address;

    @FindBy(id = "inputCity")
    private WebElement city;

    @FindBy(css = "html > body > div:nth-of-type(2) > div:nth-of-type(2) > form > div:nth-of-type(9) > select")
    private Select county;

    @FindBy(id = "#inputZip")
    private WebElement zip;

    @FindBy(id = "formerAverage")
    private WebElement average;

    @FindBy(id = "admissionScore")
    private WebElement admissionScore;

    @FindBy(id = "startDate")
    private WebElement startDate;

    @FindBy(id = "gridCheck")
    private WebElement welcomePackageCheck;

    @FindBy(id = "fullstack")
    private WebElement fullstackToggle;

    @FindBy(id = "frontend")
    private WebElement frontendToggle;

    @FindBy(id = "backend")
    private WebElement backendToggle;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(css = "div[class^='alert']")
    private WebElement alert;

    public DataEntryPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public boolean addNewEntry(String firstNameStr, String lastNameStr,String idCardNumberStr, String idNumberStr,
    String emailStr, String phoneNumberStr, String addressStr, String cityStr, String countyStr, int zipCode,
                            int formerAverage, int admissionScoreNum, String startDateStr,boolean welcomePackageArrived, int fullstackFrontendOrBackEnd123){

        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.clear();
        firstName.sendKeys(firstNameStr);
        lastName.clear();
        lastName.sendKeys(lastNameStr);
        idCardNumber.clear();
        idCardNumber.sendKeys(idCardNumberStr);
        idNumber.clear();
        idNumber.sendKeys(idNumberStr);
        email.clear();
        email.sendKeys(emailStr);
        phoneNumber.clear();
        phoneNumber.sendKeys(phoneNumberStr);
        address.clear();
        address.sendKeys(addressStr);
        city.clear();
        city.sendKeys(cityStr);

        county.selectByVisibleText(countyStr);

        zip.clear();
        zip.sendKeys(String.valueOf(zipCode));
        average.clear();
        average.sendKeys(String.valueOf(formerAverage));
        admissionScore.clear();
        admissionScore.sendKeys(String.valueOf(admissionScoreNum));
        startDate.sendKeys(startDateStr);
        if(welcomePackageArrived){
            welcomePackageCheck.click();
        }
        if (fullstackFrontendOrBackEnd123 == 1){
            fullstackToggle.click();
        } else if (fullstackFrontendOrBackEnd123 == 2) {
            frontendToggle.click();
        } else if (fullstackFrontendOrBackEnd123 == 3) {
            backendToggle.click();
        }

        submitButton.click();

        try{
            wait.until(ExpectedConditions.visibilityOf(alert));
            return true;
        } catch (Error e){
            return false;
        }
    }


}
