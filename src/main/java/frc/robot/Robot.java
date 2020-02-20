/*----------------------------------------------------------------------------*/
/* Copym_right (c) 2017-2018 FIRST. All m_rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.biblioteca.*;
import frc.robot.RobotConstants;
import frc.robot.biblioteca.*;
import frc.robot.biblioteca.basesubsystem.*;

public class Robot extends TimedRobot {
  HuskyTalon m_rightMaster;
  HuskyTalon m_leftMaster;
  HuskyVictor m_rightSlave;
  HuskyVictor m_leftSlave;
  HuskyJoystick driveControl;
  LimeLightCamera m_limeLight;
  Drive m_drive;
  BasicPID m_pid;
  double m_P = 0.001;
  double m_I = 0.001;
  double m_D = 0.001;

  @Override
  public void robotInit() {
    driveControl = new HuskyJoystick(RobotConstants.joystickNumber);
    driveControl.setDeadZone(RobotConstants.joystickDeadZone);
    //Motors
    m_rightMaster = new HuskyTalon(RobotConstants.rightMasterPort);
    m_leftMaster = new HuskyTalon(RobotConstants.leftMasterPort);
    m_rightSlave = new HuskyVictor(RobotConstants.rightSlavePort);
    m_leftSlave = new HuskyVictor(RobotConstants.leftSlavePort);

    m_rightMaster.setInverted(RobotConstants.rightInvert);
    m_leftMaster.setInverted(RobotConstants.leftInvert);
    m_leftSlave.follow(m_leftMaster);
    m_rightSlave.follow(m_rightMaster);
    m_limeLight = new LimeLightCamera();
    m_drive = new SimpleTankDrive(m_leftMaster, m_leftSlave, m_rightMaster, m_rightSlave);
    m_pid = new BasicPID();
    m_pid.setP(m_P);
    m_pid.setI(m_I);
    m_pid.setD(m_D);
    m_pid.setMinOutput(-0.5);
    m_pid.setMinOutput(0.5);
  }
  @Override
  public void robotPeriodic() {
  }
  @Override
  public void autonomousInit() {
  }
  @Override
  public void autonomousPeriodic() {
    RoboBaseClass.gatherInfoAll();

    m_pid.setPosition(m_limeLight.getXDistance());
    m_pid.setTarget(0);
    m_drive.setForward(m_pid.calculateError());

    RoboBaseClass.doActionsAll();
  }
  @Override
  public void teleopPeriodic() {
    RoboBaseClass.gatherInfoAll();
    m_drive.setForward(driveControl.getAxis(0));
    m_drive.setTwist(driveControl.getAxis(1));
    RoboBaseClass.doActionsAll();
  }
  @Override
  public void testPeriodic() {
  }
}
