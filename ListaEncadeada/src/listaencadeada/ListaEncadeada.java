package listaencadeada;

import java.util.Scanner;

public class ListaEncadeada {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int op = 0;
        do{
        System.out.println("  1 - Incluir um objeto no início na lista\n"
                + "  2 - Incluir um objeto no final da lista\n"
                + "  3 - Verificar se um objeto específico está na lista\n"
                + "  4 - Remover um objeto específico da lista\n"
                + "  5 - Remover o primeiro objeto da lista\n"
                + "  6 - Remover o último objeto da lista\n"
                + "  7 - Mostrar todos os objetos da lista na ordem do primeiro para o último\n"
                + "  8 - Mostrar todos os objetos da lista na ordem do último para o primeiro\n"
                + "  9 - Sair");
        op = tec.nextInt();
        }while(op<1 || op>9);
        switch (op) {
            case 1:
                Metodos teste = new Metodos();
                teste.insereInicio();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
        }
    }
}
