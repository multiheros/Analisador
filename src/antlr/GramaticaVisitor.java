// Generated from C:\Analisador\src\antlr\Gramatica.g4 by ANTLR 4.10.1

    package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GramaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GramaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code NInicio}
	 * labeled alternative in {@link GramaticaParser#inicio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNInicio(GramaticaParser.NInicioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlocoDeclaracao}
	 * labeled alternative in {@link GramaticaParser#declaracao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlocoDeclaracao(GramaticaParser.BlocoDeclaracaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NDeclaracao}
	 * labeled alternative in {@link GramaticaParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNDeclaracao(GramaticaParser.NDeclaracaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlocoPrograma}
	 * labeled alternative in {@link GramaticaParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlocoPrograma(GramaticaParser.BlocoProgramaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NAtribuicao}
	 * labeled alternative in {@link GramaticaParser#instr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNAtribuicao(GramaticaParser.NAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NOperacao}
	 * labeled alternative in {@link GramaticaParser#operacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNOperacao(GramaticaParser.NOperacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#operando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperando(GramaticaParser.OperandoContext ctx);
}