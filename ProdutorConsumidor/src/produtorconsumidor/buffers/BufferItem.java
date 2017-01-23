package produtorconsumidor.buffers;

public class BufferItem {
	private static int idGen = 0;
	public int identificador;
	
	private BufferItem(int id){
		identificador = id;
	}
	
	public static BufferItem getNewBufferItem(){
		return new BufferItem(idGen++);
	}
	
	@Override
	public String toString() {
		return String.format("BufferID = %s",identificador);
	}

}
