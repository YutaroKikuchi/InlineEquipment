package Class;


/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:58
 */
public class Treating_Part {

	public TreatingUnit TreatingUnit = new TreatingUnit();

	public Treating_Part(){

	}

	public void finalize() throws Throwable {

	}

	public boolean Treating(int colorID){
		TreatingUnit.Treating();
		colorID=TreatingUnit.getColorNumber();
		if(colorID==5){
			return false;
		}else{
			return true;
		}
	}

}