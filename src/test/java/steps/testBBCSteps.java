package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class testBBCSteps {

    WebDriver driver = new ChromeDriver();


    @Given("^Im on the BBC homepage$")
    public void im_on_the_BBC_homepage() throws Throwable {
        driver.get("http://www.bbc.co.uk/news");
    }

    @Then("^I should see multiple tabs on the header$")
    public void i_should_see_multiple_tabs_on_the_header() throws Throwable {
        driver.findElement(By.id("orb-header"));
        List<WebElement> listOfElements = driver.findElements(By.cssSelector("#orb-nav-links li"));
        Assert.assertTrue(listOfElements.size() == 190);
    }

    @When("^Im click on Tech Page tab$")
    public void im_click_on_Tech_Page_tab() throws Throwable {
        driver.findElement(By.cssSelector("a[href='/news/technology']")).click();
    }

    @Then("^Tech Page opens$")
    public void tech_Page_opens() throws Throwable {
        String pageTitle = driver.findElement(By.id("comp-index-title")).getText();
        Assert.assertTrue(pageTitle.equals("Technology"));
        Assert.assertEquals(pageTitle, "Technology");

    }


    @When("^i click search icon$")
    public void i_click_search_icon() throws Throwable {
        driver.findElement(By.className("se-searchbox__submit")).click();
    }
    @Then("^a list of results for \"([^\"]*)\" is returned$")
    public void a_list_of_results_for_is_returned(String searchTerm) throws Throwable {
        List<WebElement> listOfElements = driver.findElements(By.cssSelector("#search-content li"));
        Assert.assertTrue(listOfElements.size()==10);
        for (WebElement item : listOfElements) {
            String itemText = item.getText();
            Assert.assertTrue(itemText.contains(searchTerm));
    }


    }

    @When("^i enter text \"([^\"]*)\" in the search box$")
    public void i_enter_text_in_the_search_box(String searchTerm) throws Throwable {
        driver.findElement(By.id("orb-search-q")).sendKeys(searchTerm);

    }

    @Then("^I should be able to view the most watched section$")
    public void i_should_be_able_to_view_the_most_watched_section() throws Throwable {
        //driver.findElement(By.id("nw-c-must-see-heading__title"));
        driver.findElement(By.id("nw-c-most-watched-heading__title"));
    }

    @When("^I select an article from most watched section$")
    public void i_select_an_article_from_most_watched_section() throws Throwable {
        driver.findElement(By.id("nw-c-most-watched-heading__title"));
        driver.findElement(By.cssSelector("li[data-entityid='most-popular-watched#4']")).click();
    }

    @Then("^the selected article text should appear$")
    public void the_selected_article_text_should_appear() throws Throwable {
        WebElement articleHeading = driver.findElement(By.className("vxp-media__headline"));
        Assert.assertTrue(articleHeading.isDisplayed());
    }

}

/**@After
    public void close() {
        driver.quit();
    }

}**/
