package app;

import antlr.GramaticaLexer;
import antlr.GramaticaParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class AnalisadorSemantico {
    public static void main(String[] args) {

        // pega a entrada do parser
        GramaticaParser parser = getParser("src\\teste\\entrada.txt");

        // obtém arvore
        ParseTree ast = parser.inicio();

        // imprime a arvore
        System.out.println(ast.toStringTree());

        // inicia o MyListener
        MyListener listener = new MyListener();

        // percorre a ast
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, ast);
    }

    private static GramaticaParser getParser(String fileName) {
            GramaticaParser parser = null;

            try {
                CharStream input = CharStreams.fromFileName(fileName);
                GramaticaLexer lexer = new GramaticaLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                parser = new GramaticaParser(tokens);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return parser;
    }
}

