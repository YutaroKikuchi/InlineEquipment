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

	public void Treating(float value[]){
		TreatingUnit.Treating(value);
	}

}