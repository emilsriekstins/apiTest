package apiTest.stepdefinitions;

import apiTest.domain.Board;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import static apiTest.clients.TrelloClient.getBoardInfo;
import static apiTest.clients.TrelloClient.updateBoardInfo;
import static apiTest.constants.ProjectConstants.BOARD_ID;
import static apiTest.constants.ProjectConstants.BOARD_NAME;

public class TrelloSteps {
    @Given("The board exists and contains the correct information")
    public void getBoardDataAndCheckInfo() {
        Response response = getBoardInfo(BOARD_ID);
        Board board = response.as(Board.class);
        
        Assertions.assertThat(board.getId())
                .as("We assert that the board ID is correct")
                .isEqualTo(BOARD_ID);

        Assertions.assertThat(board.getName())
                .as("We assert that the board name is correct")
                .isEqualTo(BOARD_NAME);
    }

    @When("I change the board title to {string}")
    public void iChangeTheBoardTitleTo(String title) {
        Response response = updateBoardInfo(BOARD_NAME ,BOARD_ID);
    }

    @And("I check that the board name was updated to {string}")
    public void iCheckThatTheBoardNameWasUpdatedTo(String title) {
        // TODO add api calls
        System.out.println("The 3rd step was executed");
    }

    @Then("I add a list with a name {string} to the board")
    public void iAddAListWithANameToTheBoard(String listName) {
        // TODO add api calls
        System.out.println("The 4th step was executed");
    }
}
