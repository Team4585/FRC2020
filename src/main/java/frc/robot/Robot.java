/*----------------------------------------------------------------------------*/
/* Copym_right (c) 2017-2018 FIRST. All m_rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.biblioteca.*;
import frc.robot.RobotConstants;
import frc.robot.biblioteca.*;
import frc.robot.biblioteca.basesubsystem.*;
import frc.robot.subsystem.Laika;
import frc.robot.biblioteca.autonomous.AutoController;;

public class Robot extends TimedRobot {
  HuskyJoystick driveControl;
  Drive m_drive;
  LimeLightCamera m_limeLight;
  AutoController m_autoController;

  @Override
  public void robotInit() {
    driveControl = new HuskyJoystick(RobotConstants.joystickNumber);
    driveControl.setDeadZone(RobotConstants.joystickDeadZone);
    //Motors

    m_limeLight = new LimeLightCamera();
    m_drive = new Laika();
    m_autoController = new AutoController();
  }
  @Override
  public void robotPeriodic() {
  }
  @Override
  public void autonomousInit() {
    m_autoController.Init();
    m_autoController.setActive(true);
  }
  @Override
  public void autonomousPeriodic() {
    RoboBaseClass.gatherInfoAll();

    RoboBaseClass.doActionsAll();
  }
  @Override
  public void teleopPeriodic() {
    RoboBaseClass.gatherInfoAll();

    m_drive.setForward(driveControl.getAxis(2));
    m_drive.setTwist(driveControl.getAxis(1));

    RoboBaseClass.doActionsAll();
  }
  @Override
  public void testPeriodic() {
  }
}
