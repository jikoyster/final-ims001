package accounts.customers;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-14T02:09:52")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SingularAttribute<Customers, String> code;
    public static volatile SingularAttribute<Customers, String> address;
    public static volatile SingularAttribute<Customers, Double> balance;
    public static volatile SingularAttribute<Customers, String> phone;
    public static volatile SingularAttribute<Customers, String> name;
    public static volatile SingularAttribute<Customers, String> fax;
    public static volatile SingularAttribute<Customers, Date> dateadded;
    public static volatile SingularAttribute<Customers, String> email;

}