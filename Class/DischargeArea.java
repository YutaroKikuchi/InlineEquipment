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
	
	public void setColor(String in){
		super.Area_Sample.Treat_Log.setColor(in);
	}
	
	public void Treating(){
		String currentcolor = super.Area_Sample.Treat_Log.getColor();
		if(currentcolor!=IEConstants.UDF){
			if(currentcolor==IEConstants.TGT){
				IEConstants.DIS.rotateTo(IEConstants.DIS_ROT);
			}else{
				IEConstants.DIS.rotateTo(IEConstants.DIS_ROT*-1);
			}
		}else{
				IEConstants.DIS.rotateTo(0);
		}
	}
}