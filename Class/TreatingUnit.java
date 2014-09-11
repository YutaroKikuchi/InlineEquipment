package Class;

import Constants.IEConstants;


/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:58
 */
public class TreatingUnit {

	public TreatingUnit(){
	}

	public void finalize() throws Throwable {

	}

	public void Treating(float colorvalue[]){
		IEConstants.COL.fetchSample(colorvalue, 0);	//Fæ“¾
	}
}