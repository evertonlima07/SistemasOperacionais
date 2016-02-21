package br.ufs.so.estrategia;

import br.ufs.so.dominio.EstrategiaEscalonamento;
import br.ufs.so.dominio.FilaProcessos;
import br.ufs.so.dominio.Processo;

public class EstrategiaExemplo implements EstrategiaEscalonamento {

	@Override
	public Processo escolherProximoProcesso(FilaProcessos[] filas, Integer timer) {
		return filas[0].processos.get(5);
	}

	@Override
	public Boolean isEscalonamentoPreemptivo() {
		return false;
	}

	@Override
	public Integer getQuantum() {
		return null;
	}

}
