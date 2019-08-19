import Logic.Engine;
import Visuals.Screen;

public class Main {

    // first lets try to create a visual board on gui.

    public static void main(String[] args){

        Engine engine = new Engine();
        Screen screen = new Screen(engine);
        screen.run();

        //blocking pieces
        //castling: engine has a castiling possible method?
        //pawn diagonal eating
        //en passant -> responsibility of jumper to inform adjacent pawns of 1 turn possibility
        //turn counter in engine
        //check that king cant go too far
        // fixed . fix illegal turn order costing a move (pawn double jump)
        // pawn upgrading at end of field
        // pawn can move backwards on first move

    }

}
