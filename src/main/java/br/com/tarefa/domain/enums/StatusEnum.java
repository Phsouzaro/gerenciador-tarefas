package br.com.tarefa.domain.enums;

public enum StatusEnum {

    CRIADA("CRIADA"),
    FAZENDO("FAZENDO"),
    FEITO("FEITO");

    private String value;
    StatusEnum(String valor){
        this.value = valor;
    }

    public String getValue() {
        return value;
    }

    public static StatusEnum fromValue(String text){
        for(StatusEnum b : StatusEnum.values()){
            if(String.valueOf(b.value).equals(text)){
                return b;
            }
        }
        return null;
    }
}
