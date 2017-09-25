package listaencadeada.fuchina;
 
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Alunos {
 
    int codigo;
    String nome;
    Alunos proximo;
 
    public Alunos() {
    }
 
    public Alunos(int cod, String nome, Alunos proximo) {
        this.codigo = cod;
        this.nome = nome;
        this.proximo = proximo;
    }
 
    public int pedeInteiro(String mensagem, int min, int max) {
        int aux = 0;
        Scanner leia = new Scanner(System.in);
        do {
            try {
                System.out.println(mensagem);
                aux = leia.nextInt();
                if (aux < min || aux > max) {
                    System.out.println("ERRO: Digite um número de "+min+" à "+max+".");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Digite apenas números inteiros.");
                aux = - 1;
            }
        } while ((aux < min || aux > max));
        return aux;
    }
 
    public String pedeNome() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Informe o nome do aluno: ");
        return leia.nextLine();
    }
}
