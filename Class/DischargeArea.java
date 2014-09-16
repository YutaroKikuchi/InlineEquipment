package Class;

import Constants.IEConstants;

/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:56
 */
public class DischargeArea extends Area{

	public Moving_Stage Moving_Stage;

	String[] colors = {IEConstants.UDF,IEConstants.UDF};
	
	public DischargeArea(){
		IEConstants.DIS.resetTachoCount();
		IEConstants.DIS.rotateTo(0);
		IEConstants.DIS.setSpeed(IEConstants.DIS_SPD);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	
	public void setColor(String in){
		colors[1]=colors[0];
		colors[0]=in;
	}
	
	public void Treating(){
		if(colors[1]!=IEConstants.BLK){
			if(colors[1]==IEConstants.TGT){
				IEConstants.DIS.rotateTo(IEConstants.DIS_ROT);
			}else{
				IEConstants.DIS.rotateTo(IEConstants.DIS_ROT*-1);
			}
		}else{
			IEConstants.DIS.rotateTo(0);
		}
	}
}