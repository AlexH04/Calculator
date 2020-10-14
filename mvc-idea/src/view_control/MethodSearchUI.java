package view_control;
/*
  UI to support MethodSearch evaluation

  support one input and multiple outputs

  @version 1.0
 * @author John Mortensen
 */

import control_file_search.MethodSearch;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class MethodSearchUI extends MainMenu {

	/**
	 * 
	 */
	// view section ++
	private static final long serialVersionUID = 1L;
	private final JTextField filename;
	private final JTextField searchTerm;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				MethodSearchUI frame = new MethodSearchUI();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public MethodSearchUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		DefaultListModel<String> l1 = new DefaultListModel<>();  // support for JList
		JList<String> list = new JList<>(l1);  					// l1 is JList working element
        list.setBounds(16,101, 414,137);  
        contentPane.add(list); 
       
		JLabel lblFileName = new JLabel("Search File Name");
		lblFileName.setBounds(6, 0, 184, 26);
		contentPane.add(lblFileName);
		
		filename = new JTextField();
		filename.setBounds(6, 21, 438, 26);
		contentPane.add(filename);
		filename.setColumns(10);
		filename.setText("control_ap_exam/BinaryMathQuestions.java");
		
		JLabel lblTerm = new JLabel("Search Term");
		lblTerm.setBounds(6, 38, 184, 26);
		contentPane.add(lblTerm);
		
		searchTerm = new JTextField();
		searchTerm.setColumns(10);
		searchTerm.setBounds(6, 63, 438, 26);
		contentPane.add(searchTerm);
		searchTerm.setText("Binary");

		JButton buttonTest = new JButton("Test");
		buttonTest.addActionListener(e -> {
			ArrayList<String> methods = MethodSearch.getMethods(filename.getText(), searchTerm.getText());
			l1.clear();
			for (String method: methods) {
				l1.addElement(method);
			}
		});
		buttonTest.setBounds(275, 0, 145, 29);
		contentPane.add(buttonTest);
		
		JButton buttonTestConsole = new JButton("C");
		buttonTestConsole.setForeground(Color.RED);
		buttonTestConsole.setBackground(Color.LIGHT_GRAY);
		buttonTestConsole.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		buttonTestConsole.addActionListener(e -> MethodSearch.main(filename.getText(), searchTerm.getText()));
		buttonTestConsole.setBounds(419, 7, 21, 18);
		contentPane.add(buttonTestConsole); 
         
		
	}
}
