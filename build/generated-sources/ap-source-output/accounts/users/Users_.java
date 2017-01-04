package accounts.users;

import accounts.users.UserType;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-03T23:08:08")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> log;
    public static volatile SingularAttribute<Users, UserType> typeid;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, Date> dateadded;
    public static volatile SingularAttribute<Users, String> username;

}