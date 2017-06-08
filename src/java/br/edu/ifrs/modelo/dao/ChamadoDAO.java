
package br.edu.ifrs.modelo.dao;


import br.edu.ifrs.modelo.bean.Chamado;
import br.edu.ifrs.modelo.bean.Recepcionista;
import br.edu.ifrs.modelo.bean.Servidor;
import br.edu.ifrs.modelo.bean.Usuario;
import br.edu.ifrs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ChamadoDAO {
        public static void adicionar(Chamado c) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            try {
                /* Conectar no banco de dados */
                con = Conexao.abrirConexao();
                
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   
                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("insert into chamados (nome_solicitante, perfil_solicitante, email_contato, telefone_contato, descricao_solicitacao, situacao, data_abertura, anexos) values (?, ?, ?, ?, ?, ?, ?, ?)");
                pstmt.setString(1, c.getNomeSolicitante());
                pstmt.setString(2, c.getPerfilSolicitante());
                pstmt.setString(3, c.getEmailSolicitante());
                pstmt.setString(4, c.getTelefoneSolicitante());
                pstmt.setString(5, c.getDescricaoSolicitacao());
                pstmt.setString(6, c.getSituacao());
                pstmt.setString(7, dateFormat.format(c.getDataAbertura().getTime()));
                pstmt.setString(8, c.getAnexo().toString());
         
   
                /* Executar a sentença no banco de dados */
                pstmt.execute();
            } catch (Exception e) {
                throw new Exception("Falha ao inserir o chamado no Banco de Dados.<br><!--" + e.getMessage() + "-->");
            } finally {
                pstmt.close();
                con.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
//    public static void atualizar(Chamado c) throws Exception {
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        
//        try {
//            try {
//                /* Conectar no banco de dados */
//                con = Conexao.abrirConexao();
//                
//                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//                /* Preprar a sentença SQL */
//
//                pstmt = con.prepareStatement("update chamados set nome_solicitante = ?, perfil_solicitante = ?, email_contato = ?, telefone_contato = ?, descricao_solicitacao = ?, situacao = ?, data_abertura = ?, anexos = ?, cpf_recepcionista = ?, cpf_servidor = ? where id = ?");
//                
//                pstmt.setString(1, c.getNomeSolicitante());
//                pstmt.setString(2, c.getPerfilSolicitante());
//                pstmt.setString(3, c.getEmailSolicitante());
//                pstmt.setString(4, c.getTelefoneSolicitante());
//                pstmt.setString(5, c.getDescricaoSolicitacao());
//                pstmt.setString(6, c.getEmailSolicitante());
//                pstmt.setString(7, c.getSituacao());
//                pstmt.setString(8, dateFormat.format(c.getDataAbertura().getTime()));
//                pstmt.setString(9, c.getAnexo().toString());
//                pstmt.setString(10, c.getRecepcionista().getUsuario().getCpf());
//                pstmt.setString(11, c.getServidor().getUsuario().getCpf());
//                pstmt.setInt(12, c.getId());
//                
//                /* Executar a sentença no banco de dados */
//                pstmt.execute();
//            } catch (Exception e) {
//                throw new Exception("Falha ao atualizar o chamado no Banco de Dados.<br><!--" + e.getMessage() + "-->");
//            } finally {
//                pstmt.close();
//                con.close();
//            }
//        } catch (Exception ex) {
//            throw ex;
//        }
//    }
//    
//    public static Chamado[] pesquisar (Chamado ch) throws Exception {
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        List<Chamado> lista = new ArrayList();
//        
//        try {
//            try {
//                con = Conexao.abrirConexao();
//                
//
//                /* Preprar a sentença SQL */
//                pstmt = con.prepareStatement("select * from chamados where nome like ?");
//                pstmt.setString(1, (ch.getNomeSolicitante() == null ? "%":"%"+ch.getNomeSolicitante()+"%"));
//                pstmt.setString(2, (ch.getDataAbertura() == null ? "%":"%"+ch.getDataAbertura()+"%"));
//                pstmt.setString(3, (ch.getSituacao() == null ? "%":"%"+ch.getSituacao()+"%"));
//                pstmt.setString(4, (ch.getServidor().getUsuario().getCpf() == null ? "%":"%"+ch.getServidor().getUsuario().getCpf()+"%"));
//               
//                
//                
//                /* Executar a sentença no banco de dados */
//                rs = pstmt.executeQuery();
//                while (rs.next() == true) {
//                    //username, senha, situacao, observacoes, id_perfil
//                    Chamado c = new Chamado();
//                    
//                    c.setNomeSolicitante(rs.getString("nome_solicitante"));
//                    c.setPerfilSolicitante(rs.getString("perfil_solicitante"));
//                    c.setEmailSolicitante(rs.getString("email_contato"));
//                    c.setTelefoneSolicitante(rs.getString("telefone_contato"));
//                    c.setDescricaoSolicitacao(rs.getString("descricao_solicitacao"));
//                    c.setSituacao(rs.getString("situacao"));
//    //                c.setDataAbertura(rs.getString("data_abertura"));
//                    c.setAnexo(rs.getString("anexos"));
//                    c.setId(rs.getInt("id"));
//                    
//                    Usuario u = new Usuario();
//                    Recepcionista r = new Recepcionista();
//                    u.setCpf(rs.getString("cpf_recepcionista"));
//                    r.setUsuario(u);                    
//                    c.setRecepcionista(r);
//                    
//                    Usuario us = new Usuario();
//                    Servidor s = new Servidor();
//                    us.setCpf(rs.getString("cpf_servidor"));
//                    s.setUsuario(us);                    
//                    c.setServidor(s);
//                    
//                    lista.add(c);                    
//                }
//                
//
//                
//                
//            } catch (Exception e) {
//                throw new Exception("Falha ao consultar o chamado no Banco de Dados.<br><!--" + e.getMessage() + "-->");
//            } finally {
//                pstmt.close();
//                con.close();
//            }
//        } catch (Exception ex) {
//            throw ex;
//        }
//        
//        return lista.toArray(new Chamado[0]);
//    }
//    
//    public static Chamado consultar (int id) throws Exception {
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        Chamado c = new Chamado();
//        
//        try {
//            try {
//                con = Conexao.abrirConexao();
//                
//                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//
//                /* Preprar a sentença SQL */
//                pstmt = con.prepareStatement("select * from chamados where id = ?");
//                pstmt.setInt(1, id);
//                
//                /* Executar a sentença no banco de dados */
//                rs = pstmt.executeQuery();
//                if (rs.next() == true) {
//                    
//                    
//                    c.setNomeSolicitante(rs.getString("nome_solicitante"));
//                    c.setPerfilSolicitante(rs.getString("perfil_solicitante"));
//                    c.setEmailSolicitante(rs.getString("email_contato"));
//                    c.setTelefoneSolicitante(rs.getString("telefone_contato"));
//                    c.setDescricaoSolicitacao(rs.getString("descricao_solicitacao"));
//                    c.setSituacao(rs.getString("situacao"));
//    //                c.setDataAbertura(rs.getString("data_abertura"));
//                    c.setAnexo(rs.getString("anexos"));
//                    c.setId(rs.getInt("id"));
//                    
//                    Usuario u = new Usuario();
//                    Recepcionista r = new Recepcionista();
//                    u.setCpf(rs.getString("cpf_recepcionista"));
//                    r.setUsuario(u);                    
//                    c.setRecepcionista(r);
//                    
//                    Usuario us = new Usuario();
//                    Servidor s = new Servidor();
//                    us.setCpf(rs.getString("cpf_servidor"));
//                    s.setUsuario(us);                    
//                    c.setServidor(s);
//            
//                    
//                }
//            } catch (Exception e) {
//                throw new Exception("Falha ao pesquisar o chamado no Banco de Dados.<br><!--" + e.getMessage() + "-->");
//            } finally {
//                pstmt.close();
//                con.close();
//            }
//        } catch (Exception ex) {
//            throw ex;
//        }
//        
//        return c;
//    }
//    
//    public static void deletar(Chamado c) throws Exception {
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        
//        try {
//            try {
//                /* Conectar no banco de dados */
//                con = Conexao.abrirConexao();
//
//                /* Preprar a sentença SQL */
//                pstmt = con.prepareStatement("delete from chamados where cpf = ?");
//                pstmt.setString(1, c.getCpf());
//                
//                /* Executar a sentença no banco de dados */
//                pstmt.execute();
//            } catch (Exception e) {
//                throw new Exception("Falha ao deletar o chamado no Banco de Dados.<br><!--" + e.getMessage() + "-->");
//            } finally {
//                pstmt.close();
//                con.close();
//            }
//        } catch (Exception ex) {
//            throw ex;
//        }
//    }
}
