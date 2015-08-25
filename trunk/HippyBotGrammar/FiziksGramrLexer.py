# $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\Users\\James\\Documents\\FiziksGramr.g 2010-01-23 21:47:36

import sys
from antlr3 import *
from antlr3.compat import set, frozenset


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
T__16=16
WS=11
ESC_SEQ=12
T__18=18
T__17=17
COMMENT=10
STRING=7


class FiziksGramrLexer(Lexer):

    grammarFileName = "C:\\Users\\James\\Documents\\FiziksGramr.g"
    antlr_version = version_str_to_tuple("3.2 Sep 23, 2009 12:02:23")
    antlr_version_str = "3.2 Sep 23, 2009 12:02:23"

    def __init__(self, input=None, state=None):
        if state is None:
            state = RecognizerSharedState()
        super(FiziksGramrLexer, self).__init__(input, state)


        self.dfa9 = self.DFA9(
            self, 9,
            eot = self.DFA9_eot,
            eof = self.DFA9_eof,
            min = self.DFA9_min,
            max = self.DFA9_max,
            accept = self.DFA9_accept,
            special = self.DFA9_special,
            transition = self.DFA9_transition
            )

        self.dfa20 = self.DFA20(
            self, 20,
            eot = self.DFA20_eot,
            eof = self.DFA20_eof,
            min = self.DFA20_min,
            max = self.DFA20_max,
            accept = self.DFA20_accept,
            special = self.DFA20_special,
            transition = self.DFA20_transition
            )






    # $ANTLR start "T__16"
    def mT__16(self, ):

        try:
            _type = T__16
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:7:7: ( '#' )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:7:9: '#'
            pass 
            self.match(35)



            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "T__16"



    # $ANTLR start "T__17"
    def mT__17(self, ):

        try:
            _type = T__17
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:8:7: ( ']' )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:8:9: ']'
            pass 
            self.match(93)



            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "T__17"



    # $ANTLR start "T__18"
    def mT__18(self, ):

        try:
            _type = T__18
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:9:7: ( 'import' )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:9:9: 'import'
            pass 
            self.match("import")



            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "T__18"



    # $ANTLR start "T__19"
    def mT__19(self, ):

        try:
            _type = T__19
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:10:7: ( 'hippy' )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:10:9: 'hippy'
            pass 
            self.match("hippy")



            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "T__19"



    # $ANTLR start "T__20"
    def mT__20(self, ):

        try:
            _type = T__20
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:11:7: ( 'all' )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:11:9: 'all'
            pass 
            self.match("all")



            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "T__20"



    # $ANTLR start "T__21"
    def mT__21(self, ):

        try:
            _type = T__21
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:12:7: ( 'the' )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:12:9: 'the'
            pass 
            self.match("the")



            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "T__21"



    # $ANTLR start "T__22"
    def mT__22(self, ):

        try:
            _type = T__22
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:13:7: ( 'hippies' )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:13:9: 'hippies'
            pass 
            self.match("hippies")



            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "T__22"



    # $ANTLR start "T__23"
    def mT__23(self, ):

        try:
            _type = T__23
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:14:7: ( 'must' )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:14:9: 'must'
            pass 
            self.match("must")



            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "T__23"



    # $ANTLR start "T__24"
    def mT__24(self, ):

        try:
            _type = T__24
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:15:7: ( 'die' )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:15:9: 'die'
            pass 
            self.match("die")



            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "T__24"



    # $ANTLR start "T__25"
    def mT__25(self, ):

        try:
            _type = T__25
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:16:7: ( '-' )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:16:9: '-'
            pass 
            self.match(45)



            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "T__25"



    # $ANTLR start "ID"
    def mID(self, ):

        try:
            _type = ID
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:17:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:17:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            pass 
            if (65 <= self.input.LA(1) <= 90) or self.input.LA(1) == 95 or (97 <= self.input.LA(1) <= 122):
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse

            # C:\\Users\\James\\Documents\\FiziksGramr.g:17:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            while True: #loop1
                alt1 = 2
                LA1_0 = self.input.LA(1)

                if ((48 <= LA1_0 <= 57) or (65 <= LA1_0 <= 90) or LA1_0 == 95 or (97 <= LA1_0 <= 122)) :
                    alt1 = 1


                if alt1 == 1:
                    # C:\\Users\\James\\Documents\\FiziksGramr.g:
                    pass 
                    if (48 <= self.input.LA(1) <= 57) or (65 <= self.input.LA(1) <= 90) or self.input.LA(1) == 95 or (97 <= self.input.LA(1) <= 122):
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse



                else:
                    break #loop1



            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "ID"



    # $ANTLR start "INT"
    def mINT(self, ):

        try:
            _type = INT
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:20:5: ( ( '0' .. '9' )+ )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:20:7: ( '0' .. '9' )+
            pass 
            # C:\\Users\\James\\Documents\\FiziksGramr.g:20:7: ( '0' .. '9' )+
            cnt2 = 0
            while True: #loop2
                alt2 = 2
                LA2_0 = self.input.LA(1)

                if ((48 <= LA2_0 <= 57)) :
                    alt2 = 1


                if alt2 == 1:
                    # C:\\Users\\James\\Documents\\FiziksGramr.g:20:7: '0' .. '9'
                    pass 
                    self.matchRange(48, 57)


                else:
                    if cnt2 >= 1:
                        break #loop2

                    eee = EarlyExitException(2, self.input)
                    raise eee

                cnt2 += 1



            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "INT"



    # $ANTLR start "FLOAT"
    def mFLOAT(self, ):

        try:
            _type = FLOAT
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:24:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
            alt9 = 3
            alt9 = self.dfa9.predict(self.input)
            if alt9 == 1:
                # C:\\Users\\James\\Documents\\FiziksGramr.g:24:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
                pass 
                # C:\\Users\\James\\Documents\\FiziksGramr.g:24:9: ( '0' .. '9' )+
                cnt3 = 0
                while True: #loop3
                    alt3 = 2
                    LA3_0 = self.input.LA(1)

                    if ((48 <= LA3_0 <= 57)) :
                        alt3 = 1


                    if alt3 == 1:
                        # C:\\Users\\James\\Documents\\FiziksGramr.g:24:10: '0' .. '9'
                        pass 
                        self.matchRange(48, 57)


                    else:
                        if cnt3 >= 1:
                            break #loop3

                        eee = EarlyExitException(3, self.input)
                        raise eee

                    cnt3 += 1
                self.match(46)
                # C:\\Users\\James\\Documents\\FiziksGramr.g:24:25: ( '0' .. '9' )*
                while True: #loop4
                    alt4 = 2
                    LA4_0 = self.input.LA(1)

                    if ((48 <= LA4_0 <= 57)) :
                        alt4 = 1


                    if alt4 == 1:
                        # C:\\Users\\James\\Documents\\FiziksGramr.g:24:26: '0' .. '9'
                        pass 
                        self.matchRange(48, 57)


                    else:
                        break #loop4
                # C:\\Users\\James\\Documents\\FiziksGramr.g:24:37: ( EXPONENT )?
                alt5 = 2
                LA5_0 = self.input.LA(1)

                if (LA5_0 == 69 or LA5_0 == 101) :
                    alt5 = 1
                if alt5 == 1:
                    # C:\\Users\\James\\Documents\\FiziksGramr.g:24:37: EXPONENT
                    pass 
                    self.mEXPONENT()





            elif alt9 == 2:
                # C:\\Users\\James\\Documents\\FiziksGramr.g:25:9: '.' ( '0' .. '9' )+ ( EXPONENT )?
                pass 
                self.match(46)
                # C:\\Users\\James\\Documents\\FiziksGramr.g:25:13: ( '0' .. '9' )+
                cnt6 = 0
                while True: #loop6
                    alt6 = 2
                    LA6_0 = self.input.LA(1)

                    if ((48 <= LA6_0 <= 57)) :
                        alt6 = 1


                    if alt6 == 1:
                        # C:\\Users\\James\\Documents\\FiziksGramr.g:25:14: '0' .. '9'
                        pass 
                        self.matchRange(48, 57)


                    else:
                        if cnt6 >= 1:
                            break #loop6

                        eee = EarlyExitException(6, self.input)
                        raise eee

                    cnt6 += 1
                # C:\\Users\\James\\Documents\\FiziksGramr.g:25:25: ( EXPONENT )?
                alt7 = 2
                LA7_0 = self.input.LA(1)

                if (LA7_0 == 69 or LA7_0 == 101) :
                    alt7 = 1
                if alt7 == 1:
                    # C:\\Users\\James\\Documents\\FiziksGramr.g:25:25: EXPONENT
                    pass 
                    self.mEXPONENT()





            elif alt9 == 3:
                # C:\\Users\\James\\Documents\\FiziksGramr.g:26:9: ( '0' .. '9' )+ EXPONENT
                pass 
                # C:\\Users\\James\\Documents\\FiziksGramr.g:26:9: ( '0' .. '9' )+
                cnt8 = 0
                while True: #loop8
                    alt8 = 2
                    LA8_0 = self.input.LA(1)

                    if ((48 <= LA8_0 <= 57)) :
                        alt8 = 1


                    if alt8 == 1:
                        # C:\\Users\\James\\Documents\\FiziksGramr.g:26:10: '0' .. '9'
                        pass 
                        self.matchRange(48, 57)


                    else:
                        if cnt8 >= 1:
                            break #loop8

                        eee = EarlyExitException(8, self.input)
                        raise eee

                    cnt8 += 1
                self.mEXPONENT()


            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "FLOAT"



    # $ANTLR start "COMMENT"
    def mCOMMENT(self, ):

        try:
            _type = COMMENT
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:30:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            alt13 = 2
            LA13_0 = self.input.LA(1)

            if (LA13_0 == 47) :
                LA13_1 = self.input.LA(2)

                if (LA13_1 == 47) :
                    alt13 = 1
                elif (LA13_1 == 42) :
                    alt13 = 2
                else:
                    nvae = NoViableAltException("", 13, 1, self.input)

                    raise nvae

            else:
                nvae = NoViableAltException("", 13, 0, self.input)

                raise nvae

            if alt13 == 1:
                # C:\\Users\\James\\Documents\\FiziksGramr.g:30:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                pass 
                self.match("//")
                # C:\\Users\\James\\Documents\\FiziksGramr.g:30:14: (~ ( '\\n' | '\\r' ) )*
                while True: #loop10
                    alt10 = 2
                    LA10_0 = self.input.LA(1)

                    if ((0 <= LA10_0 <= 9) or (11 <= LA10_0 <= 12) or (14 <= LA10_0 <= 65535)) :
                        alt10 = 1


                    if alt10 == 1:
                        # C:\\Users\\James\\Documents\\FiziksGramr.g:30:14: ~ ( '\\n' | '\\r' )
                        pass 
                        if (0 <= self.input.LA(1) <= 9) or (11 <= self.input.LA(1) <= 12) or (14 <= self.input.LA(1) <= 65535):
                            self.input.consume()
                        else:
                            mse = MismatchedSetException(None, self.input)
                            self.recover(mse)
                            raise mse



                    else:
                        break #loop10
                # C:\\Users\\James\\Documents\\FiziksGramr.g:30:28: ( '\\r' )?
                alt11 = 2
                LA11_0 = self.input.LA(1)

                if (LA11_0 == 13) :
                    alt11 = 1
                if alt11 == 1:
                    # C:\\Users\\James\\Documents\\FiziksGramr.g:30:28: '\\r'
                    pass 
                    self.match(13)



                self.match(10)
                #action start
                _channel=HIDDEN;
                #action end


            elif alt13 == 2:
                # C:\\Users\\James\\Documents\\FiziksGramr.g:31:9: '/*' ( options {greedy=false; } : . )* '*/'
                pass 
                self.match("/*")
                # C:\\Users\\James\\Documents\\FiziksGramr.g:31:14: ( options {greedy=false; } : . )*
                while True: #loop12
                    alt12 = 2
                    LA12_0 = self.input.LA(1)

                    if (LA12_0 == 42) :
                        LA12_1 = self.input.LA(2)

                        if (LA12_1 == 47) :
                            alt12 = 2
                        elif ((0 <= LA12_1 <= 46) or (48 <= LA12_1 <= 65535)) :
                            alt12 = 1


                    elif ((0 <= LA12_0 <= 41) or (43 <= LA12_0 <= 65535)) :
                        alt12 = 1


                    if alt12 == 1:
                        # C:\\Users\\James\\Documents\\FiziksGramr.g:31:42: .
                        pass 
                        self.matchAny()


                    else:
                        break #loop12
                self.match("*/")
                #action start
                _channel=HIDDEN;
                #action end


            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "COMMENT"



    # $ANTLR start "WS"
    def mWS(self, ):

        try:
            _type = WS
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:34:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:34:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            pass 
            if (9 <= self.input.LA(1) <= 10) or self.input.LA(1) == 13 or self.input.LA(1) == 32:
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse

            #action start
            _channel=HIDDEN;
            #action end



            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "WS"



    # $ANTLR start "STRING"
    def mSTRING(self, ):

        try:
            _type = STRING
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:42:5: ( '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"' )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:42:8: '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"'
            pass 
            self.match(34)
            # C:\\Users\\James\\Documents\\FiziksGramr.g:42:12: ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )*
            while True: #loop14
                alt14 = 3
                LA14_0 = self.input.LA(1)

                if (LA14_0 == 92) :
                    alt14 = 1
                elif ((0 <= LA14_0 <= 33) or (35 <= LA14_0 <= 91) or (93 <= LA14_0 <= 65535)) :
                    alt14 = 2


                if alt14 == 1:
                    # C:\\Users\\James\\Documents\\FiziksGramr.g:42:14: ESC_SEQ
                    pass 
                    self.mESC_SEQ()


                elif alt14 == 2:
                    # C:\\Users\\James\\Documents\\FiziksGramr.g:42:24: ~ ( '\\\\' | '\"' )
                    pass 
                    if (0 <= self.input.LA(1) <= 33) or (35 <= self.input.LA(1) <= 91) or (93 <= self.input.LA(1) <= 65535):
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse



                else:
                    break #loop14
            self.match(34)



            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "STRING"



    # $ANTLR start "CHAR"
    def mCHAR(self, ):

        try:
            _type = CHAR
            _channel = DEFAULT_CHANNEL

            # C:\\Users\\James\\Documents\\FiziksGramr.g:45:5: ( '\\'' ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:45:8: '\\'' ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) ) '\\''
            pass 
            self.match(39)
            # C:\\Users\\James\\Documents\\FiziksGramr.g:45:13: ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) )
            alt15 = 2
            LA15_0 = self.input.LA(1)

            if (LA15_0 == 92) :
                alt15 = 1
            elif ((0 <= LA15_0 <= 38) or (40 <= LA15_0 <= 91) or (93 <= LA15_0 <= 65535)) :
                alt15 = 2
            else:
                nvae = NoViableAltException("", 15, 0, self.input)

                raise nvae

            if alt15 == 1:
                # C:\\Users\\James\\Documents\\FiziksGramr.g:45:15: ESC_SEQ
                pass 
                self.mESC_SEQ()


            elif alt15 == 2:
                # C:\\Users\\James\\Documents\\FiziksGramr.g:45:25: ~ ( '\\'' | '\\\\' )
                pass 
                if (0 <= self.input.LA(1) <= 38) or (40 <= self.input.LA(1) <= 91) or (93 <= self.input.LA(1) <= 65535):
                    self.input.consume()
                else:
                    mse = MismatchedSetException(None, self.input)
                    self.recover(mse)
                    raise mse




            self.match(39)



            self._state.type = _type
            self._state.channel = _channel

        finally:

            pass

    # $ANTLR end "CHAR"



    # $ANTLR start "EXPONENT"
    def mEXPONENT(self, ):

        try:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:49:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:49:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            pass 
            if self.input.LA(1) == 69 or self.input.LA(1) == 101:
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse

            # C:\\Users\\James\\Documents\\FiziksGramr.g:49:22: ( '+' | '-' )?
            alt16 = 2
            LA16_0 = self.input.LA(1)

            if (LA16_0 == 43 or LA16_0 == 45) :
                alt16 = 1
            if alt16 == 1:
                # C:\\Users\\James\\Documents\\FiziksGramr.g:
                pass 
                if self.input.LA(1) == 43 or self.input.LA(1) == 45:
                    self.input.consume()
                else:
                    mse = MismatchedSetException(None, self.input)
                    self.recover(mse)
                    raise mse




            # C:\\Users\\James\\Documents\\FiziksGramr.g:49:33: ( '0' .. '9' )+
            cnt17 = 0
            while True: #loop17
                alt17 = 2
                LA17_0 = self.input.LA(1)

                if ((48 <= LA17_0 <= 57)) :
                    alt17 = 1


                if alt17 == 1:
                    # C:\\Users\\James\\Documents\\FiziksGramr.g:49:34: '0' .. '9'
                    pass 
                    self.matchRange(48, 57)


                else:
                    if cnt17 >= 1:
                        break #loop17

                    eee = EarlyExitException(17, self.input)
                    raise eee

                cnt17 += 1




        finally:

            pass

    # $ANTLR end "EXPONENT"



    # $ANTLR start "HEX_DIGIT"
    def mHEX_DIGIT(self, ):

        try:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:52:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:52:13: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            pass 
            if (48 <= self.input.LA(1) <= 57) or (65 <= self.input.LA(1) <= 70) or (97 <= self.input.LA(1) <= 102):
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse





        finally:

            pass

    # $ANTLR end "HEX_DIGIT"



    # $ANTLR start "ESC_SEQ"
    def mESC_SEQ(self, ):

        try:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:56:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            alt18 = 3
            LA18_0 = self.input.LA(1)

            if (LA18_0 == 92) :
                LA18 = self.input.LA(2)
                if LA18 == 34 or LA18 == 39 or LA18 == 92 or LA18 == 98 or LA18 == 102 or LA18 == 110 or LA18 == 114 or LA18 == 116:
                    alt18 = 1
                elif LA18 == 117:
                    alt18 = 2
                elif LA18 == 48 or LA18 == 49 or LA18 == 50 or LA18 == 51 or LA18 == 52 or LA18 == 53 or LA18 == 54 or LA18 == 55:
                    alt18 = 3
                else:
                    nvae = NoViableAltException("", 18, 1, self.input)

                    raise nvae

            else:
                nvae = NoViableAltException("", 18, 0, self.input)

                raise nvae

            if alt18 == 1:
                # C:\\Users\\James\\Documents\\FiziksGramr.g:56:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                pass 
                self.match(92)
                if self.input.LA(1) == 34 or self.input.LA(1) == 39 or self.input.LA(1) == 92 or self.input.LA(1) == 98 or self.input.LA(1) == 102 or self.input.LA(1) == 110 or self.input.LA(1) == 114 or self.input.LA(1) == 116:
                    self.input.consume()
                else:
                    mse = MismatchedSetException(None, self.input)
                    self.recover(mse)
                    raise mse



            elif alt18 == 2:
                # C:\\Users\\James\\Documents\\FiziksGramr.g:57:9: UNICODE_ESC
                pass 
                self.mUNICODE_ESC()


            elif alt18 == 3:
                # C:\\Users\\James\\Documents\\FiziksGramr.g:58:9: OCTAL_ESC
                pass 
                self.mOCTAL_ESC()



        finally:

            pass

    # $ANTLR end "ESC_SEQ"



    # $ANTLR start "OCTAL_ESC"
    def mOCTAL_ESC(self, ):

        try:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:63:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            alt19 = 3
            LA19_0 = self.input.LA(1)

            if (LA19_0 == 92) :
                LA19_1 = self.input.LA(2)

                if ((48 <= LA19_1 <= 51)) :
                    LA19_2 = self.input.LA(3)

                    if ((48 <= LA19_2 <= 55)) :
                        LA19_4 = self.input.LA(4)

                        if ((48 <= LA19_4 <= 55)) :
                            alt19 = 1
                        else:
                            alt19 = 2
                    else:
                        alt19 = 3
                elif ((52 <= LA19_1 <= 55)) :
                    LA19_3 = self.input.LA(3)

                    if ((48 <= LA19_3 <= 55)) :
                        alt19 = 2
                    else:
                        alt19 = 3
                else:
                    nvae = NoViableAltException("", 19, 1, self.input)

                    raise nvae

            else:
                nvae = NoViableAltException("", 19, 0, self.input)

                raise nvae

            if alt19 == 1:
                # C:\\Users\\James\\Documents\\FiziksGramr.g:63:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                pass 
                self.match(92)
                # C:\\Users\\James\\Documents\\FiziksGramr.g:63:14: ( '0' .. '3' )
                # C:\\Users\\James\\Documents\\FiziksGramr.g:63:15: '0' .. '3'
                pass 
                self.matchRange(48, 51)



                # C:\\Users\\James\\Documents\\FiziksGramr.g:63:25: ( '0' .. '7' )
                # C:\\Users\\James\\Documents\\FiziksGramr.g:63:26: '0' .. '7'
                pass 
                self.matchRange(48, 55)



                # C:\\Users\\James\\Documents\\FiziksGramr.g:63:36: ( '0' .. '7' )
                # C:\\Users\\James\\Documents\\FiziksGramr.g:63:37: '0' .. '7'
                pass 
                self.matchRange(48, 55)





            elif alt19 == 2:
                # C:\\Users\\James\\Documents\\FiziksGramr.g:64:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                pass 
                self.match(92)
                # C:\\Users\\James\\Documents\\FiziksGramr.g:64:14: ( '0' .. '7' )
                # C:\\Users\\James\\Documents\\FiziksGramr.g:64:15: '0' .. '7'
                pass 
                self.matchRange(48, 55)



                # C:\\Users\\James\\Documents\\FiziksGramr.g:64:25: ( '0' .. '7' )
                # C:\\Users\\James\\Documents\\FiziksGramr.g:64:26: '0' .. '7'
                pass 
                self.matchRange(48, 55)





            elif alt19 == 3:
                # C:\\Users\\James\\Documents\\FiziksGramr.g:65:9: '\\\\' ( '0' .. '7' )
                pass 
                self.match(92)
                # C:\\Users\\James\\Documents\\FiziksGramr.g:65:14: ( '0' .. '7' )
                # C:\\Users\\James\\Documents\\FiziksGramr.g:65:15: '0' .. '7'
                pass 
                self.matchRange(48, 55)






        finally:

            pass

    # $ANTLR end "OCTAL_ESC"



    # $ANTLR start "UNICODE_ESC"
    def mUNICODE_ESC(self, ):

        try:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:70:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            # C:\\Users\\James\\Documents\\FiziksGramr.g:70:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            pass 
            self.match(92)
            self.match(117)
            self.mHEX_DIGIT()
            self.mHEX_DIGIT()
            self.mHEX_DIGIT()
            self.mHEX_DIGIT()




        finally:

            pass

    # $ANTLR end "UNICODE_ESC"



    def mTokens(self):
        # C:\\Users\\James\\Documents\\FiziksGramr.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | ID | INT | FLOAT | COMMENT | WS | STRING | CHAR )
        alt20 = 17
        alt20 = self.dfa20.predict(self.input)
        if alt20 == 1:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:10: T__16
            pass 
            self.mT__16()


        elif alt20 == 2:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:16: T__17
            pass 
            self.mT__17()


        elif alt20 == 3:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:22: T__18
            pass 
            self.mT__18()


        elif alt20 == 4:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:28: T__19
            pass 
            self.mT__19()


        elif alt20 == 5:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:34: T__20
            pass 
            self.mT__20()


        elif alt20 == 6:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:40: T__21
            pass 
            self.mT__21()


        elif alt20 == 7:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:46: T__22
            pass 
            self.mT__22()


        elif alt20 == 8:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:52: T__23
            pass 
            self.mT__23()


        elif alt20 == 9:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:58: T__24
            pass 
            self.mT__24()


        elif alt20 == 10:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:64: T__25
            pass 
            self.mT__25()


        elif alt20 == 11:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:70: ID
            pass 
            self.mID()


        elif alt20 == 12:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:73: INT
            pass 
            self.mINT()


        elif alt20 == 13:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:77: FLOAT
            pass 
            self.mFLOAT()


        elif alt20 == 14:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:83: COMMENT
            pass 
            self.mCOMMENT()


        elif alt20 == 15:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:91: WS
            pass 
            self.mWS()


        elif alt20 == 16:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:94: STRING
            pass 
            self.mSTRING()


        elif alt20 == 17:
            # C:\\Users\\James\\Documents\\FiziksGramr.g:1:101: CHAR
            pass 
            self.mCHAR()







    # lookup tables for DFA #9

    DFA9_eot = DFA.unpack(
        u"\5\uffff"
        )

    DFA9_eof = DFA.unpack(
        u"\5\uffff"
        )

    DFA9_min = DFA.unpack(
        u"\2\56\3\uffff"
        )

    DFA9_max = DFA.unpack(
        u"\1\71\1\145\3\uffff"
        )

    DFA9_accept = DFA.unpack(
        u"\2\uffff\1\2\1\1\1\3"
        )

    DFA9_special = DFA.unpack(
        u"\5\uffff"
        )

            
    DFA9_transition = [
        DFA.unpack(u"\1\2\1\uffff\12\1"),
        DFA.unpack(u"\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"")
    ]

    # class definition for DFA #9

    class DFA9(DFA):
        pass


    # lookup tables for DFA #20

    DFA20_eot = DFA.unpack(
        u"\3\uffff\6\12\2\uffff\1\27\5\uffff\6\12\1\uffff\2\12\1\40\1\41"
        u"\1\12\1\43\2\12\2\uffff\1\47\1\uffff\1\12\1\51\1\12\1\uffff\1\53"
        u"\1\uffff\1\12\1\uffff\1\55\1\uffff"
        )

    DFA20_eof = DFA.unpack(
        u"\56\uffff"
        )

    DFA20_min = DFA.unpack(
        u"\1\11\2\uffff\1\155\1\151\1\154\1\150\1\165\1\151\2\uffff\1\56"
        u"\5\uffff\2\160\1\154\1\145\1\163\1\145\1\uffff\1\157\1\160\2\60"
        u"\1\164\1\60\1\162\1\151\2\uffff\1\60\1\uffff\1\164\1\60\1\145\1"
        u"\uffff\1\60\1\uffff\1\163\1\uffff\1\60\1\uffff"
        )

    DFA20_max = DFA.unpack(
        u"\1\172\2\uffff\1\155\1\151\1\154\1\150\1\165\1\151\2\uffff\1\145"
        u"\5\uffff\2\160\1\154\1\145\1\163\1\145\1\uffff\1\157\1\160\2\172"
        u"\1\164\1\172\1\162\1\171\2\uffff\1\172\1\uffff\1\164\1\172\1\145"
        u"\1\uffff\1\172\1\uffff\1\163\1\uffff\1\172\1\uffff"
        )

    DFA20_accept = DFA.unpack(
        u"\1\uffff\1\1\1\2\6\uffff\1\12\1\13\1\uffff\1\15\1\16\1\17\1\20"
        u"\1\21\6\uffff\1\14\10\uffff\1\5\1\6\1\uffff\1\11\3\uffff\1\10\1"
        u"\uffff\1\4\1\uffff\1\3\1\uffff\1\7"
        )

    DFA20_special = DFA.unpack(
        u"\56\uffff"
        )

            
    DFA20_transition = [
        DFA.unpack(u"\2\16\2\uffff\1\16\22\uffff\1\16\1\uffff\1\17\1\1\3"
        u"\uffff\1\20\5\uffff\1\11\1\14\1\15\12\13\7\uffff\32\12\2\uffff"
        u"\1\2\1\uffff\1\12\1\uffff\1\5\2\12\1\10\3\12\1\4\1\3\3\12\1\7\6"
        u"\12\1\6\6\12"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\21"),
        DFA.unpack(u"\1\22"),
        DFA.unpack(u"\1\23"),
        DFA.unpack(u"\1\24"),
        DFA.unpack(u"\1\25"),
        DFA.unpack(u"\1\26"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\14\1\uffff\12\13\13\uffff\1\14\37\uffff\1\14"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\30"),
        DFA.unpack(u"\1\31"),
        DFA.unpack(u"\1\32"),
        DFA.unpack(u"\1\33"),
        DFA.unpack(u"\1\34"),
        DFA.unpack(u"\1\35"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\36"),
        DFA.unpack(u"\1\37"),
        DFA.unpack(u"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12"),
        DFA.unpack(u"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12"),
        DFA.unpack(u"\1\42"),
        DFA.unpack(u"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12"),
        DFA.unpack(u"\1\44"),
        DFA.unpack(u"\1\46\17\uffff\1\45"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\50"),
        DFA.unpack(u"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12"),
        DFA.unpack(u"\1\52"),
        DFA.unpack(u""),
        DFA.unpack(u"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\54"),
        DFA.unpack(u""),
        DFA.unpack(u"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12"),
        DFA.unpack(u"")
    ]

    # class definition for DFA #20

    class DFA20(DFA):
        pass


 



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import LexerMain
    main = LexerMain(FiziksGramrLexer)
    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)


if __name__ == '__main__':
    main(sys.argv)
