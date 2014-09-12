package Class;

/**
 * @author yusan
 * @version 1.0
 * @created 2014/08/29 21:16:57
 */
public class IntroduceArea extends Area {

	public Moving_Stage Moving_Stage;
	public Before_Equipment BeforeEquipment;
	public Sensor IntroduceSensor;

	public IntroduceArea(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public boolean Tell_Sample(){
		return IntroduceSensor.Get_Status();
	}

	public void Treat_Sample(){

	}

}