package org.academiadecodigo.thunderstructs.models;

public enum Teams {
    MAN_UNITED(),
    BARCELONA(),
    MAN_CITY(),
    REAL_MADRID(),
    BENFICA(),
    LIVERPOOL(),
    PORTO(),
    SPORTING(),
    SANTA_CLARA(),
    ATL_MADRID();

    private String name;


    Teams(){

    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


}


