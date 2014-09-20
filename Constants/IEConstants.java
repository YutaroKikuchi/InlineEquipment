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
	
	public static RegulatedMotor BAND = Motor.C;	//ベルトコンベア用モータ
	public static RegulatedMotor BEF = Motor.D;		//前処理装置用モータ
	public static RegulatedMotor DIS = Motor.A;		//排出ユニット用モータ
	
	public static EV3ColorSensor CLSEN = new EV3ColorSensor(SensorPort.S3);	//処理ユニット用カラーセンサ
	public static SensorMode COL = CLSEN.getMode(2);						//処理ユニット用カラーセンサ
	public static EV3UltrasonicSensor SonicSensor = new EV3UltrasonicSensor(SensorPort.S4);	//導入エリア用超音波センサ
	public static SensorMode SNC = SonicSensor.getMode(0);	//超音波センサモード
	
	public static int ROT = 10;		//ベルトコンベア用モータを動かす角度
	public static int ROT2 = 90;
	public static int SPD = 200;	//ベルトコンベア用モータを動かす速度
	
	public static float BSC = 0;	//超音波センサ用基準値
	
	public static int BEF_ROT = -60;	//前処理装置用モータを動かす角度
	public static int BEF_SPD = 150;//前処理装置用モータを動かす速度
	
	public static int DIS_ROT = 22;	//排出勝利用モータを動かす角度
	public static int DIS_SPD = 200;//排出処理用モータを動かす速度
	public static String TGT = "赤";	//排出用する色

	public static int SAM = 100;	//扱う試料の最大数
	
	public static String PASS = "なんか";	//処理ログを補完するディレクトリパス
	
	public static String RED = "赤";		//色の名前
	public static String BLUE = "青";
	public static String YLW = "黄";
	public static String BLK = "黒";
	public static String GRN = "緑";
	public static String UDF = "不明";
	
	public static String COMP = "処理完了";		//ログに示す内容
	public static String UNCOMP = "処理未完了";
	public static String LOG = "ID,色,処理状況\n";
	
	public static double[] BLK_LEV ={0.01,0.01,0.01};
}
