package bom;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class new1 extends JFrame {
	private game Game;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new1 frame = new new1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.;
	 */
	private int choose;
	public new1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// NHẤN NÚT CHỌN BẮT ĐẦU
		
		JButton btnNewButton = new JButton("b\u1EAFt \u0111\u1EA7u n\u00E0o");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game = new game();
				Game.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(Game);				
				JButton n1 = new JButton("");
				n1.addMouseListener(new MouseAdapter() {	
					@Override
					public void mouseClicked(MouseEvent arg0) {
						JOptionPane b=new JOptionPane();
						b.showMessageDialog(null,"ffsdfsdfsdfs");
						Game.setStart(2);
						n1.setVisible(false);
				          setContentPane(Game);
					}
				});				
				n1.setIcon(new ImageIcon("C:\\Users\\user56\\eclipse-workspace\\bom\\a.png"));				
				JButton n2 = new JButton("TR\u1EDE L\u1EA0I");
				n2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						setContentPane(contentPane);
					}
				});
				
				GroupLayout gl_contentPane = new GroupLayout(Game);
				gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(n1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(289)
							.addComponent(n2)
							.addContainerGap(429, Short.MAX_VALUE))
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(n2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(n1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(619, Short.MAX_VALUE))
				);
			
				Game.setLayout(gl_contentPane);
			}
		});//KẾT THÚ NÚT CHỌN
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(287, 226, 253, 104);
		contentPane.add(btnNewButton);
		if(choose==1)
		{
		}

	}
	
}
