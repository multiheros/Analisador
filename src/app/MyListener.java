package app;

import antlr.GramaticaBaseListener;
import antlr.GramaticaParser;

import java.util.HashMap;
import java.util.Map;

public class MyListener extends GramaticaBaseListener {

    private final Map<String, String> tabelaSimbolos = new HashMap<>();
    private final Map<String, String> atribuicaoVariaveis = new HashMap<>();

    @Override
    public void enterBlocoDeclaracao(GramaticaParser.BlocoDeclaracaoContext ctx) {
        System.out.println("\n###############################################################################################################################");
        System.out.println("# Inicio Bloco Declaracao");
        System.out.println("###############################################################################################################################\n");
    }

    @Override
    public void exitNDeclaracao(GramaticaParser.NDeclaracaoContext ctx) {
        System.out.println("declaracao: " + ctx.getText());
        String tipo = ctx.TIPO().getText();
        String id = ctx.ID().getText();

        if (tabelaSimbolos.containsKey(id)) {
            System.out.println("Bloco declaracao: declaracao duplicada! Variavel " + id + " ja esta declarada");
        } else {
            tabelaSimbolos.put(id, tipo);
        }
    }

    @Override
    public void exitBlocoDeclaracao(GramaticaParser.BlocoDeclaracaoContext ctx) {
        System.out.println("\n###############################################################################################################################");
        System.out.println("# Fim Bloco Declaracao");
        System.out.println("###############################################################################################################################\n");
    }

    @Override
    public void enterBlocoPrograma(GramaticaParser.BlocoProgramaContext ctx) {
        System.out.println("\n###############################################################################################################################");
        System.out.println("# Inicio Bloco Programa");
        System.out.println("###############################################################################################################################\n");

        boolean controle;
        boolean operadorLogico;
        boolean operadorAritimetico;
        String tipoVarivavel;
        String[] result;
        String[] operandos;
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
                    if (operando.matches("[0-9]*\\.[0-9]+")) { // verifica se é um float
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
                operadorAritimetico = result[1].matches("(([a-zA-Z]+)([a-zA-Z0-9]*)?|[0-9])([-+*/])(([a-zA-Z]+)([a-zA-Z0-9]*)?|[0-9])");
                for (String key : check.keySet()) {
                    controle = false;
                    if (operadorLogico) { // se for operador lógico
                        if (antigo.length() > 0 && (!check.get(key).equals(check.get(antigo)))) { // se os tipos não forem iguais
                            System.out.println("Erro na linha " + (linha + i) + ", operadores logicos {<,>} nao aceitam tipos diferentes: " +
                                    "{" + key + ", type:" + check.get(key) + "} e {" + antigo  + ", type:" + check.get(antigo) + "}");
                            controle = true;
                        }

                        if (antigo.length() > 0 && !controle && !tipoVarivavel.equals("bool")) { // se a atribuição não for do mesmo tipo da variável
                            System.out.println("Erro na linha " + (linha + i) + ", variavel {" + result[0] + "} do tipo {" + tipoVarivavel +
                                    "} recebendo valor do tipo {bool}");
                            controle = false;
                            break;
                        }
                        antigo = key;
                    } else if (operadorAritimetico) {
                        if (antigo.length() > 0 && (!check.get(key).equals(check.get(antigo)))) { // se os tipos não forem iguais
                            System.out.println("Erro na linha " + (linha + i) + ", operadores aritmeticos {-,+,*,/} nao aceitam tipos diferentes: " +
                                    "{" + key + ", type:" + check.get(key) + "} e {" + antigo  + ", type:" + check.get(antigo) + "}");
                            controle = true;
                        }

                        if (antigo.length() > 0 && !controle && (!tipoVarivavel.equals("int") | !tipoVarivavel.equals("float"))) { // se a atribuição não for do mesmo tipo da variável
                            System.out.println("Erro na linha " + (linha + i) + ", variavel {" + result[0] + "} do tipo {" + tipoVarivavel +
                                    "} recebendo valor do tipo {int}");
                            controle = false;
                            break;
                        }
                        antigo = key;
                    } else { // se a atribuição não for do mesmo tipo
                        if (!tipoVarivavel.equals(check.get(key))) {
                            System.out.println("Erro na linha " + (linha + i) + ", variavel {" + result[0] + "} e do tipo {" + tipoVarivavel + "} " +
                                    "e esta recebendo {" + key + "} do tipo {" + check.get(key) + "}");
                        }
                    }
                }
                check.clear();
            }
        }

        System.out.println("\n###############################################################################################################################");
        System.out.println("# Fim Bloco Programa");
        System.out.println("###############################################################################################################################\n");
    }
}