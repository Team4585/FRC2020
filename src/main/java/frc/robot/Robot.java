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
import frc.robot.biblioteca.basesubsystem.*;
import frc.robot.RobotConstants;
import frc.robot.subsystem.*;
import frc.robot.biblioteca.autonomous.AutoController;
import frc.robot.biblioteca.autonomous.AutoTaskLimeLightRotate;

public class Robot extends TimedRobot {
  Drive m_driveTrain;
  Output m_shooter;
  Intake m_intake;
  ControlPanel m_colorWheel;

  HuskyJoystick m_driveControl;
  HuskyJoystick m_weaponsControl;

  LimeLightCamera m_limeLight;
  AutoController m_autoController;
  AutoTaskLimeLightRotate m_autoRotate;

  double speedSum;
  double speedCount;
  int waitTime;
  boolean m_doIntake;
  boolean m_doHelix;

  @Override
  public void robotInit() {
    m_driveTrain = new Corellius();
    //m_driveTrain = new Laika();
    m_shooter = new Deathstar();
    m_intake = new TractorBeam();
    m_colorWheel = new ControlPanelWrapper();

    m_driveControl = new HuskyJoystick(RobotConstants.joystickNumber);
    m_driveControl.setDeadZone(RobotConstants.joystickDeadZone);

    m_limeLight = new LimeLightCamera();

    m_autoController = new AutoController();
    m_autoRotate = new AutoTaskLimeLightRotate(m_driveTrain, m_shooter, m_limeLight);
  }
  @Override
  public void robotPeriodic() {
  }
  @Override
  public void autonomousInit() {
    m_autoController.Init(m_driveTrain, m_limeLight);
    m_autoController.setActive(true);
  }
  @Override
  public void autonomousPeriodic() {
    RoboBaseClass.gatherInfoAll();
    RoboBaseClass.doActionsAll();
  }
  @Override
  public void teleopInit() {
    m_autoRotate.Init();
  }
  @Override
  public void teleopPeriodic() {
    RoboBaseClass.gatherInfoAll();
    
    m_driveTrain.setForward(m_driveControl.getAxis(RobotConstants.forwardAxis) * 1);
    if(m_driveControl.getButton(RobotConstants.aimOverrideButton)) {
      m_autoRotate.Run();
    } else {
      m_driveTrain.setTwist(m_driveControl.getAxis(RobotConstants.twistAxis) * 1);
      m_shooter.rotateY(m_weaponsControl.getAxis(RobotConstants.aimAxis));
    }
    m_driveTrain.setStrafe(m_driveControl.getAxis(RobotConstants.strafeAxis) * 1);

    m_shooter.setShoot(m_weaponsControl.getButton(RobotConstants.shootButton)?RobotConstants.shootSpeed:0);
    
    if(m_weaponsControl.getButtonPressed(RobotConstants.intakeButton)) {
      m_doIntake = !m_doIntake;
    }
    if(m_weaponsControl.getButtonPressed(RobotConstants.helixButton)) {
      m_doHelix = !m_doHelix;
    }
    m_intake.intake(m_doIntake?RobotConstants.intakeSpeed:0, m_doHelix?RobotConstants.helixSpeed:0);

    if(m_weaponsControl.getButton(9)) {
      m_colorWheel.goToColor(RobotConstants.colorBlue);
    } else if(m_weaponsControl.getButton(10)) {
      m_colorWheel.goToColor(RobotConstants.colorGreen);
    } else if(m_weaponsControl.getButton(11)) {
      m_colorWheel.goToColor(RobotConstants.colorRed);
    } else if(m_weaponsControl.getButton(12)) {
      m_colorWheel.goToColor(RobotConstants.colorYellow);
    } else {//TODO Make this autonomous
      m_colorWheel.setMotorController(m_weaponsControl.getButton(8)?RobotConstants.colorSpinnerSpeed:0);
    }

    RoboBaseClass.doActionsAll();
  }
  @Override
  public void testPeriodic() {

  }
}
