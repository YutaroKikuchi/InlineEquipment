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
	
	public static RegulatedMotor BAND = Motor.C;	//�x���g�R���x�A�p���[�^
	public static RegulatedMotor BEF = Motor.D;		//�O�������u�p���[�^
	public static RegulatedMotor DIS = Motor.A;		//�r�o���j�b�g�p���[�^
	
	public static EV3ColorSensor CLSEN = new EV3ColorSensor(SensorPort.S3);	//�������j�b�g�p�J���[�Z���T
	public static SensorMode COL = CLSEN.getMode(2);						//�������j�b�g�p�J���[�Z���T
	public static EV3UltrasonicSensor SonicSensor = new EV3UltrasonicSensor(SensorPort.S4);	//�����G���A�p�����g�Z���T
	public static SensorMode SNC = SonicSensor.getMode(0);	//�����g�Z���T���[�h
	
	public static int ROT = 10;		//�x���g�R���x�A�p���[�^�𓮂����p�x
	public static int ROT2 = 90;
	public static int SPD = 200;	//�x���g�R���x�A�p���[�^�𓮂������x
	
	public static float BSC = 0;	//�����g�Z���T�p��l
	
	public static int BEF_ROT = -60;	//�O�������u�p���[�^�𓮂����p�x
	public static int BEF_SPD = 150;//�O�������u�p���[�^�𓮂������x
	
	public static int DIS_ROT = 22;	//�r�o�����p���[�^�𓮂����p�x
	public static int DIS_SPD = 200;//�r�o�����p���[�^�𓮂������x
	public static String TGT = "��";	//�r�o�p����F

	public static int SAM = 100;	//���������̍ő吔
	
	public static String PASS = "�Ȃ�";	//�������O��⊮����f�B���N�g���p�X
	
	public static String RED = "��";		//�F�̖��O
	public static String BLUE = "��";
	public static String YLW = "��";
	public static String BLK = "��";
	public static String GRN = "��";
	public static String UDF = "�s��";
	
	public static String COMP = "��������";		//���O�Ɏ������e
	public static String UNCOMP = "����������";
	public static String LOG = "ID,�F,������\n";
	
	public static double[] BLK_LEV ={0.01,0.01,0.01};
}
