package br.ufs.so.dominio;

/**
 * Interface para as estratégias de escalonamento.
 * Todas as estratégias devem implementar essa classe.
 * @author Leonardo Jr.
 *
 */
public interface EstrategiaEscalonamento {
	/**
	 * Deve escolher o próximo processo a ser executado dentre as filas disponíveis.
	 * @param filas As filas de processos, em um array. A ordem do array pode ser a ordem de prioridade das filas (sugestão)
	 * @param timer O tempo do processador. Importante para simular o tempo de chegada.
	 * @return
	 */
	public Processo escolherProximoProcesso(FilaProcessos[] filas, Integer timer);
	
	//Identifica se o escalonamento é preemptivo ou não
	public Boolean isEscalonamentoPreemptivo();
	
	//Recupera o valor do quantum-padrão da estratégia. 
	public Integer getQuantum();
}
