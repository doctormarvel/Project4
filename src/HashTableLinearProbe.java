
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
	public int tableSize = 7;
	HashEntry <K, V>[] hashtable;
	public HashTableLinearProbe() {
		hashtable = new HashEntry[tableSize];
	}
	
	public boolean insert (K key, V value) {
		boolean status = false;
		int count = 0; // to know how big the array is
		int hashValue = getHashValue(key);
		
		for (int i = hashValue; i < tableSize; i++) {
			if (hashtable[i]== null) {
				hashtable[i] = new HashEntry(key, value);
				status = true;
				return status;
			}
			else if(i == tableSize-1) {
				i = 0;
			}
			else if (count == tableSize) { //Stops if we have traversed the whole tree once
				rehash();
			}
			else {
				count++;
			}
		}
		return status;
	}
	
	public V find (K key){
		V temp = null;
		int count = 0;
		int hashValue = getHashValue(key);
		
		for (int i = hashValue; i < tableSize; i++) {
			if (key == hashtable[i].inputkey) {
				temp = hashtable[i].inputvalue;
				return temp;
			}
			else if (i == tableSize-1) {
				i = 0;
			}
			else if (count == tableSize - 1) { //Stops if we have traversed the whole tree once
				break;
			}
			else if (count < hashValue && hashtable[i].inputkey == null) { //Checks for if there is a space 
				break;
			}
			else {
				count++;
			}
		}
		return temp;
	}
	
	public boolean delete (K key) {
		boolean status = false;
		int hashValue = getHashValue(key);
		int count = 0;
		for (int i = hashValue; i < tableSize; i++) {
				if (hashtable[i] != null && key.equals(hashtable[i].inputkey)) {
				hashtable[i].deleted = true;
				status = true;
				return status;
			}
			else if (i == tableSize-1) {
				i = 0;
			}
			else if (count == tableSize - 1) { //Stops if we have traversed the whole tree once
				break;
			}
			else if (hashtable[i] == null) { //Checks for if there is a space 
				break;
			}
			else {
				System.out.println(hashtable[i].inputkey);
				count++;
			}
		}
		return status;
	}
	
	public int getHashValue(K key) {
		int hashValue = 0;
		int totalValue = 0;
		String keyString = (String) key; // need to parse to string
		for (int i = 0; i < keyString.length(); i++) {
			if (keyString.charAt(i) < 58) {
				totalValue = Integer.valueOf(keyString);
				break;
			}
			else {
				totalValue += keyString.charAt(i);
			}
		}
		hashValue = totalValue % tableSize;

		return hashValue;
	}
	
	public void rehash() {
		//temp solution to increase hashtable by a prime number
		int primeNumbers [] = {17,37,79};
		int oldTableSize = tableSize;
		for (int i = 0; i < primeNumbers.length; i++) {
			if (tableSize < primeNumbers[i]) {
				tableSize = primeNumbers[i];
				break;
			}
		}
		HashEntry<K, V> [] newTable = new HashEntry[tableSize];
		
		for (int i = 0; i < oldTableSize; i++) {
			if(hashtable[i] != null) {
				int hashValue = getHashValue(hashtable[i].inputkey);
				
				for (int j = hashValue; j < tableSize; j++) {
					if (newTable[j]== null) {
						newTable[j] = new HashEntry(hashtable[i].inputkey, hashtable[i].inputvalue);
					}
					else if(j == tableSize-1) {
						j = 0;
					}
				}
			}
		}
		hashtable = newTable;
	}
}
