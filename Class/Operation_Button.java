package Class;

import lejos.hardware.Button;
import lejos.hardware.Key;

/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:57
 */
public class Operation_Button {

	public Operation_Part Operation_Part;

	String SwitchMode;
	Key button;
	
	public Operation_Button(Key button){
		this.button = button;
	}

	public void finalize() throws Throwable {

	}

	public void Pushdown(){
		if(button.isDown()==true){
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