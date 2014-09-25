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
		super.Area_Sample.setnumber(currentNumber+1);
		currentNumber++;
		if(colorvalue[0]<0.02 &&colorvalue[1]<0.02 && colorvalue[2]<0.02){
			colorname = IEConstants.BLK; //すべてのRGB値が0.02より小さかったら黒と判定
		}else if(selectColor(colorvalue,0)){
			if(colorvalue[1]>=colorvalue[2]){
				colorname = IEConstants.YLW;	//R,G,Bの値の順に大きかったら黄と判定
			}else{
				colorname = IEConstants.RED;	//R,B,Gの値の順に大きかったら赤と判定
			}
		}else if(selectColor(colorvalue,1)){
			colorname = IEConstants.GRN;		//Gの値が一番大きかったら緑と判定
		}else if(selectColor(colorvalue,2)){
			colorname = IEConstants.BLUE;		//Bの値が一番大きかったら青と判定
		}else{
			colorname = IEConstants.UDF;		//不明と判定
		}
		
		if(colorname!=IEConstants.UDF){									//処理状況を記録 色が不明な場合は処理していないと記録
			super.Area_Sample.Treat_Log.setState(true);
		}else{
			super.Area_Sample.Treat_Log.setState(false);
		}
		
		super.Area_Sample.Treat_Log.setColor(colorname);

		if(colorname != IEConstants.UDF){
			csvString = (currentNumber+1) + "," + colorname +"," + IEConstants.COMP;
		}else{
			csvString = (currentNumber+1) + "," + colorname +"," + IEConstants.UNCOMP;
		}
		//addCSV(csvString);
	}
	
	/*
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
	*/
	
	private boolean selectColor(float in[],int no){
		switch(no){
		case 0:
			if((in[0]>=in[1] && in[0]>=in[2])){
				return true;
			}else{
				return false;
			}
		case 1:
			if(in[1]>=in[0] && in[1]>=in[2]){
				return true;
			}else{
				return false;
			}
		case 2:
			if(in[2]>=in[0] && in[2]>=in[1]){
				return true;
			}else{
				return false;
			}
		default:
			return false;
		}
	}
}