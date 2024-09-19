package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginSteps extends CommonMethods{

   // public static WebDriver driver;

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        //launch the application in chrome browser
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        WebElement usernameField = driver.findElement(By.xpath("//*[@id='txtUsername']"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='txtPassword']"));
        passwordField.sendKeys("Hum@nhrm123");

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
       WebElement loginButton = driver.findElement(By.xpath("//*[@id='btnLogin']"));
       loginButton.click();
    }

    @Then("user should logged in successfully")
    public void user_should_logged_in_successfully() {
        System.out.println("test passed");
    }

    @Then("user closes the browser")
    public void user_closes_the_browser() {
       driver.close();
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        WebElement usernameField = driver.findElement(By.xpath("//*[@id='txtUsername']"));
        usernameField.sendKeys("admin123");
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='txtPassword']"));
        passwordField.sendKeys("Hum@nhrm123456");
    }
    @Then("user should see error message")
    public void user_should_see_error_message() {
        System.out.println("error message shown");
    }
}
