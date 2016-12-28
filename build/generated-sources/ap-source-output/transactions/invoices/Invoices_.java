package transactions.invoices;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import transactions.invoices.InvoiceItems;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-29T02:31:12")
@StaticMetamodel(Invoices.class)
public class Invoices_ { 

    public static volatile SingularAttribute<Invoices, Double> totalAmount;
    public static volatile SingularAttribute<Invoices, Date> dateaddded;
    public static volatile CollectionAttribute<Invoices, InvoiceItems> invoiceItemsCollection;
    public static volatile SingularAttribute<Invoices, String> id;
    public static volatile SingularAttribute<Invoices, String> items;

}