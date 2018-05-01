delete from decklist;
delete from user;
delete from stats;
alter table stats AUTO_INCREMENT = 1;
alter table decklist AUTO_INCREMENT = 1;
alter table user AUTO_INCREMENT = 1;
insert into user(user_name, user_password) values("Action", "Jackson");
insert into decklist(name, user_id, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19, card20, card21, card22, card23, card24, card25, card26, card27, card28, card29, card30) VALUES ('ZooLock', 1 ,'Power Word: Shield', 'Fire Fly', 'Flame Imp', 'Flame Imp', 'Glacial Shard', 'Glacial Shard', 'Kobold Librarian', 'Kobold Librarian', 'Malchezaar''s Imp', 'Malchezaar''s Imp', 'Soulfire', 'Soulfire', 'Voidwalker', 'Voidwalker', 'Prince Keleseth', 'Darkshire Councilman', 'Darkshire Councilman', 'Dark Iron Dwarf', 'Dark Iron Dwarf', 'Saronite Chain Gang', 'Saronite Chain Gang', 'Spellbreaker', 'Spellbreaker', 'Despicable Dreadlord', 'Despicable Dreadlord', 'Doomguard', 'Doomguard', 'Fungalmancer', 'Fungalmancer', 'Leeroy Jenkins');
insert into stats(wins, losses, win_percentage, deck_id) VALUES (1, 2, 65, 1);

