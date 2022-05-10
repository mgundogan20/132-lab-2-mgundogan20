// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.security.SecureRandom;



///////////////////////////////////////////////////////////////////
//
//
//     PART1 and PART2 
//     ADD ALL YOUR CODE AT THE END OF THE CLASS               
//     Note: This class has overloaded print deck methods (textbook version does not have)
///////////////////////////////////////////////////////////////////

public class DeckOfCards {
   // random number generator
   private static final SecureRandom randomNumbers = new SecureRandom();
   private static final int NUMBER_OF_CARDS = 52; // constant # of Cards

   private Card[] deck = new Card[NUMBER_OF_CARDS]; // Card references
   private int currentCard = 0; // index of next Card to be dealt (0-51)

   // constructor fills deck of Cards
   public DeckOfCards() {
      String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};    
      String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};      

      // populate deck with Card objects                   
      for (int count = 0; count < deck.length; count++) {  
         deck[count] =                                     
            new Card(faces[count % 13], suits[count / 13]);
      }                                                    
   } 

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle() {
      // next call to method dealCard should start at deck[0] again
      currentCard = 0; 

      // for each Card, pick another random Card (0-51) and swap them
      for (int first = 0; first < deck.length; first++) {
         // select a random number between 0 and 51 
         int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

         // swap current Card with randomly selected Card
         Card temp = deck[first];   
         deck[first] = deck[second];
         deck[second] = temp;       
      } 
   } 

   // deal one Card
   public Card dealCard() {
      // determine whether Cards remain to be dealt
      if (currentCard < deck.length) {
         return deck[currentCard++]; // return current Card in array
      } 
      else {
         return null; // return null to indicate that all Cards were dealt
      } 
   }
   
   // for printing the deck
   public void printDeck() {
	      // print all 52 Cards in the order they are stored in the deck
	      System.out.println("Printing Deck ");
	      for (int i = 0; i < 52; i++) {
	         // deal and display a Card
	         System.out.printf("%-19s", deck[i]);
	         if ((i+1) % 4 == 0) { // output a newline after every fourth card
	            System.out.println();
	         } 
	      } 
	      System.out.printf("End of Deck%n%n");  
   }
   
   // overload printDeck, for printing a given Card Array
   public void printDeck(Card[] cardArray) {
	      // print all  Cards in the order they are stored in the cardArray
	      System.out.println("Printing Deck ");
	      for (int i = 0; i < cardArray.length; i++) {
	         // deal and display a Card
	         System.out.printf("%-19s", cardArray[i]);
	         if ((i+1) % 4 == 0) { // output a newline after every fourth card
	            System.out.println();
	         } 
	      } 
	      System.out.printf("End of Deck%n%n");  
   }
   
   
   
   ///////////////////////////////////////////////////
   //// ADD YOUR CHANGES AFTER THIS POINT ////////////

   
   // Prelab 
   // complete isFlush
   public boolean isFlush(int start) {
	   boolean output = true;
	   
	   if(start > this.deck.length-5)
		   output = false;
	   else
		   for(int i=0 ; i<5 ; i++) {
			   if(this.deck[start].getSuit().equals(this.deck[start+i].getSuit()) == false) {
				   output = false;
			   }
		   }
	   return output;
   }
   
   //Inlab
   // overloading isFlush for a given hand
   
   public static boolean isFlush(Card[] hand) {
	   boolean output = true;
	   
	   if(hand.length < 5)
		   output = false;
	   else
		   for(int i=0 ; i<5 ; i++) {
			   if(hand[0].getSuit().equals(hand[0+i].getSuit()) == false) {
				   output = false;
			   }
		   }
	   return output;
   }
   
   public static boolean isFlush(Card[] deck, int start) {
	   boolean output = true;
	   
	   if(start > deck.length-5)
		   output = false;
	   else
		   for(int i=0 ; i<5 ; i++) {
			   if(deck[start].getSuit().equals(deck[start+i].getSuit()) == false) {
				   output = false;
			   }
		   }
	   return output;
   }
   
   public Card[] shuffle2() {
	   Card swap[] = this.deck.clone();
	   
	   currentCard = 0; 

	   for (int first = 0; first < swap.length; first++) 
	   {
		   int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

	       Card temp = swap[first];   
	       swap[first] = swap[second];
	       swap[second] = temp;       
	   }
	   
	   return swap;
	   
   }

   public Card[] deal5() {
	   Card hand[] = new Card[5];
	   
	   for(int i=0; i<5 ;i++) {
		   hand[i] = this.dealCard();
	   }
	   
	   return hand;
   }
} 






























