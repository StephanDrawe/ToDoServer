package com.revature.models;

import javax.persistence.*;

@Entity
@Table
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    private boolean isFinished;

//    no-args constructors
    public ToDo(){

    }

//    getters
    public int getId(){
        return this.id;
    }
    public String getBody(){
        return this.text;
    }
    public boolean getFinished(){
        return this.isFinished;
    }

//    setters
    public void setId(int id){
        this.id = id;
    }
    public void setBody(String text){
        this.text = text;
    }
    public void setFinished(boolean isFinished){
        this.isFinished = isFinished;
    }


}
