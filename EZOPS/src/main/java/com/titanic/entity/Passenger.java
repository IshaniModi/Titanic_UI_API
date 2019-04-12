package com.titanic.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Passenger")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Passenger {


    public String getCabin() {
        return Cabin;
    }

    public void setCabin(String cabin) {
        Cabin = cabin;
    }

    @Id
     int PassengerId;
    int Pclass	;
    String Name1	;

    public String getName2() {
        return Name2;
    }

    public void setName2(String name2) {
        Name2 = name2;
    }

    String Name2;
    String Sex	;
    Float Age;
    int SibSp;
    int Parch;
    String Ticket;
    Float Fare;
    String Cabin;
    Character Embarked;

    public Passenger()
    {

    }
    public Passenger(int passengerId, int pclass, String name1, String name2, String sex, Float age, int sibSp, int parch, String ticket, Float fare, String cabin, Character embarked) {
        PassengerId = passengerId;
        Pclass = pclass;
        Name1 = name1;
        Name2 = name2;
        Sex = sex;
        Age = age;
        SibSp = sibSp;
        Parch = parch;
        Ticket = ticket;
        Fare = fare;
        Cabin = cabin;
        Embarked = embarked;
    }
    public int getPassengerId() {
        return PassengerId;
    }

    public void setPassengerId(int passengerId) {
        PassengerId = passengerId;
    }
    public int getPclass() {
        return Pclass;
    }

    public void setPclass(int pclass) {
        Pclass = pclass;
    }

    public String getName1() {
        return Name1;
    }

    public void setName1(String name1) {
        Name1 = name1;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public float getAge() {
        return Age;
    }

    public void setAge(Float age) {
        Age = age;
    }

    public int getSibSp() {
        return SibSp;
    }

    public void setSibSp(int sibSp) {
        SibSp = sibSp;
    }

    public int getParch() {
        return Parch;
    }

    public void setParch(int parch) {
        Parch = parch;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public Float getFare() {
        return Fare;
    }

    public void setFare(Float fare) {
        Fare = fare;
    }



    public Character getEmbarked() {
        return Embarked;
    }

    public void setEmbarked(Character embarked) {
        Embarked = embarked;
    }
}
