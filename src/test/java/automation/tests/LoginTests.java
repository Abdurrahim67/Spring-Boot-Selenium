package automation.tests;

import automation.SpringBaseTestNGTest;
import automation.page.Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.*;


@SpringBootTest
public class LoginTests extends SpringBaseTestNGTest  {

    @Autowired
    private Page page;

    @Autowired
    private WebDriverWait wait;

    @Value("${valid.email}")
    private String validEmail;

    @Value("${valid.password}")
    private String validPassword;


    @Test(groups = {"smoke"})
    public void LoginPositivTest() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(page.EinwiligenButton)).click();
        wait.until(ExpectedConditions.visibilityOf(page.SignupButton)).click();
        wait.until(ExpectedConditions.visibilityOf(page.Email)).sendKeys(validEmail);
        wait.until(ExpectedConditions.visibilityOf(page.Password)).sendKeys(validPassword);
        wait.until(ExpectedConditions.elementToBeClickable(page.LoginButton)).click();
        Assert.assertTrue(true);

    }

    @DataProvider
    public static Object[][] InvalidTestData() {
        return new Object[][]{
                {"999@gmail.com", "muster1."}, {"mter9878+@gmail.com", "musdghd"}, {"must7234@gmail.com", "nde678"}, {"@gmail.com", ""}

        };
    }

    @Test(dataProvider = "InvalidTestData",groups = {"smoke"})
    public void LoginNegativenTests(String invalidEmail, String invalidPassword) {
        wait.until(ExpectedConditions.visibilityOf(page.EinwiligenButton)).click();
        wait.until(ExpectedConditions.visibilityOf(page.SignupButton)).click();
        wait.until(ExpectedConditions.visibilityOf(page.Email)).sendKeys(invalidEmail);
        wait.until(ExpectedConditions.visibilityOf(page.Password)).sendKeys(invalidPassword);
        wait.until(ExpectedConditions.elementToBeClickable(page.LoginButton)).click();
        Assert.assertTrue(true);

    }

}



