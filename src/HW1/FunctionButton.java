package HW1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FunctionButton extends Button{
	
	public FunctionButton(String function) 
	{
		this.setText(function);
	}
	
	public String actionPerformed(ActionEvent e, JTextField text, String output)
	{
			//重置按钮
			if (e.getActionCommand()=="C") {
				output = "";
				text.setText(output);
				firstFlag = true;
				secondFlag = false;
				len = 0;
				op1 = 0;
				op2 = 0;
				opp = "";
			}
			
			//回删按钮
			else if (e.getActionCommand()=="←") {
				String content = text.getText();
	            int remain = content.length(); 
	            String last = content.substring(remain-1);
	            //回删内容为计算符号的处理
	            if (last.equals("+") ||
	            	last.equals("-") ||
	            	last.equals("x") ||
	            	last.equals("÷")) {
	            	firstFlag = true;
	    			secondFlag = false;
	    			len = 0;
	    			op1 = 0;
	    			op2 = 0;
	    			opp = "";
	            }
				output = output.substring(0, remain-1);
				text.setText(output);
			}
			
			//作者的相关信息
			else 
			{
				output = "P76081035重構d4smart作品";
				text.setText(output);
			}
			
			return output;
	}
}
