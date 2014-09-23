package Test;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
import Class.Before_Equipment;
import Class.DischargeArea;
import Class.Moving_Part;
import Class.Moving_Stage;
import Class.Sensor;
import Class.TreatingUnit;
import Constants.IEConstants;

public class UnitTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DischargeAreaTest();
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
	
	private static void DischargeAreaTest(){
		DischargeArea aaa = new DischargeArea();
		String color=IEConstants.UDF;
		int command=0;
		
		while(true){
			command = Button.waitForAnyPress();
			LCD.clear();
			LCD.drawString("colors[0] = "+aaa.getColor0(), 0, 0);
			LCD.drawString("colors[1] = "+aaa.getColor1(), 0, 1);
			
			switch(command){
			case 4:
				color=IEConstants.RED;
				aaa.setColor(color);
				LCD.drawString("Inserted "+IEConstants.RED, 0, 3);
				break;
			case 1:
				color=IEConstants.BLUE;
				aaa.setColor(color);
				LCD.drawString("Inserted "+IEConstants.BLUE, 0, 3);
				break;
			case 16:
				color=IEConstants.GRN;
				aaa.setColor(color);
				LCD.drawString("Inserted "+IEConstants.GRN, 0, 3);
				break;
			case 8:
				color=IEConstants.BLK;
				aaa.setColor(color);
				LCD.drawString("Inserted "+IEConstants.BLK, 0, 3);
				break;
			case 2:
				color=IEConstants.YLW;
				aaa.setColor(color);
				LCD.drawString("Inserted "+IEConstants.YLW, 0, 3);
				break;
			case 32:
				color=IEConstants.UDF;
				aaa.setColor(color);
				LCD.drawString("Inserted "+IEConstants.UDF, 0, 3);
				break;
			default:
				LCD.drawString("ERROR", 0, 3);
				break;
			}
			
			aaa.Treating();
			
			if(Button.waitForAnyPress()==32){
				break;
			}
			
			LCD.refresh();
		}
		IEConstants.DIS.rotateTo(0);
	}
	
	private void TreatingAreaTest(){
		
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
