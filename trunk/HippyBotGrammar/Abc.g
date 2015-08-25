grammar Abc;

options
{
	language=Python;
	output=AST;
//	charVocabulary='\u0000'..'\uFFFE';
}
   

tokens {
	IDD;
	INT;
	FLOAT;
	STRING;
	CHAR;  
	BF;  
}

IDD  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ; 

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

BF	:	'#' ('[' | ']' | '>' | '<' | '+' | '-' | '.' | ',')* ';';
fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;


start	:	(statement)*;

statement
	:	'import' IDD ';'
	|	'using' IDD block
	|	'for' list block
	|	'if' list block ('else' block)?
	|	assignment ';';

list	:	cond1 (',' cond1)*
	| 	;

block	:	
		'{' start '}';
		
assignment
	:	expression (':' cond1)*;

cond1	:	cond2 (('=='|'!=') cond2)*;
cond2	:	cond3 (('>'|'<'|'>='|'<=') cond3)*;
cond3	:	expression (('&&'|'||') expression)*;

expression
	:	factor (('-'|'+') factor)*;
	
factor	:	subexpr (('%'|'*'|'/') subexpr)*;





subexpr	:	'(' cond1 ')'
	|	unary;
	
unary	:	'-' dot
	| 	'+' dot
	| 	'!' dot
	| 	dot;

dot	:	val ('hippy' val)*;
	
val	:	IDD|INT|STRING|array|method|BF;

method	:	IDD '(' list ')' ;

array	:	'[' arrayElements ']';

arrayElements
	:	cond1 (',' cond1)*
	|	;