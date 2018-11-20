package com.thanksgivingProject.game.Entity;

import javax.persistence.*;

@Entity(name = "ITEMS")
public class Item {
    //Item has an Id and name

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long id;

    @Column(name = "ITEM_NAME")
    private String name;

    public Item(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Item(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Item(String name){
        this.name = name;
    }

}
