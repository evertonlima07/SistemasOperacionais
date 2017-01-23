package produtorconsumidor.buffers;

public abstract class BufferManipulator implements Runnable {
	private Buffer buffer;
	
	public BufferManipulator(Buffer buffer) {
		this.buffer = buffer;	
	}
	
	public Buffer getBuffer() {
		return buffer;
	}
}
