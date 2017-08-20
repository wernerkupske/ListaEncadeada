package trabalhointerface;

import trabalhointerface.telas.Inicio;

public class Vendas {
    /*
    Script BD:
    
CREATE DATABASE FAT_TRUCK;

USE FAT_TRUCK;

CREATE TABLE ADMIN (
    USER_ADM VARCHAR(40) PRIMARY KEY,
    SENHA_ADM VARCHAR(40) NOT NULL
);

CREATE TABLE PRODUTO (
    COD_PDTO INT PRIMARY KEY,
    NOM_PDTO VARCHAR (60) NOT NULL,
    PRECO_PDTO BIGINT(6.2) NOT NULL,
    ICON_PDTO BLOB NOT NULL
);

CREATE TABLE VENDA (
    COD_VENDA INT PRIMARY KEY,
    DAT_VENDA DATE NOT NULL,
    TOTAL_VENDA BIGINT (6.2) NOT NULL
);

CREATE TABLE VENDA_PRODUTO (
    COD_VENDA INT,
    COD_PDTO INT,
    QTD_VENDA INT,
    PRECO_PDTO BIGINT (6.2),
    PRIMARY KEY (COD_VENDA, COD_PDTO),
    FOREIGN KEY VENDA_PRODUTO(COD_VENDA) REFERENCES VENDA(COD_VENDA),
    FOREIGN KEY VENDA_PRODUTO(COD_PDTO) REFERENCES PRODUTO(COD_PDTO)
);
    */
    
    
    
    public static void main(String[] args) {
        Inicio inicio = new Inicio();
        inicio.setVisible(true); 
        System.out.println("");
    }
    
}
