package Test;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
import Class.Before_Equipment;
import Class.DischargeArea;
import Class.IntroduceArea;
import Class.Moving_Part;
import Class.Moving_Stage;
import Class.Operation_Button.ButtonException;
import Class.Operation_Part;
import Class.Sensor;
import Class.TreatArea;
import Class.TreatingUnit;
import Constants.IEConstants;

public class UnitTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Moving_StageTest();
	}
	
	private static void TreatingUnitTest(){	//カラーセンサからのRGB値を取得します
		
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
	
	private static void SensorTest(){	//超音波センサから取得した値を表示します
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
	
	private static void Moving_StageTest(){
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
			LCD.drawString("currentcolor="+aaa.Area_Sample.Treat_Log.getColor(), 0, 0);
			
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
	
	private static void TreatingAreaTest(){
		TreatArea aaa = new TreatArea();
		String bbb = "";
		float[] colorvalue = new float[3];
		
		while(true){
			LCD.clear();
			aaa.Treat_Sample();
			bbb = aaa.Area_Sample.getID()+" , "+aaa.Area_Sample.Treat_Log.getColor()+" , "+aaa.Area_Sample.Treat_Log.returnTake_After();
			aaa.TreatingPart.TreatingUnit.Treating(colorvalue);
			LCD.drawString(bbb, 0, 0);
			for(int i=0;i<3;i++){
				LCD.drawString("color["+i+"]="+colorvalue[i], 0, i+1);
			}

			if(Button.waitForAnyPress()==32){
				break;
			}
		}
		LCD.refresh();
	}
	
	private static void BeforeEquip_SensorTest(){
		Before_Equipment aaa = new Before_Equipment();
		Sensor bbb = new Sensor();
		
		float[] value = new float[10];
		while(true){
			LCD.clear();
			aaa.Give_Sample();
			bbb.Get_Status(value);
			
			LCD.drawString("value="+value[0], 0, 0);
			
			if(Button.waitForAnyPress()==32){
				break;
			}
		}
		LCD.refresh();
	}
	
	private static void IntroduceAreaTest(){
		IntroduceArea aaa = new IntroduceArea();
		Before_Equipment bbb = new Before_Equipment();
		
		while(true){
			LCD.clear();
			if(aaa.Tell_Sample()==true){
				LCD.drawString("true", 0, 0);
			}else{
				LCD.drawString("false", 0, 0);
				bbb.Give_Sample();
			}
			
			if(Button.waitForAnyPress()==32){
				break;
			}
		}
		LCD.refresh();
	}
	
	private static void OperationButtonTest(){
		Operation_Part aaa = new Operation_Part();
		int bbb=0; 
		LCD.clear();
		for(int i=0;i<6;i++){
			aaa.StartButton.start();
			aaa.OffButton.start();
			while(true){
				try{
					Delay.msDelay(500);
					LCD.drawString(aaa.StartButton.getName(), 0, 0);
					LCD.drawString(aaa.OffButton.getName(), 0, 1);
					if(aaa.StartButton.getbuttonflag()==true){
						throw aaa.StartButton.new ButtonException("Pressed Enter Button");
					}else if(aaa.OffButton.getbuttonflag()==true){
						throw aaa.OffButton.new ButtonException("Pressed Off Button");
					}
				}catch(ButtonException e){
					LCD.clear();
					LCD.drawString(e.getMessage(), 0, 0);
					break;
				}
			}
			
			Delay.msDelay(1000);
			Button.waitForAnyEvent();
			aaa.StopThread(IEConstants.START);
			aaa.StopThread(IEConstants.OFF);
			aaa.SetButton(IEConstants.START);
			aaa.SetButton(IEConstants.OFF);
			LCD.clear();
		}
	}
	
	private static void BeforeIntroTest(){
		Before_Equipment bbb = new Before_Equipment();
		IntroduceArea aaa = new IntroduceArea();
		
		while(true){
			LCD.clear();
			bbb.Give_Sample();
			if(aaa.Tell_Sample()==true){
				LCD.drawString("true", 0, 0);
			}else{
				LCD.drawString("false", 0, 0);
			}
			if(Button.waitForAnyPress()==32){
				break;
			}
		}
		LCD.refresh();
	}
	
	private static void TreatDischargeTest(){
		TreatArea aaa = new TreatArea();
		DischargeArea bbb = new DischargeArea();
		while(true){
			aaa.Treat_Sample();
			Button.waitForAnyEvent();
			bbb.setColor(aaa.Area_Sample.Treat_Log.getColor());
			bbb.Treating();
			
			LCD.drawString("TreatArea="+aaa.Area_Sample.Treat_Log.getColor(), 0, 0);
			LCD.drawString("DischargeArea="+bbb.Area_Sample.Treat_Log.getColor(), 0, 1);
			
			if(Button.waitForAnyPress()==32){
				break;
			}
			LCD.clear();
		}
	}
	
	private static void MovingPartTest(){
		Moving_Part aaa = new Moving_Part();
		
		while(true){
			aaa.Move();
			aaa.Treating();
			if(Button.waitForAnyPress()==32){
				break;
			}
			aaa.MoveLittle();
		}
		
		IEConstants.DIS.rotateTo(0);
	}

}