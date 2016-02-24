package jWatermark;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.JComboBox;

public class MainWindow {

	private JFrame frmJwatermark;
	private JTextField inputTextField;
	private JTextField watermarkTextField;
	private JTextField outputTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmJwatermark.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		String[] watermarkPositionCombo = {"Top-Left", "Top-Center", "Top-Right", "Middle-Left", "Middle-Center", "Middle-Right"};
		
		frmJwatermark = new JFrame();
		frmJwatermark.setTitle("jWaterMark");
		frmJwatermark.setBounds(100, 100, 548, 504);
		frmJwatermark.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJwatermark.setMinimumSize(new Dimension(250, 500));

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frmJwatermark.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblInputPicturesFolder = new JLabel("Input Pictures Folder:");
		lblInputPicturesFolder.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblInputPicturesFolder = new GridBagConstraints();
		gbc_lblInputPicturesFolder.fill = GridBagConstraints.BOTH;
		gbc_lblInputPicturesFolder.insets = new Insets(5, 5, 5, 5);
		gbc_lblInputPicturesFolder.gridx = 0;
		gbc_lblInputPicturesFolder.gridy = 0;
		frmJwatermark.getContentPane().add(lblInputPicturesFolder, gbc_lblInputPicturesFolder);
		
		inputTextField = new JTextField();
		lblInputPicturesFolder.setLabelFor(inputTextField);
		GridBagConstraints gbc_inputTextField = new GridBagConstraints();
		gbc_inputTextField.anchor = GridBagConstraints.NORTH;
		gbc_inputTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputTextField.insets = new Insets(0, 5, 5, 5);
		gbc_inputTextField.gridx = 0;
		gbc_inputTextField.gridy = 1;
		frmJwatermark.getContentPane().add(inputTextField, gbc_inputTextField);
		inputTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Browse...");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		frmJwatermark.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Watermark Picture Location:");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 5, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		frmJwatermark.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		watermarkTextField = new JTextField();
		lblNewLabel.setLabelFor(watermarkTextField);
		GridBagConstraints gbc_watermarkTextField = new GridBagConstraints();
		gbc_watermarkTextField.anchor = GridBagConstraints.NORTH;
		gbc_watermarkTextField.insets = new Insets(0, 5, 5, 5);
		gbc_watermarkTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_watermarkTextField.gridx = 0;
		gbc_watermarkTextField.gridy = 3;
		frmJwatermark.getContentPane().add(watermarkTextField, gbc_watermarkTextField);
		watermarkTextField.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse...");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
		gbc_btnBrowse.anchor = GridBagConstraints.NORTH;
		gbc_btnBrowse.insets = new Insets(0, 0, 5, 5);
		gbc_btnBrowse.gridx = 1;
		gbc_btnBrowse.gridy = 3;
		frmJwatermark.getContentPane().add(btnBrowse, gbc_btnBrowse);
		
		JLabel lblOutputFolder = new JLabel("Output Folder:");
		lblOutputFolder.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblOutputFolder = new GridBagConstraints();
		gbc_lblOutputFolder.fill = GridBagConstraints.BOTH;
		gbc_lblOutputFolder.insets = new Insets(0, 5, 5, 5);
		gbc_lblOutputFolder.gridx = 0;
		gbc_lblOutputFolder.gridy = 4;
		frmJwatermark.getContentPane().add(lblOutputFolder, gbc_lblOutputFolder);
		
		outputTextField = new JTextField();
		lblOutputFolder.setLabelFor(outputTextField);
		GridBagConstraints gbc_outputTextField = new GridBagConstraints();
		gbc_outputTextField.anchor = GridBagConstraints.NORTH;
		gbc_outputTextField.insets = new Insets(0, 5, 5, 5);
		gbc_outputTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_outputTextField.gridx = 0;
		gbc_outputTextField.gridy = 5;
		frmJwatermark.getContentPane().add(outputTextField, gbc_outputTextField);
		outputTextField.setColumns(10);
		
		JButton btnBrowse_1 = new JButton("Browse...");
		btnBrowse_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnBrowse_1 = new GridBagConstraints();
		gbc_btnBrowse_1.anchor = GridBagConstraints.NORTH;
		gbc_btnBrowse_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnBrowse_1.gridx = 1;
		gbc_btnBrowse_1.gridy = 5;
		frmJwatermark.getContentPane().add(btnBrowse_1, gbc_btnBrowse_1);
		
		JLabel lblOpacity = new JLabel("Opacity:");
		GridBagConstraints gbc_lblOpacity = new GridBagConstraints();
		gbc_lblOpacity.fill = GridBagConstraints.BOTH;
		gbc_lblOpacity.insets = new Insets(0, 5, 5, 5);
		gbc_lblOpacity.gridx = 0;
		gbc_lblOpacity.gridy = 6;
		frmJwatermark.getContentPane().add(lblOpacity, gbc_lblOpacity);
		
		JSlider opacitySlider = new JSlider(SwingConstants.HORIZONTAL);
		opacitySlider.setValue(80);
		opacitySlider.setPaintLabels(true);
		opacitySlider.setPaintTicks(true);
		lblOpacity.setLabelFor(opacitySlider);
		GridBagConstraints gbc_opacitySlider = new GridBagConstraints();
		gbc_opacitySlider.gridwidth = 2;
		gbc_opacitySlider.anchor = GridBagConstraints.NORTH;
		gbc_opacitySlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_opacitySlider.insets = new Insets(0, 0, 5, 5);
		gbc_opacitySlider.gridx = 0;
		gbc_opacitySlider.gridy = 7;
		opacitySlider.setMajorTickSpacing(10);
		frmJwatermark.getContentPane().add(opacitySlider, gbc_opacitySlider);
		
		JLabel lblWatermarkLocation = new JLabel("Watermark Position:");
		GridBagConstraints gbc_lblWatermarkLocation = new GridBagConstraints();
		gbc_lblWatermarkLocation.fill = GridBagConstraints.VERTICAL;
		gbc_lblWatermarkLocation.anchor = GridBagConstraints.WEST;
		gbc_lblWatermarkLocation.insets = new Insets(0, 5, 5, 5);
		gbc_lblWatermarkLocation.gridx = 0;
		gbc_lblWatermarkLocation.gridy = 8;
		frmJwatermark.getContentPane().add(lblWatermarkLocation, gbc_lblWatermarkLocation);
		
		JComboBox<Object> comboBox = new JComboBox<Object>(watermarkPositionCombo);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTH;
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 5, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 9;
		frmJwatermark.getContentPane().add(comboBox, gbc_comboBox);
		
		JButton btnNewButton_1 = new JButton("Apply");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.insets = new Insets(5, 5, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 10;
		frmJwatermark.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
	}

}
