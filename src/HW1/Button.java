package HW1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class Button extends JButton{
	static boolean firstFlag = true;
	static boolean secondFlag = false;
	static int len = 0;
	static float op1 = 0;
	static float op2 = 0;
	static String opp = "";
	
	public abstract String actionPerformed(ActionEvent e, JTextField text, String output);
}
