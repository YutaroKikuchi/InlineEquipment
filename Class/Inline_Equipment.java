package Class;


/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:56
 */
public class Inline_Equipment {

	public Operation_Part Operation_part = new Operation_Part();
	public Moving_Part Moving_Part = new Moving_Part();

	public Inline_Equipment(){

	}

	public void finalize() throws Throwable {

	}

	public void Action_Start(){		//â^ì]íÜÇÃìÆçÏ
		while(true){
			if(Moving_Part.Moving_Stage.IntroArea.Tell_Sample()==true){
				Moving_Part.Moving_Stage.TreArea.Treat_Sample();
				Moving_Part.Moving_Stage.DisArea.Treating();
				Moving_Part.Moving_Stage.Unlock_Moving();
				Moving_Part.Moving_Stage.Moving();
				Moving_Part.Moving_Stage.Lock_Moving();
			}else{
				Moving_Part.Moving_Stage.IntroArea.BeforeEquipment.Give_Sample();
			}
			
			try{
				Operation_part.StopButton.Pushdown();
			}catch(ArithmeticException err){
				break;
			}
		}
	}

	public void Action_Stop(){		//í‚é~íÜÇÃìÆçÏ
		while(true){
			try{
				Operation_part.StartButton.Pushdown();
			}catch(ArithmeticException err){
				break;
			}
		}
	}

	public void Action_Stop_Complete(){

	}

}