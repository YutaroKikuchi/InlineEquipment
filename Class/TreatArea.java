package Class;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Constants.IEConstants;


/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:58
 */
public class TreatArea extends Area {

	public Moving_Stage Moving_Stage;
	public Treating_Part TreatingPart;
	private FileWriter fw;
	private PrintWriter pw;

	private int currentNumber;
	
	public TreatArea(){
		TreatingPart = new Treating_Part();
		currentNumber = 0;
		try{
			fw = new FileWriter(IEConstants.PASS, false); 
			pw = new PrintWriter(new BufferedWriter(fw));
			pw.print(IEConstants.LOG);
			pw.close();
		}catch (IOException ex){
			 ex.printStackTrace();
		}
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void Treat_Sample(){
		String colorname;
		float colorvalue[] = new float[IEConstants.COL.sampleSize()];
		String csvString;
		
		TreatingPart.TreatingUnit.Treating(colorvalue);
		
		if(colorvalue[0]<=200 && colorvalue[1]<=200 && colorvalue[2]<=200){
			colorname = IEConstants.BLK;	//黒と判定
		}else if(colorvalue[0]<=200 && colorvalue[1]<=200 && colorvalue[2]>200){
			colorname = IEConstants.BLUE;	//青と判定
		}else if(colorvalue[0]<=200 && colorvalue[1]>200 && colorvalue[2]<=200){
			colorname = IEConstants.GRN;	//緑と判定
		}else if(colorvalue[0]>200 && colorvalue[1]<=200 && colorvalue[2]<=200){
			colorname = IEConstants.RED;	//赤と判定
		}else if(colorvalue[0]>200 && colorvalue[1]>200 && colorvalue[2]<=200){
			colorname = IEConstants.YLW;	//黄と判定
		}else{
			colorname = IEConstants.UDF;	//不明と判定
		}
		
		if(colorname!=IEConstants.UDF){									//処理状況を記録 色が不明な場合は処理していないと記録
			super.Area_Sample.Treat_Log.setState(true);
		}
		
		super.Area_Sample.Treat_Log.setColor(colorname);

		if(colorname != IEConstants.UDF){
			csvString = (currentNumber+1) + "," + colorname +"," + IEConstants.COMP;
		}else{
			csvString = (currentNumber+1) + "," + colorname +"," + IEConstants.UNCOMP;
		}
		addCSV(csvString);
	}
	
	private void addCSV(String csvline){
		try{
			fw = new FileWriter(IEConstants.PASS, true); 
			pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.print(csvline);
			pw.println();
			pw.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}