package ru.training.at.hw7;

import beans.TrelloBoardJson;
import io.restassured.http.Method;
import org.testng.annotations.Test;

import static constants.ParameterName.BOARD_NAME;
import static constants.ParameterName.NEW_BOARD_NAME;
import static core.TrelloServiceObj.*;
import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class TrelloBoardTest {
    String createdBoardName;
    String createdBoardId;

    @Test(priority = 0)
    public void checkBoardCreated() {
      TrelloBoardJson board = getBoard(
              new ApiRequestBuilder()
                        .setBoardName(BOARD_NAME)
                        .setMethod(Method.POST)
                        .buildRequest()
                        .sendRequest()
                        .then().assertThat()
                        .spec(goodResponseSpecification())
                        .extract()
                        .response());

        createdBoardId = board.getId();
        createdBoardName = board.getName();

        assertEquals(createdBoardName, BOARD_NAME);
        assertNotNull(board);
    }

    @Test(priority = 1)
    public void checkBoardUpdated() {
        TrelloBoardJson board = getBoard(
                new ApiRequestBuilder()
                        .setId(createdBoardId)
                        .setBoardName(NEW_BOARD_NAME)
                        .setMethod(Method.PUT)
                        .buildRequest()
                        .sendUpdDelGetRequest(createdBoardId)
                        .then().assertThat()
                        .spec(goodResponseSpecification())
                        .extract()
                        .response());

        assertNotEquals(board.getName(), BOARD_NAME);
        assertEquals(board.getId(), createdBoardId);
        assertNotNull(board);
    }

    @Test(priority = 2)
    public void checkBoardCanBeRetrievedById() {
        TrelloBoardJson board = getBoard(
                new ApiRequestBuilder()
                        .setMethod(Method.GET)
                        .buildRequest()
                        .sendUpdDelGetRequest(createdBoardId)
                        .then().assertThat()
                        .spec(goodResponseSpecification())
                        .extract()
                        .response());

        assertNotEquals(board.getName(), BOARD_NAME);
        assertEquals(board.getId(), createdBoardId);
        assertNotNull(board);
    }

    @Test(priority = 3, dependsOnMethods = {})
    public void deleteBoard() {
        TrelloBoardJson board = getBoard(
                new ApiRequestBuilder()
                        .setId(createdBoardId)
                        .setMethod(Method.DELETE)
                        .buildRequest()
                        .sendUpdDelGetRequest(createdBoardId)
                        .then().assertThat()
                        .spec(goodResponseSpecification())
                        .extract()
                        .response());

        assertNull(board.getName());
        assertNull(board.getId());
        assertNotNull(board);
    }

    @Test(priority = 4, dependsOnMethods = {})
    public void checkBoardDeleted() {
        String board = getDeletedBoard(
                new ApiRequestBuilder()
                        .setId(createdBoardId)
                        .buildRequest()
                        .sendUpdDelGetRequest(createdBoardId)
                        .then().assertThat()
                        .spec(badResponseSpecification())
                        .extract()
                        .response());

        assertNotNull(board);
        assertTrue(board.contains("The requested resource was not found."));
    }
}
