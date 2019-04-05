package com.example.user.endexam;

import java.io.Serializable;

public class Product implements Serializable {
    private String CodePro;
    private String NamePro;
    private String CostPro;
    private String UnitPro;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    private int Id;

    public Product() {
    }

    public Product(String codePro, String namePro, String costPro, String unitPro) {
        CodePro = codePro;
        NamePro = namePro;
        CostPro = costPro;
        UnitPro = unitPro;
    }

    public String getCodePro() {
        return CodePro;
    }

    public void setCodePro(String codePro) {
        CodePro = codePro;
    }

    public String getNamePro() {
        return NamePro;
    }

    public void setNamePro(String namePro) {
        NamePro = namePro;
    }

    public String getCostPro() {
        return CostPro;
    }

    public void setCostPro(String costPro) {
        CostPro = costPro;
    }

    public String getUnitPro() {
        return UnitPro;
    }

    public void setUnitPro(String unitPro) {
        UnitPro = unitPro;
    }
}
