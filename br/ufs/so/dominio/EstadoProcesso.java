package br.ufs.so.dominio;

/**
 * Representam os possíveis estados do processo.
 * @author Leonardo Jr.
 */
public final class EstadoProcesso {
	
	//Estado Inicial do Processo
	public static int NOVO = 1;
	
	//Indica que o processo está pronto para execução
	public static int PRONTO = 2;
	
	//Indica que o processo está executando
	public static int EXECUTANDO = 3; 
	
	//Indica que o processo foi finalizado (completamente executado)
	public static int FINALIZADO = 4; 	
	
	private EstadoProcesso(){}
}
