public class Colaborador {
    public String nome;
    public int idade;
    public String cargo;
    public double salario;

    public Colaborador(String nome, int idade, String cargo, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.cargo= cargo;
        this.salario=salario;
    }


    public void showColaborador(){

        System.out.printf(this.nome + " ("+this.idade+" anos) - ["+this.cargo+"] {%.2f €}", this.salario);
    }


    public void setNome(String nome) {

        this.nome = nome;
    }


    public void setIdade(int idade) {

        this.idade = idade;
    }


    public void setCargo(String cargo) {

        this.cargo = cargo;
    }


    public void setSalario(double salario) {

        this.salario = salario;
    }

    public double getSalario(){

        return this.salario;
    }


}
