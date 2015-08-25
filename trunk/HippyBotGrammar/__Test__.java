import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        FiziksGramrLexer lex = new FiziksGramrLexer(new ANTLRFileStream("C:\\Users\\James\\Documents\\output\\__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        FiziksGramrParser g = new FiziksGramrParser(tokens, 49100, null);
        try {
            g.ID();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}