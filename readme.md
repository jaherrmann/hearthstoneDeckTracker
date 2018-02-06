# Jeff Herrmann Individual Project

## Problem

As an avid Hearthstone ranked player who enjoys climbing the HS ladder there is a need to determine which decks are more powerful than others, which decks have been good over which period, and which decks are most powerful overall. There are some very fancy, and powerful, ways to accomplish this--like using the Hearthstone Deck Tracker pluging for Windows. The downside for that plugin is that the player is not able to make on-the-fly adjustments to their deck without creating a new deck entirely. 

For instance I would not be able to remove just 1 card from the deck and keep the w-l percentage regardless of how many games I played.

My website solves that problem. It gives players a repository to store their cards, favorite decks, and ultimately determine how well their decks are performing. By giving the player powerful control over their statistics it will allow for better choices to be made out their in the wild. 

### Techniques

* Database
	* MySQL (any postgres love? No. None of that.)
	* Store users and their card collections
	* Store win loss percentages for all users spanning each deck they have saved.
	* Unlimited amount of decks(??)
* Dependency Management 	
	* Maven
* Hosting
	* AWS
* Layout
	*Bootstrap
* API
	* Will use a fancy hearthstone API that should give me some really cool card graphics. 

*** [Project Plan](ProjectPlan.md)
*** [Development Journal](Journal.md)
