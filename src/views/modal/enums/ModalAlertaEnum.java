package views.modal.enums;

public enum ModalAlertaEnum {

	INFO(1),
	ALERTA(2),
	ERRO(3);

	private final Integer tipo;

	ModalAlertaEnum(int tipo) {
		this.tipo = tipo;
	}

	public Integer getTipo() {
		return tipo;
	}
}
