package frc.robot.subsystem;
import frc.robot.biblioteca.*;
import frc.robot.RobotConstants;

public class TractorBeam extends Intake {
    public TractorBeam() {
        m_intakeMotors = new MotorController[] {new HuskyVictor(RobotConstants.intakePort)};
        m_helixMotors = new MotorController[] {new HuskyVictor(RobotConstants.helixPort)};
        m_activator = new HuskySolenoid(RobotConstants.activateSolenoidPort);
    }
}
