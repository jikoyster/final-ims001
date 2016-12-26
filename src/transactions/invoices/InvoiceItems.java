/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transactions.invoices;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import warehouse.stocks.Stocks;

/**
 *
 * @author Jake-LAPTOP
 */
@Entity
@Table(name = "INVOICE_ITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceItems.findAll", query = "SELECT i FROM InvoiceItems i"),
    @NamedQuery(name = "InvoiceItems.findByItemid", query = "SELECT i FROM InvoiceItems i WHERE i.itemid = :itemid"),
    @NamedQuery(name = "InvoiceItems.findByQuantity", query = "SELECT i FROM InvoiceItems i WHERE i.quantity = :quantity"),
    @NamedQuery(name = "InvoiceItems.findBySubtotal", query = "SELECT i FROM InvoiceItems i WHERE i.subtotal = :subtotal")})
public class InvoiceItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ITEMID")
    private Integer itemid;
    @Column(name = "QUANTITY")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SUBTOTAL")
    private Double subtotal;
    @JoinColumn(name = "INVOICE", referencedColumnName = "ID")
    @ManyToOne
    private Invoices invoice;
    @JoinColumn(name = "CODE", referencedColumnName = "CODE")
    @ManyToOne
    private Stocks code;

    public InvoiceItems() {
    }

    public InvoiceItems(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Invoices getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoices invoice) {
        this.invoice = invoice;
    }

    public Stocks getCode() {
        return code;
    }

    public void setCode(Stocks code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemid != null ? itemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceItems)) {
            return false;
        }
        InvoiceItems other = (InvoiceItems) object;
        if ((this.itemid == null && other.itemid != null) || (this.itemid != null && !this.itemid.equals(other.itemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "transactions.invoices.InvoiceItems[ itemid=" + itemid + " ]";
    }
    
}
