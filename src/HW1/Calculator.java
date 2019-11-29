package HW1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame{
	
	private JTextField text;
	private String output = "";
	// 定义字符串数组，为按钮的显示文本赋值
	String str[] = { "Inf", "00","←", "C", "7", "8", "9", "÷", "4", "5", "6",
				"x", "1", "2", "3", "-", "0", ".", "=", "+" };
	int type[] = {2,0,2,2,0,0,0,1,0,0,0,1,0,0,0,1,0,0,1,1};
		
	public Calculator() {
		super("简易计算器"); // 继承父类的构造方法

		// 初始化容器
		Container c = this.getContentPane();
		// 设置边界布局
		BorderLayout borderLayout = (BorderLayout) c.getLayout();
		borderLayout.setHgap(40);
		borderLayout.setVgap(20);

		c.setLayout(borderLayout);

		// 设置文本域外观
		text = new JTextField();
		text.setHorizontalAlignment(SwingConstants.TRAILING);
		text.setPreferredSize(new Dimension(12, 50));
		text.setColumns(10);
		text.setEditable(false);
		//c.add(text, BorderLayout.NORTH);*/

		// 定义面板，并设置为网格布局，5行4列，组件水平、垂直间距均为5
		JPanel table = new JPanel();
		table.setLayout(new GridLayout(5, 4, 5, 5));
		table.setBackground(Color.pink);// 添加颜色
		setLayout(new BorderLayout()); // 定义窗体布局为边界布局
		// 循环定义按钮，并添加到面板中
		for (int i = 0; i < str.length; i++) {
			Button button;
			switch(type[i])
			{
			case 0:
				button = new NumberButton(str[i]);
				button.addActionListener(new ActionListener() {

			        @Override
			        public void actionPerformed(ActionEvent arg0) {
			        	output = button.actionPerformed(arg0, text, output);}
				}
			        );
				table.add(button);
				break;
			case 1:
				button = new OperatorButton(str[i]);
				button.addActionListener(new ActionListener() {

			        @Override
			        public void actionPerformed(ActionEvent arg0) {
			        	output = button.actionPerformed(arg0, text, output);}
				}
			        );
				table.add(button);
				break;
			case 2:
				button = new FunctionButton(str[i]);
				button.addActionListener(new ActionListener() {

			        @Override
			        public void actionPerformed(ActionEvent arg0) {
			        	output = button.actionPerformed(arg0, text, output);}
				}
			        );
				table.add(button);
				break;
			}
		}
		
		//将组件添加到容器中
		c.add(text, BorderLayout.NORTH);
		c.add(table, BorderLayout.CENTER);
		
		//外观及功能设置
		setSize(242,304);// 定义大小
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // 让窗口居中显示
		// this.setResizable(false);// 不能改变窗体大小
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 设置鼠标形状
		this.setVisible(true);//可见
	}
}
