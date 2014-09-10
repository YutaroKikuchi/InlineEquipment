package Class;

import Constants.IEConstants;

/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:58
 */
public class Sensor {
	
	private float value[] = new float[IEConstants.SNC.sampleSize()];
	
	public Sensor(float basic){
	}

	public void finalize() throws Throwable {

	}

	public boolean Get_Status(){
		IEConstants.SNC.fetchSample(value, 0);
		
		if((value[0]-IEConstants.BSC)>0.1){
			return false;
		}else{
			return true;
		}
	}

}