package frc.robot.subsystem;
import frc.robot.biblioteca.*;
import frc.robot.RobotConstants;

public class ControlPanelWrapper extends ControlPanel {
    public ControlPanelWrapper() {
        m_MotorController = new HuskyVictor(RobotConstants.spinnerPort);
        m_colorSensor = new RevColorSensorV3();
        m_colorTolerance = RobotConstants.colorTolerance;
    }
}