package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberStandardOutputView implements DrawNumberView{
    @Override 
    public void start(){
    
    }
    @Override
    public void setController(DrawNumberController controller){

    }
    @Override
    public void result(DrawResult result){
        IO.println("Result: " + result.getDescription());
    }
}