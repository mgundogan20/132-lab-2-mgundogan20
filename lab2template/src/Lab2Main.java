
public class Lab2Main {
	
    // This is the lab2 driver class
	// main method makes necessary calls for problems that  you need to solve
	// comment out the part that you want work

	public static void main(String[] args) {
		
		//myTester();
		//prelab();          //   uncomment for testing before lab
		//inlabCardDeck(); // uncomment for testing in lab
		inlabArrays();   // uncomment for testing in lab

	}
	
	
	
	// PART1 prelab DeckOfCards problems
	private static void prelab() {

		System.out.printf("Number of Card instances should be zero: %d%n",
				           Card.getCardCount());
		DeckOfCards myDeckOfCards = new DeckOfCards();
		
	
		myDeckOfCards.printDeck();
		
		System.out.printf("Number of Card instances should be 52 now: %d%n",
		           Card.getCardCount());
		 
		 
		System.out.printf("Is the first five cards is a flush? %b%n",
				         myDeckOfCards.isFlush(0));
	
		// shuffle cards
		myDeckOfCards.shuffle();
		myDeckOfCards.printDeck();
		
		System.out.printf("Is the first five cards is a flush? %b%n",
		         myDeckOfCards.isFlush(0));
	

	}
	







	//  NOTE  THE FOLLOWING TESTS WILL BE RUN AFTER INLAB PROBLEMS SOLVED
	//  NOW THEY ARE COMMENTED OUT




	


    // PART2 inlab DeckOfCards problem tests
	private static void inlabCardDeck() {



		// Create a  new Deck
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.printDeck();
		
		
		// get a shuffled Card array, DeckOfCards still not shuffled
		Card[] cardArray = myDeckOfCards.shuffle2();
		myDeckOfCards.printDeck(cardArray);
		
		
		// This must be true, myDeckOfCards not shuffled yet
	    System.out.println(myDeckOfCards.isFlush(0));
		
		// This is probably false, newDeck is shuffled
		System.out.println(myDeckOfCards.isFlush(cardArray,0));
		
		// get a hand from the unshuffled one 
		Card[] hand = myDeckOfCards.deal5();
		
		// This should be true
		System.out.println(myDeckOfCards.isFlush(hand));
		
		
		System.out.printf("Number of Card instances should be still 52: %d%n",
		           Card.getCardCount());

		
		DeckOfCards secondDeckOfCards = new DeckOfCards();
		secondDeckOfCards.shuffle();
		hand = secondDeckOfCards.deal5();
		myDeckOfCards.printDeck(hand);
		
		
		// This is probably false
		System.out.println(myDeckOfCards.isFlush(hand));
		
		
		System.out.printf("Number of Card instances should be 104: %d%n",
		           Card.getCardCount());
		
		//Mevlut's tester
		
		//cardArray[0].setSuit("!!!!!!!!!!!");
		//myDeckOfCards.printDeck(cardArray);
		//myDeckOfCards.printDeck();

	}





	
	
	
	// PART3 inlab Array problems tests
	private static void inlabArrays() {



	    // Part3.1
		
		int[] arr = {2,6,4,2,1,2,3,1};
		System.out.printf("This should be true: %b%n",isArraySpecial(arr,0));
		arr[1]=8;
		System.out.printf("This should be false: %b%n",isArraySpecial(arr,0));
		
		
		//Part 3.2
		char[] pattern1 = {'E','L','L','\0'};
 			
		char[] str = new char[10];
		
	    printStr(pattern1);
	    System.out.println();
		System.out.println(lenStr(pattern1));
		
	    insert(str,'O',0);
		insert(str,'L',0);
	    insert(str,'L',0);
		insert(str,'E',0);
		insert(str,'H',0);
		
		
		printStr(str);	
		System.out.println();
		
		delete(str,'E');
		
		printStr(str);
		System.out.println();
		
		insert(str,'E',lenStr(str));
		
		printStr(str);
		System.out.println();
	
	}
	

	
	// ADD methods for PART3 below
	
	//PART 3.1 recursive method
	
	public static boolean isArraySpecial(int[] arr, int index) {
		
		//Creating an array that excludes the boundry points of arr
		int[] myArr = new int[Math.max(arr.length-2, 0)];
		for(int i=1; i<arr.length-1 ;i++) {
			myArr[i-1] = arr[i];
		}
		
		
		
		//base case, either empty or a single element
		if(arr.length == 1 || arr.length == 0) {
			return true;
		}
		
		//induction using recursion
		if(arr[0] == 2*arr[arr.length-1] && isArraySpecial(myArr, 0)) {
			return true;
		}
		else
			return false;
	}
	
	








	
	
	
	
    // PART 3.2 char array methods
	public static void delete(char[] str, char c) {
		int index = -666;
		for(int i=0; i<lenStr(str) ;i++) {
			if(str[i] == c) {
				index = i;
				break;
			}
		}
		if(index != -666) {
			for(int i = index+1; i<lenStr(str) ;i++) {
				str[i-1] = str[i];
			}
		}
	}
	
	public static void insert(char[] str, char c, int index){
	
		if(str.length-1 == lenStr(str) || index > lenStr(str)) {
			int dummy = 0;
		}
		else {
			for(int i=lenStr(str); i>index ;i--) {
				str[i] = str[i-1];
			}
			str[index] = c;
		}
	
	}












	
	/////// DO NOT CHANGE BELOW
	
	// return length of the string str
	public static int lenStr(char[] str) {
	    int i;
	    for(i=0;i<str.length && (str[i]!='\0'); i++);
	    return i;
	}

	// print the string str
	public static void printStr(char[] str) {
	    for(int i=0;i<str.length && (str[i]!='\0'); i++)
	       System.out.print(str[i]);
	}

	


}
