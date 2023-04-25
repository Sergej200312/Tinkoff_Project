package domains.DAO;

import domains.LinkSubscription;

import java.util.List;

public interface LinkSubscriptionDAO {
    LinkSubscription add(LinkSubscription linkSubscription);

    void remove(long id);

    List<LinkSubscription> findAll();
}
