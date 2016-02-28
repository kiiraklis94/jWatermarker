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
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.Font;

public class MainWindow {

	private JFrame frmJwatermark;
	private JTextArea inputTextArea;
	private JTextField watermarkTextField;
	private JTextField outputTextField;
	private JComboBox watermarkPosComboBox;
	private JSlider opacitySlider;

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
		
		String[] watermarkPositionCombo = {"Top-Left", "Top-Center", "Top-Right", "Middle-Left", "Middle-Center", "Middle-Right", "Bottom-Left", "Bottom-Center", 
				"Bottom-Right"};
		
		frmJwatermark = new JFrame();
		frmJwatermark.setTitle("jWaterMark");
		frmJwatermark.setBounds(100, 100, 516, 500);
		frmJwatermark.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJwatermark.setMinimumSize(new Dimension(250, 500));

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frmJwatermark.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblInputPicturesFolder = new JLabel("Input Pictures:");
		lblInputPicturesFolder.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblInputPicturesFolder = new GridBagConstraints();
		gbc_lblInputPicturesFolder.fill = GridBagConstraints.BOTH;
		gbc_lblInputPicturesFolder.insets = new Insets(5, 5, 5, 5);
		gbc_lblInputPicturesFolder.gridx = 0;
		gbc_lblInputPicturesFolder.gridy = 0;
		frmJwatermark.getContentPane().add(lblInputPicturesFolder, gbc_lblInputPicturesFolder);

		inputTextArea = new JTextArea();
		inputTextArea.setEditable(false);
		inputTextArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
		inputTextArea.setRows(4);
		lblInputPicturesFolder.setLabelFor(inputTextArea);
		GridBagConstraints gbc_inputTextArea = new GridBagConstraints();
		gbc_inputTextArea.anchor = GridBagConstraints.NORTH;
		gbc_inputTextArea.fill = GridBagConstraints.BOTH;
		gbc_inputTextArea.insets = new Insets(0, 5, 5, 5);
		gbc_inputTextArea.gridx = 0;
		gbc_inputTextArea.gridy = 1;
		
