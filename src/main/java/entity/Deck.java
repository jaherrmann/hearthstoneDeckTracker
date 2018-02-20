package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A class that will represent a users deck
 */
@Entity(name = "Deck")
@Table(name = "deck")
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "rarity")
    private String rarity;

    @Column(name = "mana_cost")
    private int mana_cost;

    @Column(name = "card_set")
    private String card_set;

    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Stats> stats = new HashSet<>();

    /**
     * No argument constructor
     */
    public Deck(){

    }

    /**
     * Instantiates a new deck
     * @param name
     * @param rarity
     * @param mana_cost
     * @param card_set
     */
    public Deck(String name, String rarity, int mana_cost, String card_set){
        this.name = name;
        this.rarity = rarity;
        this.mana_cost = mana_cost;
        this.card_set = card_set;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getMana_cost() {
        return mana_cost;
    }

    public void setMana_cost(int mana_cost) {
        this.mana_cost = mana_cost;
    }

    public String getSet() {
        return card_set;
    }

    public void setSet(String set) {
        this.card_set = set;
    }

    public void addStat(Stats stat) {
        stats.add(stat);
        stat.setDeck(this);
    }

    public void removeStat(Stats stat){
        stats.remove(stat);
        stat.setDeck(null);
    }

//    public Set<Stats> getStats() {
//        return stats;
//    }
//
//    public void setStats(Set<Stats> stats) {
//        this.stats = stats;
//    }
}
