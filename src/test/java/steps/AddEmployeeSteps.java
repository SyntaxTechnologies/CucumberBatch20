package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods{

   // public static WebDriver driver;

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
        WebElement addEmployeeButton = driver.findElement(By.xpath("//*[@id='menu_pim_addEmployee']"));
        addEmployeeButton.click();
    }

    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
        WebElement firstNameLoc = driver.findElement(By.xpath("//*[@id='firstName']"));
        WebElement lastNameLoc = driver.findElement(By.xpath("//*[@id='lastName']"));
        firstNameLoc.sendKeys("mike");
        lastNameLoc.sendKeys("tyson");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveButton = driver.findElement(By.xpath("//*[@id='btnSave']"));
        saveButton.click();
    }

    @Then("employee added succesfully")
    public void employee_added_succesfully() {
        System.out.println("employee added");
    }

    @When("user enters firstname , middlename, lastname and upload photo")
    public void user_enters_firstname_middlename_lastname_and_upload_photo() {
         WebElement firstNameLoc = driver.findElement(By.xpath("//*[@id='firstName']"));
         WebElement middleNameLoc = driver.findElement(By.xpath("//*[@id='middleName']"));
         WebElement lastNameLoc = driver.findElement(By.xpath("//*[@id='lastName']"));

         firstNameLoc.sendKeys("mike");
         middleNameLoc.sendKeys("jamie");
         lastNameLoc.sendKeys("tyson");
    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String firstName, String middleName, String lastName) {
        WebElement firstNameLoc = driver.findElement(By.xpath("//*[@id='firstName']"));
        WebElement middleNameLoc = driver.findElement(By.xpath("//*[@id='middleName']"));
        WebElement lastNameLoc = driver.findElement(By.xpath("//*[@id='lastName']"));

        firstNameLoc.sendKeys(firstName);
        middleNameLoc.sendKeys(middleName);
        lastNameLoc.sendKeys(lastName);
    }

    @When("user enters {string} and {string} and {string} for employee")
    public void user_enters_and_and_for_employee(String fn, String mn, String ln) {
        WebElement firstNameLoc = driver.findElement(By.xpath("//*[@id='firstName']"));
        WebElement middleNameLoc = driver.findElement(By.xpath("//*[@id='middleName']"));
        WebElement lastNameLoc = driver.findElement(By.xpath("//*[@id='lastName']"));

        firstNameLoc.sendKeys(fn);
        middleNameLoc.sendKeys(mn);
        lastNameLoc.sendKeys(ln);
    }

    @When("user adds multiple employees from excel and verify the employee has added")
    public void user_adds_multiple_employees_from_excel_and_verify_the_employee_has_added() throws InterruptedException, IOException {
        //this excel reader returns list of maps

        List<Map<String,String>> newEmployees = ExcelReader.read(Constants.EXCEL_FILE_PATH,"employees");

        for (Map<String,String> newEmployee:newEmployees
        ) {
            //this newEmployee map will give me all the values based on the keys

            WebElement firstNameLoc = driver.findElement(By.xpath("//*[@id='firstName']"));
            WebElement middleNameLoc = driver.findElement(By.xpath("//*[@id='middleName']"));
            WebElement lastNameLoc = driver.findElement(By.xpath("//*[@id='lastName']"));

            firstNameLoc.sendKeys(newEmployee.get("firstName"));
            middleNameLoc.sendKeys(newEmployee.get("middleName"));
            lastNameLoc.sendKeys(newEmployee.get("lastName"));

            WebElement saveButton = driver.findElement(By.xpath("//*[@id='btnSave']"));
            saveButton.click();

            WebElement addEmployeeButton = driver.findElement(By.xpath("//*[@id='menu_pim_addEmployee']"));
            addEmployeeButton.click();

        }

    }

}
