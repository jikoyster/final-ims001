package warehouse.category;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import warehouse.stocks.Stocks;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-23T01:56:30")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile CollectionAttribute<Category, Stocks> stocksCollection;
    public static volatile SingularAttribute<Category, String> name;
    public static volatile SingularAttribute<Category, Integer> id;
    public static volatile SingularAttribute<Category, Date> dateadded;

}