package Class;

import Constants.IEConstants;

/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:56
 */
public class DischargeArea extends Area{

	public Moving_Stage Moving_Stage;

	public DischargeArea(){
		IEConstants.DIS.resetTachoCount();
		IEConstants.DIS.rotateTo(0);
		IEConstants.DIS.setSpeed(IEConstants.DIS_SPD);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void Tern_Point(boolean scolor){
		if(scolor == true){
			IEConstants.DIS.rotateTo(IEConstants.DIS_ROT);
		}else{
			IEConstants.DIS.rotateTo(IEConstants.DIS_ROT*-1);
		}
	}
}