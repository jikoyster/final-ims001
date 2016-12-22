/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.priceCode;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jake-LAPTOP
 */
@Entity
@Table(name = "PRICE_CODE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PriceCode.findAll", query = "SELECT p FROM PriceCode p"),
    @NamedQuery(name = "PriceCode.findByCode", query = "SELECT p FROM PriceCode p WHERE p.code = :code"),
    @NamedQuery(name = "PriceCode.findByActualPrice", query = "SELECT p FROM PriceCode p WHERE p.actualPrice = :actualPrice")})
public class PriceCode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE")
    private String code;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ACTUAL_PRICE")
    private Double actualPrice;

    public PriceCode() {
    }

    public PriceCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Double actualPrice) {
        this.actualPrice = actualPrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PriceCode)) {
            return false;
        }
        PriceCode other = (PriceCode) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "priceCode.PriceCode[ code=" + code + " ]";
    }
    
}
