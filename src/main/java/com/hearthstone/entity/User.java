package com.hearthstone.entity;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "User")
@Table(name = "user")
/**
 * This entity maps out the relationships between the User and the Deck
 * @author jaherrmann
 */

public class User {

    @Column(name="user_name")
    private String user_name;

    @Column(name="user_password")
    private String user_password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private int id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Decklist> decklist = new HashSet<>();

    /**
     * No argument constructor
     */
    public User(){

    }

    /**
     * Instantiates a user
     * @param user_name username
     * @param user_password userPassword
     */
    public User(String user_name, String user_password){
        this.user_name = user_name;
        this.user_password = user_password;
    }

    /**
     * This will get the decklist from a user
     * @return decklist the decklist
     */
    public Set<Decklist> getDecklist() {
        return decklist;
    }

    /**
     * This will set a user's decklist
     * @param decklist decklist
     */
    public void setDecklist(Set<Decklist> decklist){
        this.decklist = decklist;
    }

    /**
     * Gets the user name
     * @return user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * Sets the user_)name
     * @param user_name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * Gets the user password
     * @return user_password
     */
    public String getUser_password() {
        return user_password;
    }

    /**
     * Sets the user_password
     * @param user_password
     */
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    /**
     * Gets the id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
}
