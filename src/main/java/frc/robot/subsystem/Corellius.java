package frc.robot.subsystem;

import frc.robot.biblioteca.basesubsystem.MecanumDrive;
import frc.robot.RobotConstants;
import frc.robot.biblioteca.*;

public class Corellius extends MecanumDrive {
    public Corellius() {
        super(new HuskyTalon(RobotConstants.frontLeftPort), 
        new HuskyTalon(RobotConstants.frontRightPort), 
        new HuskyTalon(RobotConstants.backLeftPort), 
        new HuskyTalon(RobotConstants.backRightPort), 0.0, 0.0, Math.PI * 0.1524, 0);
    }
}
