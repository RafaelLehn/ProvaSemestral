package rafaellehnbatista.com.br.provasemestral;

import com.google.gson.annotations.SerializedName;

/**
 * Created by logonrm on 10/11/2017.
 */

public class StarWars {
    @SerializedName(value = "name")
    private String nome;
    @SerializedName(value = "hair_color")
    private String cabelo;
    @SerializedName(value = "skin_color")
    private String pele;
    @SerializedName(value = "gender")
    private String foto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCabelo() {
        return cabelo;
    }

    public void setCabelo(String cabelo){
        this.cabelo = cabelo;
    }

    public String getPele() {
        return pele;
    }

    public void setPele(String pele){
        this.pele = pele;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto){
        this.foto = foto;
    }

}

