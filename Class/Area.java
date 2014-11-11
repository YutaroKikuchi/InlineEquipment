package Class;

import Constants.IEConstants;


/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:56
 */
public class Area {

	public Sample Area_Sample;

	public Area(){
		Area_Sample = new Sample();
	}

	public void finalize() throws Throwable {

	}

	public void Check_Moving(){

	}

	public void Take_Sample(){

	}
	
	public void Init(){
		Area_Sample.setnumber(0);
		Area_Sample.Treat_Log.setState(false);
		Area_Sample.Treat_Log.setColor(IEConstants.UDF);
	}

}