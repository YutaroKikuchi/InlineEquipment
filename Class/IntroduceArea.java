package Class;

import Constants.IEConstants;

/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:57
 */
public class IntroduceArea extends Area {

	public Moving_Stage Moving_Stage;
	public Before_Equipment BeforeEquipment;
	public Sensor IntroduceSensor;

	public IntroduceArea(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public boolean Tell_Sample(){
		float[] Sensorvalue = new float[IEConstants.SNC.sampleSize()];
		
		IntroduceSensor.Get_Status(Sensorvalue);
		
		for(int k = 0;k<IEConstants.SNC.sampleSize();k++){
			if(Sensorvalue[k]<IEConstants.BSC){
				return true;
			}else{
				return false;
			}
		}
		
		return false;
	}

	public void Treat_Sample(){

	}

}