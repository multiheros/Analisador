package app;

import antlr.GramaticaBaseListener;
import antlr.GramaticaParser;

import java.util.HashMap;
import java.util.Map;

public class MyListener extends GramaticaBaseListener {

    private Map<String, String> tabelaSimbolos = new HashMap<String, String>();
    private Map<String, String> variaveis = new HashMap<String, String>();
    @Override
    public void exitNDeclaracao(GramaticaParser.NDeclaracaoContext ctx) {
        System.out.println("Out declaracao: " + ctx.getText());
        String tipo = ctx.TIPO().getText();
        String id = ctx.ID().getText();

        if(tabelaSimbolos.containsKey(id)) {
            System.out.println("declaracao duplicada! Variavel " + id + " ja esta declarada");
        } else {
            tabelaSimbolos.put(id, tipo);
        }
    }

    @Override
    public void enterBlocoPrograma(GramaticaParser.BlocoProgramaContext ctx) {
        String result[];
        int linha = ctx.getStart().getLine();

        for (int i = 1; i < ctx.getChildCount(); i++) {
            result = ctx.getChild(i).getText().replace(";", "").split("=");

            if(!tabelaSimbolos.containsKey(result[0])) {
                System.out.println("Erro na linha " + (linha + i) + ", variavel-> " + result[0] + " nao foi declarada");
            } else {
                if (result[1].matches("[0-9]*\\.[0-9]+")) {
                    variaveis.put(result[0], "float");
                } else if (result[1].matches("[0-9]*")) {
                    variaveis.put(result[0], "int");
                } else if (result[1] == "True" || (result[1] == "False")) {
                    variaveis.put(result[0], "boolean");
                } else {
                    variaveis.put(result[0], "string");
                }
            }
        }

        System.out.println(variaveis);
    }

    @Override
    public void exitBlocoPrograma(GramaticaParser.BlocoProgramaContext ctx) {
        //System.out.println("Out declaracao: " + ctx.getText());

        /*
        if(tabelaSimbolos.containsKey(id)) {
            System.out.println("Declaração duplicada! Variável " + id + " já está declarada");
        }
         */
    }

    /*
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        System.out.println("entrou na regra: " + ctx.getText());
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        System.out.println("saiu na regra: " + ctx.getText());
    }
    */
}
