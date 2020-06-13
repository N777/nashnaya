import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;



import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ListJ {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListJ window = new ListJ();
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
	public ListJ() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private JTextField textField_2;
	private void initialize() {
		List<String> linkedList = new LinkedList<String>();
		frame = new JFrame();
		frame.setBounds(100, 100, 564, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 132, 528, 279);
		frame.getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setBounds(10, 30, 389, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				linkedList.add(textField.getText());
				textArea.append("Добавлен элемент: " + textField.getText() + "\n");
			}
		});
		btnNewButton.setBounds(409, 29, 116, 23);
		frame.getContentPane().add(btnNewButton);
		

		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 73, 389, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u041D\u0430\u0439\u0442\u0438");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListIterator<String> it = linkedList.listIterator(linkedList.size());
				String final1 = "";
				int count = 0;
				boolean find = false;
				textArea.setText("");
				while(it.hasPrevious()) {
					if(it.previous().equals(textField_1.getText())){
						textArea.append("Строка найдена на " + count + " позиции\n");
						find = true;
					}
					count++;
				}
				if (find == false) {
					textArea.setText("Строка не найдена");
				}
			}
		});
		btnNewButton_1.setBounds(409, 72, 116, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u0412\u044B\u0432\u0435\u0441\u0442\u0438 \u0441\u043F\u0438\u0441\u043E\u043A");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListIterator<String> it = linkedList.listIterator();
				String final1 = "";
				while(it.hasNext()) {
					final1 += it.next() + "-> ";
				}
				final1 += "<Конец списка>";
				textArea.setText(final1);
			}
		});
		btnNewButton_2.setBounds(10, 98, 138, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\u041D\u043E\u0432\u044B\u0439 \u044D\u043B\u0435\u043C\u0435\u043D\u0442");
		lblNewLabel.setBounds(10, 11, 107, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u041F\u043E\u0438\u0441\u043A \u0432 \u0441\u043F\u0438\u0441\u043A\u0435");
		lblNewLabel_1.setBounds(10, 58, 107, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(293, 99, 96, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C \u044D\u043B\u0435\u043C\u0435\u043D\u0442");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = Integer.parseInt(textField_2.getText());
				linkedList.remove(index);
			}
			});
		
		
		btnNewButton_3.setBounds(400, 98, 138, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u0412\u044B\u0432\u0435\u0441\u0442\u0438 \u0441\u043F\u0438\u0441\u043E\u043A \u0432 \u043E\u0431\u0440\u0430\u0442\u043D\u043E\u043C \u043D\u0430\u043F\u0440\u0432\u043B\u0435\u043D\u0438\u0438");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListIterator<String> it = linkedList.listIterator(linkedList.size());
				String final1 = "";
				while(it.hasPrevious()) {
					final1 += it.previous() + "-> ";
				}
				final1 += "<Конец списка>";
				textArea.setText(final1);
			}
		});
		btnNewButton_4.setBounds(158, 98, 125, 23);
		frame.getContentPane().add(btnNewButton_4);
		
	}
}
