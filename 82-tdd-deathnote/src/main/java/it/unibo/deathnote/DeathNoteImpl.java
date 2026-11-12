/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package it.unibo.deathnote;

import it.unibo.deathnote.api.DeathNote;

/**
 *
 * @author matti
 */
public class DeathNoteImpl implements DeathNote{
    @Override 
    public String getRule(int ruleNumber){
        throw new IllegalStateException();
    }
    @Override 
    public void writeName(String name){
        throw new IllegalStateException();
    }
    @Override 
    public boolean writeDeathCause(String cause){
        throw new IllegalStateException();
    }
    @Override 
    public boolean writeDetails(String details){
        throw new IllegalStateException();
    }
    @Override
    public String getDeathCause(String name){
        throw new IllegalStateException();
    }
    @Override
    public String getDeathDetails(String name){
        throw new IllegalStateException();
    }
    @Override
    public boolean isNameWritten(String name){
        throw new IllegalStateException();
    }
}
