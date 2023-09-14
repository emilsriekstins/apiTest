package apiTest.clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static apiTest.constants.ProjectConstants.API_KEY;
import static apiTest.constants.ProjectConstants.API_TOKEN;

public class TrelloClient {
    private static RequestSpecification trelloSpec() {
        return RestAssured
                .given().log().all()
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN);
    }

    public static Response getBoardInfo(String boardID){
        return RestAssured
                .given(trelloSpec())
                .when()
                .get("https://api.trello.com/1/boards/" + boardID)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response updateBoardInfo(String boardName, String boardID) {
        return RestAssured
                .given(trelloSpec())
                .queryParam("name", boardName)
                .when()
                .put("https://api.trello.com/1/boards/" + boardID)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response createList(String listName, String boardID) {
        return RestAssured
                .given(trelloSpec())
                .queryParam("name", listName)
                .queryParam("idBoard", boardID)
                .when()
                .post("https://api.trello.com/1/lists")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response deleteList(String listID) {
        return RestAssured
                .given(trelloSpec())
                .queryParam("value", true)
                .when()
                .put("https://api.trello.com/1/lists/" + listID + "/closed")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
}
