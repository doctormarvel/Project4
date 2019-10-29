
public class HashTableLinearProbe <K, V>{
	private class HashEntry <K, V>{
		K inputkey;
		V inputvalue;
		boolean deleted;
		
		public HashEntry (K key, V value) {
			inputkey = key;
			inputvalue = value;
			deleted = false;
		}
	}
	
	HashEntry <K, V>[] hashtable = new HashEntry[10];
	
	public boolean insert (K key, V value) {
		return true;
	}
	
	public V find (K key){
		return null;
	}
	
	public boolean delete (K key) {
		return true;
	}
	
	public int getHashValue(K key) {
		return 0;
	}
	
	public void rehash() {
		
	}
}
