package br.com.treinar.bradesco;

import br.com.treinar.bradesco.banco.Conta;

public class ContaCorrente extends Conta {

	private Double tarifa;
	
	private Double limiteCredito;
	//private Integer qtdSaque;

	public Double getTarifa() {
		return tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	public Double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	@Override
	public Double recuperarSaldo() {
		return saldo + limiteCredito;
	}

	@Override
	public Boolean sacar(Double valor) {
		//TODO implementar regra de qtd de saques
		Boolean sacou = Boolean.FALSE;
		if (saldo >= (valor + limiteCredito)) {
			if (saldo >= valor) {
				saldo -= valor;
			} else {
				limiteCredito -= valor - saldo;
				saldo = 0d;
			}
			sacou = Boolean.TRUE;
		}
		return sacou;
	}
	
}