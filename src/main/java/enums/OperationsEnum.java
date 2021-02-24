package enums;

public enum OperationsEnum {

    BOLETO_ATUALIZADO("BOLETO ATUALIZADO"),
    BOLETO_QUITACAO("BOLETO DE QUITA��O"),
    CARTAS_E_DOCUMENTOS("CARTAS E DOCUMENTOS"),
    CARTA_IMPOSTO_RENDA("CARTA DE IMPOSTO DE RENDA"),
    PLANILHA_CALCULO("PLANILHA DE C�LCULO"),
    CARTA_COMPROVACAO_PAGAMENTO("CARTA DE COMPROVA��O DE PAGAMENTO"),
    ENCERRANDO_LEASING("ENCERRAMENTO DE LEASING"),
    HISTORICO_SOLICITACOES("HIST�RICO DE SOLICITA��ES"),
    VIA_CONTRATO("VIA DE CONTRATO"),
    CARTA_QUITACAO("CARTA DE QUITA��O"),
    CARTA_SAIDA_PAIS("CARTA SA�DA DO PA�S"),
    BOLETO("Boleto");

    private String operation;
    OperationsEnum(String option){
        this.operation = option;
    }
    public String getOperation(){
        return operation;
    }

}
