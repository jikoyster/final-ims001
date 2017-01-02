package warehouse.stocks;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import transactions.invoices.InvoiceItems;
import warehouse.Warehouse;
import warehouse.category.Category;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-03T01:37:57")
@StaticMetamodel(Stocks.class)
public class Stocks_ { 

    public static volatile SingularAttribute<Stocks, String> code;
    public static volatile SingularAttribute<Stocks, Double> cost;
    public static volatile SingularAttribute<Stocks, Integer> amountPerUnit;
    public static volatile SingularAttribute<Stocks, Double> netPrice;
    public static volatile SingularAttribute<Stocks, Integer> less;
    public static volatile SingularAttribute<Stocks, Warehouse> warehouse;
    public static volatile SingularAttribute<Stocks, Date> dateadded;
    public static volatile SingularAttribute<Stocks, Integer> criticalLevel;
    public static volatile SingularAttribute<Stocks, String> unit;
    public static volatile SingularAttribute<Stocks, Integer> balance;
    public static volatile SingularAttribute<Stocks, Integer> wholesaleMarkupPercentage;
    public static volatile SingularAttribute<Stocks, Integer> retailMarkupPercentage;
    public static volatile SingularAttribute<Stocks, String> name;
    public static volatile CollectionAttribute<Stocks, InvoiceItems> invoiceItemsCollection;
    public static volatile SingularAttribute<Stocks, Category> category;
    public static volatile SingularAttribute<Stocks, Double> wholesalePrice;
    public static volatile SingularAttribute<Stocks, Double> retailPrice;

}