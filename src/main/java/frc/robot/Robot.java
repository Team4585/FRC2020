/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.biblioteca.*;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import frc.robot.RobotConstants;
import frc.robot.biblioteca.*;
import frc.robot.biblioteca.subsystem.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  HuskyTalon rightMaster;
  HuskyTalon leftMaster;
  //HuskyTalon largeIntake;
  //HuskyTalon smallIntake;
  HuskyVictor rightSlave;
  HuskyVictor leftSlave;
  HuskyJoystick driveControl;
  LimeLightCamera m_limeLight;
  Drive m_drive;
  double m_P = 0.001;
  double m_I = 0.001;
  double m_D = 0.001;

  @Override
  public void robotInit() {
    driveControl = new HuskyJoystick(RobotConstants.joystickNumber);
    driveControl.setDeadZone(RobotConstants.joystickDeadZone);
    //Motors
    rightMaster = new HuskyTalon(RobotConstants.rightMasterPort);
    leftMaster = new HuskyTalon(RobotConstants.leftMasterPort);
    rightSlave = new HuskyVictor(RobotConstants.rightSlavePort);
    leftSlave = new HuskyVictor(RobotConstants.leftSlavePort);
    //largeIntake = new HuskyTalon(RobotConstants.largeIntakePort);
    //smallIntake = new HuskyTalon(RobotConstants.largeIntakePort);

    rightMaster.setInverted(RobotConstants.rightInvert);
    leftMaster.setInverted(RobotConstants.leftInvert);
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
    m_limeLight = new LimeLightCamera();
    m_drive = new SimpleTankDrive(leftMaster, leftSlave, rightMaster, rightSlave);
    //largeIntake.setInverted(RobotConstants.largeInvert);
    //smallIntake.setInverted(RobotConstants.smallInvert);
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
    double output = 0;
    double m_error;
    double m_errorSum = 0;
    double m_lastPosition = 0;
    m_error = m_limeLight.getXDistance();
    m_errorSum += m_error;
    output += m_error * m_P;
    output += m_errorSum * m_I;
    output -= m_error - m_lastPosition * m_D;
    m_drive.setForward(output);
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
