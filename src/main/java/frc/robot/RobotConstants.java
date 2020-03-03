package frc.robot;

import frc.robot.biblioteca.HuskyColor;

public class RobotConstants {
    //TalonSRX(motor) Ports
    public static int frontRightPort = 2;
    public static int frontLeftPort = 3;
    public static int backRightPort = 1;
    public static int backLeftPort = 0;
    //public static int leftMasterPort = 0;
    //public static int rightMasterPort = 3;
    //SparkMax Ports
    public static int shootLeftPort = 0;
    public static int shootRightPort = 1;
    //VictorSPX(motor) Ports
    public static int intakePort = 0;
    public static int helixPort = 0;
    public static int aimPort = 0;
    public static int spinnerPort = 0;
    //public static int leftSlavePort = 1;
    //public static int rightSlavePort = 2;
    //Pneumatics
    public static int activateSolenoidPort = 0;
    //Sensor Ports
    public static int joystickNumber = 0;
    public static int aimPotentiometerPort = 0;
    //Joystick
    public static int forwardAxis = 1;
    public static int twistAxis = 0;
    public static int strafeAxis = 2;

    public static int shootButton = 1;
    public static int intakeButton = 2;
    public static int helixButton = 3;

    /*
    Intake = button2 (toggle)
    Negative intake = button 5 (hold)
    Helix = button3 (toggle)
    Control Spin(x4) = button 4
    Control move = button 6
    Control color = blue(9), green(10), red(11), yellow(12)

    */ 
    //Constants
    public static double joystickDeadZone = 0.1;//0 to 1
    public static double colorTolerance = 0.1;

    public static HuskyColor colorRed;
    public static HuskyColor colorYellow;
    public static HuskyColor colorGreen;
    public static HuskyColor colorBlue;

    public static double shootSpeed = 1;
    public static double intakeSpeed = 1;
    public static double helixSpeed = 1;
    public static double colorSpinnerSpeed = 1;
    //PID
    public static double rotateP = 0.080;
    public static double rotateI = 0.001;
    public static double rotateD = 0.03;
    public static double rotateTolerance = 1;
    public static double driveP = 0;
    public static double driveI = 0;
    public static double driveD = 0;
    public static double driveTolerance = 1;
    public static double aimXP = 0.080;
    public static double aimXI = 0.001;
    public static double aimXD = 0.030;
    public static double aimXTolerance = 1;
    public static double aimYP = 0.080;
    public static double aimYI = 0.001;
    public static double aimYD = 0.030;
    public static double aimYTolerance = 1;
}