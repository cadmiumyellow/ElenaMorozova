package core;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import beans.TrelloBoardJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import static constants.ParameterName.*;
import static io.restassured.http.ContentType.URLENC;
import static org.hamcrest.Matchers.lessThan;

public class TrelloServiceObj {
    private static final URI TRELLO_URI = URI.create("https://trello.com/1/boards");
    private Method requestMethod;

    //BEGINNING OF BUILDER PATTERN
    private Map<String, String> parameters;

    private TrelloServiceObj(Map<String, String> parameters, Method method) {
        this.parameters = parameters;
        this.requestMethod = method;
    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
    }

    public static class ApiRequestBuilder {
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;

        public ApiRequestBuilder setMethod(Method method){
            requestMethod = method;
            return this;
        }

        public ApiRequestBuilder setId(String id) {
            parameters.put("id", id);
            return this;
        }

        public ApiRequestBuilder setBoardName(String boardName) {
            parameters.put("name", boardName);
            return this;
        }

        public ApiRequestBuilder setApiKey() {
            parameters.put("key", API_KEY);
            return this;
        }

        public ApiRequestBuilder setApiToken() {
            parameters.put("token", API_TOKEN);
            return this;
        }

        public TrelloServiceObj buildRequest() {
            return new TrelloServiceObj(parameters, requestMethod);
        }
    }
    //ENDING OF BUILDER PATTERN

    public Response sendUpdDelGetRequest(String boardId) {
        return RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .request(requestMethod, TRELLO_URI + "/" + boardId)
                .prettyPeek();
    }

    public Response sendRequest() {
        return RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .request(requestMethod, TRELLO_URI)
                .prettyPeek();
    }

   public static TrelloBoardJson getBoard(Response response) {
        TrelloBoardJson board = new Gson()
                .fromJson(response.asString().trim(), new TypeToken<TrelloBoardJson>() {
                }.getType());
        return board;
    }

    public static String getDeletedBoard(Response response) {
        return  response.asString().trim();
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .addQueryParam("token", API_TOKEN)
                .addQueryParam("key", API_KEY)
                .setBaseUri(TRELLO_URI)
                .build().contentType(URLENC.withCharset("utf-8"));
    }

    public static ResponseSpecification goodResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(10000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static ResponseSpecification notFoundResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.TEXT)
                .expectResponseTime(lessThan(10000L))
                .expectStatusCode(HttpStatus.SC_NOT_FOUND)
                .build();
    }

    public static TrelloBoardJson createBoard() {
        return  getBoard(new ApiRequestBuilder()
                .setBoardName(BOARD_NAME)
                .setMethod(Method.POST)
                .buildRequest()
                .sendRequest()
                .then().assertThat()
                .spec(goodResponseSpecification())
                .extract()
                .response());
    }

    public static TrelloBoardJson deleteBoard(String boardId) {
        return getBoard(new ApiRequestBuilder()
                .setId(boardId)
                .setMethod(Method.DELETE)
                .buildRequest()
                .sendUpdDelGetRequest(boardId)
                .then().assertThat()
                .spec(goodResponseSpecification())
                .extract()
                .response());
    }

    public static TrelloBoardJson getBoardById(String boardId) {
        return getBoard(new ApiRequestBuilder()
                //.setId(boardId)
                .setMethod(Method.GET)
                .buildRequest()
                .sendUpdDelGetRequest(boardId)
                .then().assertThat()
                .spec(goodResponseSpecification())
                .extract()
                .response());
    }

    public static String getDeletedBoardById(String boardId) {
        return getDeletedBoard(new ApiRequestBuilder()
                .buildRequest()
                .sendUpdDelGetRequest(boardId)
                .then().assertThat()
                .spec(notFoundResponseSpecification())
                .extract()
                .response());
    }

    public static TrelloBoardJson updateBoardName(String newBoardName, String boardId) {
        return getBoard(new ApiRequestBuilder()
                //.setId(id)
                .setBoardName(newBoardName)
                .setMethod(Method.PUT)
                .buildRequest()
                .sendUpdDelGetRequest(boardId)
                .then().assertThat()
                .spec(goodResponseSpecification())
                .extract()
                .response());
    }

}
