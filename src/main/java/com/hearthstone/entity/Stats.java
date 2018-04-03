package com.hearthstone.entity;

import com.hearthstone.entity.Deck;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Stats")
@Table(name = "stats")
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;


    private String description;

    @ManyToOne
    private Deck deck;


    public Stats(){
    }

    public Stats(String description, Deck deck) {
        this.deck = deck;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", deck=" + deck +
                '}';
    }
}
