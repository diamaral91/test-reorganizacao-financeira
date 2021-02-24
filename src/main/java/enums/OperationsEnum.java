package enums;

public enum OperationsEnum {

    BOLETO_ATUALIZADO("BOLETO ATUALIZADO"),
    BOLETO_QUITACAO("BOLETO DE QUITAÇÃO"),
    CARTAS_E_DOCUMENTOS("CARTAS E DOCUMENTOS"),
    CARTA_IMPOSTO_RENDA("CARTA DE IMPOSTO DE RENDA"),
    PLANILHA_CALCULO("PLANILHA DE CÁLCULO"),
    CARTA_COMPROVACAO_PAGAMENTO("CARTA DE COMPROVAÇÃO DE PAGAMENTO"),
    ENCERRANDO_LEASING("ENCERRAMENTO DE LEASING"),
    HISTORICO_SOLICITACOES("HISTÓRICO DE SOLICITAÇÕES"),
    VIA_CONTRATO("VIA DE CONTRATO"),
    CARTA_QUITACAO("CARTA DE QUITAÇÃO"),
    CARTA_SAIDA_PAIS("CARTA SAÍDA DO PAÍS"),
    BOLETO("Boleto");

    private String operation;
    OperationsEnum(String option){
        this.operation = option;
    }
    public String getOperation(){
        return operation;
    }

}
