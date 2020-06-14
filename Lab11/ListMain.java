import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ListMain {

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
					ListMain window = new ListMain();
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
	public ListMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	static ListElem head = null;
	private JTextField textField_2;
	private void initialize() {
		
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
				ListElem newElem = new ListElem();
				newElem.Data = textField.getText();
				newElem.next = head;
				head = newElem;
				textArea.append("Добавлен элемент: " + newElem.Data + "\n");
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
				ListElem pos = head;
				int count = 0;
				boolean find = false;
				while(pos != null) {
					if (pos.Data.equals(textField_1.getText())) {
						textArea.setText("");
						textArea.append("Строка найдена на " + count + " позиции\n");
						find = true;
					}
					pos = pos.next;
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
				ListElem pos = head;
				String final1 = "";
				while (pos != null) {
					final1 += pos.Data + "-> ";
					pos = pos.next;
				}
				final1 += "<Конец списка>";
				textArea.setText(final1);
			}
		});
		btnNewButton_2.setBounds(10, 98, 152, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\u041D\u043E\u0432\u044B\u0439 \u044D\u043B\u0435\u043C\u0435\u043D\u0442");
		lblNewLabel.setBounds(10, 11, 107, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u041F\u043E\u0438\u0441\u043A \u0432 \u0441\u043F\u0438\u0441\u043A\u0435");
		lblNewLabel_1.setBounds(10, 58, 107, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 99, 96, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C \u044D\u043B\u0435\u043C\u0435\u043D\u0442");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = Integer.parseInt(textField_2.getText());
				if (index == 0) {
					head = head.next;
					return;
				}
				ListElem pos = head;
				for (int i = 0; i < index - 1; i++) {
					if (pos == null) {
					return;
					}
				pos = pos.next;
				}
				pos.next = pos.next.next;
			}
			});
		
		
		btnNewButton_3.setBounds(296, 98, 138, 23);
		frame.getContentPane().add(btnNewButton_3);
		
	}
}
