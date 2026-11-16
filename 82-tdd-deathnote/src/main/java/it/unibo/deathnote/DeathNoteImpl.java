/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package it.unibo.deathnote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.unibo.deathnote.api.DeathNote;

/**
 *
 * @author matti
 */
public class DeathNoteImpl implements DeathNote{
    List<String> peopleKilled = new ArrayList<>();
    Map<String,String> causes = new HashMap<>();
    Map<String,String> details = new HashMap<>();
    long lastKill;
    long lastCause;

    @Override 
    public String getRule(int ruleNumber){
        if (ruleNumber < 1 || ruleNumber > RULES.size()){
            throw new IllegalArgumentException();
        }
        return RULES.get(ruleNumber - 1);
    }
    @Override 
    public void writeName(String name)throws NullPointerException{
        if (name == null) {
            throw new NullPointerException("name given is null");
        }
        peopleKilled.add(name);
        causes.put(name, "heart attack");
        details.put(name, "");
        lastKill = System.currentTimeMillis();
        lastCause = 0;
    }
    @Override 
    public boolean writeDeathCause(String cause){
        if (peopleKilled.isEmpty() || cause == null || cause.isBlank()){
            throw new IllegalStateException();
        }
        if (System.currentTimeMillis() > lastKill + 40 ){
            return false;
        }
        String lastName = peopleKilled.getLast();
        causes.put(lastName, cause);
        lastCause = System.currentTimeMillis();
        return true;
    }
    @Override 
    public boolean writeDetails(String details){
        if (peopleKilled.isEmpty() || details == null || details.isBlank()){
            throw new IllegalStateException();
        }
        if (System.currentTimeMillis() > lastCause + 6040 ){
            return false;
        }
        String lastName = peopleKilled.getLast();
        this.details.put(lastName, details);
        return true;
    }
    @Override
    public String getDeathCause(String name){
        if (peopleKilled.contains(name)) {
            return causes.get(name);
        }
        throw new IllegalArgumentException();
    }
    @Override
    public String getDeathDetails(String name){
        if (peopleKilled.contains(name)) {
            return details.get(name);
        }
        throw new IllegalArgumentException();
    }
    @Override
    public boolean isNameWritten(String name){
        return peopleKilled.contains(name);
    }
}
