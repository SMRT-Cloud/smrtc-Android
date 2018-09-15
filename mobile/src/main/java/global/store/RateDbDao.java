package global.store;

import global.ConciergeRate;

/**
 * Created by akshaynexus on 3/3/18.
 */

public interface RateDbDao<T> extends AbstractDbDao<T>{

    ConciergeRate getRate(String coin);


    void insertOrUpdateIfExist(ConciergeRate conciergeRate);

}
