package ru.training.at.hw7;

import beans.TrelloBoardJson;
import org.testng.annotations.Test;

import static constants.ParameterName.BOARD_NAME;
import static constants.ParameterName.NEW_BOARD_NAME;
import static core.TrelloServiceObj.*;
import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class TrelloBoardTest {

    @Test
    public void testBoardCreated() {
        TrelloBoardJson board = createBoard();
        String createdBoardId = board.getId();

        assertEquals(board.getName(), BOARD_NAME);
        assertTrue(board.getName().length() == BOARD_NAME.length());
        assertNotNull(board);

        deleteBoard(createdBoardId);
    }

    @Test
    public void testBoardUpdated() {
        TrelloBoardJson board = createBoard();
        String createdBoardId = board.getId();
        String createdBoardName = board.getName();

        TrelloBoardJson updatedBoard = updateBoardName(NEW_BOARD_NAME, createdBoardId);

        assertNotEquals(updatedBoard.getName(), createdBoardName);
        assertNotEquals(updatedBoard.getName().length(), createdBoardName.length());
        assertEquals(updatedBoard.getId(), createdBoardId);
        assertNotNull(updatedBoard);

        deleteBoard(createdBoardId);
    }

    @Test
    public void testBoardCanBeRetrievedById() {
        TrelloBoardJson board = createBoard();
        String createdBoardId = board.getId();

        TrelloBoardJson retrievedBoardById = getBoardById(createdBoardId);

        assertEquals(board.getName(), retrievedBoardById.getName());
        assertEquals(retrievedBoardById.getId(), createdBoardId);
        assertNotNull(retrievedBoardById);

        deleteBoard(createdBoardId);
    }

    @Test
    public void testBoardDeleted() {
        TrelloBoardJson board = createBoard();
        String createdBoardId = board.getId();

        TrelloBoardJson deletedBoard = deleteBoard(createdBoardId);
        String deletedBoardDescription = getDeletedBoardById(createdBoardId);

        assertNotNull(deletedBoard);
        assertNotEquals(board, deletedBoard);
        assertTrue(deletedBoardDescription.contains("The requested resource was not found."));
    }
}
