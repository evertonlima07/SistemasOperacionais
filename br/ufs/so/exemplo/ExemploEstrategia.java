package br.ufs.so.exemplo;

import br.ufs.so.dominio.Processador;
import br.ufs.so.dominio.Processo;
import br.ufs.so.dominio.TipoProcesso;
import br.ufs.so.estrategia.EstrategiaExemplo;

public class ExemploEstrategia {
	public static void main(String[] args) {
		Processador p = new Processador(new EstrategiaExemplo());
		Processo p1 = new Processo(TipoProcesso.SISTEMA, 1);
		p1.setPID(1);
		p1.setTempoCPU(8);
		p1.setTempoChegada(0);
		Processo p2 = new Processo(TipoProcesso.SISTEMA, 1);
		p2.setPID(2);
		p2.setTempoCPU(4);
		p2.setTempoChegada(1);
		Processo p3 = new Processo(TipoProcesso.SISTEMA, 1);
		p3.setPID(3);
		p3.setTempoCPU(9);
		p3.setTempoChegada(2);
		Processo p4 = new Processo(TipoProcesso.SISTEMA, 1);
		p4.setPID(4);
		p4.setTempoCPU(5);
		p4.setTempoChegada(3);
		p.getProcessosSistema().processos.add(p1);
		p.getProcessosSistema().processos.add(p2);
		p.getProcessosSistema().processos.add(p3);
		p.getProcessosSistema().processos.add(p4);
		p.executarProcessos();
	}
}
