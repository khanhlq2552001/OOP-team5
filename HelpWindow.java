package t3;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
public class HelpWindow extends JFrame{

	private JPanel contentPane;


	public HelpWindow() {
		setTitle("Help");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 778, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("1. Generate Array");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(27, 73, 440, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterSize = new JLabel("- Enter size of array in \"Array Size\" field.");
		lblEnterSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterSize.setBounds(47, 100, 440, 17);
		contentPane.add(lblEnterSize);
		
		JLabel lblChoose = new JLabel("- In \"Generate value\" field:");
		lblChoose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChoose.setBounds(47, 122, 440, 17);
		contentPane.add(lblChoose);
		
		JLabel lblChooserandomly = new JLabel("+ Choose \"Randomly\" if you want generate random values");
		lblChooserandomly.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChooserandomly.setBounds(74, 149, 440, 17);
		contentPane.add(lblChooserandomly);
		
		JLabel lblChooserandomly_1 = new JLabel("+ Choose \"Type\" if you want manually input values");
		lblChooserandomly_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChooserandomly_1.setBounds(74, 176, 440, 17);
		contentPane.add(lblChooserandomly_1);
		
		JLabel lblIfYou = new JLabel("- If you want to generate values by \"Type\", input list of values in \"Array Values\" , seperated by comma.");
		lblIfYou.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIfYou.setBounds(47, 203, 669, 17);
		contentPane.add(lblIfYou);
		
		JLabel lblChooseSort = new JLabel("2. Choose sort algorithm to visualize");
		lblChooseSort.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChooseSort.setBounds(27, 230, 440, 17);
		contentPane.add(lblChooseSort);
		
		JLabel lblClickOn = new JLabel("- Click on 1 of 3 buttons corresponding to 3 sort algorithms.");
		lblClickOn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClickOn.setBounds(47, 257, 440, 17);
		contentPane.add(lblClickOn);
		
		JLabel lblViewSort = new JLabel("3. View Sort Visualization");
		lblViewSort.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblViewSort.setBounds(27, 284, 440, 17);
		contentPane.add(lblViewSort);
		
		JLabel lblClickstart = new JLabel("- Click \"Start\" to start an algorithm.");
		lblClickstart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClickstart.setBounds(47, 311, 440, 17);
		contentPane.add(lblClickstart);
		
		JLabel lblClickplay = new JLabel("- Click \"Play\" to view steps continuously.");
		lblClickplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClickplay.setBounds(47, 365, 440, 17);
		contentPane.add(lblClickplay);
		
		JLabel lblClickpause = new JLabel("- Click \"Pause\" to pause the visualization . You can click \"Play\" or \"Next\" to continue.");
		lblClickpause.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClickpause.setBounds(47, 392, 648, 17);
		contentPane.add(lblClickpause);
		
		JLabel lblClicknext = new JLabel("- Click \"Next\" to view next step of the algorithm.");
		lblClicknext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClicknext.setBounds(47, 338, 440, 17);
		contentPane.add(lblClicknext);
		
		JLabel lblClickback = new JLabel("- Click \"Back\" to stop visualization and return to main menu.");
		lblClickback.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClickback.setBounds(47, 419, 648, 17);
		contentPane.add(lblClickback);
		
		JLabel lblExitProgram = new JLabel("3. Exit program");
		lblExitProgram.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExitProgram.setBounds(27, 446, 440, 17);
		contentPane.add(lblExitProgram);
		
		JLabel lblClickexit = new JLabel("- Click \"Exit\" to exit the program.");
		lblClickexit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClickexit.setBounds(47, 473, 440, 17);
		contentPane.add(lblClickexit);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(340, 512, 85, 31);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HelpWindow.this.dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblSortVisualizationApplication = new JLabel("SORT VISUALIZATION APPLICATION");
		lblSortVisualizationApplication.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSortVisualizationApplication.setBounds(231, 24, 440, 17);
		contentPane.add(lblSortVisualizationApplication);
		setLocationRelativeTo(null);		

		setVisible(true);
	}
}
