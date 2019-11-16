package HW1;

import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		//加载UI模块
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		//创建实例
		Calculator caculator = new Calculator();
	}
}
