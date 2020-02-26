package frc.robot;

public class RobotConstants {
	//TalonSRX(motor) Ports
    public static int leftMasterPort = 0;
    public static int rightMasterPort = 3;
    //VictorSPX(motor) Ports
    public static int leftSlavePort = 1;
    public static int rightSlavePort = 2;
    //Pneumatics
    public static int defensePistonPort = 0;
    //Sensor Ports
    public static int joystickNumber = 0;

    //Joystick Axes
    public static int forwardAxis = 1;
    public static int twistAxis = 0;
    //Joystick Buttons
    public static int pistonButton = 11;
    public static int largeIntakeButton = 1;
    public static int smallIntakeButton = 2;
    //Constants
    public static double largeIntakeSpeed = 1;//-1 to 1
    public static double smallIntakeSpeed = 1;//-1 to 1
    public static double joystickDeadZone = 0.1;//0 to 1
    public static boolean rightInvert = false;
    public static boolean leftInvert = false;
    public static boolean largeInvert = false;
    public static boolean smallInvert = false;
    //PID
    public static double rotateP = 0.08;//0.0000001;
    public static double rotateI = 0.001;//0.0000001;
    public static double rotateD = 0.03;//0.975;
    public static double rotateTolerance = 0;
}