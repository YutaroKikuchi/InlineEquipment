package Class;

import Constants.IEConstants;


/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:56
 */
public class Before_Equipment {

	public Before_Equipment(){
		IEConstants.BEF.resetTachoCount();
		IEConstants.BEF.rotateTo(0);
		IEConstants.BEF.setSpeed(IEConstants.BEF_SPD);
	}

	public void finalize() throws Throwable {

	}

	public void End_Giving(){

	}

	public void Give_Sample(){
		IEConstants.BEF.rotate(-40);
		IEConstants.BEF.rotate(80);
		IEConstants.BEF.rotate(-40);
	}

	public void Start_Giving(){
		
	}

}