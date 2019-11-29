package HW1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.*;

public class NumberButton extends Button{

	public NumberButton(String number)
	{
		this.setText(number);
	}
	
	public String actionPerformed(ActionEvent e, JTextField text, String output)
	{
		output += e.getActionCommand();
		text.setText(output);
		return output;
	}
}
