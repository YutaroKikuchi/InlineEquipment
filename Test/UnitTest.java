package Test;

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
		TreatingUnitTest();
	}
	
	private static void TreatingUnitTest(){
		
		TreatingUnit aaa = new TreatingUnit();
		float[] color = {0,0,0};
		
		for(int i=0;i<3;i++){
			aaa.Treating(color);
		
			for(i=0;i<3;i++){
				System.out.print(color[i]);
			}
			System.out.print("\n");
			
			Delay.msDelay(3000);
		}
	}
	
	private static void SensorTest(){
		float[] testValue = new float[IEConstants.SNC.sampleSize()];
		Sensor aaa = new Sensor();
		
		for(int k=0;k<3;k++){
		aaa.Get_Status(testValue);
		
		for(int i=0;i<IEConstants.SNC.sampleSize();i++){
			
			System.out.print(testValue[i]+" ");
			Delay.msDelay(10000);
		}
		}
	}
	
	private static void Moving_Stage(){
		Moving_Stage aaa = new Moving_Stage();
		
		for(int i=0;i<3;i++){
		log("Unlock_Moving");
		aaa.Unlock_Moving();
		log("Moving");
		aaa.Moving();
		log("Lock_Moving");
		aaa.Lock_Moving();
		log("Moving");
		aaa.Moving();
		Delay.msDelay(5000);
		}
	}
	
	private static void Before_EquipmentTest(){
		Before_Equipment aaa = new Before_Equipment();
		
		for(int i=0;i<3;i++){
			log("Give_Sample");
			aaa.Give_Sample();
			
			Delay.msDelay(5000);
		}
	}
	
	private static void log(String in){
		System.out.println(in);
	}

}
