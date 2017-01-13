package transactions.orders;

import accounts.suppliers.Suppliers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-14T02:09:52")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Double> totalAmount;
    public static volatile SingularAttribute<Orders, Date> dateaddded;
    public static volatile SingularAttribute<Orders, String> id;
    public static volatile SingularAttribute<Orders, String> status;
    public static volatile SingularAttribute<Orders, Suppliers> customer;

}