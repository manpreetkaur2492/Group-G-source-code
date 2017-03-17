
package com.client_server;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.operations.Operation;
import com.operations.ServerGet;
import com.numerousthrow.NumerousThrowGetter;

public class Server extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	private javax.swing.JLabel title_label;
	private javax.swing.JLabel lbl_Requested_Client;
	private javax.swing.JLabel lblMutDVC;
	private javax.swing.JLabel lbl_Avilable_Clnt;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	public javax.swing.JTextArea txtAreaDB;
	public javax.swing.JTextArea txtAreaMultiDescCoding;
	public javax.swing.JTextArea txtAreaNodes;
	private javax.swing.JTable tbl;
	private javax.swing.JTextField txtBW;
	public DefaultTableModel defaultTableMode;
	Operation operation;

	public Server() {
		initComponents();
		init();
	}

	private void init() {
		operation = new Operation();
		operation.loadFiles(txtAreaDB);
		new ServerGet(this);
		new NumerousThrowGetter(this);
	}

	private void initComponents() {
		
		jScrollPane1 = new javax.swing.JScrollPane();
		txtAreaDB = new javax.swing.JTextArea();
		title_label = new javax.swing.JLabel();
		txtBW = new javax.swing.JTextField();
		lbl_Requested_Client = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		tbl = new javax.swing.JTable();
		jScrollPane3 = new javax.swing.JScrollPane();
		txtAreaMultiDescCoding = new javax.swing.JTextArea();
		lblMutDVC = new javax.swing.JLabel();
		lbl_Avilable_Clnt = new javax.swing.JLabel();
		jScrollPane4 = new javax.swing.JScrollPane();
		txtAreaNodes = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		

		txtAreaDB.setColumns(20);
		txtAreaDB.setRows(5);
		jScrollPane1.setViewportView(txtAreaDB);

		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(-400, -400, 190, 170);

		title_label.setText("Standard-Compliant Multiple Description video coding");
		getContentPane().add(title_label);
		title_label.setBounds(70, 10, 400, 20);

		lbl_Requested_Client.setText("Requested Client:");
		getContentPane().add(lbl_Requested_Client);
		lbl_Requested_Client.setBounds(220, 40, 120, 16);

		defaultTableMode = new DefaultTableModel();
		tbl.setModel(defaultTableMode);
		jScrollPane2.setViewportView(tbl);
		defaultTableMode.addColumn("Clent Name");
		defaultTableMode.addColumn("Port");
		defaultTableMode.addColumn("File");

		getContentPane().add(jScrollPane2);
		jScrollPane2.setBounds(20, 60, 580, 170);

		txtAreaMultiDescCoding.setColumns(20);
		txtAreaMultiDescCoding.setRows(5);
		jScrollPane3.setViewportView(txtAreaMultiDescCoding);

		getContentPane().add(jScrollPane3);
		jScrollPane3.setBounds(220, 260, 390, 220);

		lblMutDVC.setText("Multiple Description video coding");
		getContentPane().add(lblMutDVC);
		lblMutDVC.setBounds(220, 240, 300, 16);

		lbl_Avilable_Clnt.setText("Available Clients");
		getContentPane().add(lbl_Avilable_Clnt);
		lbl_Avilable_Clnt.setBounds(20, 240, 150, 16);

		txtAreaNodes.setColumns(20);
		txtAreaNodes.setRows(5);
		jScrollPane4.setViewportView(txtAreaNodes);

		getContentPane().add(jScrollPane4);
		jScrollPane4.setBounds(20, 260, 190, 220);

		setSize(650, 537);
		setTitle("Server : Multiple Description video coding");
		setResizable(false);
		setVisible(true);

	}

	public static void main(String args[]) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Server().setVisible(true);
			}
		});
	}

}