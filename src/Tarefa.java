public class Tarefa {
    public String titulo;
    public String descricao;
    public int categoria;
    public boolean status = false;

    /*
    Categorias: 1 - Trabalho; 2 - Casa; 3 - Saúde e bem estar;
    4 - Estudos; 5 - Religião; 6 - Lazer; 7 - Outros.
    */

    public Tarefa(String titulo, String descricao, int categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
    }



    public String getCategoria() {
        switch (categoria) {
            case 1:
                return "Trabalho";
            case 2:
                return "Casa";
            case 3:
                return "Saúde e Bem Estar";
            case 4:
                return "Estudos";
            case 5:
                return "Religião";
            case 6:
                return "Lazer";
            default:
                return "Outros";
        }
    }

    public String consultar(int i) {
        String s = "Título: " + titulo + "\nStatus: " + getStatus() + "\nCategoria: " + getCategoria() + "\nDescrição: " + descricao;
        switch (i) {
            case 1:
                return s;
            case 2:
                if (!status) {
                    return s;
                } else {
                    return null;
                }
            case 3:
                if (status) {
                    return s;
                } else {
                    return null;
                }
            default:
                return s;
        }
    }


    public String getTitulo() {
        return this.titulo;
    }

    public String getStatus() {
        if (status) {
            return "Finalizada";
        } else {
            return "Pendente";
        }
    }

    public void marcar() {
        if (status) {
            System.out.println("A tarefa já consta como finalizada.");
        } else{
            this.status = true;
            System.out.println("Parabéns! Tarefa finalizada.");
        }

    }


    public void desmarcar() {
        if(!status){
            System.out.println("A tarefa já consta como pendente.");
            } else{
        this.status = false;
        System.out.println("Tarefa pendente.");}
    }
}



