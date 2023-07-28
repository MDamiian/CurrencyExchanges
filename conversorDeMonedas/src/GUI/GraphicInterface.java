package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GraphicInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBoxFirst;
	private JComboBox comboBoxSecond;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicInterface frame = new GraphicInterface();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setTitle("Divisas");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GraphicInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnConvert = new JButton("Conversion");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convert();
			}
		});
		btnConvert.setBounds(57, 137, 105, 21);
		contentPane.add(btnConvert);

		JButton btnClear = new JButton("Limpiar");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setBounds(182, 137, 104, 21);
		contentPane.add(btnClear);

		textField = new JTextField();
		textField.setBounds(121, 33, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cantidad");
		lblNewLabel.setBounds(57, 36, 59, 13);
		contentPane.add(lblNewLabel);

		comboBoxFirst = new JComboBox(
				new String[] { "Peso", "Dolar", "Euro", "Libra Esterlina", "Yen Japones", "Won Sul-coreano" });
		comboBoxFirst.setBounds(58, 86, 104, 21);
		contentPane.add(comboBoxFirst);

		comboBoxSecond = new JComboBox(
				new String[] { "Peso", "Dolar", "Euro", "Libra Esterlina", "Yen Japones", "Won Sul-coreano" });
		comboBoxSecond.setBounds(182, 86, 104, 21);
		contentPane.add(comboBoxSecond);
	}

	public void clear() {
		textField.setText("");
		comboBoxFirst.setSelectedIndex(0);
		comboBoxSecond.setSelectedIndex(0);
	}

	public void convert() {
		//Matriz para calcular el intercambio
		//      Peso  |Dolar   |Euro    |Libra   |Yen    |Won
		
		double[][] values = {
			    {1    , 0.059  , 0.054  , 0.046  , 8.25  , 75.98  },
			    {16.87, 1      , 0.91   , 0.78   , 139.40, 1281.92},
			    {18.53, 1.10   , 1      , 0.86   , 152.99, 1408.00},
			    {21.59, 1.28   , 1.16   , 1      , 178.28, 1640.54},
			    {0.12 , 0.0072 , 0.0065 , 0.0056 , 1     , 9.20   },
			    {0.013, 0.00078, 0.00071, 0.00061, 0.11  , 1      }
			};
		
		int first = comboBoxFirst.getSelectedIndex();
		int second = comboBoxSecond.getSelectedIndex();
		JOptionPane.showMessageDialog(this, values[first][second] * Double.valueOf(textField.getText()));
	}
}
