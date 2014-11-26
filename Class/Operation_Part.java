package Class;

import lejos.hardware.Button;
import lejos.hardware.Key;
import Constants.IEConstants;


/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:57
 */
public class Operation_Part {

	
	public Operation_Button StartButton;
	public Operation_Button StopButton;
	public Operation_Button OffButton;
	
	public Operation_Part(){
		StartButton = new Operation_Button(IEConstants.START);
		StopButton = new Operation_Button(IEConstants.STOP);
		OffButton = new Operation_Button(IEConstants.OFF);

	}

	public void finalize() throws Throwable {

	}
	
	public void StopThread(Key in){
		if(in == IEConstants.START){
			StartButton.setrunable(false);
		}else if(in == IEConstants.STOP){
			StopButton.setrunable(false);
		}else if(in == IEConstants.OFF){
			OffButton.setrunable(false);
		}
	}
	
	public void SetButton(Key in){
		if(in == IEConstants.START){
			StartButton = new Operation_Button(in);
		}else if(in == IEConstants.STOP){
			StopButton = new Operation_Button(in);
		}else if(in == IEConstants.OFF){
			OffButton = new Operation_Button(in);
		}
	}

}