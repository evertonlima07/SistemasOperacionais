package br.ufs.so.dominio;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe referente a um processo específico.
 * @author Leonardo Jr.
 *
 */

public class Processo {
	
	//Identificador do processo
	private int PID;
	
	//Prioridade do processo	
	private int prioridade;
	
	//Tempo de CPU necessário para que o processo finalize
	private int tempoCPU;
	
	//Estado do processo - sempre inicia-se em NOVO
	private int estado = EstadoProcesso.NOVO;
	
	//Tipo do processo (equivale à prioridade)
	private int tipoProcesso;
	
	//Tempo de chegada do processo ao processador. Funciona como um certo delay para indicar que dado processo 
	//pode ser de fato executado (se o timer do processador for menor que o tempo de chegada é porque ele "não estava" lá
	private int tempoChegada = 0;
	
	public int getPID() {
		return PID;
	}

	public int getTempoChegada() {
		return tempoChegada;
	}

	public void setTempoChegada(int tempoChegada) {
		this.tempoChegada = tempoChegada;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getTempoCPU() {
		return tempoCPU;
	}

	public void setTempoCPU(int tempoCPU) {
		this.tempoCPU = tempoCPU;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		System.out.println("|Processo "+PID+"| "+getDescricaoEstado(this.estado)+" -> "+getDescricaoEstado(estado));
		this.estado = estado;
	}

	public int getTipoProcesso() {
		return tipoProcesso;
	}

	public void setTipoProcesso(int tipoProcesso) {
		this.tipoProcesso = tipoProcesso;
	}
	
	public void iniciarExecucao(){
		setEstado(EstadoProcesso.EXECUTANDO);
	}
	
	public void finalizarProcesso(){
		setEstado(EstadoProcesso.FINALIZADO);
	}
	
	public boolean isEmExecucao(){
		return this.estado == EstadoProcesso.EXECUTANDO;
	}
	
	public boolean isFinalizado(){
		return this.estado == EstadoProcesso.FINALIZADO;
	}
	
	public void decrementarTempoCPU(){
		--this.tempoCPU;
	}

	public Processo(int prioridade, int tipoProcesso) {
		this.PID = ThreadLocalRandom.current().nextInt(1,Integer.MAX_VALUE);
		this.tempoCPU = ThreadLocalRandom.current().nextInt(1, 21);
		this.prioridade = prioridade;
		this.tipoProcesso = tipoProcesso;
	}
	
	public String getDescricaoEstado(){
		switch (estado) {
		case 1:
			return "Novo";
		case 2:
			return "Pronto";
		case 3:
			return "Executando";
		case 4:
			return "Finalizado";
		}
		return "";
	}
	
	public String getDescricaoEstado(int estado){
		switch (estado) {
		case 1:
			return "Novo";
		case 2:
			return "Pronto";
		case 3:
			return "Executando";
		case 4:
			return "Finalizado";
		}
		return "";
	}
	
	@Override
	public String toString() {
		return "Processo PID : "+PID+"; Estado = "+getDescricaoEstado() + "; Prioridade = "+prioridade + "; Tempo de CPU = "+tempoCPU;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj!=null && obj.getClass().equals(this.getClass()) && this.PID == ((Processo)obj).PID;
	}
}
