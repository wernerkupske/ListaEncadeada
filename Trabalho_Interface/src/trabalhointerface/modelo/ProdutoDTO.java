package trabalhointerface.modelo;

import javax.swing.ImageIcon;

public class ProdutoDTO {
    private int codigo;
    private ImageIcon icone;
    private String nome;
    private float preco;

    public ProdutoDTO() {
        this.codigo = 0;
        this.nome = "";
        this.icone = null;
        this.preco = 0;
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setIcone(ImageIcon icone) {
        this.icone = icone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public Object[] getLinhaTabela(){
        Object[] retorno = {String.valueOf(this.codigo), this, String.valueOf(this.preco)};
        return retorno;
    }
    
    @Override
    public String toString(){
        return nome;
    }

    public ProdutoDTO(int codigo, String nome, float preco, ImageIcon icone) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.icone = icone;
    }
}