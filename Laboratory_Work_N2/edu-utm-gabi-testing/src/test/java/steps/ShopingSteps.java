package steps;

import actions.CompleteTask;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

public class ShopingSteps {
    CompleteTask completeTask = new CompleteTask();

    @Given("^user is already on the '(.+)' home page$")
    public void openNikeHomePageAndGoToproducts(String pageUrl) throws InterruptedException, IOException {
        completeTask.goToNikeStoreAndCompleteTask(pageUrl);
    }

    @When("^user select and click a category of products to buy$")
    public void selectProductsFromCategory() {
        //TODO: implement scenario context
    }

    @Then("^the list of selected products are displayed in the console$")
    public void displayProductsInConsole() {
        //TODO: implement scenario context
    }

}
