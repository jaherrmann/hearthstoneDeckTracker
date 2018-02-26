# Database Design


### User

Description: This is the user's table. It will store the user's information as a unique primary key. Other columns include:
	*Name
	*Username
	*Email

### Decks

Description: This table will be a sort of cross-roads between the User and the Decks that the user will have. It will carry a primary key of a deck, and a foreign key of the user. One user can have many decks. Columns will include:
	*Id	
	*UserId

### Decklist

Description: This deck will be the holding table of all of the cards in a certain deck. Right now I'm storing each deck as a entire, large, comma separated list--I can't think of a better way to do this. I will un-spool the cards column when the time comes. This table will have no primary key, per se, but a foreign key that references the deck_id, which being inique, will serve as a suitable primary key here. 
	*Deck_Id
	*Cards
	*DeckName

### Stats

Description: The stats table will include a record of wins, losses, win percentage, and total games for a given deck. Primary key will be a unique, auto-incremented value, and the foreign key will be the deck_id. This table has a unique primary key because I can envision a scenario where I want to reference stats apart from the deck.
	*Id
	*Deck_id
	*Wins
	*Losses
	*Win%
	*TotalGames


 
I decided that because of the difficulty that would go along creating an environmental code calculator (depsite 
how much I would like to do one) would be entirely too much work to justify going that route. Instead I decided
to create a hearthstone deck tracker. This should be a fairly challenging project because there are over 400 cards currently available to choose from. This creates a world of deckbuilding possiblities and should be fun to create. I also created the scaffolding for the project and need to start looking into API's so that I don't have to create a database for every card ever printed! (This would be an awful idea an I would never do this.) I also finished all the week 3 stuff ahead of time for a first and am now on the 'lead lap' so to speak. Feels good. 


