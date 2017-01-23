package br.ufs.so.estrategia;

import java.util.Collections;
import java.util.Comparator;

import br.ufs.so.dominio.EstrategiaEscalonamento;
import br.ufs.so.dominio.FilaProcessos;
import br.ufs.so.dominio.Processo;

/**
 * Implementação da rotina de escalonamento FCFS (First Come First Serve);
 * @author Leonardo Jr.
 *
 */
public class FCFS implements EstrategiaEscalonamento {
	@Override
	public Processo escolherProximoProcesso(FilaProcessos[] filas, Integer timer) {
		for(FilaProcessos p: filas){
			if(p.processos.size()>0){
				Collections.sort(p.processos, new Comparator<Processo>() {
					@Override
					public int compare(Processo o1, Processo o2) {
						return new Integer(o1.getTempoChegada()).compareTo(o2.getTempoChegada());
					}
				});
				for(Processo processo: p.processos){
					if(processo.getTempoChegada()<=timer)
						return processo;
				}
			}
		}
		return null;
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
