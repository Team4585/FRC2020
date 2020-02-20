package frc.robot.biblioteca;

class ColorInput extends RoboBaseClass {
    private HuskyColor m_currentValue;
    public ColorInput() {
        super();
    }
    public HuskyColor getValue() {
        return(m_currentValue);
    }
    protected void setValue(HuskyColor color) {
        m_currentValue = color;
    }
}
