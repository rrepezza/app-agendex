package br.com.senai.enums;

public enum Sexo {
	F("FEMININO"), M("MASCULINO");

	private String descricao;

	Sexo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
