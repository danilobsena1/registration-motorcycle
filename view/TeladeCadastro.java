package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import dao.AcessoDao;
import dao.DataSource;
import model.Motos;

public class TeladeCadastro {

	protected Shell shlTeladeCadastro;
	private Text textMarca;
	private Label lblModelo;
	private Text textModelo;
	private Label lblValor;
	private Text textValor;
	private Label lblAno;
	private Text textAno;
	private Button btnCadastrar;
	private Button btnVisualizarDados;
	private Button btnSair;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TeladeCadastro window = new TeladeCadastro();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlTeladeCadastro.open();
		shlTeladeCadastro.layout();
		while (!shlTeladeCadastro.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlTeladeCadastro = new Shell();
		shlTeladeCadastro.setSize(664, 355);
		shlTeladeCadastro.setText("Tela de Cadastro");
		
		Label lblMensagemparaAdmin = new Label(shlTeladeCadastro, SWT.NONE);
		lblMensagemparaAdmin.setFont(SWTResourceManager.getFont("Noto Sans", 11, SWT.BOLD));
		lblMensagemparaAdmin.setAlignment(SWT.CENTER);
		lblMensagemparaAdmin.setBounds(20, 10, 634, 19);
		lblMensagemparaAdmin.setText("INSIRA NOS CAMPOS OS DADOS DA MOTO");
		
		Label lblMarca = new Label(shlTeladeCadastro, SWT.NONE);
		lblMarca.setFont(SWTResourceManager.getFont("Noto Sans", 11, SWT.BOLD));
		lblMarca.setBounds(40, 65, 64, 19);
		lblMarca.setText("MARCA");
		
		textMarca = new Text(shlTeladeCadastro, SWT.BORDER);
		textMarca.setBounds(110, 54, 197, 30);
		
		lblModelo = new Label(shlTeladeCadastro, SWT.NONE);
		lblModelo.setFont(SWTResourceManager.getFont("Noto Sans", 11, SWT.BOLD));
		lblModelo.setBounds(328, 65, 64, 19);
		lblModelo.setText("MODELO");
		
		textModelo = new Text(shlTeladeCadastro, SWT.BORDER);
		textModelo.setBounds(398, 54, 197, 30);
		
		lblValor = new Label(shlTeladeCadastro, SWT.NONE);
		lblValor.setFont(SWTResourceManager.getFont("Noto Sans", 11, SWT.BOLD));
		lblValor.setAlignment(SWT.CENTER);
		lblValor.setBounds(49, 146, 55, 19);
		lblValor.setText("VALOR");
		
		textValor = new Text(shlTeladeCadastro, SWT.BORDER);
		textValor.setBounds(110, 135, 197, 30);
		
		lblAno = new Label(shlTeladeCadastro, SWT.NONE);
		lblAno.setFont(SWTResourceManager.getFont("Noto Sans", 11, SWT.BOLD));
		lblAno.setAlignment(SWT.CENTER);
		lblAno.setBounds(346, 146, 55, 19);
		lblAno.setText("ANO");
		
		textAno = new Text(shlTeladeCadastro, SWT.BORDER);
		textAno.setBounds(398, 135, 197, 30);
		
		btnCadastrar = new Button(shlTeladeCadastro, SWT.NONE);
		btnCadastrar.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btnCadastrar.setFont(SWTResourceManager.getFont("Noto Sans", 11, SWT.BOLD));
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Motos moto = new Motos();
				
				moto.setMarca(textMarca.getText());
				moto.setModelo(textModelo.getText());
				moto.setValor(Double.parseDouble(textValor.getText()));
				moto.setAno(Integer.parseInt(textAno.getText()));
				
				DataSource ds = new DataSource();
				AcessoDao dao = new AcessoDao(ds);
				
				dao.adicionarMoto(moto);
			}
		});
		btnCadastrar.setBounds(503, 173, 92, 29);
		btnCadastrar.setText("Cadastrar");
		
		btnVisualizarDados = new Button(shlTeladeCadastro, SWT.NONE);
		btnVisualizarDados.setFont(SWTResourceManager.getFont("Noto Sans", 11, SWT.BOLD));
		btnVisualizarDados.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Codigos abaixo abre a tela de exibição.
				shlTeladeCadastro.close();
				TeladeExibicao te = new TeladeExibicao();
				te.open();
			}
		});
		btnVisualizarDados.setBounds(239, 230, 232, 40);
		btnVisualizarDados.setText("Consultar Dados Cadastrados");
		
		btnSair = new Button(shlTeladeCadastro, SWT.NONE);
		btnSair.setFont(SWTResourceManager.getFont("Noto Sans", 11, SWT.BOLD));
		btnSair.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlTeladeCadastro.close(); // Ação fecha a tela de Cadastro.
			}
		});
		btnSair.setBounds(318, 287, 92, 29);
		btnSair.setText("Sair");

	}
}
