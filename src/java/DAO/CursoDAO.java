/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Curso;
import Util.DBUtil;
import java.sql.Date;
import static org.hibernate.type.StandardBasicTypes.BLOB;

public class CursoDAO {
    private Connection connection;
    private byte[] videoaulaBytes;

    public CursoDAO() {
        connection = DBUtil.getConnection();
    }

    public void addUser(Curso curso) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into Curso(codigo,nome,area,duracao,cadeira,videoaula) values (?, ?, ?, ?,?,? )");
            // Parameters start with 1
            preparedStatement.setInt(1, curso.getcodigo());
            preparedStatement.setString(2, curso.getnome());
          preparedStatement.setString(3, curso.getarea());
           preparedStatement.setDate(4, (Date) curso.getduracao());
            preparedStatement.setString(5, curso.getcadeira());
            preparedStatement.setByte(6, curso.getvideoaula());
            
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from Curso where codigo=?");
            // Parameters start with 1
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCurso(Curso curso) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update Curso set codigo=?, nome=?, area=?, duracao=?, cadeira=?, videoaula=?" +
                            "where codigo=?");
            // Parameters start with 1
            preparedStatement.setInt(1, curso.getcodigo());
            preparedStatement.setString(2, curso.getnome());
          preparedStatement.setString(3, curso.getarea());
           preparedStatement.setDate(4, (Date) curso.getduracao());
            preparedStatement.setString(5, curso.getcadeira());
            preparedStatement.setByte(6, curso.getvideoaula());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Curso> getAllCurso() {
        List<Curso> listaDeCurso = new ArrayList<Curso>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Curso");
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setcodigo(rs.getInt("codigo"));
                curso.setnome(rs.getString("nome"));
                curso.setarea(rs.getString("area"));
                curso.setduracao(rs.getDate("duracao"));
                curso.setcadeira(rs.getString("cadeira"));
                curso.setvideoaula(rs.getByte("videoaulas"));
                
                listaDeCurso.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeCurso;
    }

    public Curso getCursoByCodigo(int codigo) {
        Curso curso = new Curso();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from curso where codigo=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                curso.setcodigo(rs.getInt("codigo"));
               curso.setnome(rs.getString("nome"));
                curso.setarea(rs.getString("area"));
                curso.setduracao(rs.getDate("duracao"));
                curso.setcadeira(rs.getString("cadeira"));
                curso.setvideoaula(rs.getByte("videoaula"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return curso;
    }

    public void deleteCurso(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Curso getCursoBycodigo(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addCurso(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

