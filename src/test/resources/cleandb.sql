delete from deck;
#delete from stats;
alter table deck AUTO_INCREMENT = 1;
#alter table stats AUTO_INCREMENT = 1;
insert into deck (name, rarity, mana_cost, card_set) VALUES('Lyra the Sunshard', 'Legendary', 5, 'Journey to Ungoro'),('Northshire Cleric', 'Common', 1, 'Basic'),('Prince Keleseth', 'Legendary', 2, 'Knights of the Frozen Throne'),('Nzoth, the Corruptor', 'Legenday', 10, 'Whispers of the Old Gods'),('Duskbreaker', 'Rare', 4, 'Kobolds and Catacombs');
#INSERT INTO stats VALUES (1,3,'Jeffs Deck'),(2,5,'Big'),(3,2,'Spell'),(4,1,'Miracle'),(5,4,'Aggro'),(6,3,'Token'),(7,1,'Pirate');