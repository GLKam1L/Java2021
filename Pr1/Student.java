package ru.mirea.java2021.ikbo2019.iskhakov;

public class Student{
    private String name;
    private int scores;
    public Student(String name, int scores){
        this.name = name;
        this.scores = scores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public int getScores() {
        return scores;
    }


}
