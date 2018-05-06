package com.hearthstone.entity;

//import com.hearthstone.entity.Deck;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Stats")
@Table(name = "stats")
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "wins")
    private int wins;

    @Column(name = "losses")
    private int losses;

    @Column(name = "win_percentage")
    private int winPercentage;

    @Column(name = "deck_id")
    private int deck_id;


    public Stats(){
    }

    public Stats(int wins, int losses, int winPercentage, int deck_id){
        this.wins = wins;
        this.losses = losses;
        this.winPercentage = winPercentage;
        this.deck_id = deck_id;
    }


//    public Set<Decklist> getDecklist() {
//        return decklist;
//    }
//
//    public void setDecklist(Set<Decklist> decklist){
//        this.decklist = decklist;
//    }
    public int getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(int deck_id) {
        this.deck_id = deck_id;
    }


    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(int winPercentage) {
        this.winPercentage = winPercentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Stats{" +
                "id=" + id +
//                ", decklist=" + decklist +
                '}';
    }
}
