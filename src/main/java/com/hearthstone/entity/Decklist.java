package com.hearthstone.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class that will represent a users deck
 */
@Entity(name = "Decklist")
@Table(name = "decklist")
public class Decklist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH})
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "card1")
    private String card1;

    @Column(name = "card2")
    private String card2;

    @Column(name = "card3")
    private String card3;

    @Column(name = "card4")
    private String card4;

    @Column(name = "card5")
    private String card5;

    @Column(name = "card6")
    private String card6;

    @Column(name = "card7")
    private String card7;

    @Column(name = "card8")
    private String card8;

    @Column(name = "card9")
    private String card9;

    @Column(name = "card10")
    private String card10;

    @Column(name = "card11")
    private String card11;

    @Column(name = "card12")
    private String card12;

    @Column(name = "card13")
    private String card13;

    @Column(name = "card14")
    private String card14;

    @Column(name = "card15")
    private String card15;

    @Column(name = "card16")
    private String card16;

    @Column(name = "card17")
    private String card17;

    @Column(name = "card18")
    private String card18;

    @Column(name = "card19")
    private String card19;

    @Column(name = "card20")
    private String card20;

    @Column(name = "card21")
    private String card21;

    @Column(name = "card22")
    private String card22;

    @Column(name = "card23")
    private String card23;

    @Column(name = "card24")
    private String card24;

    @Column(name = "card25")
    private String card25;

    @Column(name = "card26")
    private String card26;

    @Column(name = "card27")
    private String card27;

    @Column(name = "card28")
    private String card28;

    @Column(name = "card29")
    private String card29;

    @Column(name = "card30")
    private String card30;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getCard1() {
        return card1;
    }

    public void setCard1(String card1) {
        this.card1 = card1;
    }

    public String getCard2() {
        return card2;
    }

    public void setCard2(String card2) {
        this.card2 = card2;
    }

    public String getCard3() {
        return card3;
    }

    public void setCard3(String card3) {
        this.card3 = card3;
    }

    public String getCard4() {
        return card4;
    }

    public void setCard4(String card4) {
        this.card4 = card4;
    }

    public String getCard5() {
        return card5;
    }

    public void setCard5(String card5) {
        this.card5 = card5;
    }

    public String getCard6() {
        return card6;
    }

    public void setCard6(String card6) {
        this.card6 = card6;
    }

    public String getCard7() {
        return card7;
    }

    public void setCard7(String card7) {
        this.card7 = card7;
    }

    public String getCard8() {
        return card8;
    }

    public void setCard8(String card8) {
        this.card8 = card8;
    }

    public String getCard9() {
        return card9;
    }

    public void setCard9(String card9) {
        this.card9 = card9;
    }

    public String getCard10() {
        return card10;
    }

    public void setCard10(String card10) {
        this.card10 = card10;
    }

    public String getCard11() {
        return card11;
    }

    public void setCard11(String card11) {
        this.card11 = card11;
    }

    public String getCard12() {
        return card12;
    }

    public void setCard12(String card12) {
        this.card12 = card12;
    }

    public String getCard13() {
        return card13;
    }

    public void setCard13(String card13) {
        this.card13 = card13;
    }

    public String getCard14() {
        return card14;
    }

    public void setCard14(String card14) {
        this.card14 = card14;
    }

    public String getCard15() {
        return card15;
    }

    public void setCard15(String card15) {
        this.card15 = card15;
    }

    public String getCard16() {
        return card16;
    }

    public void setCard16(String card16) {
        this.card16 = card16;
    }

    public String getCard17() {
        return card17;
    }

    public void setCard17(String card17) {
        this.card17 = card17;
    }

    public String getCard18() {
        return card18;
    }

    public void setCard18(String card18) {
        this.card18 = card18;
    }

    public String getCard19() {
        return card19;
    }

    public void setCard19(String card19) {
        this.card19 = card19;
    }

    public String getCard20() {
        return card20;
    }

    public void setCard20(String card20) {
        this.card20 = card20;
    }

    public String getCard21() {
        return card21;
    }

    public void setCard21(String card21) {
        this.card21 = card21;
    }

    public String getCard22() {
        return card22;
    }

    public void setCard22(String card22) {
        this.card22 = card22;
    }

    public String getCard23() {
        return card23;
    }

    public void setCard23(String card23) {
        this.card23 = card23;
    }

    public String getCard24() {
        return card24;
    }

    public void setCard24(String card24) {
        this.card24 = card24;
    }

    public String getCard25() {
        return card25;
    }

    public void setCard25(String card25) {
        this.card25 = card25;
    }

    public String getCard26() {
        return card26;
    }

    public void setCard26(String card26) {
        this.card26 = card26;
    }

    public String getCard27() {
        return card27;
    }

    public void setCard27(String card27) {
        this.card27 = card27;
    }

    public String getCard28() {
        return card28;
    }

    public void setCard28(String card28) {
        this.card28 = card28;
    }

    public String getCard29() {
        return card29;
    }

    public void setCard29(String card29) {
        this.card29 = card29;
    }

    public String getCard30() {
        return card30;
    }

    public void setCard30(String card30) {
        this.card30 = card30;
    }

    /**
     * No-argument constructor
     */
    public Decklist(){
    }
    /**
     * Instantiates a deck
     */
    public Decklist(String name, User user, String card1, String card2, String card3, String card4, String card5,
                    String card6, String card7, String card8, String card9, String card10, String card11,String card12,
                    String card13, String card14, String card15, String card16, String card17, String card18, String card19,
                    String card20, String card21, String card22, String card23, String card24, String card25, String card26,
                    String card27, String card28, String card29, String card30){
        this.user = user;
        this.name = name;
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
        this.card4 = card4;
        this.card5 = card5;
        this.card6 = card6;
        this.card7 = card7;
        this.card8 = card8;
        this.card9 = card9;
        this.card10 = card10;
        this.card11 = card11;
        this.card12 = card12;
        this.card13 = card13;
        this.card14 = card14;
        this.card15 = card15;
        this.card16 = card16;
        this.card17 = card17;
        this.card18 = card18;
        this.card19 = card19;
        this.card20 = card20;
        this.card21 = card21;
        this.card22 = card22;
        this.card23 = card23;
        this.card24 = card24;
        this.card25 = card25;
        this.card26 = card26;
        this.card27 = card27;
        this.card28 = card28;
        this.card29 = card29;
        this.card30 = card30;
    }
}