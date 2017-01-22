package transactions.orders;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import transactions.invoices.Invoices;
import warehouse.stocks.Stocks;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-23T01:56:30")
@StaticMetamodel(OrderItems.class)
public class OrderItems_ { 

    public static volatile SingularAttribute<OrderItems, Integer> itemid;
    public static volatile SingularAttribute<OrderItems, Integer> quantity;
    public static volatile SingularAttribute<OrderItems, Stocks> code;
    public static volatile SingularAttribute<OrderItems, Double> subtotal;
    public static volatile SingularAttribute<OrderItems, Invoices> invoice;

}