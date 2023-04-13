/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author hoshi
 */
@Entity
@Table(name = "placas")
@DiscriminatorValue("placa")
@PrimaryKeyJoinColumn(name="id_tramite")
public class Placa extends Tramite implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_placa")
    private Integer id;
    
    @Basic
    private Date fechaExpedicion;
    private Date fechaVencimiento;
    private String numPlacaNu;
    private String estado;
    //private double costo;

    public Placa() {
    }

    public Placa(Integer id, Date fechaExpedicion, Date fechaVencimiento, String numPlacaNu, String estado) {
        this.id = id;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.numPlacaNu = numPlacaNu;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placa)) {
            return false;
        }
        Placa other = (Placa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Placa[ id=" + id + " ]";
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNumPlacaNu() {
        return numPlacaNu;
    }

    public void setNumPlacaNu(String numPlacaNu) {
        this.numPlacaNu = numPlacaNu;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

//    public double getCosto() {
//        return costo;
//    }
//
//    public void setCosto(double costo) {
//        this.costo = costo;
//    }
    
}
