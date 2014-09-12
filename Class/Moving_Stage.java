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

	private boolean LockMov;	//ベルトコンベアロック
	private int angle;			//モータの現在の角度
	
	public Moving_Stage(){
		LockMov = false;
		angle = 0;
		IntroArea = new IntroduceArea();
		TreArea = new TreatArea();
		DisArea = new DischargeArea();
		IEConstants.BAND.resetTachoCount();
		IEConstants.BAND.rotateTo(0);
	}

	public void finalize() throws Throwable {

	}

	public boolean Check_Sample(){
		return false;
	}

	public void Lock_Moving(){
		LockMov = false;
	}

	public void Moving(){
		if(LockMov==true){
			angle += IEConstants.ROT;
			IEConstants.BAND.setSpeed(IEConstants.SPD);
			IEConstants.BAND.rotateTo(angle);
		}
	}

	public void Take_Sample(){
		
	}

	public void Unlock_Moving(){
		LockMov = true;
	}

}