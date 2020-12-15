package locadora;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class alugarCarro extends JFrame {

	private JPanel contentPane;
	private JTextField txtcpf;
	private JTextField txtnome;
	private JTextField txtcnh;
	private JTextField txtid;
	private JTextField txtpreço;
	private JButton btnNewButton_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alugarCarro frame = new alugarCarro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public alugarCarro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtcpf = new JTextField();
		txtcpf.setBounds(10, 55, 137, 20);
		contentPane.add(txtcpf);
		txtcpf.setColumns(10);
		
		txtnome = new JTextField();
		txtnome.setBounds(10, 100, 137, 20);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		txtcnh = new JTextField();
		txtcnh.setBounds(247, 55, 137, 20);
		contentPane.add(txtcnh);
		txtcnh.setColumns(10);
		
		txtid = new JTextField();
		txtid.setBounds(9, 149, 137, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtpreço = new JTextField();
		txtpreço.setBounds(246, 100, 138, 20);
		contentPane.add(txtpreço);
		txtpreço.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirma();
			}
		});
		btnNewButton.setBounds(247, 148, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setBounds(10, 42, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 87, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("id_carro");
		lblNewLabel_2.setBounds(10, 131, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CNH");
		lblNewLabel_3.setBounds(247, 42, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pre\u00E7o");
		lblNewLabel_4.setBounds(247, 87, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new tela().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(368, 148, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	
	void confirma() {
		 try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url="jdbc:sqlserver://localhost:49692;databaseName=locadora_carro";
				String usu= "sa";
				String senha= "sa";
				
				Connection conex=DriverManager.getConnection(url,usu,senha);
				
				
				Statement stmt =conex.createStatement();
				
				if(txtid.getText().equals("")||txtnome.getText().equals("")||txtid.getText().equals("")||txtcnh.getText().equals("")||txtpreço.getText().equals("")) {
					
					JOptionPane.showMessageDialog(contentPane, "Todos os campos são obrigatórios");
					
				}else {
					stmt.executeUpdate("insert into carro(id_carro,nome_carro,ano,cor,preço)values ('"+txtid.getText()+"','"+txtnome.getText()+"','"+txtid.getText()+"','"+txtcnh.getText()+"','"+txtpreço.getText()+"')");
					
					JOptionPane.showMessageDialog(contentPane,"cadastro efetuado com sucesso");
					
				}
				conex.close();
				stmt.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage());
		}
	
	}
	}
	
	
	




