grammar Gramatica;

@header {
    package antlr;
}

inicio: (declaracao)? programa EOF #NInicio;
declaracao: ':declaracao' (decl)* #BlocoDeclaracao;
decl: TIPO (ID)';' #NDeclaracao;
programa: ':programa' (instr)* #BlocoPrograma;
instr: ID '=' (ID|NUM|STR|BOL|operacao)';' #NAtribuicao;
operacao: operando OPERADOR (operando|operacao) #NOperacao;
operando: ID|NUM|STR|BOL #NOperando;

TIPO: ('int'|'float'|'bool'|'string');
ID: ([a-zA-Z]+)([a-zA-Z0-9]*)?;
WS: [ \r\t\n]+ ->skip;
NUM: [0-9]+('.'[0-9]+)?;
STR: '"'~["]*?'"';
True: [1];
False: [0];
BOL: True|False;
OPERADOR: '+'|'-'|'*'|'/'|'>'|'<';