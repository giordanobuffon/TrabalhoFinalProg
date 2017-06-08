/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo.bean;


import java.util.Calendar;

public class Resposta {
    
    private int id;
    private int idChamado;
    private String descricaoResposta;
    private Calendar dataAbertura;
    private boolean rascunho; 
    private Object anexo;
    private Servidor servidor;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getIdChamado() {
        return idChamado;
    }
    public void setIdChamado(int idChamado) {
        this.idChamado = idChamado;
    }


    public String getDescricaoResposta() {
        return descricaoResposta;
    }
    public void setDescricaoResposta(String descricaoResposta) {
        this.descricaoResposta = descricaoResposta;
    }

 
    public boolean isRascunho() {
        return rascunho;
    }
    public void setRascunho(boolean rascunho) {
        this.rascunho = rascunho;
    }


    public Object getAnexo() {
        return anexo;
    }
    public void setAnexo(Object anexo) {
        this.anexo = anexo;
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
