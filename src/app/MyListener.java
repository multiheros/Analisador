package app;

import antlr.GramaticaBaseListener;
import antlr.GramaticaParser;

import java.util.HashMap;
import java.util.Map;

public class MyListener extends GramaticaBaseListener {

    private Map<String, String> tabelaSimbolos = new HashMap<String, String>();

    @Override
    public void exitNDeclaracao(GramaticaParser.NDeclaracaoContext ctx) {
        System.out.println("Out declaração: " + ctx.getText());
        String tipo = ctx.TIPO().getText();
        String id = ctx.ID().getText();

        if(tabelaSimbolos.containsKey(id)) {
            System.out.println("Declaração duplicada! Variável " + id + " já está declarada");
        } else {
            tabelaSimbolos.put(id, tipo);
        }
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
