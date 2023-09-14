package apiTest.helpers;

import apiTest.domain.Board;
import apiTest.domain.List;
import lombok.Getter;
import lombok.Setter;


public class TestCaseContext {
    @Setter @Getter
    private static Board board;
    @Setter @Getter
    private static List list;

    public static void init() {
        board = null;
        list = null;
    }
}
