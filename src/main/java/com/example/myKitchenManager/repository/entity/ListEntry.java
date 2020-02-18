package com.example.myKitchenManager.repository.entity;

import javax.persistence.*;

@Entity
@Table(name="list_entry")
public class ListEntry {

    @Id
    @Column(name="list_entry_id")
    private int id;

//    @OneToMany(mappedBy="nationalityListEntry")
//    private List<Users> users;

    private String source;

    private String entry;

    public ListEntry() {
    }

    public ListEntry(int id, String source, String entry) {
        this.id = id;
        this.source = source;
        this.entry = entry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
