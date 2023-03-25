import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Main {


    static Scanner input = new Scanner(System.in);
    public static ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();



    //Programa
    public static void main(String[] args) {

        int opcao;

        do{
            menu();
            System.out.print("Opção: ");
            opcao=input.nextInt();
            input.nextLine();
            limpa();

            switch (opcao){
                case 1:
                    registarColaborador();
                    break;
                case 2:
                    if (colaboradores.size() == 0){
                        System.out.println("Sem colaboradores registados.\n");
                    }
                    else {
                        editarColaborador();
                    }
                    break;
                case 3:
                    if (colaboradores.size() == 0){
                        System.out.println("Sem colaboradores registados.\n");
                    }
                    else {
                        procurarColaborador();
                    }
                    break;
                case 4:
                    if (colaboradores.size() == 0){
                        System.out.println("Sem colaboradores registados.\n");
                    }
                    else {
                       despedimento();
                    }
                    break;
                case 5:
                    if (colaboradores.size() == 0){
                        System.out.println("Sem colaboradores registados.\n");
                    }
                    else {
                        listarColaborador();
                    }
                    break;
                case 6:
                    if (colaboradores.size() == 0){
                        System.out.println("Sem colaboradores registados.\n");
                    }
                    else {
                        ordemSalario();
                    }
                    break;
                case 7:
                    if(colaboradores.size() == 0){
                        System.out.println("Sem colaboradores registados.");
                    }
                    else {
                        balizaSalarial();
                    }
                    break;
                case 8:
                    if(colaboradores.size() == 0){
                        System.out.println("Sem colaboradores registados.");
                    }
                    else {
                        despesasColaboradores();
                    }
                    break;
                case 0:
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

            enter();
            limpa();

        }while (opcao!=0);

    }


    //Funcoes
    public static void menu(){
        System.out.println("\n===== Gestor de Colaboradores =====\n");
        System.out.println("1 - Registar novo colaborador.");
        System.out.println("2 - Editar colaborador.");
        System.out.println("3 - Procurar colaborador por nome.");
        System.out.println("4 - Despedir colaborador.");
        System.out.println("5 - Lista de colaboradores.");
        System.out.println();
        System.out.println("6 - Lista de colaboradores por ordem salarial.");
        System.out.println();
        System.out.println("7 - Procurar colaboradores por baliza de salário.");
        System.out.println("8 - Despesas dos colaboradores");
        System.out.println();
        System.out.println("0 - Logout.\n");
    }


    public static void registarColaborador(){

        String nome, cargo;
        int idade;
        double salario;


        System.out.println("--- Novo Colaborador ---");
        System.out.print("\nNome: ");
        nome = input.nextLine();
        System.out.print("Idade: ");
        idade = input.nextInt();
        while(idade<18 && idade<66){
            System.out.println("ERRO! TRABALHADOR NÃO PODE SER MENOR NEM ESTAR NA IDADE DA REFORMA!");
            System.out.print("Digite novamente a Idade: ");
            idade = input.nextInt();
        }
        input.nextLine();
        System.out.print("Cargo: ");
        cargo = input.nextLine();
        System.out.print("Salário: ");
        salario = input.nextDouble();
        while(salario <= 0){
            System.out.println("SALÁRIO INVÁLIDO!");
            System.out.print("Digite novamente o salário: ");
            salario = input.nextDouble();
        }
        input.nextLine();
        colaboradores.add(new Colaborador(nome, idade, cargo, salario));
        System.out.println("\n\nSUCESSO!");
    }





    public static void editarColaborador(){

        int id, opcao;

        System.out.println("--- Editar Colaborador ---\n");
        for(int i = 0; i < colaboradores.size(); i++){
            System.out.print((i+1) + ") ");
            colaboradores.get(i).showColaborador();
            System.out.println();
        }

        System.out.print("\nDigite o id do colaborador a ser editado: ");
        id = input.nextInt();
        input.nextLine();

        limpa();

        System.out.print("=== ");
        colaboradores.get((id-1)).showColaborador();
        System.out.print(" ===\n\n");
        System.out.println("1- Nome.");
        System.out.println("2- Idade.");
        System.out.println("3- Cargo.");
        System.out.println("4- Salário.");
        System.out.print("\nSeleccione o que será editado neste colaborador: ");
        opcao = input.nextInt();
        input.nextLine();
        System.out.print("\nDigite o que irá substituir (");

        switch (opcao){
            case 1:
                String nome_novo;

                System.out.print(colaboradores.get((id-1)).nome + ") : ");
                nome_novo = input.nextLine();
                colaboradores.get((id-1)).setNome(nome_novo);
                System.out.print("\n\n=== ");
                colaboradores.get((id-1)).showColaborador();
                System.out.print(" ===");
                System.out.println("\n\nSUCESSO!");
                break;

            case 2:
                int idade_novo;

                System.out.print(colaboradores.get((id-1)).idade + ") : ");
                idade_novo = input.nextInt();
                input.nextLine();
                colaboradores.get((id-1)).setIdade(idade_novo);
                System.out.print("\n\n=== ");
                colaboradores.get((id-1)).showColaborador();
                System.out.print(" ===");
                System.out.println("\n\nSUCESSO!");
                break;

            case 3:
                String cargo_novo;

                System.out.print(colaboradores.get((id-1)).cargo + ") : ");
                cargo_novo = input.nextLine();
                colaboradores.get((id-1)).setCargo(cargo_novo);
                System.out.print("\n\n=== ");
                colaboradores.get((id-1)).showColaborador();
                System.out.print(" ===");
                System.out.println("\n\nSUCESSO!");
                break;
            case 4:
                double salario_novo;

                System.out.print(colaboradores.get((id-1)).salario + ") : ");
                salario_novo = input.nextDouble();
                input.nextLine();
                colaboradores.get((id-1)).setSalario(salario_novo);
                System.out.print("\n\n=== ");
                colaboradores.get((id-1)).showColaborador();
                System.out.print(" ===");
                System.out.println("\n\nSUCESSO!");
                break;
            default:
                System.out.println("\n\nOPÇÃO INVÁLIDA!");
        }
    }


    public static void procurarColaborador(){

        String nome_procurar;
        boolean procura = false;

        System.out.print("Digite o nome a ser procurado: ");
        nome_procurar = input.nextLine();
        System.out.println();
        for (int i = 0; i < colaboradores.size(); i++){
            if (colaboradores.get(i).nome.toLowerCase().indexOf(nome_procurar.toLowerCase()) != -1){
                System.out.print((i+1) + ") ");
                colaboradores.get(i).showColaborador();
                System.out.println();
                procura = true;
            }
        }
        if(!procura){
            System.out.println("\n\nColaborador não encontrado!");
        }
    }


    public static void despedimento(){

        int opcao;
        char questao;

        for(int i = 0; i < colaboradores.size(); i++){
            System.out.print((i+1) + ") ");
            colaboradores.get(i).showColaborador();
            System.out.println();
        }

        System.out.println();
        System.out.print("Digite o código do colaborador a ser despedido: ");
        opcao = input.nextInt()-1;


        while(opcao<0 || opcao>=colaboradores.size()){
            System.out.print("Código de colaborador não encontrado, digite novamente: ");
            opcao = input.nextInt();
        }
        input.nextLine();
        System.out.print("\nTens certeza desta operação? (s/n) ");
        questao = input.nextLine().charAt(0);
        if (questao == 's' || questao == 'S'){
            colaboradores.remove((opcao));
        }
        System.out.println();
        for(int i=0; i<colaboradores.size(); i++){
            System.out.print((i+1) + ") ");
            colaboradores.get(i).showColaborador();
            System.out.println();
        }

        System.out.println("\nSUCESSO!");
    }


    public static void listarColaborador(){

        System.out.println("--- Lista de Colaboradores Registados ---\n");

        for(int i=0; i<colaboradores.size(); i++){
            System.out.print((i+1) + " - ");
            colaboradores.get(i).showColaborador();
            System.out.println();
        }
    }


    public static void ordemSalario(){

        int x=1;
        ArrayList<Colaborador> listanova = new ArrayList<>();
        listanova= (ArrayList<Colaborador>)colaboradores.clone();

        listanova.sort(Comparator.comparing(Colaborador::getSalario));

        for (Colaborador ordenado : listanova) {
            System.out.print(x + " - ");
            ordenado.showColaborador();
            System.out.println();
            x++;
        }

    }


    public static void balizaSalarial(){

        double minimo, maximo;

        System.out.print("Digite o valor MINIMO de salário a ser procurado: ");
        minimo = input.nextDouble();
        System.out.print("Digite o valor MÁXIMO de salário a ser procurado: ");
        maximo = input.nextDouble();
        while(maximo<=minimo){
            System.out.print("Preço salário máximo inválido! Digite um número maior que o digitado no valor minimo: ");
            maximo = input.nextDouble();
        }

        input.nextLine();
        System.out.println("\n---- Lista de colaboradores dentro dos valores escolhidos ----\n");

        for (int i = 0; i < colaboradores.size(); i++){
            if (colaboradores.get(i).salario >= minimo && colaboradores.get(i).salario <= maximo){
                colaboradores.get(i).showColaborador();
                System.out.println();
            }
        }
    }

    public static void despesasColaboradores(){

        double total = 0;

        System.out.println("--- Lista de Colaboradores Registados---\n");

        for(int i = 0; i < colaboradores.size(); i++){
            System.out.print((i+1) + ") ");
            colaboradores.get(i).showColaborador();
            System.out.println();
            total += colaboradores.get(i).salario;
        }

        System.out.printf("\n\n--- TOTAL: (%.2f €) ---\n", total);
    }





    public static void enter(){

        String enter;

        System.out.println("\nPressione ENTER para continuar...");
        enter = input.nextLine();
    }


    public static void aguarde(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException erro){
            erro.printStackTrace();
        }
    }

    public static void limpa(){
        for(int i=0; i<15; i++){
            System.out.println();
        }
    }

}