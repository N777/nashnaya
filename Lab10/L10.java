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

public class L10 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					L10 window = new L10();
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
	public L10() {
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
	
		String final1 = null;
		JButton btnNewButton = new JButton("\u0421\u043E\u0440\u0442\u0438\u0440\u043E\u0432\u0430\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String a = textArea.getText();
				String final1 = a;
				StringTokenizer st = new StringTokenizer(a, " \t\n\r,.");
				int count = st.countTokens();
				int arr[] = null;
				arr = new int[count];
				
				while(st.hasMoreTokens()){

					for (int i = 0; i < count; i++) {
						arr[i] = Integer.parseInt(st.nextToken());
					}
				}
				for (int i = 0; i < count; i++) {
					boolean stop = false;
					
					for (int j = 1; j < count; j++) {
						
						stop = true;
						if (arr[j-1] > arr[j]) {
							stop = false;
							int temp = arr[j];
							arr[j] = arr[j-1];
							arr[j-1] = temp;
							
						}
					
					if (stop == false) {
					for (int k = 0; k < count; k++) {
					final1 += arr[k] + " ";
					}
					final1 += "\n";
					textArea.setText(final1);
					}}
					
				}
				
				try {
					FileWriter wr = new FileWriter(new File("C:\\Temp\\lab10.txt"), false);
					wr.write(final1);
					wr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(328, 46, 106, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Scanner sc = new Scanner(new FileReader(new File("C:\\Temp\\inputl10.txt")));
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
