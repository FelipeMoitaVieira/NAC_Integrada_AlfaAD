package br.com.fiap.beans;

public class LancamentoHonoriaio {

	private int codigo;
	private String tipoTarefa;
	private Processo processo;
	private String dataHonorario;
	private float qtdeHora;
	private String observacao;
	
	public LancamentoHonoriaio(int codigo, String tipoTarefa, Processo processo, String dataHonorario, float qtdeHora,
			String observacao) {
		super();
		this.codigo = codigo;
		this.tipoTarefa = tipoTarefa;
		this.processo = processo;
		this.dataHonorario = dataHonorario;
		this.qtdeHora = qtdeHora;
		this.observacao = observacao;
	}
	
	
	public LancamentoHonoriaio() {
		super();
	}


	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTipoTarefa() {
		return tipoTarefa;
	}
	public void setTipoTarefa(String tipoTarefa) {
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
	public float getQtdeHora() {
		return qtdeHora;
	}
	public void setQtdeHora(float qtdeHora) {
		this.qtdeHora = qtdeHora;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}
