package br.ufs.so.dominio;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Classe que emula um processador.
 * 
 * @author Leonardo Jr.
 *
 */
public class Processador {
	
	//Filas de processos.
	//O processador tem uma filha de processos para cada uma das prioridades definidas...
	private FilaProcessos processosAluno = new FilaProcessos(TipoProcesso.ALUNO);
	private FilaProcessos processosSistema = new FilaProcessos(TipoProcesso.SISTEMA);
	private FilaProcessos processosProfessor = new FilaProcessos(TipoProcesso.PROFESSOR);
	//... e um array com todas as filas disponíveis;
	private FilaProcessos[] filas = new FilaProcessos[]{processosSistema, processosProfessor, processosAluno};
	
	//Por fim, uma fila de processos finalizados.
	private List<Processo> processosFinalizados = new ArrayList<Processo>();

	//Definição da estratégia de escalonamento a ser adotada pelo processador.
	private EstrategiaEscalonamento estrategia;
	
	//O processador tem um relógio interno, que emula os ticks do processador. 	
	private Integer timer = 0;
	
	//Número máximo de ticks do processador.
	private Integer timeoutDoProcessador = 100;
	
	//Mostrar todos os ticks ou apenas eventos importantes.
	private Boolean modoDebug = false;
	
	
	/**
	 * Método básico do processador. 
	 * Funciona basicamente como um loop, onde, a cada loop ele aumenta o tempo do processador e 
	 * decrementa o tempo do processo em execução.
	 */
	public void executarProcessos() {
		//Inicia a execução escolhendo um primeiro processo.
		Processo p = estrategia.escolherProximoProcesso(filas, timer);
		
		//O tempo máximo do processador se esgotou?
		while(timer < timeoutDoProcessador){
			
			//Flag que identifica se devemos procurar um novo processo
			boolean novoProcesso = false;
			
			//Se não existir processo hábil, o processador deve apenas indicar uma mensagem que está parado
			//e pedir ao escalonador um novo processo.
			if(p==null){
				if(modoDebug)
					System.out.println("["+timer+"] Processador Parado.");
				novoProcesso = true;
			}
			else{
				//Se o processo ainda não está em execução...
				if(!p.isEmExecucao()){
					System.out.println("["+timer+"] Iniciando execução do processo "+p.getPID());
					p.iniciarExecucao();
				}
				
				if(modoDebug)
					System.out.println("["+timer+"] Executando processo "+p);
				
				//Se o processo finalizou sua execução...
				if(p.getTempoCPU()==0){
					System.out.println("["+timer+"] Processo finalizado! "+p);
					p.finalizarProcesso();
					removerProcesso(p);
					novoProcesso = true;
				}
				
				p.decrementarTempoCPU(); //Diminuiu o tempo de CPU do processo atual
				
				//Se o escalonamento for preemptivo, mesmo que o processo atual não tenha terminado
				//ele deve buscar um novo processo ao fim. 
				//TODO: Implementar o gerenciamento do quantum.
				if(estrategia.isEscalonamentoPreemptivo()){
					novoProcesso = true;
				}
			}
			timer++; //Incrementa o tempo do processador.
			
			//Caso alguma das condições para recuperação de um novo processo tenham sido atendidas...
			if(novoProcesso){
				Processo proximoProcesso = estrategia.escolherProximoProcesso(filas, timer);
				//É possível que o próximo processo a ser executado seja o mesmo processo (como RR).
				//Caso não seja (e exista um próximo processo)
				if(proximoProcesso!=null && p!=null && !proximoProcesso.equals(p) && !p.isFinalizado()){
					System.out.println("["+timer+"] Troca de contexto! "+p);
					p.setEstado(EstadoProcesso.PRONTO);
				}
				p = proximoProcesso;
			}
		}
		
	}
	
	/**
	 * Remove o processo p da fila que ele estiver.
	 * @param p O processo a ser removido.
	 */
	public void removerProcesso(Processo p){
		for(FilaProcessos fila:filas){
			for (Iterator<Processo> iterator = fila.processos.iterator(); iterator.hasNext();) {
				if(iterator.next().equals(p)){
					processosFinalizados.add(p);
					iterator.remove();
					return;
				}				
			}
		}
	}
	
	public Processador(EstrategiaEscalonamento estrategia) {
		this.estrategia = estrategia;
	}

	public FilaProcessos getProcessosSistema() {
		return processosSistema;
	}

	public void setProcessosSistema(FilaProcessos processosSistema) {
		this.processosSistema = processosSistema;
	}
}
