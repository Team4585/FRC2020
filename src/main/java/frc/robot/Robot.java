/*----------------------------------------------------------------------------*/
/* Copym_right (c) 2017-2018 FIRST. All m_rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.biblioteca.RoboBaseClass;
import java.util.*;
import java.io.*;

//Testing

public class Robot extends TimedRobot {
  chassis m_theChassis;
  NewJoystick m_theJoystick;
  Human m_theHuman;

  @Override
  public void robotInit() {
    
//    SmartDashboard.putNumber("Forward Axis", 1);
//    SmartDashboard.putNumber("TwistAxis", 2);
//    SmartDashboard.putNumber("StrafeAxis", 0);
//    SmartDashboard.putNumber("AimAxis", 2);
//    SmartDashboard.putNumber("Aim Override Button", 1);
//    SmartDashboard.putNumber("Shoot Button", 1);
//    SmartDashboard.putNumber("Intake Button", 2);
//    SmartDashboard.putNumber("Helix Button", 3);
//    SmartDashboard.putNumber("Joystick Deadzones", 0.25);

    m_theChassis = new chassis();
    m_theJoystick = new NewJoystick();
    m_theHuman = new Human(m_theChassis, m_theJoystick);
  }

  public void initSubsystems()
  {
    m_theJoystick.newJoystickInit();
    m_theChassis.chassisInit();
  }

  @Override
  public void robotPeriodic() {
  }
  @Override
  public void autonomousInit() {
    //m_autoController.Init(m_driveTrain, m_limeLight);
    //m_autoController.setActive(true);
  }
  @Override
  public void autonomousPeriodic() {
    //Cry
    RoboBaseClass.gatherInfoAll();
    RoboBaseClass.doActionsAll();
  }
  @Override
  public void teleopInit() {
 //   RobotConstants.forwardAxis = (int) SmartDashboard.getNumber("Forward Axis", 1);
 //   RobotConstants.twistAxis = (int) SmartDashboard.getNumber("Twist Axis", 2);
 //   RobotConstants.strafeAxis = (int) SmartDashboard.getNumber("Strafe Axis", 0);
 //   RobotConstants.aimAxis = (int) SmartDashboard.getNumber("Aim Axis", 1);
 //   RobotConstants.aimOverrideButton = (int) SmartDashboard.getNumber("Aim Override Button", 1);
 //   RobotConstants.shootButton = (int) SmartDashboard.getNumber("Shoot Button", 1);
 //   RobotConstants.intakeButton = (int) SmartDashboard.getNumber("Intake Button", 2);
 //   RobotConstants.helixButton = (int) SmartDashboard.getNumber("Helix Button", 3);
 //   RobotConstants.joystickDeadZone = (int) SmartDashboard.getNumber("Joystick Deadzones", 0.25);

    initSubsystems();
  }
  @Override
  public void teleopPeriodic() {
      m_theJoystick.gatherInformation();
      m_theHuman.makeCalculations();
      m_theChassis.chassisDoActions();

    RoboBaseClass.doActionsAll();
  }
  @Override
  public void testPeriodic() {
  }
}
// woo code

