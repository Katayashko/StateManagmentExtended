package com.example.statemanagmentextended;

import androidx.lifecycle.ViewModel;

public class CountViewModel extends ViewModel{
    private int count = 0;
    private boolean state;

    public int getcount(){
        return count;
    }

    public void incrementCount(){
        count++;
    }

    public void stateOn(){
        state = true;
    }

    public void stateOff(){
        state = false;
    }

    public boolean getState(){
        return state;
    }
}
