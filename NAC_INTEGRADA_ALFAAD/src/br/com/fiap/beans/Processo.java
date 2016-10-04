package br.com.fiap.beans;

public class Processo {

	private long numeroProcesso;
	private Advogado advogado;
	private Forum forum;
	private Cliente cliente;
	private String descricaoProcesso;
	private String dataAbertura;
	private String dataFechamento;
	private String dataDiaVencimento;
	private short resultado;
	private short situacao;
	private String observacao;
	
	public Processo(long numeroProcesso, Advogado advogado, Forum forum, Cliente cliente, String descricaoProcesso,
			String dataAbertura, String dataFechamento, String dataDiaVencimento, short resultado, short situacao,
			String observacao) {
		super();
		this.numeroProcesso = numeroProcesso;
		this.advogado = advogado;
		this.forum = forum;
		this.cliente = cliente;
		this.descricaoProcesso = descricaoProcesso;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
		this.dataDiaVencimento = dataDiaVencimento;
		this.resultado = resultado;
		this.situacao = situacao;
		this.observacao = observacao;
	}

	public Processo() {
		super();
	}

	public long getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(long numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDescricaoProcesso() {
		return descricaoProcesso;
	}

	public void setDescricaoProcesso(String descricaoProcesso) {
		this.descricaoProcesso = descricaoProcesso;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(String dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public String getDataDiaVencimento() {
		return dataDiaVencimento;
	}

	public void setDataDiaVencimento(String dataDiaVencimento) {
		this.dataDiaVencimento = dataDiaVencimento;
	}

	public short getResultado() {
		return resultado;
	}

	public void setResultado(short resultado) {
		this.resultado = resultado;
	}

	public short getSituacao() {
		return situacao;
	}

	public void setSituacao(short situacao) {
		this.situacao = situacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
	
	
	
}
