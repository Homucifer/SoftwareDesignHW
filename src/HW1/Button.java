package HW1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Button extends JButton{
	//private JTextField text;
	static boolean firstFlag = true;
	static boolean secondFlag = false;
	static int len = 0;
	static float op1 = 0;
	static float op2 = 0;
	static String opp = "";
	private int type;
	
	public Button(String s, int typeNo)
	{
		this.setText(s);
		this.type = typeNo;
	}
	
	public String actionPerformed(ActionEvent e, JTextField text, String output)
	{
		switch(type)
		{
			case 0:
				output += e.getActionCommand();
				text.setText(output);
				break;
			case 1:
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
				
				if(secondFlag && e.getActionCommand()=="=")
				{
					op2 = Float.parseFloat(text.getText().substring(len+1));  
					switch (opp) {
					case "+": output = add(output); 		break;
					case "-": output = minus(output); 		break;
					case "x": output = mutiply(output); 	break;
					case "÷": output = divide(output);		break;
					}
					text.setText(output);
					op1 = Float.parseFloat(output);
					firstFlag = true;
					secondFlag = false;
				}
				break;
			case 2:
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
				break;
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
