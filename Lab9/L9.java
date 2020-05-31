import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class L9 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					L9 window = new L9();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public L9() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	String in = "";
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 15, 314, 235);
		frame.getContentPane().add(textArea);
	
		
		JButton btnNewButton = new JButton("\u0417\u0430\u043C\u0435\u043D\u0438\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = textArea.getText();
				StringTokenizer st = new StringTokenizer(a, " \t\n\r,.");
				int count = 0;
				while(st.hasMoreTokens()){
					StringBuilder sb = new StringBuilder(st.nextToken());
					if ((sb.charAt(0) == 'A') || (sb.charAt(0) == 'a'))   {
						count++;
					}
				}
				try {
					FileWriter wr = new FileWriter(new File("C:\\Temp\\lab9.html"), false);
					a = "<!DOCTYPE html><head>    <title>lab9</title></head><body>  <p align='center'><b>Лабораторная работа №9</b></p>  <p align='center'><i>Вариант A</i></p>  <p>Выполнил студент группы <i>ИВТАСбд-11</i> <b>Егоров В.С.</b></p>  <p>Файл: <b>lab9.html</b></p>  <p>Начало слова: <b>А</b></p>  <p>Количество найденных слов: <b>" + count + "</b></p></body></html>";
					wr.write(a);
					wr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(328, 46, 96, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Scanner sc = new Scanner(new FileReader(new File("C:\\Temp\\inputl9.txt")));
					while(sc.hasNextLine()) {
					in += sc.nextLine() + "\n";
					textArea.setText(in);
					}
					sc.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(328, 11, 96, 23);
		frame.getContentPane().add(btnNewButton_1);
		
	}	
}
