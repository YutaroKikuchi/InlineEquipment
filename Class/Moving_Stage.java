package Class;

import Constants.IEConstants;


/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:57
 */
public class Moving_Stage {

	public Area Area;
	public IntroduceArea IntroArea;
	public TreatArea TreArea;
	public DischargeArea DisArea;
	public TreatingUnit CheckSensor;

	private boolean LockMov;	//ベルトコンベアロック
	private int angle;			//モータの現在の角度
	
	public Moving_Stage(){
		LockMov = false;
		angle = 0;
		IntroArea = new IntroduceArea();
		TreArea = new TreatArea();
		DisArea = new DischargeArea();
		CheckSensor = new TreatingUnit();
		IEConstants.BAND.resetTachoCount();
		IEConstants.BAND.rotateTo(0);
		IEConstants.BAND.setSpeed(IEConstants.SPD);
	}

	public void finalize() throws Throwable {

	}

	private boolean Check_Sample(){
		float[] color=new float[IEConstants.COL.sampleSize()];
		CheckSensor.Treating(color);
		if(color[0]>IEConstants.BLK_LEV[0] && color[1]>IEConstants.BLK_LEV[1] && color[2]>IEConstants.BLK_LEV[2]){
			return true;
		}else{
			return false;
		}
	}

	public void Lock_Moving(){
		LockMov = false;
	}

	public void Moving(){
		if(LockMov==true){
			while(true){
				angle += IEConstants.ROT;
				IEConstants.BAND.rotateTo(angle);
				if(Check_Sample()==true){
					break;
				}
			}
		}
	}
	
	public void Moving_After(){
		if(LockMov==true){
			angle += IEConstants.ROT2;
			IEConstants.BAND.rotateTo(angle);
		}
	}

	public void Take_Sample(){
		
	}

	public void Unlock_Moving(){
		LockMov = true;
	}

}