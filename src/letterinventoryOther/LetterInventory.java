package letterinventoryOther;

// Programmer: Quinn Murphy
// Date: 10/20/22 
// Class: CS145
// LetterInventory - Lab 3
// References: book, stackOverflow, etc.
// This one was kinda more weird then I thought.
// While my original idea was to just use a
// char array on the inputed string, then use a 
// java sort string method or something. But after 
// reading the instructions, I went the route they said to go. 
// It looks complex, but it really just has a whole
// bunch of loops and checks to see what chars are
// in the array, and how to organize them.

public class LetterInventory {

	int[] inventory;
	
	
	
	public static void main(String[] args) {
		// main method... just calls the letterinventory method, and i put a 
		// toString and println just to prove it works.
		LetterInventory letter = new LetterInventory("Quinn");
		LetterInventory letter2 = new LetterInventory("Murphy");
		letter.add(letter2);
		letter.toString();
		System.out.println(letter);
		
		
	}

	public LetterInventory(String s) {
		// counts letters in the string, for 
		// lower and upper case. Alphabet has 
		// 26 letters...
		inventory = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c <= 'z' && c >= 'a') {
				inventory[c - 'a']++;

			} else if (c <= 'Z' && c >= 'A') {
				inventory[c - 'A']++;

			}

		}

	}

	public void add(LetterInventory first) {
		// pretty simple, we just add the 
		// local inventory to the first one.
		for (int i = 0; i < 26; i++) {
			this.inventory[i] += first.inventory[i];

		}

	}

	public void add(String string) {
		// part two of add. Makes another letter
		// inventory and then just calls it again.
		// as a string...
		LetterInventory other = new LetterInventory(string);
		add(other);

	}

	public boolean contains(LetterInventory other) {
			// just a check if we already added 
		// the two inventories or not..
		for (int i = 0; i < 26; i++) {
			if (this.inventory[i] < other.inventory[i]) {
				return false;

			}

		}
		return true;
	}
	
	
	public boolean contains(String string) {
		// just calls the contains method on the letterinventory.
		LetterInventory other = new LetterInventory(string);
		return contains(other);
		
	}
	
	public void subtract(LetterInventory other) {
		
		if(!this.contains(other)) {
			throw new IllegalArgumentException();
			
		}
		for(int i = 0; i < 26; i++) {
			this.inventory[i] -= other.inventory[i];
			
		}
		
		
	}
	
	public void subtract(String string) {
		LetterInventory other = new LetterInventory(string);
		subtract(other);
		
	}
	
	public boolean isEmpty() {
		// if inventory has more then 1 char
		// in it, return false. 
		for(int i = 0; i < 26; i++) {
			if(this.inventory[i] != 0) {
				return false;
			}
		}
		return true;
		
	}
	
	public String toString() {
		// pretty simple. Just the brackets for
		// styling sake, and then loop and print through 
		// the array (inventory)
		String bracket = "[";
		for(int i = 0; i < 26; i++) {
			for(int v = 0; v < this.inventory[i]; v++) {
				
				bracket += (char)(i + 'a');
				
			}
		}
		return bracket + "]";
	}
	
	public int size() {
		// just a count of how big 
		// the inventory is. 
		int size = 0;
		for(int i = 0; i < 26; i++) {
			size += this.inventory[i];
		}
		return size;
	}
	
	
	

}