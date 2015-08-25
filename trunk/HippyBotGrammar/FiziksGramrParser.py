# $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\Users\\James\\Documents\\FiziksGramr.g 2010-01-23 21:47:36

import sys
from antlr3 import *
from antlr3.compat import set, frozenset
from antlr3.debug import *


# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EXPONENT=9
T__25=25
T__24=24
T__23=23
T__22=22
T__21=21
UNICODE_ESC=14
T__20=20
OCTAL_ESC=15
CHAR=8
HEX_DIGIT=13
INT=5
FLOAT=6
ID=4
EOF=-1
T__19=19
ESC_SEQ=12
WS=11
T__16=16
T__18=18
T__17=17
COMMENT=10
STRING=7

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>", 
    "ID", "INT", "FLOAT", "STRING", "CHAR", "EXPONENT", "COMMENT", "WS", 
    "ESC_SEQ", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC", "'#'", "']'", "'import'", 
    "'hippy'", "'all'", "'the'", "'hippies'", "'must'", "'die'", "'-'"
]




class FiziksGramrParser(DebugParser):
    grammarFileName = "C:\\Users\\James\\Documents\\FiziksGramr.g"
    antlr_version = version_str_to_tuple("3.2 Sep 23, 2009 12:02:23")
    antlr_version_str = "3.2 Sep 23, 2009 12:02:23"
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        debug_socket = kwargs.pop('debug_socket', None)
        port = kwargs.pop('port', None)
        super(FiziksGramrParser, self).__init__(input, state, *args, **kwargs)

        self._state.ruleMemo = {}





        self.ruleLevel = 0

        if self._dbg is None:
            proxy = DebugEventSocketProxy(self, debug=debug_socket, port=port)
            self.setDebugListener(proxy)
            proxy.handshake()




    ruleNames = [
        "invalidRule", "synpred6_FiziksGramr", "val", "statement", "expression", 
        "iimport", "synpred3_FiziksGramr", "synpred4_FiziksGramr", "hippy", 
        "theymustalldie", "start", "synpred5_FiziksGramr", "synpred8_FiziksGramr", 
        "synpred1_FiziksGramr", "synpred7_FiziksGramr", "synpred2_FiziksGramr"
        ]
     
    def getRuleLevel(self):
        return self.ruleLevel

    def incRuleLevel(self):
        self.ruleLevel += 1

    def decRuleLevel(self):
        self.ruleLevel -= 1

    def evalPredicate(self, result, predicate):
        self._dbg.semanticPredicate(result, predicate)
        return result





    # $ANTLR start "start"
    # C:\\Users\\James\\Documents\\FiziksGramr.g:74:1: start : ( statement '#' ']' )* ;
    def start(self, ):

        start_StartIndex = self.input.index()
        try:
            self._dbg.enterRule(self.getGrammarFileName(), "start")
            if self.getRuleLevel() == 0:
                self._dbg.commence();
            self.incRuleLevel()
            self._dbg.location(74, 1)

            success = False
            try:
                try:
                    if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 1):
                        # for cached failed rules, alreadyParsedRule will raise an exception
                        success = True
                        return 

                    # C:\\Users\\James\\Documents\\FiziksGramr.g:74:7: ( ( statement '#' ']' )* )
                    self._dbg.enterAlt(1)

                    # C:\\Users\\James\\Documents\\FiziksGramr.g:74:9: ( statement '#' ']' )*
                    pass 
                    self._dbg.location(74, 9)
                    # C:\\Users\\James\\Documents\\FiziksGramr.g:74:9: ( statement '#' ']' )*
                    try:
                        self._dbg.enterSubRule(1)
                        while True: #loop1
                            alt1 = 2
                            try:
                                self._dbg.enterDecision(1)
                                LA1_0 = self.input.LA(1)

                                if ((18 <= LA1_0 <= 20)) :
                                    alt1 = 1


                            finally:
                                self._dbg.exitDecision(1)
                            if alt1 == 1:
                                self._dbg.enterAlt(1)

                                # C:\\Users\\James\\Documents\\FiziksGramr.g:74:10: statement '#' ']'
                                pass 
                                self._dbg.location(74, 10)
                                self._state.following.append(self.FOLLOW_statement_in_start625)
                                self.statement()

                                self._state.following.pop()
                                self._dbg.location(74, 20)
                                self.match(self.input, 16, self.FOLLOW_16_in_start627)
                                self._dbg.location(74, 24)
                                self.match(self.input, 17, self.FOLLOW_17_in_start629)


                            else:
                                break #loop1
                    finally:
                        self._dbg.exitSubRule(1)





                    success = True
                except RecognitionException, re:
                    self.reportError(re)
                    self.recover(self.input, re)
            finally:
                if self._state.backtracking > 0:
                    self.memoize(self.input, 1, start_StartIndex, success)

                pass

            self._dbg.location(74, 29)
        finally:
            self._dbg.exitRule(self.getGrammarFileName(), "start")
            self.decRuleLevel()
            if self.getRuleLevel() == 0:
                 self._dbg.terminate()

        return 

    # $ANTLR end "start"


    # $ANTLR start "statement"
    # C:\\Users\\James\\Documents\\FiziksGramr.g:76:1: statement : ( iimport | hippy | theymustalldie );
    def statement(self, ):

        statement_StartIndex = self.input.index()
        try:
            self._dbg.enterRule(self.getGrammarFileName(), "statement")
            if self.getRuleLevel() == 0:
                self._dbg.commence();
            self.incRuleLevel()
            self._dbg.location(76, 1)

            success = False
            try:
                try:
                    if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 2):
                        # for cached failed rules, alreadyParsedRule will raise an exception
                        success = True
                        return 

                    # C:\\Users\\James\\Documents\\FiziksGramr.g:77:2: ( iimport | hippy | theymustalldie )
                    alt2 = 3
                    try:
                        self._dbg.enterDecision(2)
                        LA2 = self.input.LA(1)
                        if LA2 == 18:
                            alt2 = 1
                        elif LA2 == 19:
                            alt2 = 2
                        elif LA2 == 20:
                            alt2 = 3
                        else:
                            if self._state.backtracking > 0:
                                raise BacktrackingFailed

                            nvae = NoViableAltException("", 2, 0, self.input)

                            self._dbg.recognitionException(nvae)
                            raise nvae

                    finally:
                        self._dbg.exitDecision(2)
                    if alt2 == 1:
                        self._dbg.enterAlt(1)

                        # C:\\Users\\James\\Documents\\FiziksGramr.g:77:4: iimport
                        pass 
                        self._dbg.location(77, 4)
                        self._state.following.append(self.FOLLOW_iimport_in_statement640)
                        self.iimport()

                        self._state.following.pop()


                    elif alt2 == 2:
                        self._dbg.enterAlt(2)

                        # C:\\Users\\James\\Documents\\FiziksGramr.g:77:12: hippy
                        pass 
                        self._dbg.location(77, 12)
                        self._state.following.append(self.FOLLOW_hippy_in_statement642)
                        self.hippy()

                        self._state.following.pop()


                    elif alt2 == 3:
                        self._dbg.enterAlt(3)

                        # C:\\Users\\James\\Documents\\FiziksGramr.g:77:18: theymustalldie
                        pass 
                        self._dbg.location(77, 18)
                        self._state.following.append(self.FOLLOW_theymustalldie_in_statement644)
                        self.theymustalldie()

                        self._state.following.pop()



                    success = True
                except RecognitionException, re:
                    self.reportError(re)
                    self.recover(self.input, re)
            finally:
                if self._state.backtracking > 0:
                    self.memoize(self.input, 2, statement_StartIndex, success)

                pass

            self._dbg.location(77, 32)
        finally:
            self._dbg.exitRule(self.getGrammarFileName(), "statement")
            self.decRuleLevel()
            if self.getRuleLevel() == 0:
                 self._dbg.terminate()

        return 

    # $ANTLR end "statement"


    # $ANTLR start "iimport"
    # C:\\Users\\James\\Documents\\FiziksGramr.g:79:1: iimport : 'import' val ;
    def iimport(self, ):

        iimport_StartIndex = self.input.index()
        try:
            self._dbg.enterRule(self.getGrammarFileName(), "iimport")
            if self.getRuleLevel() == 0:
                self._dbg.commence();
            self.incRuleLevel()
            self._dbg.location(79, 1)

            success = False
            try:
                try:
                    if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 3):
                        # for cached failed rules, alreadyParsedRule will raise an exception
                        success = True
                        return 

                    # C:\\Users\\James\\Documents\\FiziksGramr.g:79:9: ( 'import' val )
                    self._dbg.enterAlt(1)

                    # C:\\Users\\James\\Documents\\FiziksGramr.g:79:11: 'import' val
                    pass 
                    self._dbg.location(79, 11)
                    self.match(self.input, 18, self.FOLLOW_18_in_iimport653)
                    self._dbg.location(79, 20)
                    self._state.following.append(self.FOLLOW_val_in_iimport655)
                    self.val()

                    self._state.following.pop()




                    success = True
                except RecognitionException, re:
                    self.reportError(re)
                    self.recover(self.input, re)
            finally:
                if self._state.backtracking > 0:
                    self.memoize(self.input, 3, iimport_StartIndex, success)

                pass

            self._dbg.location(79, 23)
        finally:
            self._dbg.exitRule(self.getGrammarFileName(), "iimport")
            self.decRuleLevel()
            if self.getRuleLevel() == 0:
                 self._dbg.terminate()

        return 

    # $ANTLR end "iimport"


    # $ANTLR start "hippy"
    # C:\\Users\\James\\Documents\\FiziksGramr.g:81:1: hippy : 'hippy' expression ;
    def hippy(self, ):

        hippy_StartIndex = self.input.index()
        try:
            self._dbg.enterRule(self.getGrammarFileName(), "hippy")
            if self.getRuleLevel() == 0:
                self._dbg.commence();
            self.incRuleLevel()
            self._dbg.location(81, 1)

            success = False
            try:
                try:
                    if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 4):
                        # for cached failed rules, alreadyParsedRule will raise an exception
                        success = True
                        return 

                    # C:\\Users\\James\\Documents\\FiziksGramr.g:81:7: ( 'hippy' expression )
                    self._dbg.enterAlt(1)

                    # C:\\Users\\James\\Documents\\FiziksGramr.g:81:9: 'hippy' expression
                    pass 
                    self._dbg.location(81, 9)
                    self.match(self.input, 19, self.FOLLOW_19_in_hippy663)
                    self._dbg.location(81, 17)
                    self._state.following.append(self.FOLLOW_expression_in_hippy665)
                    self.expression()

                    self._state.following.pop()




                    success = True
                except RecognitionException, re:
                    self.reportError(re)
                    self.recover(self.input, re)
            finally:
                if self._state.backtracking > 0:
                    self.memoize(self.input, 4, hippy_StartIndex, success)

                pass

            self._dbg.location(81, 27)
        finally:
            self._dbg.exitRule(self.getGrammarFileName(), "hippy")
            self.decRuleLevel()
            if self.getRuleLevel() == 0:
                 self._dbg.terminate()

        return 

    # $ANTLR end "hippy"


    # $ANTLR start "theymustalldie"
    # C:\\Users\\James\\Documents\\FiziksGramr.g:83:1: theymustalldie : 'all' 'the' 'hippies' 'must' 'die' ;
    def theymustalldie(self, ):

        theymustalldie_StartIndex = self.input.index()
        try:
            self._dbg.enterRule(self.getGrammarFileName(), "theymustalldie")
            if self.getRuleLevel() == 0:
                self._dbg.commence();
            self.incRuleLevel()
            self._dbg.location(83, 1)

            success = False
            try:
                try:
                    if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 5):
                        # for cached failed rules, alreadyParsedRule will raise an exception
                        success = True
                        return 

                    # C:\\Users\\James\\Documents\\FiziksGramr.g:84:2: ( 'all' 'the' 'hippies' 'must' 'die' )
                    self._dbg.enterAlt(1)

                    # C:\\Users\\James\\Documents\\FiziksGramr.g:84:4: 'all' 'the' 'hippies' 'must' 'die'
                    pass 
                    self._dbg.location(84, 4)
                    self.match(self.input, 20, self.FOLLOW_20_in_theymustalldie674)
                    self._dbg.location(84, 10)
                    self.match(self.input, 21, self.FOLLOW_21_in_theymustalldie676)
                    self._dbg.location(84, 16)
                    self.match(self.input, 22, self.FOLLOW_22_in_theymustalldie678)
                    self._dbg.location(84, 26)
                    self.match(self.input, 23, self.FOLLOW_23_in_theymustalldie680)
                    self._dbg.location(84, 33)
                    self.match(self.input, 24, self.FOLLOW_24_in_theymustalldie682)




                    success = True
                except RecognitionException, re:
                    self.reportError(re)
                    self.recover(self.input, re)
            finally:
                if self._state.backtracking > 0:
                    self.memoize(self.input, 5, theymustalldie_StartIndex, success)

                pass

            self._dbg.location(84, 38)
        finally:
            self._dbg.exitRule(self.getGrammarFileName(), "theymustalldie")
            self.decRuleLevel()
            if self.getRuleLevel() == 0:
                 self._dbg.terminate()

        return 

    # $ANTLR end "theymustalldie"


    # $ANTLR start "expression"
    # C:\\Users\\James\\Documents\\FiziksGramr.g:86:1: expression : val ( '-' val )* ;
    def expression(self, ):

        expression_StartIndex = self.input.index()
        try:
            self._dbg.enterRule(self.getGrammarFileName(), "expression")
            if self.getRuleLevel() == 0:
                self._dbg.commence();
            self.incRuleLevel()
            self._dbg.location(86, 1)

            success = False
            try:
                try:
                    if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 6):
                        # for cached failed rules, alreadyParsedRule will raise an exception
                        success = True
                        return 

                    # C:\\Users\\James\\Documents\\FiziksGramr.g:87:2: ( val ( '-' val )* )
                    self._dbg.enterAlt(1)

                    # C:\\Users\\James\\Documents\\FiziksGramr.g:87:4: val ( '-' val )*
                    pass 
                    self._dbg.location(87, 4)
                    self._state.following.append(self.FOLLOW_val_in_expression692)
                    self.val()

                    self._state.following.pop()
                    self._dbg.location(87, 8)
                    # C:\\Users\\James\\Documents\\FiziksGramr.g:87:8: ( '-' val )*
                    try:
                        self._dbg.enterSubRule(3)
                        while True: #loop3
                            alt3 = 2
                            try:
                                self._dbg.enterDecision(3)
                                LA3_0 = self.input.LA(1)

                                if (LA3_0 == 25) :
                                    alt3 = 1


                            finally:
                                self._dbg.exitDecision(3)
                            if alt3 == 1:
                                self._dbg.enterAlt(1)

                                # C:\\Users\\James\\Documents\\FiziksGramr.g:87:9: '-' val
                                pass 
                                self._dbg.location(87, 9)
                                self.match(self.input, 25, self.FOLLOW_25_in_expression695)
                                self._dbg.location(87, 13)
                                self._state.following.append(self.FOLLOW_val_in_expression697)
                                self.val()

                                self._state.following.pop()


                            else:
                                break #loop3
                    finally:
                        self._dbg.exitSubRule(3)





                    success = True
                except RecognitionException, re:
                    self.reportError(re)
                    self.recover(self.input, re)
            finally:
                if self._state.backtracking > 0:
                    self.memoize(self.input, 6, expression_StartIndex, success)

                pass

            self._dbg.location(87, 18)
        finally:
            self._dbg.exitRule(self.getGrammarFileName(), "expression")
            self.decRuleLevel()
            if self.getRuleLevel() == 0:
                 self._dbg.terminate()

        return 

    # $ANTLR end "expression"


    # $ANTLR start "val"
    # C:\\Users\\James\\Documents\\FiziksGramr.g:89:1: val : ( ID | INT | FLOAT | STRING | CHAR );
    def val(self, ):

        val_StartIndex = self.input.index()
        try:
            self._dbg.enterRule(self.getGrammarFileName(), "val")
            if self.getRuleLevel() == 0:
                self._dbg.commence();
            self.incRuleLevel()
            self._dbg.location(89, 1)

            success = False
            try:
                try:
                    if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 7):
                        # for cached failed rules, alreadyParsedRule will raise an exception
                        success = True
                        return 

                    # C:\\Users\\James\\Documents\\FiziksGramr.g:89:6: ( ID | INT | FLOAT | STRING | CHAR )
                    self._dbg.enterAlt(1)

                    # C:\\Users\\James\\Documents\\FiziksGramr.g:
                    pass 
                    self._dbg.location(89, 6)
                    if (ID <= self.input.LA(1) <= CHAR):
                        self.input.consume()
                        self._state.errorRecovery = False

                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed

                        mse = MismatchedSetException(None, self.input)
                        self._dbg.recognitionException(mse)
                        raise mse






                    success = True
                except RecognitionException, re:
                    self.reportError(re)
                    self.recover(self.input, re)
            finally:
                if self._state.backtracking > 0:
                    self.memoize(self.input, 7, val_StartIndex, success)

                pass

            self._dbg.location(89, 32)
        finally:
            self._dbg.exitRule(self.getGrammarFileName(), "val")
            self.decRuleLevel()
            if self.getRuleLevel() == 0:
                 self._dbg.terminate()

        return 

    # $ANTLR end "val"


    # Delegated rules


 

    FOLLOW_statement_in_start625 = frozenset([16])
    FOLLOW_16_in_start627 = frozenset([17])
    FOLLOW_17_in_start629 = frozenset([1, 18, 19, 20])
    FOLLOW_iimport_in_statement640 = frozenset([1])
    FOLLOW_hippy_in_statement642 = frozenset([1])
    FOLLOW_theymustalldie_in_statement644 = frozenset([1])
    FOLLOW_18_in_iimport653 = frozenset([4, 5, 6, 7, 8])
    FOLLOW_val_in_iimport655 = frozenset([1])
    FOLLOW_19_in_hippy663 = frozenset([4, 5, 6, 7, 8])
    FOLLOW_expression_in_hippy665 = frozenset([1])
    FOLLOW_20_in_theymustalldie674 = frozenset([21])
    FOLLOW_21_in_theymustalldie676 = frozenset([22])
    FOLLOW_22_in_theymustalldie678 = frozenset([23])
    FOLLOW_23_in_theymustalldie680 = frozenset([24])
    FOLLOW_24_in_theymustalldie682 = frozenset([1])
    FOLLOW_val_in_expression692 = frozenset([1, 25])
    FOLLOW_25_in_expression695 = frozenset([4, 5, 6, 7, 8])
    FOLLOW_val_in_expression697 = frozenset([1, 25])
    FOLLOW_set_in_val0 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("FiziksGramrLexer", FiziksGramrParser)
    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)


if __name__ == '__main__':
    main(sys.argv)
