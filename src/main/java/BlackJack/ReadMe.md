#1.Clarify

## 1.1 what
  Deck Player Dealer  Hand Card Suit 

  
## 1.2 How
   - Player: <br>
    How many player can be supported in a table?<br>
    Is there a fixed dealer or one of the players take turns to be a dealer.
    
   - rule: <br>
   What if we run out of cards?<br>
   Can dealer run out of bets? 
    
  c. win / lose / draw
  
  
  d. Points
  - initial bets for each player?
  
# 2. Core Objects
  Deck: 
    List<player>
    Dealer
    List<Card>
    totalBets;
  
  Player:
    Hand hand;
    int bets;
    
  Dealer:
    Hand hand
    
  Hand:
    List<Card>
    
  Card:
    Suit
    
  <<Suit>>:
    Spades,
    Hearts,
    Diamonds,
    CLUBS
    
# 3. Use Cases:
  ## 1.Initialize:
  - add players
  - shuffle cards
  - player place bets
  - dealer deal initial cards
  
  ## 2. Play
  - Deal
  - Increase bets
  - Stop dealing
  
  
  ## 3. win/lose/draw check
  - Compare score
  - Take / lose bets.