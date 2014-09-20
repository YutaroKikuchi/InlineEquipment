package Test;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
import Class.Before_Equipment;
import Class.Moving_Part;
import Class.Moving_Stage;
import Class.Sensor;
import Class.TreatingUnit;
import Constants.IEConstants;

public class UnitTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Moving_Stage();
	}
	
	private static void TreatingUnitTest(){
		
		TreatingUnit aaa = new TreatingUnit();
		float[] color = {0,0,0};
		
		while(true){
			aaa.Treating(color);
			
			LCD.clear();
			
			for(int j=0;j<3;j++){
				LCD.drawString("color["+j+"] = "+color[j],0,j);
			}
			
			LCD.refresh();
			
			if(Button.waitForAnyEvent()==2){
				break;
			}
		}
	}
	
	private static void SensorTest(){
		float[] testValue = new float[IEConstants.SNC.sampleSize()];
		Sensor aaa = new Sensor();
		
		while(true){
			aaa.Get_Status(testValue);
			LCD.clear();
			for(int i=0;i<IEConstants.SNC.sampleSize();i++){
				LCD.drawString("value[" +i+"]= "+testValue[i], 0, i);
			}
			if(Button.waitForAnyPress()==32){
				break;
			}
		}
	}
	
	private static void Moving_Stage(){
		Moving_Stage aaa = new Moving_Stage();
		
		while(true){
		aaa.Unlock_Moving();
		aaa.Moving();
		aaa.Lock_Moving();
		aaa.Moving();
		if(Button.waitForAnyPress()==32){
			break;
		}
		aaa.Unlock_Moving();
		aaa.Moving_After();
		aaa.Lock_Moving();
		}
	}
	
	private static void Before_EquipmentTest(){
		Before_Equipment aaa = new Before_Equipment();
		
		while(true){
			//log("Give_Sample");
			aaa.Give_Sample();
			
			if(Button.waitForAnyPress()==32){
				break;
			}
		}
	}
	
	/*
	private static void IntroduceAreaTest(){
		IntroduceAreaTest
	}
	*/
	private static void log(String in){
		System.out.println(in);
	}

}
