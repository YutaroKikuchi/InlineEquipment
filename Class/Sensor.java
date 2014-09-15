package Class;

import Constants.IEConstants;

/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:58
 */
public class Sensor {
	
	public Sensor(){
	}

	public void finalize() throws Throwable {

	}

	public void Get_Status(float value[]){
		IEConstants.SNC.fetchSample(value, 0);
	}

}