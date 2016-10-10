package br.com.fiap.beans;

public class LancamentoDespesa {

	private int codigo;
	private String tipoDespesa;
	private Processo processo;
	private String dataDespesa;
	private double valorDespesa;
	private String observacao;
	
	public LancamentoDespesa(int codigo, String tipoDespesa, Processo processo, String dataDespesa, double valorDespesa,
			String observacao) {
		super();
		this.codigo = codigo;
		this.tipoDespesa = tipoDespesa;
		this.processo = processo;
		this.dataDespesa = dataDespesa;
		this.valorDespesa = valorDespesa;
		this.observacao = observacao;
	}

	public LancamentoDespesa() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public String getDataDespesa() {
		return dataDespesa;
	}

	public void setDataDespesa(String dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	public double getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(double valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
}
