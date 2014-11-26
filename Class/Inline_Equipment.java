package Class;

import Class.Operation_Button.ButtonException;
import Constants.IEConstants;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;


/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:56
 */
public class Inline_Equipment{

	public Operation_Part Operation_part = new Operation_Part();
	public Moving_Part Moving_Part = new Moving_Part();
	private boolean power;

	public Inline_Equipment(){
		power = true;
	}

	public void finalize() throws Throwable {

	}

	public void Action_Start(){		//â^ì]íÜÇÃìÆçÏ
		Operation_part.StopButton.start();
		while(true){
			LCD.drawString("Moving...", 0, 0);
			try{
				if(Moving_Part.Check_IntroduceArea()==true){
					Moving_Part.Move();
					Moving_Part.Treating();
					Moving_Part.MoveLittle();
				}else{
					Moving_Part.Moving_Stage.IntroArea.BeforeEquipment.Give_Sample();
				}
				if(Operation_part.StopButton.getbuttonflag()==true){
					throw Operation_part.StopButton.new ButtonException("Pressed Button");
				}
			}catch(ButtonException e){
				Action_Stop_Complete();
				break;
			}
		}
		Operation_part.SetButton(IEConstants.STOP);
		LCD.clear();
		LCD.refresh();
	}

	public void Action_Stop(){		//í‚é~íÜÇÃìÆçÏ
		Operation_part.StartButton.start();
		Operation_part.OffButton.start();
		while(true){
			try{
				LCD.drawString("Press Enter!!", 0, 0);
				Delay.msDelay(3000);
				if(Operation_part.StartButton.getbuttonflag()){
					throw Operation_part.StartButton.new ButtonException("Pressed Enter Button");
				}
				if(Operation_part.OffButton.getbuttonflag()){
					throw Operation_part.OffButton.new ButtonException("Pressed Off Button");
				}
			}catch(ButtonException err){
				if(err.getMessage().equals("Pressed Enter Button")==true){
					break;
				}else if(err.getMessage().equals("Pressed Off Button")==true){
					power=false;
					break;
				}
			}
		}
		Operation_part.StopThread(IEConstants.START);
		Operation_part.StopThread(IEConstants.OFF);
		Operation_part.SetButton(IEConstants.START);
		Operation_part.SetButton(IEConstants.OFF);
		LCD.clear();
	}

	public void Action_Stop_Complete(){
		Moving_Part.Action_Stop_Complete();
	}
	
	public boolean getpower(){
		return power;
	}
}