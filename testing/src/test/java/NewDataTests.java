import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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

    private String userName;
    private String password;

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

        userName = System.getenv("TEST_USER_NAME");
        password = System.getenv("TEST_USER_PASSWORD");
        dataEntryPage = new DataEntryPage(driver, wait);

        driver.get("http://localhost:5555/");
    }

    @ParameterizedTest
    @ValueSource(strings = {"000001AA", "999999AA", "123456AA", "000000AA", "123456XX", "123456ZZ"})
    public void idCardTestCorrectBoundaries(String idCardNumber) {
        loggedOutNavbar.clickNavbarRegister();
        registerPage.register(userName, password);
        loggedOutNavbar.clickNavbarLogin();
        loginPage.login(userName, password);
        navbar.clickDataEntryPage();
        boolean pass = dataEntryPage.addNewEntry("test", "test", idCardNumber, "2-19870423-0726",
                "test@test.test", "12345678", "test 1", "Budapest", "Budapest",
                1234, 1, 1, "20240911", true, 3);
        Assertions.assertTrue(pass);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456asd", "12345asd", "981asdmkd"})
    public void idCardTestIncorrectBoundaries(String idCardNumber) {
        loggedOutNavbar.clickNavbarRegister();
        registerPage.register(userName, password);
        loggedOutNavbar.clickNavbarLogin();
        loginPage.login(userName, password);
        navbar.clickDataEntryPage();
        boolean pass = dataEntryPage.addNewEntry("test", "test", idCardNumber, "2-19870423-0726",
                "test@test.test", "12345678", "test 1", "Budapest", "Budapest",
                1234, 1, 1, "20240911", true, 3);
        Assertions.assertFalse(pass);
    }

    @ParameterizedTest
    @ValueSource(ints = {1234, 9999, 1000, 1111})
    public void ZipCodeCorrectBoundaries(int zip) {
        loggedOutNavbar.clickNavbarRegister();
        registerPage.register(userName, password);
        loggedOutNavbar.clickNavbarLogin();
        loginPage.login(userName, password);
        navbar.clickDataEntryPage();
        boolean pass = dataEntryPage.addNewEntry("test", "test", "123456AA", "2-19870423-0726",
                "test@test.test", "12345678", "test 1", "Budapest", "Budapest",
                zip, 1, 1, "20240911", true, 3);
        Assertions.assertTrue(pass);
    }

    @ParameterizedTest
    @ValueSource(ints = {19999, 12333, 9999999, 1, 22, 33})
    public void ZipCodeIncorrectBoundaries(int zip) {
        loggedOutNavbar.clickNavbarRegister();
        registerPage.register(userName, password);
        loggedOutNavbar.clickNavbarLogin();
        loginPage.login(userName, password);
        navbar.clickDataEntryPage();
        boolean pass = dataEntryPage.addNewEntry("test", "test", "123456AA", "2-19870423-0726",
                "test@test.test", "12345678", "test 1", "Budapest", "Budapest",
                zip, 1, 1, "20240911", true, 3);
        Assertions.assertFalse(pass);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345678", "11111111", "11111111111", "99999999", "99999999999"})
    public void PhoneNumberCorrectBoundaries(String phoneNumber) {
        loggedOutNavbar.clickNavbarRegister();
        registerPage.register(userName, password);
        loggedOutNavbar.clickNavbarLogin();
        loginPage.login(userName, password);
        navbar.clickDataEntryPage();
        boolean pass = dataEntryPage.addNewEntry("test", "test", "123456AA", "2-19870423-0726",
                "test@test.test", phoneNumber, "test 1", "Budapest", "Budapest",
                1234, 1, 1, "20240911", true, 3);
        Assertions.assertTrue(pass);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1111111", "99999999999999999999"})
    public void PhoneNumberIncorrectBoundaries(String phoneNumber) {
        loggedOutNavbar.clickNavbarRegister();
        registerPage.register(userName, password);
        loggedOutNavbar.clickNavbarLogin();
        loginPage.login(userName, password);
        navbar.clickDataEntryPage();
        boolean pass = dataEntryPage.addNewEntry("test", "test", "123456AA", "2-19870423-0726",
                "test@test.test", phoneNumber, "test 1", "Budapest", "Budapest",
                1234, 1, 1, "20240911", true, 3);
        Assertions.assertFalse(pass);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2-19870423-0726"})
    public void PersonalCorrectBoundaries(String idNumber) {
        loggedOutNavbar.clickNavbarRegister();
        registerPage.register(userName, password);
        loggedOutNavbar.clickNavbarLogin();
        loginPage.login(userName, password);
        navbar.clickDataEntryPage();
        boolean pass = dataEntryPage.addNewEntry("test", "test", "123456AA", idNumber,
                "test@test.test", "12345678", "test 1", "Budapest", "Budapest",
                1234, 1, 1, "20240911", true, 3);
        Assertions.assertTrue(pass);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2-19870423-0701", "2-19870423-0700"})
    public void PersonalIncorrectBoundaries(String idNumber) {
        loggedOutNavbar.clickNavbarRegister();
        registerPage.register(userName, password);
        loggedOutNavbar.clickNavbarLogin();
        loginPage.login(userName, password);
        navbar.clickDataEntryPage();
        boolean pass = dataEntryPage.addNewEntry("test", "test", "123456AA", idNumber,
                "test@test.test", "12345678", "test 1", "Budapest", "Budapest",
                1234, 1, 1, "20240911", true, 3);
        Assertions.assertFalse(pass);
    }

    @ParameterizedTest
    @ValueSource(strings = {"20220101", "20271231", "20251222"})
    public void DateCorrectBoundaries(String date) {
        loggedOutNavbar.clickNavbarRegister();
        registerPage.register(userName, password);
        loggedOutNavbar.clickNavbarLogin();
        loginPage.login(userName, password);
        navbar.clickDataEntryPage();
        boolean pass = dataEntryPage.addNewEntry("test", "test", "123456AA", "2-19870423-0726",
                "test@test.test", "12345678", "test 1", "Budapest", "Budapest",
                1234, 1, 1, date, true, 3);
        Assertions.assertTrue(pass);
    }

    @ParameterizedTest
    @ValueSource(strings = {"20211231", "20290101"})
    public void DateIncorrectBoundaries(String date) {
        loggedOutNavbar.clickNavbarRegister();
        registerPage.register(userName, password);
        loggedOutNavbar.clickNavbarLogin();
        loginPage.login(userName, password);
        navbar.clickDataEntryPage();
        boolean pass = dataEntryPage.addNewEntry("test", "test", "123456AA", "2-19870423-0726",
                "test@test.test", "12345678", "test 1", "Budapest", "Budapest",
                1234, 1, 1, date, true, 3);
        Assertions.assertFalse(pass);
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
                driver.quit();  // This should close the browser
        }
    }
}
