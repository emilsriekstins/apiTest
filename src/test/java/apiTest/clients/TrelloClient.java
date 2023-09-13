package apiTest.clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static apiTest.constants.ProjectConstants.API_KEY;
import static apiTest.constants.ProjectConstants.API_TOKEN;

public class TrelloClient {
    public static Response getBoardInfo(String boardID){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .when()
                .get("https://api.trello.com/1/boards/" + boardID)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response updateBoardInfo(String boardName, String boardID) {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .queryParam("name", boardName)
                .when()
                .put("https://api.trello.com/1/boards/" + boardID)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
}
