package transactions.invoices;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import transactions.invoices.Invoices;
import warehouse.stocks.Stocks;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-03T01:37:57")
@StaticMetamodel(InvoiceItems.class)
public class InvoiceItems_ { 

    public static volatile SingularAttribute<InvoiceItems, Integer> itemid;
    public static volatile SingularAttribute<InvoiceItems, Integer> quantity;
    public static volatile SingularAttribute<InvoiceItems, Stocks> code;
    public static volatile SingularAttribute<InvoiceItems, Double> subtotal;
    public static volatile SingularAttribute<InvoiceItems, Invoices> invoice;

}