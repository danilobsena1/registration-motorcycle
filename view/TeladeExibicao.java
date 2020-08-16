package view;

import java.util.Collection;

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

public class TeladeExibicao {

	protected Shell shellTeladeExibicao;
	private Text textMarca;
	private Text textModelo;
	private Text textValor;
	private Text textAno;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TeladeExibicao window = new TeladeExibicao();
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
		shellTeladeExibicao.open();
		shellTeladeExibicao.layout();
		while (!shellTeladeExibicao.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	
		
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shellTeladeExibicao = new Shell();
		shellTeladeExibicao.setSize(427, 517);
		shellTeladeExibicao.setText("Exibição dos dados");
		shellTeladeExibicao.setLayout(null);
		
		Label lblIconeMoto = new Label(shellTeladeExibicao, SWT.NONE);
		lblIconeMoto.setAlignment(SWT.CENTER);
		lblIconeMoto.setImage(SWTResourceManager.getImage(TeladeExibicao.class, "/images/1f3cd.png"));
		lblIconeMoto.setBounds(135, 23, 188, 128);
		
		Label lblMarca = new Label(shellTeladeExibicao, SWT.NONE);
		lblMarca.setFont(SWTResourceManager.getFont("Noto Sans", 11, SWT.BOLD));
		lblMarca.setAlignment(SWT.CENTER);
		lblMarca.setBounds(54, 244, 64, 19);
		lblMarca.setText("MARCA");
		
		textMarca = new Text(shellTeladeExibicao, SWT.BORDER);
		textMarca.setEditable(false);
		textMarca.setBounds(124, 233, 228, 30);
		
		Label lblModelo = new Label(shellTeladeExibicao, SWT.NONE);
		lblModelo.setFont(SWTResourceManager.getFont("Noto Sans", 11, SWT.BOLD));
		lblModelo.setAlignment(SWT.CENTER);
		lblModelo.setBounds(54, 294, 64, 19);
		lblModelo.setText("MODELO");
		
		textModelo = new Text(shellTeladeExibicao, SWT.BORDER);
		textModelo.setEditable(false);
		textModelo.setBounds(124, 283, 228, 30);
		
		Label lblValor = new Label(shellTeladeExibicao, SWT.NONE);
		lblValor.setFont(SWTResourceManager.getFont("Noto Sans", 11, SWT.BOLD));
		lblValor.setAlignment(SWT.CENTER);
		lblValor.setBounds(54, 342, 64, 19);
		lblValor.setText("VALOR");
		
		textValor = new Text(shellTeladeExibicao, SWT.BORDER);
		textValor.setEditable(false);
		textValor.setBounds(124, 331, 226, 30);
		
		Label lblAno = new Label(shellTeladeExibicao, SWT.NONE);
		lblAno.setFont(SWTResourceManager.getFont("Noto Sans", 11, SWT.BOLD));
		lblAno.setAlignment(SWT.CENTER);
		lblAno.setBounds(54, 394, 64, 19);
		lblAno.setText("ANO");
		
		textAno = new Text(shellTeladeExibicao, SWT.BORDER);
		textAno.setEditable(false);
		textAno.setBounds(124, 383, 226, 30);
		
		Button btnConsultar = new Button(shellTeladeExibicao, SWT.NONE);
		btnConsultar.setFont(SWTResourceManager.getFont("Noto Sans", 11, SWT.BOLD));
		btnConsultar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DataSource ds = new DataSource();
				AcessoDao ad = new AcessoDao(ds);
				
				Collection<Motos> listaMotos = ad.exibirMotos();
				
				for(Motos moto:listaMotos){
					textMarca.setText(moto.getMarca());
					textModelo.setText(moto.getModelo());
					textValor.setText(Double.toString(moto.getValor()));
					textAno.setText(Integer.toString(moto.getAno()));
				}
			}
		});
		btnConsultar.setBounds(182, 182, 92, 29);
		btnConsultar.setText("Consultar");
		
		Button btnCadastrarOutroItem = new Button(shellTeladeExibicao, SWT.NONE);
		btnCadastrarOutroItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shellTeladeExibicao.close();
				TeladeCadastro tc = new TeladeCadastro();
				tc.open();
			}
		});
		btnCadastrarOutroItem.setFont(SWTResourceManager.getFont("Noto Sans", 11, SWT.BOLD));
		btnCadastrarOutroItem.setBounds(135, 434, 177, 29);
		btnCadastrarOutroItem.setText("Cadastrar Outro Item");
		
		Button btnSair = new Button(shellTeladeExibicao, SWT.NONE);
		btnSair.setFont(SWTResourceManager.getFont("Noto Sans", 11, SWT.BOLD));
		btnSair.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shellTeladeExibicao.close(); //Saindo da tela.
			}
		});
		btnSair.setBounds(182, 478, 92, 29);
		btnSair.setText("Sair");

	}
}
