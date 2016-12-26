/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.stocks;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import transactions.invoices.InvoiceItems;
import warehouse.Warehouse;
import warehouse.category.Category;

/**
 *
 * @author Jake-LAPTOP
 */
@Entity
@Table(name = "STOCKS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stocks.findAll", query = "SELECT s FROM Stocks s"),
    @NamedQuery(name = "Stocks.findByCode", query = "SELECT s FROM Stocks s WHERE s.code = :code"),
    @NamedQuery(name = "Stocks.findByName", query = "SELECT s FROM Stocks s WHERE s.name = :name"),
    @NamedQuery(name = "Stocks.findByUnit", query = "SELECT s FROM Stocks s WHERE s.unit = :unit"),
    @NamedQuery(name = "Stocks.findByAmountPerUnit", query = "SELECT s FROM Stocks s WHERE s.amountPerUnit = :amountPerUnit"),
    @NamedQuery(name = "Stocks.findByCost", query = "SELECT s FROM Stocks s WHERE s.cost = :cost"),
    @NamedQuery(name = "Stocks.findByLess", query = "SELECT s FROM Stocks s WHERE s.less = :less"),
    @NamedQuery(name = "Stocks.findByNetPrice", query = "SELECT s FROM Stocks s WHERE s.netPrice = :netPrice"),
    @NamedQuery(name = "Stocks.findByWholesaleMarkupPercentage", query = "SELECT s FROM Stocks s WHERE s.wholesaleMarkupPercentage = :wholesaleMarkupPercentage"),
    @NamedQuery(name = "Stocks.findByWholesalePrice", query = "SELECT s FROM Stocks s WHERE s.wholesalePrice = :wholesalePrice"),
    @NamedQuery(name = "Stocks.findByRetailMarkupPercentage", query = "SELECT s FROM Stocks s WHERE s.retailMarkupPercentage = :retailMarkupPercentage"),
    @NamedQuery(name = "Stocks.findByRetailPrice", query = "SELECT s FROM Stocks s WHERE s.retailPrice = :retailPrice"),
    @NamedQuery(name = "Stocks.findByDateadded", query = "SELECT s FROM Stocks s WHERE s.dateadded = :dateadded"),
    @NamedQuery(name = "Stocks.findByCriticalLevel", query = "SELECT s FROM Stocks s WHERE s.criticalLevel = :criticalLevel"),
    @NamedQuery(name = "Stocks.findByBalance", query = "SELECT s FROM Stocks s WHERE s.balance = :balance")})
public class Stocks implements Serializable {

    @OneToMany(mappedBy = "code")
    private Collection<InvoiceItems> invoiceItemsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE")
    private String code;
    @Column(name = "NAME")
    private String name;
    @Column(name = "UNIT")
    private String unit;
    @Column(name = "AMOUNT_PER_UNIT")
    private Integer amountPerUnit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COST")
    private Double cost;
    @Column(name = "LESS")
    private Integer less;
    @Column(name = "NET_PRICE")
    private Double netPrice;
    @Column(name = "WHOLESALE_MARKUP_PERCENTAGE")
    private Integer wholesaleMarkupPercentage;
    @Column(name = "WHOLESALE_PRICE")
    private Double wholesalePrice;
    @Column(name = "RETAIL_MARKUP_PERCENTAGE")
    private Integer retailMarkupPercentage;
    @Column(name = "RETAIL_PRICE")
    private Double retailPrice;
    @Basic(optional = false)
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;
    @Basic(optional = false)
    @Column(name = "CRITICAL_LEVEL")
    private int criticalLevel;
    @Basic(optional = false)
    @Column(name = "BALANCE")
    private int balance;
    @JoinColumn(name = "CATEGORY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Category category;
    @JoinColumn(name = "WAREHOUSE", referencedColumnName = "CODE")
    @ManyToOne
    private Warehouse warehouse;

    public Stocks() {
    }

    public Stocks(String code) {
        this.code = code;
    }

    public Stocks(String code, Date dateadded, int criticalLevel, int balance) {
        this.code = code;
        this.dateadded = dateadded;
        this.criticalLevel = criticalLevel;
        this.balance = balance;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getAmountPerUnit() {
        return amountPerUnit;
    }

    public void setAmountPerUnit(Integer amountPerUnit) {
        this.amountPerUnit = amountPerUnit;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getLess() {
        return less;
    }

    public void setLess(Integer less) {
        this.less = less;
    }

    public Double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Double netPrice) {
        this.netPrice = netPrice;
    }

    public Integer getWholesaleMarkupPercentage() {
        return wholesaleMarkupPercentage;
    }

    public void setWholesaleMarkupPercentage(Integer wholesaleMarkupPercentage) {
        this.wholesaleMarkupPercentage = wholesaleMarkupPercentage;
    }

    public Double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(Double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public Integer getRetailMarkupPercentage() {
        return retailMarkupPercentage;
    }

    public void setRetailMarkupPercentage(Integer retailMarkupPercentage) {
        this.retailMarkupPercentage = retailMarkupPercentage;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Date getDateadded() {
        return dateadded;
    }

    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
    }

    public int getCriticalLevel() {
        return criticalLevel;
    }

    public void setCriticalLevel(int criticalLevel) {
        this.criticalLevel = criticalLevel;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
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
        if (!(object instanceof Stocks)) {
            return false;
        }
        Stocks other = (Stocks) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "warehouse.stocks.Stocks[ code=" + code + " ]";
    }

    @XmlTransient
    public Collection<InvoiceItems> getInvoiceItemsCollection() {
        return invoiceItemsCollection;
    }

    public void setInvoiceItemsCollection(Collection<InvoiceItems> invoiceItemsCollection) {
        this.invoiceItemsCollection = invoiceItemsCollection;
    }
    
}
