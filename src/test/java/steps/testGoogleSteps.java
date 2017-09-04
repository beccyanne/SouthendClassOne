package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class testGoogleSteps {

    WebDriver driver = new ChromeDriver();
    //WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver,20);

    @Given("^I am on the google homepage$")
    public void iAmOnTheGoogleHomepage() throws Throwable {
        driver.get("http://www.google.com");
    }

    @When("^I search for HMRC$")
    public void iSearchForHMRC() throws Throwable {
        driver.findElement(By.id("lst-ib")).sendKeys("HMRC");
        driver.findElement(By.name("btnK")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rhscol")));

    }

    @Then("^I see a list of results$")
    public void iSeeAListOfResults() throws Throwable {
        List<WebElement> results = driver.findElements(By.cssSelector("div._NId"));
        assertTrue(results.size() > 0);
    }

    @After
    public void close() {
        driver.quit();
    }
}



