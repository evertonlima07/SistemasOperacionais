package produtorconsumidor.buffers;

public abstract class Buffer {
	private BufferItem[] buffer;
	private int bufferSize;
	//Volatile evita o cache da variável
	private volatile int count;
	
	public Buffer(int bufferSize){
		this.bufferSize = bufferSize;
		buffer = new BufferItem[bufferSize];
		count = 0;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	public BufferItem[] getBuffer() {
		return buffer;
	}
	
	public void setBuffer(BufferItem[] buffer) {
		this.buffer = buffer;
	}
	
	public boolean isBufferFull(){
		return count==bufferSize;
	}
	
	public boolean isBufferEmpty(){
		return count==0;
	}
	
	abstract public void insert(BufferItem item);
	
	public void insertDebug(BufferItem item){
		//synchronized (this) {
			insert(item);
			imprimirBuffer();
		//}
		
	}
	
	public void removeDebug(){
		//synchronized (this) {
			remove();
			imprimirBuffer();			
		//}
	}
	
	public void imprimirBuffer(){
		String desenhoBuffer = "[";
		for(BufferItem bi:buffer){
			if(bi==null)
				desenhoBuffer +=" |";
			else desenhoBuffer +=bi.identificador+"|";
		}
		System.out.println(desenhoBuffer.substring(0, desenhoBuffer.length()-1)+"]");	
	}

	abstract public BufferItem remove();
}
