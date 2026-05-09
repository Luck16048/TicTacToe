import org.example.TicTacToe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {
    @Test
    void testInitBoard() {
        char[][] result = TicTacToe.initBoard(new char[3][3]);

        for (int i = 0; i < 3; i++)
            for(int j =0; j < 3; j++)
                assertEquals(' ', result[i][j]);
    }
}
