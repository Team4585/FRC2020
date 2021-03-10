/*----------------------------------------------------------------------------*/
/* Copym_right (c) 2017-2018 FIRST. All m_rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class Human
{
    chassis m_targChassis = null;
    NewJoystick m_targJoystick = null;

    public Human(chassis tempChassis, NewJoystick tempJoystick)
    {
        this.m_targChassis = tempChassis;
        this.m_targJoystick = tempJoystick;
    }

    public void makeCalculations()
    {
        //m_theChassis.setVals(m_theJoystick.getForwardAxis(), m_theJoystick.getTwistAxis(), m_theJoystick.getStrafeAxis());
        if (m_targJoystick.getButton1())
        {
            m_targChassis.setCommand(chassis.chassisCommands.MOVEFORWARD, 0.3);
        }
        else if (m_targJoystick.getButton2())
        {
            m_targChassis.setCommand(chassis.chassisCommands.MOVEBACKWARD, 0.3);
        }
        else
        {
            m_targChassis.setCommand(chassis.chassisCommands.DONOTHING, 0.0);
        }
    }
}
