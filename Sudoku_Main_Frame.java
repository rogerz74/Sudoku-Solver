
   
package SudokuCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.naming.ldap.PagedResultsResponseControl;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SudokuMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTextField textField_57;
	private JTextField textField_58;
	private JTextField textField_59;
	private JTextField textField_60;
	private JTextField textField_61;
	private JTextField textField_62;
	private JTextField textField_63;
	private JTextField textField_64;
	private JTextField textField_65;
	private JTextField textField_66;
	private JTextField textField_67;
	private JTextField textField_68;
	private JTextField textField_69;
	private JTextField textField_70;
	private JTextField textField_71;
	private JTextField textField_72;
	private JTextField textField_73;
	private JTextField textField_74;
	private JTextField textField_75;
	private JTextField textField_76;
	private JTextField textField_77;
	private JTextField textField_78;
	private JTextField textField_79;
	private JTextField textField_80;
	private JLabel output1;
	private JLabel output2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void userInterface() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SudokuMainFrame frame = new SudokuMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//public SudokuMainFrame(int[][] values) {
	public SudokuMainFrame() {
		
		int[][] cells = new int[9][9];
		int i = 0, j = 0;
		Solution s = new Solution();
		Cell[][] board = new Cell[9][9];
		s.initialize(board);
		
		
		setTitle("Sudoku Solver!! ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 996);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnterButton = new JButton("Enter");
		btnEnterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Solution result = new Solution();
				Cell[][] board = new Cell[9][9];
				
				int[][] values = new int[9][9];
				int i = 0, j = 0;
				
				values[i][j] = Integer.parseInt(textField.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_1.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_2.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_3.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_4.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_5.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_6.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_7.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_8.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_9.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_10.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_11.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_12.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_13.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_14.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_15.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_16.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_17.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_18.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_19.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_20.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_21.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_22.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_23.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_24.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_25.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_26.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_27.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_28.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_29.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_30.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_31.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_32.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_33.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_34.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_35.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_36.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_37.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_38.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_39.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_40.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_41.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_42.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_43.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_44.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_45.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_46.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_47.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_48.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_49.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_50.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_51.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_52.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_53.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_54.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_55.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_56.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_57.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_58.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_59.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_60.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_61.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_62.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_63.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_64.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_65.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_66.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_67.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_68.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_69.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_70.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_71.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_72.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_73.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_74.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_75.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_76.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_77.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_78.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_79.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				values[i][j] = Integer.parseInt(textField_80.getText());
				if(j == 8)
				{
					j = 0;
					i++;
				}
				else
					j++;
				
				
				board = Sudoku.sudokuSolver(values);
				String status = result.solve(board);
				if(status == "invalid") {
					JTable msg = new JTable(1, 1);
					msg.setBounds(100, 500, 50, 20);
					msg.setValueAt("Invalid", 0, 0);
					contentPane.add(msg);
				}
				else
				{
					JTable msg = new JTable(1, 1);
					msg.setBounds(100, 500, 50, 20);
					msg.setValueAt("Valid", 0, 0);
					contentPane.add(msg);
					table = new JTable(11, 11);
					table.setBounds(200, 544, 165, 175);
					table.setGridColor(Color.BLUE);
					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
					centerRenderer.setHorizontalAlignment( JLabel.CENTER );
					int boardIndex1 = 0, boardIndex2 = 0;
					for (int index1 = 0; index1 < 11; ++index1) {
						table.getColumnModel().getColumn(index1).setMaxWidth(10);
						table.getColumnModel().getColumn(index1).setCellRenderer( centerRenderer );
						if (index1 == 3 || index1 == 7) {
							continue;
						}
						for (int index2 = 0; index2 < 11; ++index2) {
							if (index2 == 3 || index2 == 7) {
								continue;
							}
							System.out.println(boardIndex1);
							System.out.println(boardIndex2);
							table.setValueAt(board[boardIndex1][boardIndex2].getValue(), index1, index2);
							++boardIndex2;
						}
						++boardIndex1;
						boardIndex2 = 0;
					}
					contentPane.add(table);
				}
			}
		});
		btnEnterButton.setBounds(470, 348, 117, 37);
		contentPane.add(btnEnterButton);
		
		JLabel lblNewLabel = new JLabel("Enter the Numbers in the Sudoku Board! ");
		lblNewLabel.setBounds(143, 22, 274, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText("0");
		textField.setBounds(133, 50, 30, 30);
		contentPane.add(textField);
		textField.setColumns(10);
				
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setColumns(10);
		textField_1.setBounds(158, 50, 30, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setColumns(10);
		textField_2.setBounds(185, 50, 30, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setColumns(10);
		textField_3.setBounds(227, 50, 30, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setColumns(10);
		textField_4.setBounds(255, 50, 30, 30);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("0");
		textField_5.setColumns(10);
		textField_5.setBounds(282, 50, 30, 30);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("0");
		textField_6.setColumns(10);
		textField_6.setBounds(331, 50, 30, 30);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("0");
		textField_7.setColumns(10);
		textField_7.setBounds(359, 50, 30, 30);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("0");
		textField.setText("0");
		textField_8.setColumns(10);
		textField_8.setBounds(387, 50, 30, 30);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText("0");
		textField_9.setColumns(10);
		textField_9.setBounds(133, 77, 30, 30);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText("0");
		textField_10.setColumns(10);
		textField_10.setBounds(158, 77, 30, 30);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setText("0");
		textField_11.setColumns(10);
		textField_11.setBounds(185, 77, 30, 30);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setText("0");
		textField_12.setColumns(10);
		textField_12.setBounds(227, 79, 30, 30);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setText("0");
		textField_13.setColumns(10);
		textField_13.setBounds(255, 79, 30, 30);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setText("0");
		textField_14.setColumns(10);
		textField_14.setBounds(282, 79, 30, 30);
		contentPane.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setText("0");
		textField_15.setColumns(10);
		textField_15.setBounds(331, 79, 30, 30);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setText("0");
		textField_16.setColumns(10);
		textField_16.setBounds(359, 79, 30, 30);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setText("0");
		textField_17.setColumns(10);
		textField_17.setBounds(387, 79, 30, 30);
		contentPane.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setText("0");
		textField_18.setColumns(10);
		textField_18.setBounds(133, 108, 30, 30);
		contentPane.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setText("0");
		textField_19.setColumns(10);
		textField_19.setBounds(158, 108, 30, 30);
		contentPane.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setText("0");
		textField_20.setColumns(10);
		textField_20.setBounds(185, 108, 30, 30);
		contentPane.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setText("0");
		textField_21.setColumns(10);
		textField_21.setBounds(227, 108, 30, 30);
		contentPane.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setText("0");
		textField_22.setColumns(10);
		textField_22.setBounds(255, 108, 30, 30);
		contentPane.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setText("0");
		textField_23.setColumns(10);
		textField_23.setBounds(282, 108, 30, 30);
		contentPane.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setText("0");
		textField_24.setColumns(10);
		textField_24.setBounds(331, 108, 30, 30);
		contentPane.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setText("0");
		textField_25.setColumns(10);
		textField_25.setBounds(359, 108, 30, 30);
		contentPane.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setText("0");
		textField_26.setColumns(10);
		textField_26.setBounds(387, 108, 30, 30);
		contentPane.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setText("0");
		textField_27.setColumns(10);
		textField_27.setBounds(133, 150, 30, 30);
		contentPane.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setText("0");
		textField_28.setColumns(10);
		textField_28.setBounds(158, 150, 30, 30);
		contentPane.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setText("0");
		textField_29.setColumns(10);
		textField_29.setBounds(185, 150, 30, 30);
		contentPane.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setText("0");
		textField_30.setColumns(10);
		textField_30.setBounds(227, 150, 30, 30);
		contentPane.add(textField_30);
		
		textField_31 = new JTextField();
		textField_31.setText("0");
		textField_31.setColumns(10);
		textField_31.setBounds(255, 150, 30, 30);
		contentPane.add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setText("0");
		textField_32.setColumns(10);
		textField_32.setBounds(282, 150, 30, 30);
		contentPane.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setText("0");
		textField_33.setColumns(10);
		textField_33.setBounds(331, 150, 30, 30);
		contentPane.add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setText("0");
		textField_34.setColumns(10);
		textField_34.setBounds(359, 150, 30, 30);
		contentPane.add(textField_34);
		
		textField_35 = new JTextField();
		textField_35.setText("0");
		textField_35.setColumns(10);
		textField_35.setBounds(387, 150, 30, 30);
		contentPane.add(textField_35);
		
		textField_36 = new JTextField();
		textField_36.setText("0");
		textField_36.setColumns(10);
		textField_36.setBounds(133, 181, 30, 30);
		contentPane.add(textField_36);
		
		textField_37 = new JTextField();
		textField_37.setText("0");
		textField_37.setColumns(10);
		textField_37.setBounds(158, 181, 30, 30);
		contentPane.add(textField_37);
		
		textField_38 = new JTextField();
		textField_38.setText("0");
		textField_38.setColumns(10);
		textField_38.setBounds(185, 181, 30, 30);
		contentPane.add(textField_38);
		
		textField_39 = new JTextField();
		textField_39.setText("0");
		textField_39.setColumns(10);
		textField_39.setBounds(227, 181, 30, 30);
		contentPane.add(textField_39);
		
		textField_40 = new JTextField();
		textField_40.setText("0");
		textField_40.setColumns(10);
		textField_40.setBounds(255, 181, 30, 30);
		contentPane.add(textField_40);
		
		textField_41 = new JTextField();
		textField_41.setText("0");
		textField_41.setColumns(10);
		textField_41.setBounds(282, 181, 30, 30);
		contentPane.add(textField_41);
		
		textField_42 = new JTextField();
		textField_42.setText("0");
		textField_42.setColumns(10);
		textField_42.setBounds(331, 181, 30, 30);
		contentPane.add(textField_42);
		
		textField_43 = new JTextField();
		textField_43.setText("0");
		textField_43.setColumns(10);
		textField_43.setBounds(359, 181, 30, 30);
		contentPane.add(textField_43);
		
		textField_44 = new JTextField();
		textField_44.setText("0");
		textField_44.setColumns(10);
		textField_44.setBounds(387, 181, 30, 30);
		contentPane.add(textField_44);
		
		textField_45 = new JTextField();
		textField_45.setText("0");
		textField_45.setColumns(10);
		textField_45.setBounds(133, 212, 30, 30);
		contentPane.add(textField_45);
		
		textField_46 = new JTextField();
		textField_46.setText("0");
		textField_46.setColumns(10);
		textField_46.setBounds(158, 212, 30, 30);
		contentPane.add(textField_46);
		
		textField_47 = new JTextField();
		textField_47.setText("0");
		textField_47.setColumns(10);
		textField_47.setBounds(185, 212, 30, 30);
		contentPane.add(textField_47);
		
		textField_48 = new JTextField();
		textField_48.setText("0");
		textField_48.setColumns(10);
		textField_48.setBounds(227, 212, 30, 30);
		contentPane.add(textField_48);
		
		textField_49 = new JTextField();
		textField_49.setText("0");
		textField_49.setColumns(10);
		textField_49.setBounds(255, 212, 30, 30);
		contentPane.add(textField_49);
		
		textField_50 = new JTextField();
		textField_50.setText("0");
		textField_50.setColumns(10);
		textField_50.setBounds(282, 212, 30, 30);
		contentPane.add(textField_50);
		
		textField_51 = new JTextField();
		textField_51.setText("0");
		textField_51.setColumns(10);
		textField_51.setBounds(331, 212, 30, 30);
		contentPane.add(textField_51);
		
		textField_52 = new JTextField();
		textField_52.setText("0");
		textField_52.setColumns(10);
		textField_52.setBounds(359, 212, 30, 30);
		contentPane.add(textField_52);
		
		textField_53 = new JTextField();
		textField_53.setText("0");
		textField_53.setColumns(10);
		textField_53.setBounds(387, 212, 30, 30);
		contentPane.add(textField_53);
		
		textField_54 = new JTextField();
		textField_54.setText("0");
		textField_54.setColumns(10);
		textField_54.setBounds(133, 254, 30, 30);
		contentPane.add(textField_54);
		
		textField_55 = new JTextField();
		textField_55.setText("0");
		textField_55.setColumns(10);
		textField_55.setBounds(158, 254, 30, 30);
		contentPane.add(textField_55);
		
		textField_56 = new JTextField();
		textField_56.setText("0");
		textField_56.setColumns(10);
		textField_56.setBounds(185, 254, 30, 30);
		contentPane.add(textField_56);
		
		textField_57 = new JTextField();
		textField_57.setText("0");
		textField_57.setColumns(10);
		textField_57.setBounds(227, 254, 30, 30);
		contentPane.add(textField_57);
		
		textField_58 = new JTextField();
		textField_58.setText("0");
		textField_58.setColumns(10);
		textField_58.setBounds(255, 254, 30, 30);
		contentPane.add(textField_58);
		
		textField_59 = new JTextField();
		textField_59.setText("0");
		textField_59.setColumns(10);
		textField_59.setBounds(282, 254, 30, 30);
		contentPane.add(textField_59);
		
		textField_60 = new JTextField();
		textField_60.setText("0");
		textField_60.setColumns(10);
		textField_60.setBounds(331, 254, 30, 30);
		contentPane.add(textField_60);
		
		textField_61 = new JTextField();
		textField_61.setText("0");
		textField_61.setColumns(10);
		textField_61.setBounds(359, 254, 30, 30);
		contentPane.add(textField_61);
		
		textField_62 = new JTextField();
		textField_62.setText("0");
		textField_62.setColumns(10);
		textField_62.setBounds(387, 254, 30, 30);
		contentPane.add(textField_62);
		
		textField_63 = new JTextField();
		textField_63.setText("0");
		textField_63.setColumns(10);
		textField_63.setBounds(133, 285, 30, 30);
		contentPane.add(textField_63);
		
		textField_64 = new JTextField();
		textField_64.setText("0");
		textField_64.setColumns(10);
		textField_64.setBounds(158, 285, 30, 30);
		contentPane.add(textField_64);
		
		textField_65 = new JTextField();
		textField_65.setText("0");
		textField_65.setColumns(10);
		textField_65.setBounds(185, 285, 30, 30);
		contentPane.add(textField_65);
		
		textField_66 = new JTextField();
		textField_66.setText("0");
		textField_66.setColumns(10);
		textField_66.setBounds(227, 285, 30, 30);
		contentPane.add(textField_66);
		
		textField_67 = new JTextField();
		textField_67.setText("0");
		textField_67.setColumns(10);
		textField_67.setBounds(255, 285, 30, 30);
		contentPane.add(textField_67);
		
		textField_68 = new JTextField();
		textField_68.setText("0");
		textField_68.setColumns(10);
		textField_68.setBounds(282, 285, 30, 30);
		contentPane.add(textField_68);
		
		textField_69 = new JTextField();
		textField_69.setText("0");
		textField_69.setColumns(10);
		textField_69.setBounds(331, 285, 30, 30);
		contentPane.add(textField_69);
		
		textField_70 = new JTextField();
		textField_70.setText("0");
		textField_70.setColumns(10);
		textField_70.setBounds(359, 285, 30, 30);
		contentPane.add(textField_70);
		
		textField_71 = new JTextField();
		textField_71.setText("0");
		textField_71.setColumns(10);
		textField_71.setBounds(387, 285, 30, 30);
		contentPane.add(textField_71);
		
		textField_72 = new JTextField();
		textField_72.setText("0");
		textField_72.setColumns(10);
		textField_72.setBounds(133, 319, 30, 30);
		contentPane.add(textField_72);
		
		textField_73 = new JTextField();
		textField_73.setText("0");
		textField_73.setColumns(10);
		textField_73.setBounds(158, 319, 30, 30);
		contentPane.add(textField_73);
		
		textField_74 = new JTextField();
		textField_74.setText("0");
		textField_74.setColumns(10);
		textField_74.setBounds(185, 319, 30, 30);
		contentPane.add(textField_74);
		
		textField_75 = new JTextField();
		textField_75.setText("0");
		textField_75.setColumns(10);
		textField_75.setBounds(227, 319, 30, 30);
		contentPane.add(textField_75);
		
		textField_76 = new JTextField();
		textField_76.setText("0");
		textField_76.setColumns(10);
		textField_76.setBounds(255, 319, 30, 30);
		contentPane.add(textField_76);
		
		textField_77 = new JTextField();
		textField_77.setText("0");
		textField_77.setColumns(10);
		textField_77.setBounds(282, 319, 30, 30);
		contentPane.add(textField_77);
		
		textField_78 = new JTextField();
		textField_78.setText("0");
		textField_78.setColumns(10);
		textField_78.setBounds(331, 319, 30, 30);
		contentPane.add(textField_78);
		
		textField_79 = new JTextField();
		textField_79.setText("0");
		textField_79.setColumns(10);
		textField_79.setBounds(359, 319, 30, 30);
		contentPane.add(textField_79);
		
		textField_80 = new JTextField();
		textField_80.setText("0");
		textField_80.setColumns(10);
		textField_80.setBounds(387, 319, 30, 30);
		contentPane.add(textField_80);
	}
}
