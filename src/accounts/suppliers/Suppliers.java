/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.suppliers;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jake-LAPTOP
 */
@Entity
@Table(name = "SUPPLIERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suppliers.findAll", query = "SELECT s FROM Suppliers s"),
    @NamedQuery(name = "Suppliers.findByCode", query = "SELECT s FROM Suppliers s WHERE s.code = :code"),
    @NamedQuery(name = "Suppliers.findByName", query = "SELECT s FROM Suppliers s WHERE s.name = :name"),
    @NamedQuery(name = "Suppliers.findByAddress", query = "SELECT s FROM Suppliers s WHERE s.address = :address"),
    @NamedQuery(name = "Suppliers.findByPhone", query = "SELECT s FROM Suppliers s WHERE s.phone = :phone"),
    @NamedQuery(name = "Suppliers.findByEmail", query = "SELECT s FROM Suppliers s WHERE s.email = :email"),
    @NamedQuery(name = "Suppliers.findByFax", query = "SELECT s FROM Suppliers s WHERE s.fax = :fax"),
    @NamedQuery(name = "Suppliers.findByDateadded", query = "SELECT s FROM Suppliers s WHERE s.dateadded = :dateadded")})
public class Suppliers implements Serializable {

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
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FAX")
    private String fax;
    @Basic(optional = false)
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;

    public Suppliers() {
    }

    public Suppliers(String code) {
        this.code = code;
    }

    public Suppliers(String code, Date dateadded) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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
        if (!(object instanceof Suppliers)) {
            return false;
        }
        Suppliers other = (Suppliers) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "accounts.suppliers.Suppliers[ code=" + code + " ]";
    }
    
}
