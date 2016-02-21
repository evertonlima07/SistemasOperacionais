package br.ufs.so.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma fila de processos, que armazena um tipo específico de processos.
 * @author Leonardo Jr.
 *
 */
public class FilaProcessos {
	
	//Lista de Processos na Fila
	public List<Processo> processos;
	
	//Referente ao tipo de processos existentes na fila. Equivale à prioridade da fila.
	public int tipoProcesso;
	
	//Estratégia de escalonamento específica para a fila em questão.
	public EstrategiaEscalonamento estrategia;
	
	public FilaProcessos(int tipoProcesso){
		this(tipoProcesso, null);
	}
	
	public FilaProcessos(int tipoProcesso, EstrategiaEscalonamento estrategia){
		processos = new ArrayList<Processo>();
		this.tipoProcesso = tipoProcesso; 
		this.estrategia = estrategia;
	}
}
