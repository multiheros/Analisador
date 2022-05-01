// Generated from C:\Analisador\src\antlr\Gramatica.g4 by ANTLR 4.10.1

    package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaticaParser}.
 */
public interface GramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code NInicio}
	 * labeled alternative in {@link GramaticaParser#inicio}.
	 * @param ctx the parse tree
	 */
	void enterNInicio(GramaticaParser.NInicioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NInicio}
	 * labeled alternative in {@link GramaticaParser#inicio}.
	 * @param ctx the parse tree
	 */
	void exitNInicio(GramaticaParser.NInicioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlocoDeclaracao}
	 * labeled alternative in {@link GramaticaParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterBlocoDeclaracao(GramaticaParser.BlocoDeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlocoDeclaracao}
	 * labeled alternative in {@link GramaticaParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitBlocoDeclaracao(GramaticaParser.BlocoDeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NDeclaracao}
	 * labeled alternative in {@link GramaticaParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterNDeclaracao(GramaticaParser.NDeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NDeclaracao}
	 * labeled alternative in {@link GramaticaParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitNDeclaracao(GramaticaParser.NDeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlocoPrograma}
	 * labeled alternative in {@link GramaticaParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterBlocoPrograma(GramaticaParser.BlocoProgramaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlocoPrograma}
	 * labeled alternative in {@link GramaticaParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitBlocoPrograma(GramaticaParser.BlocoProgramaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NAtribuicao}
	 * labeled alternative in {@link GramaticaParser#instr}.
	 * @param ctx the parse tree
	 */
	void enterNAtribuicao(GramaticaParser.NAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NAtribuicao}
	 * labeled alternative in {@link GramaticaParser#instr}.
	 * @param ctx the parse tree
	 */
	void exitNAtribuicao(GramaticaParser.NAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NOperacao}
	 * labeled alternative in {@link GramaticaParser#operacao}.
	 * @param ctx the parse tree
	 */
	void enterNOperacao(GramaticaParser.NOperacaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NOperacao}
	 * labeled alternative in {@link GramaticaParser#operacao}.
	 * @param ctx the parse tree
	 */
	void exitNOperacao(GramaticaParser.NOperacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#operando}.
	 * @param ctx the parse tree
	 */
	void enterOperando(GramaticaParser.OperandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#operando}.
	 * @param ctx the parse tree
	 */
	void exitOperando(GramaticaParser.OperandoContext ctx);
}