package Class;

import Constants.IEConstants;


/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:57
 */
public class Log {

	private String colorname;
	private boolean Take_After;
	public Sample Treat_Sample;

	public Log(){
		colorname=IEConstants.UDF;
		Take_After=false;
	}

	public void finalize() throws Throwable {

	}
	
	public void setColor(String Color){
		colorname=Color;
	}
	
	public void setState(boolean TreatSt){
		Take_After=TreatSt;
	}
	
	public String getColor(){
		return colorname;
	}
	
	public boolean returnTake_After(){
		return Take_After;
	}

}