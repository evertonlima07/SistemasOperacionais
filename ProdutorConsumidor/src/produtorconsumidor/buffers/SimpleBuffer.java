package produtorconsumidor.buffers;

public class SimpleBuffer extends Buffer {
	
	public SimpleBuffer(int bufferSize) {
		super(bufferSize);
	}

	@Override
	public void insert(BufferItem item) {
		int posicao = getCount();
		getBuffer()[posicao] = item;		
		System.out.format("[%s] Inserindo o item com %s no Buffer na posição %s %n",Thread.currentThread().getName(),item.toString(), posicao);
		setCount(posicao+1);
	}

	@Override
	public BufferItem remove() {
		int position = getCount()-1;
		BufferItem bi = getBuffer()[position];
		getBuffer()[position] = null;
		setCount(position);
		System.out.format("[%s] Removendo o item com %s do Buffer %n",Thread.currentThread().getName(),bi.toString());
		return bi;
	}
}
