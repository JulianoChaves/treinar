package br.com.treinar.itau.visao;

import java.util.Date;

import javax.swing.JOptionPane;

import br.com.treinar.itau.controle.ControleFactory;
import br.com.treinar.itau.controle.IControle;
import br.com.treinar.itau.controle.ItauControleArray;
import br.com.treinar.itau.controle.ItauControleJDBC;
import br.com.treinar.itau.exception.ContaNaoCadastradaException;
import br.com.treinar.itau.exception.SaldoInsuficienteException;
import br.com.treinar.itau.modelo.ContaCorrente;
import br.com.treinar.itau.modelo.ContaPoupanca;
import br.com.treinar.itau.modelo.ContaSalario;
import br.com.treinar.itau.modelo.principal.Conta;
import br.com.treinar.itau.modelo.principal.Pessoa;
import br.com.treinar.itau.util.ItauConstante;

public class TelaConta {

	private IControle controle;

	public TelaConta() {
		try {
			controle = ControleFactory.getControle(ItauConstante.ESTRATEGIA_PERSISTENCIA_ARRAY);
		} catch (ClassNotFoundException e) {
			//estrat�gia de persist�ncia default
			controle = new ItauControleArray();
		}
	}

	public void menuBanco() {
		String menu = "Digite:\n"
				+ "1 - Criar Conta\n"
				+ "2 - Depositar\n"
				+ "3 - Sacar\n"
				+ "4 - Exibir Saldo\n"
				+ "5 - Cadastrar taxa de rendimento\n"
				+ "6 - Excluir Conta\n"
				+ "7 - Listar Contas\n"
				+ "0 - Sair";
		String opcaoStr = null;
		do {
			opcaoStr = JOptionPane.showInputDialog(menu);
			switch (opcaoStr) {
			case "1":
				cadastrarConta();
				break;
			case "2":
				//conta.saldo = conta.saldo + 1000d;
				depositar();
				break;
			case "3":
				sacar();
				break;
			case "4":
				exibirSaldo();
				break;
			case "5":
				cadastrarTaxaRendimento();
				break;
			case "6":
				excluirConta();
				break;
			case "7":
				listarContas();
				break;
			case "0":
				controle.persistir();
				JOptionPane.showMessageDialog(null, "Fim do programa");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Op��o Inv�lida!");
				break;
			}
		} while (!opcaoStr.equals("0"));
	}

	private void listarContas() {
		Conta[] contas = controle.recuperarContas();
		String contasStr = "";
		for (Conta conta : contas) {
			if (conta != null) {
				contasStr += conta.getNumeroConta() + " " + conta.getPessoa().getNome() + " " + conta.recuperarSaldo() + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, contasStr);

	}

	private void excluirConta() {
		try {
			Conta conta = recuperarConta();
			controle.removerConta(conta);
		} catch (ContaNaoCadastradaException e) {
			JOptionPane.showMessageDialog(null, "Conta nao cadastrada");			
		}
	}

	private void cadastrarTaxaRendimento() {
		String taxaRendimentoStr = JOptionPane.showInputDialog("Valor antigo taxa de rendimento: " + ContaPoupanca.getTaxaRendimento());
		ContaPoupanca.setTaxaRendimento(Float.parseFloat(taxaRendimentoStr));
		JOptionPane.showMessageDialog(null, "Nova taxa de Rendimento\n" + ContaPoupanca.getTaxaRendimento());
	}

	private void exibirSaldo() {
		Conta conta;
		try {
			conta = recuperarConta();
			JOptionPane.showMessageDialog(null, "Saldo: " + conta.recuperarSaldo());			
		} catch (ContaNaoCadastradaException e) {
			JOptionPane.showMessageDialog(null, "Conta nao cadastrada");
		}
	}

	private void sacar() {
		try {
			Conta conta = recuperarConta();
			conta.sacar(Double.parseDouble(JOptionPane.showInputDialog("Valor")));
			JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso!");			
		} catch (RuntimeException | SaldoInsuficienteException e) {
			JOptionPane.showMessageDialog(null, "Saldo Insuficiente!");
		} catch (ContaNaoCadastradaException e) {
			JOptionPane.showMessageDialog(null, "Conta N�o Cadastrada!");
		}
	}

	private void depositar() {
		try {
			Conta conta = recuperarConta();
			conta.depositar(Double.parseDouble(JOptionPane.showInputDialog("Valor")));
			JOptionPane.showMessageDialog(null, "Deposito efetuado com sucesso");			
		} catch (ContaNaoCadastradaException e) {
			JOptionPane.showMessageDialog(null, "Conta nao cadastrada");			
		}
	}

	private Conta recuperarConta() throws ContaNaoCadastradaException {
		return controle.recuperarConta(Integer.parseInt(JOptionPane.showInputDialog("Numero da conta")));
	}

	private void cadastrarConta() {
		Conta conta = null;
		String menu = "Digite:\n"
				+ "1 - Conta Corrente\n"
				+ "2 - Conta Poupan�a\n"
				+ "3 - Conta Salario\n";
		String opcaoStr = JOptionPane.showInputDialog(menu);
		String numeroContaStr = JOptionPane.showInputDialog("Informe o numero da conta.");
		Integer numeroConta = Integer.parseInt(numeroContaStr);
		switch (opcaoStr) {
		case "1":
			conta = new ContaCorrente(numeroConta);
			cadastrarContaPadrao(conta);
			concluirCadastroContaCorrente((ContaCorrente) conta);
			break;
		case "2":
			conta = new ContaPoupanca(numeroConta);
			cadastrarContaPadrao(conta);
			concluirCadastroContaPoupanca((ContaPoupanca) conta);
			break;
		case "3":
			conta = new ContaSalario(numeroConta);
			cadastrarContaPadrao(conta);
			concluirCadastroContaSalario((ContaSalario) conta);
			break;

		default:
			break;
		}
		controle.salvarConta(conta);
		JOptionPane.showMessageDialog(null, conta.getClass().getSimpleName() + " cadastrada com sucesso!");
	}

	private void cadastrarContaPadrao(Conta conta) {
		conta.setPessoa(new Pessoa());
		conta.getPessoa().setNome(JOptionPane.showInputDialog("Nome do cliente"));
		conta.getPessoa().setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF do cliente")));
	}

	private void concluirCadastroContaSalario(ContaSalario cs) {
		cs.dataCreditoSalario = new Date();
	}

	private void concluirCadastroContaCorrente(ContaCorrente cc) {
		String tarifaStr = JOptionPane.showInputDialog("Valor da tarifa");
		cc.setTarifa(Double.parseDouble(tarifaStr));
		String limiteCreditoStr = JOptionPane.showInputDialog("Valor do limite de credito");
		cc.setLimiteCredito(Double.parseDouble(limiteCreditoStr));
	}

	private void concluirCadastroContaPoupanca(ContaPoupanca cp) {

		String tarifaStr = JOptionPane.showInputDialog("Dia base para dep�sito");
		cp.diaBaseDeposito = Integer.parseInt(tarifaStr);

	}

}