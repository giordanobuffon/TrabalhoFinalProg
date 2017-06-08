/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo.bean;

import java.util.Calendar;


public class Chamado {

    private int id;
    private String nomeSolicitante;
    private String perfilSolicitante;
    private String emailSolicitante;
    private String telefoneSolicitante; 
    private String descricaoSolicitacao;
    private String situacao;
    private Calendar dataAbertura;
    private Object anexo;
    private Recepcionista recepcionista;
    private Servidor servidor;

    public Chamado() {
        this.id = 0;
        this.nomeSolicitante = "";
        this.perfilSolicitante = "";
        this.emailSolicitante = "";
        this.telefoneSolicitante = "";
        this.descricaoSolicitacao = "";
        this.situacao = "";
        this.dataAbertura = null;
        this.anexo = null;
        this.recepcionista = new Recepcionista();
        this.servidor = new Servidor();
    }
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }
    public void setNomeSolicitante(String nomeSolicitante) throws Exception {
        if (nomeSolicitante == null || nomeSolicitante.isEmpty())
            throw new Exception("O campo Nome do Solicitante é de preenchimento obrigatório.");
        
        this.nomeSolicitante = nomeSolicitante;
    }


    public String getPerfilSolicitante() {
        return perfilSolicitante;
    }
    public void setPerfilSolicitante(String perfilSolicitante) throws Exception {
        if (perfilSolicitante == null || perfilSolicitante.isEmpty())
            throw new Exception("O campo Perfil é de preenchimento obrigatório.");
        
        this.perfilSolicitante = perfilSolicitante;
    }


    public String getEmailSolicitante() {
        return emailSolicitante;
    }
    public void setEmailSolicitante(String emailSolicitante) throws Exception {
        if (emailSolicitante == null || emailSolicitante.isEmpty())
            throw new Exception("O campo Email é de preenchimento obrigatório.");
        
        this.emailSolicitante = emailSolicitante;
    }


    public String getTelefoneSolicitante() {
        return telefoneSolicitante;
    }
    public void setTelefoneSolicitante(String telefoneSolicitante) {
        this.telefoneSolicitante = telefoneSolicitante;
    }


    public String getDescricaoSolicitacao() {
        return descricaoSolicitacao;
    }
    public void setDescricaoSolicitacao(String descricaoSolicitacao) throws Exception {
        if (descricaoSolicitacao == null || descricaoSolicitacao.isEmpty())
            throw new Exception("O campo Descrição é de preenchimento obrigatório.");
        
        this.descricaoSolicitacao = descricaoSolicitacao;
    }


    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }


    public Object getAnexo() {
        return anexo;
    }
    public void setAnexo(Object anexo) {
        this.anexo = anexo;
    }

    
    public Recepcionista getRecepcionista() {
        return recepcionista;
    }
    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

  
    public Servidor getServidor() {
        return servidor;
    }
    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }


    public Calendar getDataAbertura() {
        return dataAbertura;
    }
    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }


    
    
    

    
    
}
