package enums;

public enum OperationsEnum {

    BOLETO_ATUALIZADO("BOLETO ATUALIZADO"),
    BOLETO_QUITACAO("BOLETO DE QUITAÇÃO"),
    CARTAS_E_DOCUMENTOS("CARTAS E DOCUMENTOS"),
    CARTA_IMPOSTO_RENDA("CARTA DE IMPOSTO DE RENDA"),
    PLANILHA_CALCULO("PLANILHA DE CÁLCULO"),
    CARTA_COMPROVACAO_PAGAMENTO("CARTA DE COMPROVAÇÃO DE PAGAMENTO"),
    ENCERRANDO_LEASING("Encerrando meu Leasing"),
    BOLETO("Boleto");

    private String operation;
    OperationsEnum(String option){
        this.operation = option;
    }
    public String getOperation(){
        return operation;
    }

}
