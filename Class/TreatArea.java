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
			colorname = IEConstants.BLK;	//���Ɣ���
		}else if(colorvalue[0]<=200 && colorvalue[1]<=200 && colorvalue[2]>200){
			colorname = IEConstants.BLUE;	//�Ɣ���
		}else if(colorvalue[0]<=200 && colorvalue[1]>200 && colorvalue[2]<=200){
			colorname = IEConstants.GRN;	//�΂Ɣ���
		}else if(colorvalue[0]>200 && colorvalue[1]<=200 && colorvalue[2]<=200){
			colorname = IEConstants.RED;	//�ԂƔ���
		}else if(colorvalue[0]>200 && colorvalue[1]>200 && colorvalue[2]<=200){
			colorname = IEConstants.YLW;	//���Ɣ���
		}else{
			colorname = IEConstants.UDF;	//�s���Ɣ���
		}
		
		if(colorname!=IEConstants.UDF){									//�����󋵂��L�^ �F���s���ȏꍇ�͏������Ă��Ȃ��ƋL�^
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