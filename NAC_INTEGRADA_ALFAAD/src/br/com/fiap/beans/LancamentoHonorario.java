package br.com.fiap.beans;

public class LancamentoHonorario {

	private int codigo;
	private TipoTarefa tipoTarefa;
	private Processo processo;
	private String dataHonorario;
	private double qtdeHora;
	private String observacao;
	private double vlHoraAdvogado;
	
	
	
	
	public LancamentoHonorario(int codigo, TipoTarefa tipoTarefa, Processo processo, String dataHonorario,
			double qtdeHora, String observacao, double vlHoraAdvogado) {
		super();
		this.codigo = codigo;
		this.tipoTarefa = tipoTarefa;
		this.processo = processo;
		this.dataHonorario = dataHonorario;
		this.qtdeHora = qtdeHora;
		this.observacao = observacao;
		this.vlHoraAdvogado = vlHoraAdvogado;
	}


	public LancamentoHonorario() {
		super();
	}


	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public TipoTarefa getTipoTarefa() {
		return tipoTarefa;
	}
	public void setTipoTarefa(TipoTarefa tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}
	public Processo getProcesso() {
		return processo;
	}
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	public String getDataHonorario() {
		return dataHonorario;
	}
	public void setDataHonorario(String dataHonorario) {
		this.dataHonorario = dataHonorario;
	}
	public double getQtdeHora() {
		return qtdeHora;
	}
	public void setQtdeHora(double qtdeHora) {
		this.qtdeHora = qtdeHora;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public double getVlHoraAdvogado() {
		return vlHoraAdvogado;
	}


	public void setVlHoraAdvogado(double vlHoraAdvogado) {
		this.vlHoraAdvogado = vlHoraAdvogado;
	}
	
	
}
