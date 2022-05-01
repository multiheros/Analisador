package app;

import antlr.GramaticaBaseListener;
import antlr.GramaticaParser;
import org.antlr.v4.runtime.Token;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyListener extends GramaticaBaseListener {

    private final Map<String, String> tabelaSimbolos = new HashMap<>();

    @Override
    public void exitNDeclaracao(GramaticaParser.NDeclaracaoContext ctx) {
        Token token = ctx.TIPO().getSymbol();
        int linha = token.getLine();

        String tipo = ctx.TIPO().getText();
        String id = ctx.ID().getText();

        if (tabelaSimbolos.containsKey(id)) {
            System.out.println("Erro na linha " + linha + ", declaracao duplicada! Variavel " + id + " ja esta declarada");
        } else {
            tabelaSimbolos.put(id, tipo);
        }
    }

    @Override
    public void enterBlocoPrograma(GramaticaParser.BlocoProgramaContext ctx) {
        boolean controle;
        boolean operadorLogico;
        boolean operadorAritimetico;

        String[] result;
        String[] operandos;

        String tipoVarivavel;
        String antigo;

        Map<String, String> check = new HashMap<>();

        // pega linha onde começa o programa
        int linha = ctx.getStart().getLine();

        // laço para percorrer os filhos
        for (int i = 1; i < ctx.getChildCount(); i++) {
            // remove o ";" e quebra a string de atribuição entre variavel e operação
            result = ctx.getChild(i).getText().replace(";", "").split("=");

            // verifica se a variável não foi declarada
            if (!tabelaSimbolos.containsKey(result[0])) {
                System.out.println("Erro na linha " + (linha + i) + ", variavel-> " + result[0] + " nao foi declarada");
            } else {
                // pega os operandos utilizando os operadores lógicas e aritméticos
                operandos = result[1].split("[-+*><)]");
                for (String operando : operandos) {
                    if (operando.matches("[0-9]+(\\.[0-9]+)?")) { // verifica se é um float
                        check.put(operando, "float");
                    } else if (operando.chars().allMatch(Character::isDigit)) { // verifica se é um int
                        check.put(operando, "int");
                    } else if (operando.equals("True") || operando.equals("False")) { // verifica se é um boolean
                        check.put(operando, "bool");
                    } else if (operando.matches("\"([^\"]*)\"")) { // verifica se é uma string
                        check.put(operando, "string");
                    } else { // caso não seja os casos acima, então é uma variável
                        if (!tabelaSimbolos.containsKey(operando)) { // verifica se a variável não foi declarada
                            System.out.println("Erro na linha " + (linha + i) + ", variavel-> " + operando + " nao foi declarada");
                        } else { // se já foi declarada salva em uma hash para comparação posteriormente
                            check.put(operando, tabelaSimbolos.get(operando));
                        }
                    }
                }

                // resgata o tipo da variável que está recebendo a atribuição
                tipoVarivavel = tabelaSimbolos.get(result[0]);

                // variável para armazenar o nome da variável anterior para comparação
                antigo = "";

                // identifica operação lógica
                operadorLogico = result[1].matches("(([a-zA-Z]+)([a-zA-Z0-9]*)?|[0-9]|\"([^\"]*)\")([<>])(([a-zA-Z]+)([a-zA-Z0-9]*)?|[0-9]|\"([^\"]*)\")");

                // identifica operação aritmetica
                operadorAritimetico = result[1].matches("(([a-zA-Z]+)([a-zA-Z0-9]*)?|[0-9]+(\\.[0-9]+)?)([-+*/])(([a-zA-Z]+)([a-zA-Z0-9]*)?|[0-9]+(\\.[0-9]+)?)");
                for (String key : check.keySet()) {
                    if (operadorLogico) { // se for operador lógico
                        if (antigo.length() > 0 && (!logic.contains(check.get(key)) && !logic.contains(check.get(antigo)))) { // verifica os tipos validos
                            System.out.println("Erro na linha " + (linha + i) + ", operadores logicos {<,>} nao aceitam tipos diferentes: " +
                                    "{" + key + ", type:" + check.get(key) + "} e {" + antigo  + ", type:" + check.get(antigo) + "}");
                            break;
                        }

                        if (antigo.length() > 0 && !tipoVarivavel.equals("bool")) { // se a atribuição não for do mesmo tipo da variável
                            System.out.println("Erro na linha " + (linha + i) + ", variavel {" + result[0] + "} do tipo {" + tipoVarivavel +
                                    "} recebendo valor do tipo {bool}");
                            break;
                        }
                        antigo = key;
                    } else if (operadorAritimetico) {
                        if (antigo.length() > 0 && (!arithmetic.contains(check.get(key)) && !arithmetic.contains(check.get(antigo)))) { // verifica os tipos validos
                            System.out.println("Erro na linha " + (linha + i) + ", operadores aritmeticos {-,+,*,/} nao aceitam tipos diferentes: " +
                                    "{" + key + ", type:" + check.get(key) + "} e {" + antigo  + ", type:" + check.get(antigo) + "}");
                            break;
                        }

                        if (antigo.length() > 0 && (!arithmetic.contains(tipoVarivavel))) { // se a atribuição não for do mesmo tipo da variável
                            System.out.println("Erro na linha " + (linha + i) + ", variavel {" + result[0] + "} do tipo {" + tipoVarivavel +
                                    "} recebendo valor do tipo {int}");
                            break;
                        }
                        antigo = key;
                    } else { // se a atribuição não for do mesmo tipo
                        if (!tipoVarivavel.equals(check.get(key))) {
                            System.out.println("Erro na linha " + (linha + i) + ", variavel {" + result[0] + "} e do tipo {" + tipoVarivavel + "} " +
                                    "e esta recebendo {" + key + "} do tipo {" + check.get(key) + "}");
                            break;
                        }
                    }
                }
                check.clear();
            }
        }
    }

    private static final Set<String> arithmetic = Set.of(
            "int","float"
    );

    private static final Set<String> logic = Set.of(
            "int", "float"
    );
}