package br.com.treinar.bb.visao;

import java.awt.HeadlessException;
import java.util.Date;

import javax.swing.JOptionPane;

import br.com.treinar.bb.controle.ContaControle;
import br.com.treinar.bb.modelo.Cliente;
import br.com.treinar.bb.modelo.ContaCorrente;
import br.com.treinar.bb.modelo.ContaInvestimento;
import br.com.treinar.bb.modelo.ContaPoupanca;
import br.com.treinar.bb.modelo.banco.Conta;
import br.com.treinar.bb.modelo.exception.SaldoInsuficienteException;
import br.com.treinar.bb.modelo.exception.SaldoNaoDisponivelException;
import br.com.treinar.bb.modelo.exception.ValorInvalidoException;

public class TelaBB {

	private ContaControle controle;
	//teste
	
	public TelaBB() {
		controle = new ContaControle();
	}
	
	public void iniciar() {
		String menu = "Digite\n1 - Criar Conta\n2 - Definir Taxa Rendimento\n"
					+ "3 - Exibir Saldo\n4 - Captalizar Contas\n5 - Cobrar Tarifa\n"
					+ "6 - Depositar\n7 - Sacar";
		String opcao = null;
		do {
			opcao = JOptionPane.showInputDialog(menu);
			switch (opcao) {
			case "1":
				criarConta();
				break;
			case "2":
				definirTaxaRendimentoContaPoupanca();
				break;
			case "3":
				exibirSaldo();
				break;
			case "4":
				captalizar();
				break;
			case "5":
				cobrarTarifa();
				break;
			case "6":
				depositar();
				break;
			case "7":
				sacar();
				break;

			default:
				break;
			}
		} while (!opcao.equals("0"));
	}

	private void exibirSaldo() {
		Conta c = recuperarConta();
		if (c != null) {
			try {
				JOptionPane.showMessageDialog(null, c.recuperarSaldo());
			} catch (SaldoNaoDisponivelException e) {
				JOptionPane.showMessageDialog(null, "deu problema no saldo");
				//e.printStackTrace();
			}			
		}
	}

	private String exibirContas() {
		Conta[] contas = controle.recuperarContas();
		String contasStr = "";
		for (Conta conta : contas) {
			if (conta != null) {
				contasStr = conta.toString();				
			}
		}
		return contasStr;
	}
	
	private Conta recuperarConta() {
		return controle.recuperarConta(Long.parseLong(JOptionPane.showInputDialog("ID da conta\n\n" + exibirContas())));
	}

	private void criarConta() {
		
		Integer tipoConta = Integer.parseInt(JOptionPane.showInputDialog("1 - Corrente\n"
																	   + "2 - Poupan�a\n"
																	   + "3 - Investimento\n"));
		Conta c = null;
		switch (tipoConta) {
		case 1:
			c = new ContaCorrente();
			criarContaPadrao(c);
			concluirCriacaoContaCorrente((ContaCorrente)c);
			break;
		case 2:
			c = new ContaPoupanca();
			criarContaPadrao(c);
			concluirCriacaoContaPoupanca((ContaPoupanca)c);
			
			break;
		case 3:
			c = new ContaInvestimento();
			criarContaPadrao(c);
			concluirCriacaoContaInvestimento((ContaInvestimento)c);
			
			break;

		default:
			break;
		}
		if (c != null) {
			controle.adicionarConta(c);
		}
	}

	private void concluirCriacaoContaInvestimento(ContaInvestimento c) {
		c.setTaxaManutencao(Double.parseDouble(JOptionPane.showInputDialog("Taxa Manuten��o")));
		c.setTaxaRendimento(Double.parseDouble(JOptionPane.showInputDialog("Taxa Rendimento")));
	}

	private void concluirCriacaoContaPoupanca(ContaPoupanca c) {
		c.setDiaBase(Integer.valueOf(JOptionPane.showInputDialog("Dia Base Rendimento")));
	}

	private void concluirCriacaoContaCorrente(ContaCorrente c) {
		c.setLimiteCredito(Double.parseDouble(JOptionPane.showInputDialog("Limite de Cr�dito")));
		c.setTaxaManutencao(Double.parseDouble(JOptionPane.showInputDialog("Taxa Manuten��o")));
	}

	private void criarContaPadrao(Conta c) {
		c.setCliente(criarCliente());
		c.setDataAbertura(new Date());
	}

	private Cliente criarCliente() {
		Cliente c = new Cliente();
		c.setNome(JOptionPane.showInputDialog("Nome"));
		c.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF")));
		return c;
	}

	private void definirTaxaRendimentoContaPoupanca() {
		Double novaTaxa = Double.parseDouble(JOptionPane.showInputDialog("Nova taxa de rendimento"));
		controle.editarTaxaRendimento(novaTaxa);
	}
	
	private void captalizar() {
		controle.captalizarContas();		
	}
	
	private void cobrarTarifa() {
		controle.cobrarTarifa();		
	}

	private void depositar() {
		Conta conta = recuperarConta();
		Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor"));
		controle.depositar(conta, valor );
	}
			
	private void sacar() {
		Conta conta = recuperarConta();
		sacar(conta);
	}
	
	private void sacar(Conta conta) {
		Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor"));
		try {
			controle.sacar(conta, valor );
			JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso");
		} catch (SaldoInsuficienteException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Saldo insuficiente. Dispon�vel: " + e.getSaldoDisponivel());
		} catch (ValorInvalidoException e) {
			JOptionPane.showMessageDialog(null, "Voc� digitou um valor inv�lido!");
			sacar(conta);
		}
	}
	
}
