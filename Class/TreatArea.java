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
			colorname = IEConstants.BLK; //���ׂĂ�RGB�l��0.02��菬���������獕�Ɣ���
		}else if(selectColor(colorvalue,0)){
			if(colorvalue[1]>=colorvalue[2]){
				colorname = IEConstants.YLW;	//R,G,B�̒l�̏��ɑ傫�������物�Ɣ���
			}else{
				colorname = IEConstants.RED;	//R,B,G�̒l�̏��ɑ傫��������ԂƔ���
			}
		}else if(selectColor(colorvalue,1)){
			colorname = IEConstants.GRN;		//G�̒l����ԑ傫��������΂Ɣ���
		}else if(selectColor(colorvalue,2)){
			colorname = IEConstants.BLUE;		//B�̒l����ԑ傫��������Ɣ���
		}else{
			colorname = IEConstants.UDF;		//�s���Ɣ���
		}
		
		if(colorname!=IEConstants.UDF){									//�����󋵂��L�^ �F���s���ȏꍇ�͏������Ă��Ȃ��ƋL�^
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