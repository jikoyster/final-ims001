package warehouse;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import warehouse.stocks.Stocks;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-23T01:56:30")
@StaticMetamodel(Warehouse.class)
public class Warehouse_ { 

    public static volatile SingularAttribute<Warehouse, String> code;
    public static volatile SingularAttribute<Warehouse, String> address;
    public static volatile SingularAttribute<Warehouse, String> phone;
    public static volatile CollectionAttribute<Warehouse, Stocks> stocksCollection;
    public static volatile SingularAttribute<Warehouse, String> name;
    public static volatile SingularAttribute<Warehouse, String> fax;
    public static volatile SingularAttribute<Warehouse, Date> dateadded;
    public static volatile SingularAttribute<Warehouse, String> email;

}