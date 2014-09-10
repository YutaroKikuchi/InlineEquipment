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
	
	public static RegulatedMotor BAND = Motor.A;	//ベルトコンベア用モータ
	public static RegulatedMotor BEF = Motor.B;		//前処理装置用モータ
	public static RegulatedMotor DIS = Motor.C;		//排出ユニット用モータ
	
	public static EV3ColorSensor CLSEN = new EV3ColorSensor(SensorPort.S3);	//処理ユニット用カラーセンサ
	public static SensorMode COL = CLSEN.getMode(2);						//処理ユニット用カラーセンサ
	public static EV3UltrasonicSensor SonicSensor = new EV3UltrasonicSensor(SensorPort.S4);	//導入エリア用超音波センサ
	SensorMode SNC = SonicSensor.getMode(0);	//超音波センサモード
	
	public static int ROT = 30;		//ベルトコンベア用モータを動かす角度
	public static int SPD = 200;	//ベルトコンベア用モータを動かす速度
}
