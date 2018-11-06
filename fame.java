package bom;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JMenu;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class fame extends JFrame {

	private game Game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game Game = new game();
					fame frame = new fame();
					frame.getContentPane().add(Game);
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

	public fame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 726);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		//setJMenuBar(menuBar);
		
		JButton n2 = new JButton("");
		n2.setBackground(Color.WHITE);
		n2.setIcon(new ImageIcon("C:\\Users\\user56\\eclipse-workspace\\bom\\a.png"));
		n2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuBar.setVisible(false);
			}
		});
		menuBar.add(n2);
		
		JLabel lblDff = new JLabel("dff");
		lblDff.setBackground(Color.WHITE);
		menuBar.add(lblDff);
		
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user56\\eclipse-workspace\\bom\\b.png"));
		menuBar_1.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\user56\\eclipse-workspace\\bom\\b.png"));
		menuBar_1.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("tr\u1EDF v\u1EC1");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				menuBar_1.setVisible(false);
				setJMenuBar(menuBar);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		menuBar_1.add(lblNewLabel_1);
		
		
		
		
		Game = new game();
		Game.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Game);
		JButton n1 = new JButton("");
		n1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		n1.setIcon(new ImageIcon("C:\\Users\\user56\\eclipse-workspace\\bom\\a.png"));
		n1.addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseClicked(MouseEvent arg0) {
								Game.setStart(2);
				              n1.setVisible(false);
		         
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(Game);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(n1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(779, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(n1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(579, Short.MAX_VALUE))
		);
	
		Game.setLayout(gl_contentPane);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
