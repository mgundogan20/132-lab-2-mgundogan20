// Fig. 7.9: Card.java
// Card class represents a playing card.

// PART1 RELATED CHANGES
// MARK YOUR CHANGES WITH A COMMENT STARTING WORD PART1

public class Card {
   private final String face; // face of card ("Ace", "Deuce", ...)
   private final String suit; // suit of card ("Hearts", "Diamonds", ...)
   //PART1
   private static int cardCount = 0;
  
   
   // two-argument constructor initializes card's face and suit
   public Card(String cardFace, String cardSuit) {
      this.face = cardFace; // initialize face of card
      this.suit = cardSuit; // initialize suit of card
      //PART1
      Card.cardCount++;
   } 
   
   
   //PART1
   public static int getCardCount() {
	   return Card.cardCount;
   }
   
   public String getSuit() {
	   return this.suit;
   }
   
   
   // return String representation of Card
   public String toString() {             
      return face + " of " + suit;        
   }                
} 

