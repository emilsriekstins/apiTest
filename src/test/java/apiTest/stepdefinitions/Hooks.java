package apiTest.stepdefinitions;


import apiTest.helpers.TestCaseContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static apiTest.clients.TrelloClient.deleteList;
import static apiTest.clients.TrelloClient.updateBoardInfo;
import static apiTest.constants.ProjectConstants.BOARD_ID;
import static apiTest.constants.ProjectConstants.BOARD_NAME;

// Cleaning up the ...
public class Hooks {
    @Before
    public void beforeHook() {
        TestCaseContext.init();
        System.out.println("THE SCENARIO HAS STARTED");
    }

    @After
    public void afterHook() {
        deleteList(TestCaseContext.getList().getListID());
        updateBoardInfo(BOARD_NAME, TestCaseContext.getBoard().getBoardID());
        System.out.println("THE SCENARIO HAS ENDED");
    }
}
