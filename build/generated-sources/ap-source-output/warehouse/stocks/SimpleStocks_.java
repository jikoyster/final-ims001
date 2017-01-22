package warehouse.stocks;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import warehouse.category.Category;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-23T01:56:30")
@StaticMetamodel(SimpleStocks.class)
public class SimpleStocks_ { 

    public static volatile SingularAttribute<SimpleStocks, String> unit;
    public static volatile SingularAttribute<SimpleStocks, String> code;
    public static volatile SingularAttribute<SimpleStocks, Integer> amountPerUnit;
    public static volatile SingularAttribute<SimpleStocks, String> name;
    public static volatile SingularAttribute<SimpleStocks, Integer> stockOnHand;
    public static volatile SingularAttribute<SimpleStocks, Category> category;
    public static volatile SingularAttribute<SimpleStocks, Integer> criticalLevel;
    public static volatile SingularAttribute<SimpleStocks, Date> dateadded;

}