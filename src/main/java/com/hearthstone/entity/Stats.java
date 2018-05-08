package com.hearthstone.entity;

//import com.hearthstone.entity.Deck;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * This class will represent the stats tables
 * @author jeff
 */
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
    private double winPercentage;

    @Column(name = "deck_id")
    private int deck_id;

    /**
     * no-argument constructor
     */
    public Stats(){
    }

    /**
     * This is the construcor
     * @param wins wins
     * @param losses losses
     * @param winPercentage winPercentage
     * @param deck_id deck_id
     */
    public Stats(int wins, int losses, int winPercentage, int deck_id){
        this.wins = wins;
        this.losses = losses;
        this.winPercentage = winPercentage;
        this.deck_id = deck_id;
    }

    /**
     * This will get the deck_id
     * @return deck_id the deckId number
     */
    public int getDeck_id() {
        return deck_id;
    }

    /**
     * this will set the deck_id number
     * @param deck_id the deckId nyumber
     */
    public void setDeck_id(int deck_id) {
        this.deck_id = deck_id;
    }

    /**
     * Get the wins
     * @return wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Set the wins
     * @param wins wins
     */
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     * Get the losses
     * @return losses
     */
    public int getLosses() {
        return losses;
    }

    /**
     * This will set the losses
     * @param losses the losses
     */
    public void setLosses(int losses) {
        this.losses = losses;
    }

    /**
     * This wil get the winPercentage
     * @return winPercentage
     */
    public double getWinPercentage() {
        return winPercentage;
    }

    /**
     * Set the win percentage
     * @param winPercentage winPercentage
     */
    public void setWinPercentage(double winPercentage) {
        this.winPercentage = winPercentage;
    }

    /**
     * This will get the id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * This will set the id
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * simple toString method
     * @return the stats string
     */
    @Override
    public String toString() {
        return "Stats{" +
                "id=" + id +
//                ", decklist=" + decklist +
                '}';
    }
}
