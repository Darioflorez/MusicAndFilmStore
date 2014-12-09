package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
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
	public UserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setOpaque(true);
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel startPanel = new JPanel();
		contentPane.add(startPanel, "startPanel");
		startPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel searchPanel = new JPanel();
		startPanel.add(searchPanel, BorderLayout.NORTH);
		
		JButton btnLogIn = new JButton("Log in");
		searchPanel.add(btnLogIn);
		
		JButton btnSignIn = new JButton("Sign in");
		searchPanel.add(btnSignIn);
		
		JTable infoTable = new JTable(new MyTableModel());
		infoTable.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(infoTable);
		startPanel.add(scrollPane, BorderLayout.CENTER);
	}
	
	class MyTableModel extends AbstractTableModel{

		private String[] columnNames = {"Title", "Release", "Genre", "Rating", "Artist/Director"};
		private Object[][] data = {{null,null,null,null,null}};
		
		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
	        return columnNames[col];
		}
		
		@Override
		public Object getValueAt(int row, int col) {
			return data[row][col];
		}
		
		/*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
//		public Class getColumnClass(int c) {
//            return getValueAt(0, c).getClass();
//        }
        
        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }
		
		 /*
	     * Don't need to implement this method unless your table's
	     * data can change.
	     */
	    public void setValueAt(Object value, int row, int col) {
	        data[row][col] = value;
	        fireTableCellUpdated(row, col);
	    }
	}

}
