// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\Users\\James\\Documents\\FiziksGramr.g 2010-01-23 21:43:07

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
public class FiziksGramrParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "INT", "ID", "FLOAT", "STRING", "CHAR", "EXPONENT", "COMMENT", "WS", "ESC_SEQ", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC", "'import'", "'hippy'", "'all'", "'the'", "'hippies'", "'must'", "'die'", "'+'"
    };
    public static final int EXPONENT=9;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int UNICODE_ESC=14;
    public static final int T__20=20;
    public static final int OCTAL_ESC=15;
    public static final int CHAR=8;
    public static final int HEX_DIGIT=13;
    public static final int INT=4;
    public static final int FLOAT=6;
    public static final int ID=5;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int ESC_SEQ=12;
    public static final int T__16=16;
    public static final int WS=11;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int COMMENT=10;
    public static final int STRING=7;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "iimport", "val", "theymustalldie", "expression", 
        "statement", "start", "hippy"
    };
     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public FiziksGramrParser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public FiziksGramrParser(TokenStream input, int port, RecognizerSharedState state) {
            super(input, state);
            DebugEventSocketProxy proxy =
                new DebugEventSocketProxy(this, port, null);
            setDebugListener(proxy);
            try {
                proxy.handshake();
            }
            catch (IOException ioe) {
                reportError(ioe);
            }
        }
    public FiziksGramrParser(TokenStream input, DebugEventListener dbg) {
        super(input, dbg, new RecognizerSharedState());

    }
    protected boolean evalPredicate(boolean result, String predicate) {
        dbg.semanticPredicate(result, predicate);
        return result;
    }


    public String[] getTokenNames() { return FiziksGramrParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\James\\Documents\\FiziksGramr.g"; }



    // $ANTLR start "start"
    // C:\\Users\\James\\Documents\\FiziksGramr.g:68:1: start : ( statement )* ;
    public final void start() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "start");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(68, 1);

        try {
            // C:\\Users\\James\\Documents\\FiziksGramr.g:68:7: ( ( statement )* )
            dbg.enterAlt(1);

            // C:\\Users\\James\\Documents\\FiziksGramr.g:68:9: ( statement )*
            {
            dbg.location(68,9);
            // C:\\Users\\James\\Documents\\FiziksGramr.g:68:9: ( statement )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1);

                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=16 && LA1_0<=18)) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\James\\Documents\\FiziksGramr.g:68:9: statement
            	    {
            	    dbg.location(68,9);
            	    pushFollow(FOLLOW_statement_in_start584);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(68, 19);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "start");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "start"


    // $ANTLR start "statement"
    // C:\\Users\\James\\Documents\\FiziksGramr.g:70:1: statement : ( iimport | hippy | theymustalldie );
    public final void statement() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "statement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(70, 1);

        try {
            // C:\\Users\\James\\Documents\\FiziksGramr.g:71:2: ( iimport | hippy | theymustalldie )
            int alt2=3;
            try { dbg.enterDecision(2);

            switch ( input.LA(1) ) {
            case 16:
                {
                alt2=1;
                }
                break;
            case 17:
                {
                alt2=2;
                }
                break;
            case 18:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\James\\Documents\\FiziksGramr.g:71:4: iimport
                    {
                    dbg.location(71,4);
                    pushFollow(FOLLOW_iimport_in_statement594);
                    iimport();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\James\\Documents\\FiziksGramr.g:71:12: hippy
                    {
                    dbg.location(71,12);
                    pushFollow(FOLLOW_hippy_in_statement596);
                    hippy();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\James\\Documents\\FiziksGramr.g:71:18: theymustalldie
                    {
                    dbg.location(71,18);
                    pushFollow(FOLLOW_theymustalldie_in_statement598);
                    theymustalldie();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(71, 32);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "statement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "statement"


    // $ANTLR start "iimport"
    // C:\\Users\\James\\Documents\\FiziksGramr.g:73:1: iimport : 'import' ID ;
    public final void iimport() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "iimport");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(73, 1);

        try {
            // C:\\Users\\James\\Documents\\FiziksGramr.g:73:9: ( 'import' ID )
            dbg.enterAlt(1);

            // C:\\Users\\James\\Documents\\FiziksGramr.g:73:11: 'import' ID
            {
            dbg.location(73,11);
            match(input,16,FOLLOW_16_in_iimport607); 
            dbg.location(73,20);
            match(input,ID,FOLLOW_ID_in_iimport609); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(73, 22);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "iimport");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "iimport"


    // $ANTLR start "hippy"
    // C:\\Users\\James\\Documents\\FiziksGramr.g:75:1: hippy : 'hippy' expression ;
    public final void hippy() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "hippy");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(75, 1);

        try {
            // C:\\Users\\James\\Documents\\FiziksGramr.g:75:7: ( 'hippy' expression )
            dbg.enterAlt(1);

            // C:\\Users\\James\\Documents\\FiziksGramr.g:75:9: 'hippy' expression
            {
            dbg.location(75,9);
            match(input,17,FOLLOW_17_in_hippy617); 
            dbg.location(75,17);
            pushFollow(FOLLOW_expression_in_hippy619);
            expression();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(75, 27);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "hippy");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "hippy"


    // $ANTLR start "theymustalldie"
    // C:\\Users\\James\\Documents\\FiziksGramr.g:77:1: theymustalldie : 'all' 'the' 'hippies' 'must' 'die' ;
    public final void theymustalldie() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "theymustalldie");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(77, 1);

        try {
            // C:\\Users\\James\\Documents\\FiziksGramr.g:78:2: ( 'all' 'the' 'hippies' 'must' 'die' )
            dbg.enterAlt(1);

            // C:\\Users\\James\\Documents\\FiziksGramr.g:78:4: 'all' 'the' 'hippies' 'must' 'die'
            {
            dbg.location(78,4);
            match(input,18,FOLLOW_18_in_theymustalldie628); 
            dbg.location(78,10);
            match(input,19,FOLLOW_19_in_theymustalldie630); 
            dbg.location(78,16);
            match(input,20,FOLLOW_20_in_theymustalldie632); 
            dbg.location(78,26);
            match(input,21,FOLLOW_21_in_theymustalldie634); 
            dbg.location(78,33);
            match(input,22,FOLLOW_22_in_theymustalldie636); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(78, 38);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "theymustalldie");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "theymustalldie"


    // $ANTLR start "expression"
    // C:\\Users\\James\\Documents\\FiziksGramr.g:80:1: expression : val ( '+' val )* ;
    public final void expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(80, 1);

        try {
            // C:\\Users\\James\\Documents\\FiziksGramr.g:81:2: ( val ( '+' val )* )
            dbg.enterAlt(1);

            // C:\\Users\\James\\Documents\\FiziksGramr.g:81:4: val ( '+' val )*
            {
            dbg.location(81,4);
            pushFollow(FOLLOW_val_in_expression646);
            val();

            state._fsp--;

            dbg.location(81,8);
            // C:\\Users\\James\\Documents\\FiziksGramr.g:81:8: ( '+' val )*
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==23) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\James\\Documents\\FiziksGramr.g:81:9: '+' val
            	    {
            	    dbg.location(81,9);
            	    match(input,23,FOLLOW_23_in_expression649); 
            	    dbg.location(81,13);
            	    pushFollow(FOLLOW_val_in_expression651);
            	    val();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);
            } finally {dbg.exitSubRule(3);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(81, 18);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "expression"


    // $ANTLR start "val"
    // C:\\Users\\James\\Documents\\FiziksGramr.g:83:1: val : ( ID | INT | FLOAT | STRING | CHAR );
    public final void val() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "val");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(83, 1);

        try {
            // C:\\Users\\James\\Documents\\FiziksGramr.g:83:6: ( ID | INT | FLOAT | STRING | CHAR )
            dbg.enterAlt(1);

            // C:\\Users\\James\\Documents\\FiziksGramr.g:
            {
            dbg.location(83,6);
            if ( (input.LA(1)>=INT && input.LA(1)<=CHAR) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(83, 32);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "val");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "val"

    // Delegated rules


 

    public static final BitSet FOLLOW_statement_in_start584 = new BitSet(new long[]{0x0000000000070002L});
    public static final BitSet FOLLOW_iimport_in_statement594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hippy_in_statement596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_theymustalldie_in_statement598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_iimport607 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_iimport609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_hippy617 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_expression_in_hippy619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_theymustalldie628 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_theymustalldie630 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_theymustalldie632 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_theymustalldie634 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_theymustalldie636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_val_in_expression646 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_expression649 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_val_in_expression651 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_set_in_val0 = new BitSet(new long[]{0x0000000000000002L});

}