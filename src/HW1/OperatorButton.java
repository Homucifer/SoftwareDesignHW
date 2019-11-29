package HW1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OperatorButton extends Button{
	
	public OperatorButton(String operator)
	{
		this.setText(operator);
	}
	
	public String actionPerformed(ActionEvent e, JTextField text, String output)
	{
		if(firstFlag && e.getActionCommand()!="=")
		{
			op1 = Float.parseFloat(text.getText());   
            len = text.getText().length();   
            opp = e.getActionCommand();   
            output += e.getActionCommand();   
            text.setText(output);
            firstFlag = false;
            secondFlag = true;
		}
		
		if(secondFlag && e.getActionCommand() == "=")
		{
			op2 = Float.parseFloat(text.getText().substring(len+1));
			switch(opp)
			{
			case "+":
				output = add(output);
				break;
			case "-":
				output = minus(output);
				break;
			case "x":
				output = mutiply(output);
				break;
			case "÷":
				output = divide(output);
				break;
			}
			text.setText(output);
			op1 = Float.parseFloat(output);
			firstFlag = true;
			secondFlag = false;
		}
		
		return output;
	}
	
	//加减乘除的操作
		private String add(String output) {
			output = (op1 + op2)+"";
			return output;
		}
		private String minus(String output) {
			output = (op1 - op2)+"";
			return output;
		}
		private String mutiply(String output) {
			output = (op1 * op2)+"";
			return output;
		}
		private String divide(String output) {
			output = (op1 / op2)+"";
			return output;
		}
}
