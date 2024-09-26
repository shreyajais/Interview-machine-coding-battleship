package inpOut.Input;

import java.io.IOException;

public interface IInputProvider {
    PlayerInput takeInput() throws IOException;

    int takeBoardSizeInput() throws IOException;

    int takeNumberOfItemInput() throws IOException;

    ItemInput takeItemInput() throws IOException;
}
