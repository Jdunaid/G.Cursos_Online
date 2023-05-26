/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

/**
 *
 * @author LIGIA
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CursoCRUD {
    private List<Curso> cursos;
    private Scanner scanner;

    public CursoCRUD() {
        cursos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        CursoCRUD cursoCRUD = new CursoCRUD();
        cursoCRUD.menuPrincipal();
    }

    public void menuPrincipal() {
        boolean sair = false;
        while (!sair) {
            System.out.println("==== MENU PRINCIPAL ====");
            System.out.println("1. Cadastrar curso");
            System.out.println("2. Listar cursos");
            System.out.println("3. Atualizar curso");
            System.out.println("4. Excluir curso");
            System.out.println("5. Sair");
            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarCurso();
                    break;
                case 2:
                    listarCursos();
                    break;
                case 3:
                    atualizarCurso();
                    break;
                case 4:
                    excluirCurso();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public void cadastrarCurso() {
        System.out.println("==== CADASTRO DE CURSO ====");
        System.out.print("Nome do curso: ");
        String nome = scanner.nextLine();
        System.out.print("Área do curso: ");
        String area = scanner.nextLine();
        System.out.print("Número de aulas: ");
        int aula = scanner.nextInt();
        System.out.print("Duração do curso (em horas): ");
        int duracao = scanner.nextInt();
        System.out.print("Número de cadeiras: ");
        int cadeira = scanner.nextInt();
        System.out.print("Número de videoaulas: ");
        int videoaula = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        Curso curso = new Curso(nome, area, aula, duracao, cadeira, videoaula);
        cursos.add(curso);

        System.out.println("Curso cadastrado com sucesso!");
    }

    public void listarCursos() {
        System.out.println("==== LISTA DE CURSOS ====");
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
        } else {
            for (Curso curso : cursos) {
                System.out.println(curso);
            }
        }
    }

    public void atualizarCurso() {
        System.out.println("==== ATUALIZAÇÃO DE CURSO ====");
        System.out.print("Digite o nome do curso que deseja atualizar: ");
        String nome = scanner.nextLine();

        Curso cursoEncontrado = null;
        for (Curso curso : cursos) {
            if (curso.getNome().equalsIgnoreCase(nome)) {
                cursoEncontrado = curso;
                break;
            }
        }

        if (cursoEncontrado != null) {
            System.out.print("Novo nome do curso: ");
            String novoNome = scanner.nextLine();
            System.out.print("Nova área do curso: ");
            String novaArea = scanner.nextLine();
            System.out.print("Novo número de aulas: ");
            int novaAula = scanner.nextInt();
            System.out.print("Nova duração do curso (em horas): ");
            int novaDuracao = scanner.nextInt();
            System.out.print("Novo número de cadeiras: ");
            int novaCadeira = scanner.nextInt();
            System.out.print("Novo número de videoaulas: ");
            int novaVideoaula = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            cursoEncontrado.setNome(novoNome);
            cursoEncontrado.setArea(novaArea);
            cursoEncontrado.setAula(novaAula);
            cursoEncontrado.setDuracao(novaDuracao);
            cursoEncontrado.setCadeira(novaCadeira);
            cursoEncontrado.setVideoaula(novaVideoaula);

            System.out.println("Curso atualizado com sucesso!");
        } else {
            System.out.println("Curso não encontrado!");
        }
    }

    public void excluirCurso() {
        System.out.println("==== EXCLUSÃO DE CURSO ====");
        System.out.print("Digite o nome do curso que deseja excluir: ");
        String nome = scanner.nextLine();

        Curso cursoEncontrado = null;
        for (Curso curso : cursos) {
            if (curso.getNome().equalsIgnoreCase(nome)) {
                cursoEncontrado = curso;
                break;
            }
        }

        if (cursoEncontrado != null) {
            cursos.remove(cursoEncontrado);
            System.out.println("Curso excluído com sucesso!");
        } else {
            System.out.println("Curso não encontrado!");
        }
    }
}

class Curso {
    private String nome;
    private String area;
    private int aula;
    private int duracao;
    private int cadeira;
    private int videoaula;

    public Curso(String nome, String area, int aula, int duracao, int cadeira, int videoaula) {
        this.nome = nome;
        this.area = area;
        this.aula = aula;
        this.duracao = duracao;
        this.cadeira = cadeira;
        this.videoaula = videoaula;
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getCadeira() {
        return cadeira;
    }

    public void setCadeira(int cadeira) {
        this.cadeira = cadeira;
    }

    public int getVideoaula() {
        return videoaula;
    }

    public void setVideoaula(int videoaula) {
        this.videoaula = videoaula;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", area='" + area + '\'' +
                ", aula=" + aula +
                ", duracao=" + duracao +
                ", cadeira=" + cadeira +
                ", videoaula=" + videoaula +
                '}';
    }
}