		JScrollPane scrollPane = new JScrollPane(inputTextArea);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.anchor = GridBagConstraints.NORTH;
		gbc_scrollPane.insets = new Insets(0, 5, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		frmJwatermark.getContentPane().add(scrollPane, gbc_scrollPane);
		
		JButton inputBrowseButton = new JButton("Browse...");
		inputBrowseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputBrowsePressed();				
			}
		});
		GridBagConstraints gbc_inputBrowseButton = new GridBagConstraints();
		gbc_inputBrowseButton.fill = GridBagConstraints.BOTH;
		gbc_inputBrowseButton.anchor = GridBagConstraints.NORTH;
		gbc_inputBrowseButton.insets = new Insets(0, 0, 5, 5);
		gbc_inputBrowseButton.gridx = 1;
		gbc_inputBrowseButton.gridy = 1;
		frmJwatermark.getContentPane().add(inputBrowseButton, gbc_inputBrowseButton);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 2;
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		frmJwatermark.getContentPane().add(separator, gbc_separator);
		
		JLabel lblNewLabel = new JLabel("Watermark Picture:");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 5, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		frmJwatermark.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		watermarkTextField = new JTextField();
		lblNewLabel.setLabelFor(watermarkTextField);
		GridBagConstraints gbc_watermarkTextField = new GridBagConstraints();
		gbc_watermarkTextField.anchor = GridBagConstraints.NORTH;
		gbc_watermarkTextField.insets = new Insets(0, 5, 5, 5);
		gbc_watermarkTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_watermarkTextField.gridx = 0;
		gbc_watermarkTextField.gridy = 4;
		frmJwatermark.getContentPane().add(watermarkTextField, gbc_watermarkTextField);
		watermarkTextField.setColumns(10);
		
		JButton watermarkBrowseButton = new JButton("Browse...");
		watermarkBrowseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				watermarkBrowsePressed();
			}
		});
		GridBagConstraints gbc_watermarkBrowseButton = new GridBagConstraints();
		gbc_watermarkBrowseButton.anchor = GridBagConstraints.NORTH;
		gbc_watermarkBrowseButton.insets = new Insets(0, 0, 5, 5);
		gbc_watermarkBrowseButton.gridx = 1;
		gbc_watermarkBrowseButton.gridy = 4;
		frmJwatermark.getContentPane().add(watermarkBrowseButton, gbc_watermarkBrowseButton);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.gridwidth = 2;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 5;
		frmJwatermark.getContentPane().add(separator_1, gbc_separator_1);
		
		JLabel lblOutputFolder = new JLabel("Output Folder:");
		lblOutputFolder.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblOutputFolder = new GridBagConstraints();
		gbc_lblOutputFolder.fill = GridBagConstraints.BOTH;
		gbc_lblOutputFolder.insets = new Insets(0, 5, 5, 5);
		gbc_lblOutputFolder.gridx = 0;
		gbc_lblOutputFolder.gridy = 6;
		frmJwatermark.getContentPane().add(lblOutputFolder, gbc_lblOutputFolder);
		
		outputTextField = new JTextField();
		lblOutputFolder.setLabelFor(outputTextField);
		GridBagConstraints gbc_outputTextField = new GridBagConstraints();
		gbc_outputTextField.anchor = GridBagConstraints.NORTH;
		gbc_outputTextField.insets = new Insets(0, 5, 5, 5);
		gbc_outputTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_outputTextField.gridx = 0;
		gbc_outputTextField.gridy = 7;
		frmJwatermark.getContentPane().add(outputTextField, gbc_outputTextField);
		outputTextField.setColumns(10);
		
		JButton outputBrowseButton = new JButton("Browse...");
		outputBrowseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputBrowsePressed();
			}
		});
		GridBagConstraints gbc_outputBrowseButton = new GridBagConstraints();
		gbc_outputBrowseButton.anchor = GridBagConstraints.NORTH;
		gbc_outputBrowseButton.insets = new Insets(0, 0, 5, 5);
		gbc_outputBrowseButton.gridx = 1;
		gbc_outputBrowseButton.gridy = 7;
		frmJwatermark.getContentPane().add(outputBrowseButton, gbc_outputBrowseButton);
		
		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_2.gridwidth = 2;
		gbc_separator_2.insets = new Insets(0, 0, 5, 0);
		gbc_separator_2.gridx = 0;
		gbc_separator_2.gridy = 8;
		frmJwatermark.getContentPane().add(separator_2, gbc_separator_2);
		
		JLabel lblOpacity = new JLabel("Opacity:");
		GridBagConstraints gbc_lblOpacity = new GridBagConstraints();
		gbc_lblOpacity.fill = GridBagConstraints.BOTH;
		gbc_lblOpacity.insets = new Insets(0, 5, 5, 5);
		gbc_lblOpacity.gridx = 0;
		gbc_lblOpacity.gridy = 9;
		frmJwatermark.getContentPane().add(lblOpacity, gbc_lblOpacity);
		
		opacitySlider = new JSlider(SwingConstants.HORIZONTAL);
		opacitySlider.setPaintLabels(true);
		opacitySlider.setPaintTicks(true);
		opacitySlider.setValue(80);
		lblOpacity.setLabelFor(opacitySlider);
		GridBagConstraints gbc_opacitySlider = new GridBagConstraints();
		gbc_opacitySlider.gridwidth = 2;
		gbc_opacitySlider.anchor = GridBagConstraints.NORTH;
		gbc_opacitySlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_opacitySlider.insets = new Insets(0, 5, 5, 5);
		gbc_opacitySlider.gridx = 0;
		gbc_opacitySlider.gridy = 10;
		opacitySlider.setMajorTickSpacing(10);
		frmJwatermark.getContentPane().add(opacitySlider, gbc_opacitySlider);
		
		JSeparator separator_3 = new JSeparator();
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_3.gridwidth = 2;
		gbc_separator_3.insets = new Insets(0, 0, 5, 0);
		gbc_separator_3.gridx = 0;
		gbc_separator_3.gridy = 11;
		frmJwatermark.getContentPane().add(separator_3, gbc_separator_3);
		
		JLabel lblWatermarkLocation = new JLabel("Watermark Position:");
		GridBagConstraints gbc_lblWatermarkLocation = new GridBagConstraints();
		gbc_lblWatermarkLocation.fill = GridBagConstraints.VERTICAL;
		gbc_lblWatermarkLocation.anchor = GridBagConstraints.WEST;
		gbc_lblWatermarkLocation.insets = new Insets(0, 5, 5, 5);
		gbc_lblWatermarkLocation.gridx = 0;
		gbc_lblWatermarkLocation.gridy = 12;
		frmJwatermark.getContentPane().add(lblWatermarkLocation, gbc_lblWatermarkLocation);
		
		watermarkPosComboBox = new JComboBox<Object>(watermarkPositionCombo);
		GridBagConstraints gbc_watermarkPosComboBox = new GridBagConstraints();
		gbc_watermarkPosComboBox.anchor = GridBagConstraints.NORTH;
		gbc_watermarkPosComboBox.gridwidth = 2;
		gbc_watermarkPosComboBox.insets = new Insets(0, 5, 5, 5);
		gbc_watermarkPosComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_watermarkPosComboBox.gridx = 0;
		gbc_watermarkPosComboBox.gridy = 13;
		frmJwatermark.getContentPane().add(watermarkPosComboBox, gbc_watermarkPosComboBox);
		
		JSeparator separator_4 = new JSeparator();
		GridBagConstraints gbc_separator_4 = new GridBagConstraints();
		gbc_separator_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_4.gridwidth = 2;
		gbc_separator_4.insets = new Insets(0, 0, 5, 0);
		gbc_separator_4.gridx = 0;
		gbc_separator_4.gridy = 14;
		frmJwatermark.getContentPane().add(separator_4, gbc_separator_4);
		
		JButton applyButton = new JButton("Apply");
		applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				applyButtonPressed();
			}
		});
		GridBagConstraints gbc_applyButton = new GridBagConstraints();
		gbc_applyButton.fill = GridBagConstraints.BOTH;
		gbc_applyButton.gridwidth = 2;
		gbc_applyButton.insets = new Insets(5, 5, 5, 5);
		gbc_applyButton.gridx = 0;
		gbc_applyButton.gridy = 15;
		frmJwatermark.getContentPane().add(applyButton, gbc_applyButton);
	}
	
	public void inputBrowsePressed(){
		
		final JFileChooser fc = new JFileChooser();
		fc.setMultiSelectionEnabled(true);
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png");
		fc.setFileFilter(filter);
		
		int returnVal = fc.showOpenDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File[] file = fc.getSelectedFiles();
			inputTextArea.setText("");
				for(int i=0;i<=file.length-1;i++){
					inputTextArea.append(file[i].getPath() + "\n");
				}
		}
	}

	public void watermarkBrowsePressed(){
		
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			watermarkTextField.setText(file.getPath());	
		}
	}
	
	public void outputBrowsePressed(){
		
		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fc.showOpenDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			outputTextField.setText(file.getPath());	
		}
		
	}
	
	public void applyButtonPressed(){
		String[] inputs =  inputTextArea.getText().split("\\n");
		
		String watermark = watermarkTextField.getText();
		
		String output = outputTextField.getText();
		
		String position = (String) watermarkPosComboBox.getSelectedItem();
		
		int oppasity = opacitySlider.getValue();
		
//		System.out.println(position +","+ oppasity);
		
	}
	
	
	
	
}
