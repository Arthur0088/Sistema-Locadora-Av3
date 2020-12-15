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

public class telaEditar extends JFrame {

	private JPanel contentPane;
	private JTextField txtcod_carro;
	private JTextField txtnome;
	private JTextField txtcor;
	private JTextField txtano;
	private JTextField txtpreco;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaEditar frame = new telaEditar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public telaEditar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtcod_carro = new JTextField();
		txtcod_carro.setBounds(10, 55, 177, 20);
		contentPane.add(txtcod_carro);
		txtcod_carro.setColumns(10);
		
		JLabel txtcodigo_C = new JLabel("ID carro");
		txtcodigo_C.setBounds(10, 40, 46, 14);
		contentPane.add(txtcodigo_C);
		
		txtnome = new JTextField();
		txtnome.setBounds(10, 109, 114, 20);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		txtcor = new JTextField();
		txtcor.setBounds(172, 109, 100, 20);
		contentPane.add(txtcor);
		txtcor.setColumns(10);
		
		JLabel txtnome_C = new JLabel("Nome");
		txtnome_C.setBounds(10, 97, 46, 14);
		contentPane.add(txtnome_C);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					buscar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(197, 54, 89, 23);
		contentPane.add(btnNewButton);
		
		txtano = new JTextField();
		txtano.setBounds(319, 55, 100, 20);
		contentPane.add(txtano);
		txtano.setColumns(10);
		
		JLabel txtano_C = new JLabel("Ano");
		txtano_C.setBounds(319, 40, 46, 14);
		contentPane.add(txtano_C);
		
		JLabel txtcor_C = new JLabel("Cor");
		txtcor_C.setBounds(172, 97, 46, 14);
		contentPane.add(txtcor_C);
		
		txtpreco = new JTextField();
		txtpreco.setBounds(462, 55, 86, 20);
		contentPane.add(txtpreco);
		txtpreco.setColumns(10);
		
		JLabel txtpreco_C = new JLabel("Pre\u00E7o");
		txtpreco_C.setBounds(462, 40, 46, 14);
		contentPane.add(txtpreco_C);
		
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
		btnNewButton_1.setBounds(78, 241, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salvar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				salvar();
			}
		});
		btnNewButton_2.setBounds(256, 241, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Voltar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new tela().setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(429, 241, 89, 23);
		contentPane.add(btnNewButton_3);
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
			
			
			stmt.executeUpdate("update carro set id_carro = '"+txtcod_carro.getText()+"',nome_carro='"+txtnome.getText()+"',ano='"+txtano.getText()+"',cor='"+txtcor.getText()+"',preço ='"+txtpreco.getText()+"'");
			
			if(txtcod_carro.getText().equals("")) {
				JOptionPane.showMessageDialog(contentPane, "nenhum item alterado");
			}else {
				
			
			
			JOptionPane.showMessageDialog(contentPane, "atualizado com sucesso");
			
			txtcod_carro.setText("");
			txtnome.setText("");
			txtano.setText("");
			txtcor.setText("");
			txtpreco.setText("");
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	void buscar() throws SQLException {
		 try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://localhost:49692;databaseName=locadora_carro";
			String usu= "sa";
			String senha= "sa";
			
			Connection conex;
			
				conex = DriverManager.getConnection(url,usu,senha);
			
			
			Statement stmt =conex.createStatement();
			
			if(txtcod_carro.getText().equals("")) {
				
				JOptionPane.showMessageDialog(contentPane, "O campo id e obrigatório");
				
			}else {
				
				ResultSet rs =stmt.executeQuery("select * from carro where id_carro='"+txtcod_carro.getText()+"'");
				
				while(rs.next()) {
					txtcod_carro.getText();
					
					txtnome.setText(rs.getString("nome_carro").trim());
					
					txtano.setText(rs.getString("ano").trim());
					
					txtcor.setText(rs.getString("cor").trim());
					
					txtpreco.setText(rs.getString("preço").trim());
					
					
					
					
				}
				
				stmt.close();
				rs.close();
				conex.close();
			}
			}catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		 
			
		 }
		 
	void excluir() throws SQLException{

		 try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url="jdbc:sqlserver://localhost:49692;databaseName=locadora_carro";
				String usu= "sa";
				String senha= "sa";
				
				Connection conex;
				
					conex = DriverManager.getConnection(url,usu,senha);
				
				
				Statement stmt =conex.createStatement();
				String id;
				
				id= txtcod_carro.getText();
					
					stmt.executeUpdate("delete carro where id_carro ='"+id+"'");

					if(txtcod_carro.getText().equals("")) {
						
						JOptionPane.showMessageDialog(contentPane, "Nenhum item excluido");
					}else {
					
					
						JOptionPane.showMessageDialog(contentPane, "excluido com sucesso");
						
						txtcod_carro.setText("");
						txtnome.setText("");
						txtano.setText("");
						txtcor.setText("");
						txtpreco.setText("");
						
					
					stmt.close();
					conex.close();
					
					
					}
				}catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
			 
				
			 }
	
	}
	
	
	
	
	


