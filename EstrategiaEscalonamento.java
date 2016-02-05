/**
 * Interface para as estratégias de escalonamento.
 * Todas as estratégias devem implementar essa classe.
 * @author leonardo
 *
 */
public interface EstrategiaEscalonamento {
	//Deve escolher o próximo processo a ser executado dentre as filas disponíveis.
	public Processo escolherProximoProcesso(FilaProcessos[] filas);
}
