package com.example.statemanagmentextended;

import androidx.lifecycle.ViewModel;

public class StateViewModel extends ViewModel{
    int licznik = 0;
    String tekst;
    boolean stanCB;
    boolean stanS;

    public int getcount(){
        return licznik;
    }

    public void incrementCount(){
        licznik++;
    }

    public void stateCBOn(){
        stanCB = true;
    }

    public void stateCBOff(){
        stanCB = false;
    }

    public boolean getStateCB(){
        return stanCB;
    }

}
