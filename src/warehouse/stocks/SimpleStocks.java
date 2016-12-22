/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.stocks;

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
import warehouse.category.Category;
import static warehouse.stocks.Stocks_.category;

/**
 *
 * @author Jake-LAPTOP
 */
@Entity
@Table(name = "SIMPLE_STOCKS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SimpleStocks.findAll", query = "SELECT s FROM SimpleStocks s"),
    @NamedQuery(name = "SimpleStocks.findByCode", query = "SELECT s FROM SimpleStocks s WHERE s.code = :code"),
    @NamedQuery(name = "SimpleStocks.findByName", query = "SELECT s FROM SimpleStocks s WHERE s.name = :name"),
    @NamedQuery(name = "SimpleStocks.findByUnit", query = "SELECT s FROM SimpleStocks s WHERE s.unit = :unit"),
    @NamedQuery(name = "SimpleStocks.findByAmountPerUnit", query = "SELECT s FROM SimpleStocks s WHERE s.amountPerUnit = :amountPerUnit"),
    @NamedQuery(name = "SimpleStocks.findByStockOnHand", query = "SELECT s FROM SimpleStocks s WHERE s.stockOnHand = :stockOnHand"),
    @NamedQuery(name = "SimpleStocks.findByCriticalLevel", query = "SELECT s FROM SimpleStocks s WHERE s.criticalLevel = :criticalLevel"),
    @NamedQuery(name = "SimpleStocks.findByDateadded", query = "SELECT s FROM SimpleStocks s WHERE s.dateadded = :dateadded")})
public class SimpleStocks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE")
    private String code;
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "CATEGORY")
    private Category category;
    
    @Column(name = "UNIT")
    private String unit;
    @Column(name = "AMOUNT_PER_UNIT")
    private Integer amountPerUnit;
    @Column(name = "STOCK_ON_HAND")
    private Integer stockOnHand;
    @Column(name = "CRITICAL_LEVEL")
    private Integer criticalLevel;
    @Basic(optional = false)
    @Column(name = "DATEADDED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateadded;

    public SimpleStocks() {
    }

    public SimpleStocks(String code) {
        this.code = code;
    }

    public SimpleStocks(String code, Date dateadded) {
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
    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Integer getStockOnHand() {
        return stockOnHand;
    }

    public void setStockOnHand(Integer stockOnHand) {
        this.stockOnHand = stockOnHand;
    }

    public Integer getCriticalLevel() {
        return criticalLevel;
    }

    public void setCriticalLevel(Integer criticalLevel) {
        this.criticalLevel = criticalLevel;
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
        if (!(object instanceof SimpleStocks)) {
            return false;
        }
        SimpleStocks other = (SimpleStocks) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "warehouse.stocks.SimpleStocks[ code=" + code + " ]";
    }
    
}
