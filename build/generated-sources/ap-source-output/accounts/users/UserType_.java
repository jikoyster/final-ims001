package accounts.users;

import accounts.users.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-27T02:07:27")
@StaticMetamodel(UserType.class)
public class UserType_ { 

    public static volatile SingularAttribute<UserType, String> typestring;
    public static volatile SingularAttribute<UserType, Integer> typeid;
    public static volatile CollectionAttribute<UserType, Users> usersCollection;

}