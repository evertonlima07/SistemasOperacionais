Laboratório I de SO – Algoritmos de Escalonamento
-------------------------------------------------

A tarefa desse laboratório é implementar um processador que aceite qualquer uma das políticas de escalonamento apresentadas na sala (FCFS, SJF, SFJ Preemptivo, SRTF, Prioridade, RR, MLQQ, MLQQ com Feedback). Esse laboratório trabalho valerá **1,5 pontos**.

**Critérios de avaliação:**

1. Lógica implementada: 1,25;
2. Avaliação técnica da implementação: 0,25;

**Especificações:**

1 – As classes básicas estão disponibilizadas no SIGAA. Elas são: *TipoProcesso*, *EstadoProcesso*, *EstrategiaEscalonamento*, *FilaProcessos* e *Processo*. As descrições das classes estão no cabeçalho das mesmas. 

2 – Cada uma das estratégias de escalonamento deve ter sua própria classe. Todas as estratégias de escalonamento devem implementar a interface EstrategiaEscalonamento e o método escolherProximoProcesso. As classes devem estar no pacote estrategiasescalonamento;

3 – A classe que representa o processador deve chamar-se “Processador”. O processador é a entidade que executa os processos. Ela deve conter três filas de processos, cada uma representando uma prioridade especificada em TipoProcesso. Antes de iniciar o processamento, que deve ser indicado por uma mensagem, o sistema deve alterar o estado do processo para “Executando” e, após o processamento, para “Finalizado”. Os processos finalizados devem ser colocados em uma fila separada.

4 - Após cada execução (quando as filas estiverem vazias), o tempo médio de espera dos processos deverá ser exibido.

5 – Devem haver mensagens informativas que permitam a visualização da execução do processo.

6 - Para a avaliação: Preparar pequenas instâncias para verificação do funcionamento individual de cada algoritmo, bem como entre os algoritmos (através do tempo de espera).

**Sugestões:**

1 – No código inicial, foi definido que um processo pode ter tempo de CPU de 1 a 21s. Diminuam esse tempo durante a implementação, para tratar processos menores.

2 - Executem os testes com um número mínimo de casos (controlados) e depois expandam a implementação.

3 – Cuidado com o excesso de mensagens!