package Class;


/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:57
 */
public class Moving_Part {

	private boolean Stop_Reserve = false;
	public Moving_Stage Moving_Stage;

	public Moving_Part(){
		Moving_Stage = new Moving_Stage();

	}

	public void finalize() throws Throwable {

	}

	public void Action_Stop_Complete(){

	}

	public boolean Check_Action(){
		return false;
	}

	public void Move(){
		Moving_Stage.Unlock_Moving();
		Moving_Stage.Moving();
		Moving_Stage.Lock_Moving();
	}
	
	public void Treating(){
		Moving_Stage.TreArea.Treat_Sample();
		Moving_Stage.DisArea.setColor(Moving_Stage.TreArea.Area_Sample.Treat_Log.getColor());
		Moving_Stage.DisArea.Treating();
	}
	
	public boolean Check_IntroduceArea(){
		if(Moving_Stage.IntroArea.Tell_Sample()==true){
			return true;
		}else{
			return false;
		}
	}

}