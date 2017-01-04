package accounts.suppliers;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import transactions.orders.Orders;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-03T23:08:08")
@StaticMetamodel(Suppliers.class)
public class Suppliers_ { 

    public static volatile SingularAttribute<Suppliers, String> code;
    public static volatile SingularAttribute<Suppliers, String> address;
    public static volatile SingularAttribute<Suppliers, String> phone;
    public static volatile SingularAttribute<Suppliers, String> name;
    public static volatile CollectionAttribute<Suppliers, Orders> ordersCollection;
    public static volatile SingularAttribute<Suppliers, String> fax;
    public static volatile SingularAttribute<Suppliers, Date> dateadded;
    public static volatile SingularAttribute<Suppliers, String> email;

}