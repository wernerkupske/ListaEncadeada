package listaencadeada;

public class Aluno {

    public Aluno(String nome, int cod) {
        this.nome = nome;
        this.cod = cod;
    }

    String nome;
    int cod;
    Aluno proximo;

    Aluno() {
        System.out.println("N sei o que faz!");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

}
