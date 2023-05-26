/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LIGIA
 */
  public class Curso {
    private String nome;
    private String curso;
    private String area;
    private int aula;
    private int duracao;
    private String cadeira;
    private int videoaula;

public Curso(String nome,String curso, String area, int aula, int duracao, String cadeira, int videoaula) {
            this.nome = nome;
  this.curso=curso;
            this.area = area;
            this.aula = aula;
            this.duracao = duracao;
            this.cadeira = cadeira;
            this.videoaula = videoaula;
        }

    Curso(String nome, String curso, String area, int aula, int duracao, int cadeira, int videoaula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
 public String getCurso() {
            return curso;
        }

        public void setCurso(String nome) {
            this.curso = curso;
        }
        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getAulas() {
            return aula;
        }

        public void setAulas(int aulas) {
            this.aula = aula;
        }

        public int getDuracao() {
            return duracao;
        }

        public void setDuracao(int duracao) {
            this.duracao = duracao;
        }

        public String getCadeira() {
            return cadeira;
        }

        public void setCadeira(String cadeira) {
            this.cadeira = cadeira;
        }

        public int getVideoaula() {
            return videoaula;
        }

        public void setVideoaula(int videoaula) {
            this.videoaula = videoaula;
        }

    void setAula(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}



