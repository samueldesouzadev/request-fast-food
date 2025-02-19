package com.fast.food.request.infra.adapters.constants;


public enum CategoryEnum {

    LUNCH("Lanche"),
    ACCOMPANIMENT("Acompanhamento"),
    DRINK("Bebida"),
    DESSERT("Sobremesa");

    public final String name;

    CategoryEnum(String value) {
        name = value;
    }

    public String getName(){
        return this.name;
    }

}
