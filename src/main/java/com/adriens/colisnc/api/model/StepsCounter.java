/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.colisnc.api.model;

/**
 *
 * @author 3004SAL
 */
public class StepsCounter {
    private int nbSteps;
    
    public StepsCounter(){
        
    }
    
    public StepsCounter(int nbSteps){
        this.nbSteps = nbSteps;
    }

    /**
     * @return the nbSteps
     */
    public int getNbSteps() {
        return nbSteps;
    }

    /**
     * @param nbSteps the nbSteps to set
     */
    public void setNbSteps(int nbSteps) {
        this.nbSteps = nbSteps;
    }
    
    
}
