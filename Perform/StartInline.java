package Perform;

import lejos.hardware.lcd.LCD;
import Class.Inline_Equipment;

public class StartInline {

	public static void main(String[] args) {
		Inline_Equipment ie = new Inline_Equipment();
		
		for(int i=0;i<3;i++){
			ie.Action_Stop();
			
			if(ie.getpower()==false){
				break;
			}
			
			ie.Action_Start();
		}

	}

}

//java.lang.IllegalThreadStateException