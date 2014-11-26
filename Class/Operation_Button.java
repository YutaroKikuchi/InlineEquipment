package Class;

import lejos.hardware.Button;
import lejos.hardware.Key;

/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:57
 */
public class Operation_Button extends Thread{

	public Operation_Part Operation_Part;

	private Key button;
	private boolean buttonflag;
	private boolean runable;
	
	public Operation_Button(Key button){
		this.button = button;
		this.buttonflag = false;
		this.runable = false;
	}

	public void finalize() throws Throwable {

	}
	
	public void run(){
		runable = true;
		buttonflag = false;
		
		while(runable==true){
			try {
				Pushdown();
			} catch (ButtonException e) {
				buttonflag = true;
				runable=false;
				break;
			}
		}
	}

	public void Pushdown() throws ButtonException{
		if(button.isDown()==true){
			Pushdown_Event();
		}
	}

	public void Pushdown_Event() throws ButtonException{
		throw new ButtonException("Pressed Button");
	}
	
	public boolean getbuttonflag(){
		return buttonflag;
	}
	
	public void setrunable(boolean in){
		runable = in;
	}
	
	public class ButtonException extends Exception {
	    private static final long serialVersionUID = 1L;
	    public ButtonException(String message) {
	        super(message);
	    }
	}
}