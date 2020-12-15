package locadora;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class telaEditarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtcpf;
	private JTextField txtnomecl;
	private JTextField txtendereco;
	private JTextField txtcidade;
	private JTextField txtcnh;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaEditarCliente frame = new telaEditarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public telaEditarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtcpf = new JTextField();
		txtcpf.setBounds(10, 39, 151, 20);
		contentPane.add(txtcpf);
		txtcpf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setBounds(10, 23, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtnomecl = new JTextField();
		txtnomecl.setBounds(10, 84, 151, 20);
		contentPane.add(txtnomecl);
		txtnomecl.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 70, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnNewButton.setBounds(177, 38, 101, 23);
		contentPane.add(btnNewButton);
		
		txtendereco = new JTextField();
		txtendereco.setBounds(187, 84, 177, 20);
		contentPane.add(txtendereco);
		txtendereco.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o");
		lblNewLabel_2.setBounds(187, 70, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		txtcidade = new JTextField();
		txtcidade.setBounds(410, 84, 108, 20);
		contentPane.add(txtcidade);
		txtcidade.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cidade");
		lblNewLabel_3.setBounds(411, 70, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtcnh = new JTextField();
		txtcnh.setBounds(10, 132, 118, 20);
		contentPane.add(txtcnh);
		txtcnh.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CNH");
		lblNewLabel_4.setBounds(10, 115, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					excluir();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(115, 238, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salvar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		btnNewButton_2.setBounds(229, 238, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Voltar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new tela().setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(342, 238, 89, 23);
		contentPane.add(btnNewButton_3);
	}

	 void excluir() throws SQLException {
		 try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url="jdbc:sqlserver://localhost:49692;databaseName=locadora_carro";
				String usu= "sa";
				String senha= "sa";
				
				Connection conex;
				
					conex = DriverManager.getConnection(url,usu,senha);
				
				
				Statement stmt =conex.createStatement();
				String id;
				
				id= txtcpf.getText();
					
					stmt.executeUpdate("delete carro where id_carro ='"+id+"'");

					if(txtcpf.getText().equals("")) {
						
						JOptionPane.showMessageDialog(contentPane, "Nenhum item excluido");
					}else {
					
					
						JOptionPane.showMessageDialog(contentPane, "excluido com sucesso");
						
						txtcpf.setText("");
						txtnomecl.setText("");
						txtendereco.setText("");
						txtcidade.setText("");
						txtcnh.setText("");
						
					
					stmt.close();
					conex.close();
					
					
					}
				}catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
			 
				
			 }

	void buscar() {
		 try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url="jdbc:sqlserver://localhost:49692;databaseName=locadora_carro";
				String usu= "sa";
				String senha= "sa";
				
				Connection conex;
				
					conex = DriverManager.getConnection(url,usu,senha);
				
				
				Statement stmt =conex.createStatement();
				
				if(txtcpf.getText().equals("")) {
					
					JOptionPane.showMessageDialog(contentPane, "O campo CPF é obrigatório");
					
				}else {
					
					ResultSet rs =stmt.executeQuery("select * from clientes where CPF='"+txtcpf.getText()+"'");
					
					while(rs.next()) {
						txtcpf.getText();
						
						txtnomecl.setText(rs.getString("nome_cliente").trim());
						
						txtendereco.setText(rs.getString("endereço").trim());
						
						txtcidade.setText(rs.getString("cidade").trim());
						
						txtcnh.setText(rs.getString("CNH").trim());
						
					}
					
					stmt.close();
					rs.close();
					conex.close();
		
				}
				}catch (Exception e) {
					// TODO: handle exception
				}
	}

	void salvar() {
		 try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url="jdbc:sqlserver://localhost:49692;databaseName=locadora_carro";
				String usu= "sa";
				String senha= "sa";
				
				Connection conex;
				
				conex = DriverManager.getConnection(url,usu,senha);
				
				
				Statement stmt =conex.createStatement();
				
				
				stmt.executeUpdate("update clientes set CPF = '"+txtcpf.getText()+"',nome_cliente='"+txtnomecl.getText()+"',endereço='"+txtendereco.getText()+"',cidade='"+txtcidade.getText()+"',CNH ='"+txtcnh.getText()+"'");
				
				if(txtcpf.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "nenhum item alterado");
				}else {
					
				
				
				JOptionPane.showMessageDialog(contentPane, "atualizado com sucesso");
				
				txtcpf.setText("");
				txtnomecl.setText("");
				txtendereco.setText("");
				txtcidade.setText("");
				txtcnh.setText("");
				}	
			} catch (Exception e) {
				
			}
		}
		
	}

