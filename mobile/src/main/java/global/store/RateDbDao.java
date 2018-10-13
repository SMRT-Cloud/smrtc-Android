package global.store;

import global.SmartcloudRate;

/**
 * Created by Telostia on 3/3/18.
 */

public interface RateDbDao<T> extends AbstractDbDao<T>{

    SmartcloudRate getRate(String coin);


    void insertOrUpdateIfExist(SmartcloudRate smartcloudRate);

}
