package Constants;

import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.RegulatedMotor;

public class IEConstants {
private IEConstants(){
		
	}
	
	public static RegulatedMotor BAND = Motor.A;	//�x���g�R���x�A�p���[�^
	public static RegulatedMotor BEF = Motor.B;		//�O�������u�p���[�^
	public static RegulatedMotor DIS = Motor.C;		//�r�o���j�b�g�p���[�^
	
	public static EV3ColorSensor CLSEN = new EV3ColorSensor(SensorPort.S3);	//�������j�b�g�p�J���[�Z���T
	public static SensorMode COL = CLSEN.getMode(2);						//�������j�b�g�p�J���[�Z���T
	public static EV3UltrasonicSensor SonicSensor = new EV3UltrasonicSensor(SensorPort.S4);	//�����G���A�p�����g�Z���T
	SensorMode SNC = SonicSensor.getMode(0);	//�����g�Z���T���[�h
	
	public static int ROT = 30;		//�x���g�R���x�A�p���[�^�𓮂����p�x
	public static int SPD = 200;	//�x���g�R���x�A�p���[�^�𓮂������x
}
