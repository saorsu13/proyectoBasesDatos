package Interfaz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Conexion.Conexion;
import Conexion.TestConexion;

public class FormularioPrincipal implements ActionListener {

	private TestConexion miTestConexion;
	private Conexion miConexion;
	private JFrame frame;
	private JTextField CodigoPaciente1;
	private JTextField NombrePaciente1;
	private JTextField ApellidoPaciente1;
	private JTextField TipoSangre1;
	private JTextField FechaNacimiento1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Conexion conexion = new Conexion();
				Connection cn = null;
				Statement stm = null;
				ResultSet rs = null;

				try {
					cn = conexion.conectar();
					stm = cn.createStatement();
					rs = stm.executeQuery("SELECT*FROM PACIENTE");

					while (rs.next()) {
						rs.getInt(1);
					}

				} catch (SQLException e) {
					// TODO: handle exception
				}
				try {
					FormularioPrincipal window = new FormularioPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormularioPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 705, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel Hospital = new JLabel("Paciente");
		Hospital.setBounds(317, 11, 73, 25);
		Hospital.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(Hospital);

		JLabel NombrePaciente = new JLabel("Nombre Paciente");
		NombrePaciente.setBounds(20, 125, 87, 14);
		frame.getContentPane().add(NombrePaciente);

		JLabel ApellidoPaciente = new JLabel("Apellido Paciente");
		ApellidoPaciente.setBounds(20, 150, 87, 14);
		frame.getContentPane().add(ApellidoPaciente);

		JLabel CodigoPaciente = new JLabel("Codigo Paciente");
		CodigoPaciente.setBounds(20, 100, 87, 14);
		frame.getContentPane().add(CodigoPaciente);

		JLabel TipoSangre = new JLabel("Tipo de Sangre");
		TipoSangre.setBounds(20, 175, 87, 14);
		frame.getContentPane().add(TipoSangre);

		JLabel FechaNacimiento = new JLabel("Fecha de Nacimiento");
		FechaNacimiento.setBounds(20, 200, 114, 14);
		frame.getContentPane().add(FechaNacimiento);

		CodigoPaciente1 = new JTextField();
		CodigoPaciente1.setBounds(208, 97, 86, 20);
		frame.getContentPane().add(CodigoPaciente1);
		CodigoPaciente1.setColumns(10);

		NombrePaciente1 = new JTextField();
		NombrePaciente1.setBounds(208, 122, 86, 20);
		frame.getContentPane().add(NombrePaciente1);
		NombrePaciente1.setColumns(10);

		ApellidoPaciente1 = new JTextField();
		ApellidoPaciente1.setBounds(208, 147, 86, 20);
		frame.getContentPane().add(ApellidoPaciente1);
		ApellidoPaciente1.setColumns(10);

		TipoSangre1 = new JTextField();
		TipoSangre1.setBounds(208, 172, 86, 20);
		frame.getContentPane().add(TipoSangre1);
		TipoSangre1.setColumns(10);

		FechaNacimiento1 = new JTextField();
		FechaNacimiento1.setBounds(208, 197, 86, 20);
		frame.getContentPane().add(FechaNacimiento1);
		FechaNacimiento1.setColumns(10);

		btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(590, 349, 89, 23);
		btnNewButton.addActionListener(this);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.setBounds(20, 349, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == btnNewButton) {
			try {
				int codigoPaciente = Integer.parseInt(CodigoPaciente1.getText());
				String nombrePaciente = NombrePaciente1.getText();
				String apellidoPaciente = ApellidoPaciente1.getText();
				String tipoSangre = TipoSangre1.getText();
				String fechaNacimeinto = FechaNacimiento1.getText();
				String query = "INSERT INTO paciente(codigoPaciente,nombrePaciente,apellidoPaciente,tipoSangre,fechaNacimiento)values('"
						+ codigoPaciente + "','" + nombrePaciente + "','" + apellidoPaciente + "','" + tipoSangre
						+ "','" + fechaNacimeinto + "')";
				PreparedStatement stmt = miConexion.conectar().prepareStatement("INSERT INTO mydb VALUES(?,?,?,?,?)");
				stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Paciente Agregado Correctamente");

			} catch (SQLException e1) {

			}
		}
	}
}
