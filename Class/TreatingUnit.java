package Class;

import Constants.IEConstants;


/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:58
 */
public class TreatingUnit {

	private int colorNumber;

	public TreatingUnit(){
		colorNumber=0;
	}

	public void finalize() throws Throwable {

	}

	public int getColorNumber(){
		return colorNumber;
	}

	public void Treating(){
		float currentcolor[] = new float[3];
		IEConstants.COL.fetchSample(currentcolor, 0);					//�F�擾
		
		if(currentcolor[0]<=200 && currentcolor[1]<=200 && currentcolor[2]<=200){
			colorNumber = 0;	//���Ɣ���
		}else if(currentcolor[0]<=200 && currentcolor[1]<=200 && currentcolor[2]>200){
			colorNumber = 1;	//�Ɣ���
		}else if(currentcolor[0]<=200 && currentcolor[1]>200 && currentcolor[2]<=200){
			colorNumber = 2;	//�΂Ɣ���
		}else if(currentcolor[0]>200 && currentcolor[1]<=200 && currentcolor[2]<=200){
			colorNumber = 3;	//�ԂƔ���
		}else if(currentcolor[0]>200 && currentcolor[1]>200 && currentcolor[2]<=200){
			colorNumber = 4;	//���Ɣ���
		}else{
			colorNumber = 5;	//�s���Ɣ���
		}
	}

}