delete from deck;
delete from stats;
delete from decklist;
delete from user;

alter table deck AUTO_INCREMENT = 1;
alter table stats AUTO_INCREMENT = 1;
alter table decklist AUTO_INCREMENT = 1;
alter table user AUTO_INCREMENT = 1;

insert into deck (name, rarity, mana_cost, card_set) VALUES('Lyra the Sunshard', 'Legendary', 5, 'Journey to Ungoro'),('Northshire Cleric', 'Common', 1, 'Basic'),('Prince Keleseth', 'Legendary', 2, 'Knights of the Frozen Throne'),('Nzoth, the Corruptor', 'Legenday', 10, 'Whispers of the Old Gods'),('Duskbreaker', 'Rare', 4, 'Kobolds and Catacombs');
INSERT INTO stats VALUES (1,3,'Jeffs Deck'),(2,5,'Big'),(3,2,'Spell'),(4,1,'Miracle'),(5,4,'Aggro'),(6,3,'Token'),(7,1,'Pirate');

insert into user(id) values(1);
insert into decklist(name, user_id, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19, card20, card21, card22, card23, card24, card25, card26, card27, card28, card29, card30) VALUES ('ZooLock', 1, 'Fire Fly', 'Fire Fly', 'Flame Imp', 'Flame Imp', 'Glacial Shard', 'Glacial Shard', 'Kobold Librarian', 'Kobold Librarian', 'Malchezaars Imp', 'Malchezaars Imp', 'Soulfire', 'Soulfire', 'Voidwalker', 'Voidwalker', 'Prince Keleseth', 'Darkshire Councilman', 'Darkshire Councilman', 'Dark Iron Dwarf', 'Dark Iron Dwarf', 'Saronite Chain Gang', 'Saronite Chain Gang', 'Spellbreaker', 'Spellbreaker', 'Despicable Dreadlord', 'Despicable Dreadlord', 'Doomguard', 'Doomguard', 'Fungalmancer', 'Fungalmancer', 'Leeroy Jenkins');



