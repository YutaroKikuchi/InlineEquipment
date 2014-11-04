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

	private float beforevalue;
	private float nowvalue;
	private boolean areastate;
	
	public IntroduceArea(){
		IntroduceSensor = new Sensor();
		BeforeEquipment = new Before_Equipment();
		areastate=false;
		setBeforevalue();
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public boolean Tell_Sample(){
		float[] Sensorvalue = new float[IEConstants.SNC.sampleSize()];
		Sensorvalue[0] = 0;
		IntroduceSensor.Get_Status(Sensorvalue);
		nowvalue=Sensorvalue[0];
		
		if(nowvalue!=beforevalue){
			areastate = ! areastate;
		}
		
		beforevalue=nowvalue;
		
		return areastate;
	}

	public void setBeforevalue(){
		float [] sensorvalue = new float[IEConstants.SNC.sampleSize()];

		IntroduceSensor.Get_Status(sensorvalue);
		
		beforevalue = sensorvalue[0];
	}

}