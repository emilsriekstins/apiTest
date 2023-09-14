package apiTest.stepdefinitions;


import apiTest.helpers.TestCaseContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static apiTest.clients.TrelloClient.deleteList;
import static apiTest.clients.TrelloClient.updateBoardInfo;
import static apiTest.constants.ProjectConstants.BOARD_NAME;

// Cleaning up the ...
public class Hooks {
    @Before
    public void beforeHook(Scenario scenario) {
        TestCaseContext.init();
        TestCaseContext.setScenario(scenario);
        System.out.println("THE SCENARIO HAS STARTED");
    }

    @After
    public void afterHook() {
        deleteList(TestCaseContext.getList().getId());
        updateBoardInfo(BOARD_NAME, TestCaseContext.getBoard().getId());
        System.out.println("THE SCENARIO HAS ENDED");
    }
}
