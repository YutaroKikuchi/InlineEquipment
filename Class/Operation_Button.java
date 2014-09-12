package Class;

import lejos.hardware.Button;

/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:57
 */
public class Operation_Button {

	public Operation_Part Operation_Part;

	String SwitchMode;
	
	public Operation_Button(String mode){
		SwitchMode = mode;
	}

	public void finalize() throws Throwable {

	}

	public void Pushdown(){
		if((SwitchMode=="stop" && Button.DOWN.isDown()==true)||(Button.ENTER.isDown()==true && SwitchMode=="start")){
			Pushdown_Event();
		}
	}

	public void Pushdown_Event(){
		try{
			System.out.println(10/0);
		}catch(ArithmeticException err){
			throw err;
		}
	}

}