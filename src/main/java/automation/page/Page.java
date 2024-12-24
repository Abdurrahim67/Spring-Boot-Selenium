package automation.page;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class Page {

    @Autowired
    private WebDriver driver;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement SignupButton;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement Email;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement Password;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement LoginButton;

    @FindBy(xpath = "//button[@class='fc-button fc-cta-consent fc-primary-button']")
    public WebElement EinwiligenButton;
    
    


}
    // Loginpage Elements----------------------------------------------------------------
  

//user123789@gmail.com
//user123789