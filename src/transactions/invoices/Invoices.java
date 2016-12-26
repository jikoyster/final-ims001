/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transactions.invoices;

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

/**
 *
 * @author Jake-LAPTOP
 */
@Entity
@Table(name = "INVOICES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoices.findAll", query = "SELECT i FROM Invoices i"),
    @NamedQuery(name = "Invoices.findById", query = "SELECT i FROM Invoices i WHERE i.id = :id"),
    @NamedQuery(name = "Invoices.findByItems", query = "SELECT i FROM Invoices i WHERE i.items = :items"),
    @NamedQuery(name = "Invoices.findByTotalAmount", query = "SELECT i FROM Invoices i WHERE i.totalAmount = :totalAmount"),
    @NamedQuery(name = "Invoices.findByDateaddded", query = "SELECT i FROM Invoices i WHERE i.dateaddded = :dateaddded")})
public class Invoices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "ITEMS")
    private String items;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL_AMOUNT")
    private Double totalAmount;
    @Column(name = "DATEADDDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateaddded;
    @OneToMany(mappedBy = "invoice")
    private Collection<InvoiceItems> invoiceItemsCollection;

    public Invoices() {
    }

    public Invoices(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getDateaddded() {
        return dateaddded;
    }

    public void setDateaddded(Date dateaddded) {
        this.dateaddded = dateaddded;
    }

    @XmlTransient
    public Collection<InvoiceItems> getInvoiceItemsCollection() {
        return invoiceItemsCollection;
    }

    public void setInvoiceItemsCollection(Collection<InvoiceItems> invoiceItemsCollection) {
        this.invoiceItemsCollection = invoiceItemsCollection;
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
        if (!(object instanceof Invoices)) {
            return false;
        }
        Invoices other = (Invoices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "transactions.invoices.Invoices[ id=" + id + " ]";
    }
    
}
