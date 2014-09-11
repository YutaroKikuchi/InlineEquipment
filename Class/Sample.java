package Class;


/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:57
 */
public class Sample {

	private int ID;
	public Log Treat_Log;

	public Sample(int Number){
		Treat_Log = new Log();
		ID = Number;
	}

	public void finalize() throws Throwable {

	}
	
	public int getID(){
		return ID;
	}

}