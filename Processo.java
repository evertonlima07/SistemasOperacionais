import java.util.concurrent.ThreadLocalRandom;

/**
 * Representa um processo.
 * @author Leonardo Jr.
 *
 */
@SuppressWarnings("unused")
public class Processo {
	
	private int PID;
	private int prioridade;
	private int tempoCPU;
	private int estado = EstadoProcesso.NOVO;
	private int tipoProcesso;
	
	private Processo(){}
	
	public int getPID() {
		return PID;
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
		System.out.println("["+PID+"] "+getDescricaoEstado(this.estado)+" -> "+getDescricaoEstado(estado));
		this.estado = estado;
	}

	public int getTipoProcesso() {
		return tipoProcesso;
	}

	public void setTipoProcesso(int tipoProcesso) {
		this.tipoProcesso = tipoProcesso;
	}

	public Processo(int prioridade, int tipoProcesso) {
		this.PID = ThreadLocalRandom.current().nextInt(1,Integer.MAX_VALUE);
		this.tempoCPU = ThreadLocalRandom.current().nextInt(1, 21);
		this.prioridade = prioridade;
		this.tipoProcesso = tipoProcesso;
	}
	
	public Processo(int prioridade, int tipoProcesso, int tempoCPU) {
		this.PID = ThreadLocalRandom.current().nextInt(1,Integer.MAX_VALUE);
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
		return obj.getClass().equals(this.getClass()) && this.PID == ((Processo)obj).PID;
	}
}
