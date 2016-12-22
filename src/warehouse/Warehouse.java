/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import warehouse.stocks.Stocks;

/**
 *
 * @author Jake-LAPTOP
 */
@Entity
@Table(name = "WAREHOUSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warehouse.findAll", query = "SELECT w FROM Warehouse w"),
    @NamedQuery(name = "Warehouse.findByCode", query = "SELECT w FROM Warehouse w WHERE w.code = :code"),
    @NamedQuery(name = "Warehouse.findByName", query = "SELECT w FROM Warehouse w WHERE w.name = :name"),
    @NamedQuery(name = "Warehouse.findByAddress", query = "SELECT w FROM Warehouse w WHERE w.address = :address"),
    @NamedQuery(name = "Warehouse.findByPhone", query = "SELECT w FROM Warehouse w WHERE w.phone = :phone"),
    @NamedQuery(name = "Warehouse.findByFax", query = "SELECT w FROM Warehouse w WHERE w.fax = :fax"),
    @NamedQuery(name = "Warehouse.findByEmail", query = "SELECT w FROM Warehouse w WHERE w.email = :email"),
    @NamedQuery(name = "Warehouse.findByDateadded", query = "SELECT w FROM Warehouse w WHERE w.dateadded = :dateadded")})
public class Warehouse implements Serializable {

    @OneToMany(mappedBy = "warehouse")
    private Collection<Stocks> stocksCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE")
    private String code;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;

    public Warehouse() {
    }

    public Warehouse(String code) {
        this.code = code;
    }

    public Warehouse(String code, Date dateadded) {
        this.code = code;
        this.dateadded = dateadded;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
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
        if (!(object instanceof Warehouse)) {
            return false;
        }
        Warehouse other = (Warehouse) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "warehouse.Warehouse[ code=" + code + " ]";
    }

    @XmlTransient
    public Collection<Stocks> getStocksCollection() {
        return stocksCollection;
    }

    public void setStocksCollection(Collection<Stocks> stocksCollection) {
        this.stocksCollection = stocksCollection;
    }
    
}
