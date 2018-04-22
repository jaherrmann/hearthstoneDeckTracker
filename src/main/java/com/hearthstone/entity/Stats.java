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
    private String wins;

    @Column(name = "losses")
    private String losses;

    @Column(name = "win_percentage")
    private int winPercentage;

//    @OneToMany(mappedBy = "deck_id", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JsonIgnore
//    private Set<Decklist> decklist = new HashSet<>();

    public Stats(){
    }


//    public Set<Decklist> getDecklist() {
//        return decklist;
//    }
//
//    public void setDecklist(Set<Decklist> decklist){
//        this.decklist = decklist;
//    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
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
