import POM.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewDataTests {

    private WebDriver driver;
    private WebDriverWait wait;

    private LoggedOutNavbar loggedOutNavbar;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private Navbar navbar;
    private DataEntryPage dataEntryPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofMillis(2000));

        loggedOutNavbar = new LoggedOutNavbar(driver, wait);
        registerPage = new RegisterPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        navbar = new Navbar(driver, wait);
        dataEntryPage = new DataEntryPage(driver, wait);

        driver.get("http://localhost:5555/");

        String userName = "Testererer001";
        String password = "Ilovetesting123";

        loggedOutNavbar.clickNavbarRegister();
        registerPage.register(userName, password);
        loggedOutNavbar.clickNavbarLogin();
        loginPage.login(userName, password);
    }

    @ParameterizedTest
    @CsvSource({"123456asd, false",
            "12345asd, false",
            "981asdmkd, false",
            "000001AA, true",
            "999999AA, true",
            "123456AA, true",
            "000000AA, true",
            "123456XX, true",
            "123456ZZ, true"  })
    public void idCardTest(String idCardNumber, boolean expected) {
        navbar.clickDataEntryPage();
        boolean pass = dataEntryPage.addNewEntry("test", "test", idCardNumber, "2-19870423-0726",
                "test@test.test", "12345678", "test 1", "Budapest", "Budapest",
                1234, 1, 1, "20240911", true, 3);
        Assertions.assertEquals(expected,pass);
    }

    @ParameterizedTest
    @CsvSource({"1234,true",
            "9999, true",
            "1000, true",
            "1111, true",
            "19999, false",
            "12333, false",
            "9999999, false",
            "1, false",
            "22, false",
            "333, false"})
    public void ZipCodeTest(int zip, boolean expected) {
        navbar.clickDataEntryPage();
        boolean pass = dataEntryPage.addNewEntry("test", "test", "123456AA", "2-19870423-0726",
                "test@test.test", "12345678", "test 1", "Budapest", "Budapest",
                zip, 1, 1, "20240911", true, 3);
        Assertions.assertEquals(expected,pass);
    }

    @ParameterizedTest
    @CsvSource({"12345678,true",
            "11111111, true",
            "11111111111, true",
            "99999999, true",
            "99999999999, true",
            "1111111,false",
            "99999999999999999999, false"})
    public void PhoneNumberTest(String phoneNumber, boolean expected) {
        navbar.clickDataEntryPage();
        boolean pass = dataEntryPage.addNewEntry("test", "test", "123456AA", "2-19870423-0726",
                "test@test.test", phoneNumber, "test 1", "Budapest", "Budapest",
                1234, 1, 1, "20240911", true, 3);
        Assertions.assertEquals(expected,pass);
    }


    @ParameterizedTest
    @CsvSource({"2-19870423-0726, true",
            "2-19870423-0701, false",
            "2-19870423-0700, false"})
    public void PersonalIdNumberTest(String idNumber, boolean expected) {
        navbar.clickDataEntryPage();
        boolean pass = dataEntryPage.addNewEntry("test", "test", "123456AA", idNumber,
                "test@test.test", "12345678", "test 1", "Budapest", "Budapest",
                1234, 1, 1, "20240911", true, 3);
        Assertions.assertEquals(expected,pass);
    }

    @ParameterizedTest
    @CsvSource({"20220101, true",
            "20271231, true",
            "20251222, true",
            "20211231, false",
            "20290101, false"})
    public void DateTest(String date, boolean expected) {
        navbar.clickDataEntryPage();
        boolean pass = dataEntryPage.addNewEntry("test", "test", "123456AA", "2-19870423-0726",
                "test@test.test", "12345678", "test 1", "Budapest", "Budapest",
                1234, 1, 1, date, true, 3);
        Assertions.assertEquals(expected,pass);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
                driver.quit();
        }
    }
}
