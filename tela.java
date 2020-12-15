package locadora;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class tela extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtnome_c;
	private JTextField txtano;
	private JTextField txtcor;
	private JTextField txtpreco;
	private JTable table;
	private JTextField txtcpf;
	private JTextField txtnome;
	private JTextField txtcnh;
	private JTextField txtendereco;
	private JTextField txtcidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela frame = new tela();
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
	public tela() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tabela();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 592);
		setTitle("Locadora de carros");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar carro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			cadastrarCarro();
			}
		});
		btnNewButton.setBounds(488, 52, 149, 23);
		contentPane.add(btnNewButton);
		
		txtid = new JTextField();
		txtid.setBounds(10, 53, 124, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtnome_c = new JTextField();
		txtnome_c.setBounds(10, 108, 124, 20);
		contentPane.add(txtnome_c);
		txtnome_c.setColumns(10);
		
		txtano = new JTextField();
		txtano.setBounds(209, 53, 69, 20);
		contentPane.add(txtano);
		txtano.setColumns(10);
		
		txtcor = new JTextField();
		txtcor.setBounds(209, 108, 69, 20);
		contentPane.add(txtcor);
		txtcor.setColumns(10);
		
		txtpreco = new JTextField();
		txtpreco.setBounds(328, 53, 124, 20);
		contentPane.add(txtpreco);
		txtpreco.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID carro");
		lblNewLabel.setBounds(10, 39, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 95, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ano");
		lblNewLabel_2.setBounds(209, 39, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cor");
		lblNewLabel_3.setBounds(209, 95, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pre\u00E7o aluguel");
		lblNewLabel_4.setBounds(328, 39, 124, 14);
		contentPane.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 662, 178);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID carro", "Nome", "Ano", "Cor", "Pre\u00E7o"
			}
		));
		
		txtcpf = new JTextField();
		txtcpf.setBounds(10, 397, 124, 20);
		contentPane.add(txtcpf);
		txtcpf.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Cadastro de cliente");
		lblNewLabel_5.setBounds(297, 364, 143, 14);
		contentPane.add(lblNewLabel_5);
		
		txtnome = new JTextField();
		txtnome.setBounds(10, 451, 210, 20);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		txtcnh = new JTextField();
		txtcnh.setBounds(170, 397, 108, 20);
		contentPane.add(txtcnh);
		txtcnh.setColumns(10);
		
		txtendereco = new JTextField();
		txtendereco.setBounds(253, 451, 187, 20);
		contentPane.add(txtendereco);
		txtendereco.setColumns(10);
		
		txtcidade = new JTextField();
		txtcidade.setBounds(463, 451, 124, 20);
		contentPane.add(txtcidade);
		txtcidade.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cadastrar cliente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarCliente();
				
				txtid.setText("");
				txtnome_c.setText("");
				txtano.setText("");
				txtcor.setText("");
				txtpreco.setText("");
			}
		});
		btnNewButton_1.setBounds(297, 396, 155, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("CPF");
		lblNewLabel_6.setBounds(10, 382, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("CNH");
		lblNewLabel_7.setBounds(170, 382, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nome");
		lblNewLabel_8.setBounds(10, 436, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Endere\u00E7o");
		lblNewLabel_9.setBounds(253, 436, 56, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("cidade");
		lblNewLabel_10.setBounds(463, 436, 56, 14);
		contentPane.add(lblNewLabel_10);
		
		JButton btnNewButton_2 = new JButton("Editar Carro");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new telaEditar().setVisible(true);
				dispose();
			
			}
		});
		btnNewButton_2.setBounds(488, 107, 149, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Editar Cliente");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new telaEditarCliente().setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_3.setBounds(463, 396, 124, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Alugar Carro");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new alugarCarro().setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(249, 519, 137, 23);
		contentPane.add(btnNewButton_4);
	}

	 void cadastrarCarro() {
		 try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url="jdbc:sqlserver://localhost:49692;databaseName=locadora_carro";
				String usu= "sa";
				String senha= "sa";
				
				Connection conex=DriverManager.getConnection(url,usu,senha);
				
				
				Statement stmt =conex.createStatement();
				
				if(txtid.getText().equals("")||txtnome_c.getText().equals("")||txtano.getText().equals("")||txtcor.getText().equals("")||txtpreco.getText().equals("")) {
					
					JOptionPane.showMessageDialog(contentPane, "Todos os campos são obrigatórios");
					
				}else {
					stmt.executeUpdate("insert into carro(id_carro,nome_carro,ano,cor,preço)values ('"+txtid.getText()+"','"+txtnome_c.getText()+"','"+txtano.getText()+"','"+txtcor.getText()+"','"+txtpreco.getText()+"')");
					
					JOptionPane.showMessageDialog(contentPane,"cadastro efetuado com sucesso");
					
				}
				tabela();
				
				conex.close();
				stmt.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage());
		}
	
	}
	 
	 void tabela() {
		 try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url="jdbc:sqlserver://localhost:49692;databaseName=locadora_carro";
				String usu= "sa";
				String senha= "sa";
				
				Connection conex=DriverManager.getConnection(url,usu,senha);
				
				
				Statement stmt =conex.createStatement();
				
				ResultSet rs=stmt.executeQuery("select *from carro");
				
				DefaultTableModel dtm=(DefaultTableModel) table.getModel();
				
				dtm.setNumRows(0);
				
				while(rs.next()) {
					dtm.addRow(new Object[] {
							rs.getInt("id_carro"),
							rs.getString("nome_carro"),
							rs.getInt("ano"),
							rs.getString("cor"),
							rs.getFloat("preço")				
							
					});
				}
					txtid.setText("");
					txtnome_c.setText("");
					txtano.setText("");
					txtcor.setText("");
					txtpreco.setText("");
				
				
					table.setModel(dtm);
					
					
					
					stmt.close();
					conex.close();
			
			
		 }catch (Exception e) {
			// TODO: handle exception
		}
	 }

	 void cadastrarCliente() {

		 try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url="jdbc:sqlserver://localhost:49692;databaseName=locadora_carro";
				String usu= "sa";
				String senha= "sa";
				
				Connection conex=DriverManager.getConnection(url,usu,senha);
				
				
				Statement stmt =conex.createStatement();
				
				if(txtcpf.getText().equals("")||txtnome.getText().equals("")||txtcnh.getText().equals("")||txtendereco.getText().equals("")||txtcidade.getText().equals("")) {
					
					JOptionPane.showMessageDialog(contentPane, "Todos os campos são obrigatórios");
					
				}else {
					stmt.executeUpdate("insert into clientes(CPF,nome_cliente,endereço,cidade,CNH)values ('"+txtcpf.getText()+"','"+txtnome.getText()+"','"+txtendereco.getText()+"','"+txtcidade.getText()+"','"+txtcnh.getText()+"')");
					
					JOptionPane.showMessageDialog(contentPane,"cadastro efetuado com sucesso");
					
					
					
				}
				
			
				
				conex.close();
				stmt.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage());
		}
	 }
	 
	 
	 
	 
	 
}
