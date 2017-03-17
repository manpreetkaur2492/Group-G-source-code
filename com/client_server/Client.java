package com.client_server;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.operations.Operation;
import com.operations.ClientGet;
import com.numerousthrow.NumerousThrowSender;

public class Client extends javax.swing.JFrame {
	private javax.swing.JButton btnPlay;
	private javax.swing.JButton btnREQ;
	private javax.swing.JLabel lblBandwidth;
	private javax.swing.JLabel lblFileName;
	private javax.swing.JLabel lblStatus;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JPanel panelPly;
	private javax.swing.JTextField txtReqFile;
	public DefaultTableModel defaultTableMode;
	private static final long serialVersionUID = 1L;
	Operation operation;
	public String source;
	int port;
	int bw;
	ClientGet cg;
	public Client() {
		initComponents();
		operation = new Operation();
		init();
	}

	private void init() {
		source = operation.getSource();
		setTitle(source);
		bw = operation.getBW();
		lblBandwidth.setText("" + bw);
		port = operation.getPort();
		operation.setProperty("PORTNUMBERS.properties", source, "" + port);
		cg = new ClientGet(this, port);
		new NumerousThrowSender(source);

	}

	private void initComponents() {

		lblBandwidth = new javax.swing.JLabel();
		lblFileName = new javax.swing.JLabel();
		txtReqFile = new javax.swing.JTextField();
		btnREQ = new javax.swing.JButton();
		lblStatus = new javax.swing.JLabel();
		btnPlay = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		panelPly = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		lblBandwidth.setFont(new java.awt.Font("Arial", 1, 11));
		getContentPane().add(lblBandwidth);
		lblBandwidth.setBounds(80, 20, 110, 14);

		lblFileName.setText("Filename:");
		getContentPane().add(lblFileName);
		lblFileName.setBounds(20, 50, 80, 14);
		getContentPane().add(txtReqFile);
		txtReqFile.setBounds(100, 50, 370, 20);

		btnREQ.setText("Request");
		btnREQ.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnREQActionPerformed(evt);
			}
		});
		getContentPane().add(btnREQ);
		btnREQ.setBounds(100, 80, 110, 23);

		lblStatus.setText("Received Status:");
		getContentPane().add(lblStatus);
		lblStatus.setBounds(20, 100, 190, 14);

		btnPlay.setText("video");
		btnPlay.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPlayActionPerformed(evt);
			}
		});
		getContentPane().add(btnPlay);
		btnPlay.setBounds(-200, -360, 120, 30);

		defaultTableMode = new DefaultTableModel();
		jTable1.setModel(defaultTableMode);
		jScrollPane1.setViewportView(jTable1);
		defaultTableMode.addColumn("PacketNumber");
		defaultTableMode.addColumn("FileName");
		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(20, 120, 452, 130);

		panelPly.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Emptypanel"));
		panelPly.setLayout(null);
		getContentPane().add(panelPly);
		panelPly.setBounds(-450, -260, 320, 220);

		setSize(500, 537);
		setResizable(false);
		setVisible(true);
	}
	private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {
		operation.mediaPlayer(cg.lrecFile.getAbsolutePath(), panelPly);

	}

	private void btnREQActionPerformed(java.awt.event.ActionEvent evt) {
		operation.sendREQ(source, lblBandwidth.getText(), port, txtReqFile.getText());
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
				new Client().setVisible(true);
			}
		});
	}



}