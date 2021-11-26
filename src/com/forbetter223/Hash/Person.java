package com.forbetter223.Hash;

public class Person {
    public int ID;
    public String name;
    public Person next;

    public Person(int pID, String pName){
        this.ID = pID;
        this.name = pName;
        this.next = null;
    }

    public void print(){
        System.out.printf("ID = %d, name = %s \n",this.ID,this.name);
    }
}
