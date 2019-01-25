package cn.com.startai.socket.db.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import cn.com.startai.socket.mutual.js.bean.CountAverageElectricity;
import cn.com.startai.socket.mutual.js.bean.CountElectricity;
import cn.com.startai.socket.mutual.js.bean.DisplayBleDevice;
import cn.com.startai.socket.mutual.js.bean.JsUserInfo;
import cn.com.startai.socket.mutual.js.bean.JsWeatherInfo;
import cn.com.startai.socket.mutual.js.bean.WiFiDevice.LanDeviceInfo;
import cn.com.startai.socket.sign.hardware.WiFi.bean.UserInfo;
import cn.com.startai.socket.sign.hardware.WiFi.bean.WanBindingDevice;
import cn.com.startai.socket.sign.scm.bean.PowerCountdown;

import cn.com.startai.socket.db.gen.CountAverageElectricityDao;
import cn.com.startai.socket.db.gen.CountElectricityDao;
import cn.com.startai.socket.db.gen.DisplayBleDeviceDao;
import cn.com.startai.socket.db.gen.JsUserInfoDao;
import cn.com.startai.socket.db.gen.JsWeatherInfoDao;
import cn.com.startai.socket.db.gen.LanDeviceInfoDao;
import cn.com.startai.socket.db.gen.UserInfoDao;
import cn.com.startai.socket.db.gen.WanBindingDeviceDao;
import cn.com.startai.socket.db.gen.PowerCountdownDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig countAverageElectricityDaoConfig;
    private final DaoConfig countElectricityDaoConfig;
    private final DaoConfig displayBleDeviceDaoConfig;
    private final DaoConfig jsUserInfoDaoConfig;
    private final DaoConfig jsWeatherInfoDaoConfig;
    private final DaoConfig lanDeviceInfoDaoConfig;
    private final DaoConfig userInfoDaoConfig;
    private final DaoConfig wanBindingDeviceDaoConfig;
    private final DaoConfig powerCountdownDaoConfig;

    private final CountAverageElectricityDao countAverageElectricityDao;
    private final CountElectricityDao countElectricityDao;
    private final DisplayBleDeviceDao displayBleDeviceDao;
    private final JsUserInfoDao jsUserInfoDao;
    private final JsWeatherInfoDao jsWeatherInfoDao;
    private final LanDeviceInfoDao lanDeviceInfoDao;
    private final UserInfoDao userInfoDao;
    private final WanBindingDeviceDao wanBindingDeviceDao;
    private final PowerCountdownDao powerCountdownDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        countAverageElectricityDaoConfig = daoConfigMap.get(CountAverageElectricityDao.class).clone();
        countAverageElectricityDaoConfig.initIdentityScope(type);

        countElectricityDaoConfig = daoConfigMap.get(CountElectricityDao.class).clone();
        countElectricityDaoConfig.initIdentityScope(type);

        displayBleDeviceDaoConfig = daoConfigMap.get(DisplayBleDeviceDao.class).clone();
        displayBleDeviceDaoConfig.initIdentityScope(type);

        jsUserInfoDaoConfig = daoConfigMap.get(JsUserInfoDao.class).clone();
        jsUserInfoDaoConfig.initIdentityScope(type);

        jsWeatherInfoDaoConfig = daoConfigMap.get(JsWeatherInfoDao.class).clone();
        jsWeatherInfoDaoConfig.initIdentityScope(type);

        lanDeviceInfoDaoConfig = daoConfigMap.get(LanDeviceInfoDao.class).clone();
        lanDeviceInfoDaoConfig.initIdentityScope(type);

        userInfoDaoConfig = daoConfigMap.get(UserInfoDao.class).clone();
        userInfoDaoConfig.initIdentityScope(type);

        wanBindingDeviceDaoConfig = daoConfigMap.get(WanBindingDeviceDao.class).clone();
        wanBindingDeviceDaoConfig.initIdentityScope(type);

        powerCountdownDaoConfig = daoConfigMap.get(PowerCountdownDao.class).clone();
        powerCountdownDaoConfig.initIdentityScope(type);

        countAverageElectricityDao = new CountAverageElectricityDao(countAverageElectricityDaoConfig, this);
        countElectricityDao = new CountElectricityDao(countElectricityDaoConfig, this);
        displayBleDeviceDao = new DisplayBleDeviceDao(displayBleDeviceDaoConfig, this);
        jsUserInfoDao = new JsUserInfoDao(jsUserInfoDaoConfig, this);
        jsWeatherInfoDao = new JsWeatherInfoDao(jsWeatherInfoDaoConfig, this);
        lanDeviceInfoDao = new LanDeviceInfoDao(lanDeviceInfoDaoConfig, this);
        userInfoDao = new UserInfoDao(userInfoDaoConfig, this);
        wanBindingDeviceDao = new WanBindingDeviceDao(wanBindingDeviceDaoConfig, this);
        powerCountdownDao = new PowerCountdownDao(powerCountdownDaoConfig, this);

        registerDao(CountAverageElectricity.class, countAverageElectricityDao);
        registerDao(CountElectricity.class, countElectricityDao);
        registerDao(DisplayBleDevice.class, displayBleDeviceDao);
        registerDao(JsUserInfo.class, jsUserInfoDao);
        registerDao(JsWeatherInfo.class, jsWeatherInfoDao);
        registerDao(LanDeviceInfo.class, lanDeviceInfoDao);
        registerDao(UserInfo.class, userInfoDao);
        registerDao(WanBindingDevice.class, wanBindingDeviceDao);
        registerDao(PowerCountdown.class, powerCountdownDao);
    }
    
    public void clear() {
        countAverageElectricityDaoConfig.clearIdentityScope();
        countElectricityDaoConfig.clearIdentityScope();
        displayBleDeviceDaoConfig.clearIdentityScope();
        jsUserInfoDaoConfig.clearIdentityScope();
        jsWeatherInfoDaoConfig.clearIdentityScope();
        lanDeviceInfoDaoConfig.clearIdentityScope();
        userInfoDaoConfig.clearIdentityScope();
        wanBindingDeviceDaoConfig.clearIdentityScope();
        powerCountdownDaoConfig.clearIdentityScope();
    }

    public CountAverageElectricityDao getCountAverageElectricityDao() {
        return countAverageElectricityDao;
    }

    public CountElectricityDao getCountElectricityDao() {
        return countElectricityDao;
    }

    public DisplayBleDeviceDao getDisplayBleDeviceDao() {
        return displayBleDeviceDao;
    }

    public JsUserInfoDao getJsUserInfoDao() {
        return jsUserInfoDao;
    }

    public JsWeatherInfoDao getJsWeatherInfoDao() {
        return jsWeatherInfoDao;
    }

    public LanDeviceInfoDao getLanDeviceInfoDao() {
        return lanDeviceInfoDao;
    }

    public UserInfoDao getUserInfoDao() {
        return userInfoDao;
    }

    public WanBindingDeviceDao getWanBindingDeviceDao() {
        return wanBindingDeviceDao;
    }

    public PowerCountdownDao getPowerCountdownDao() {
        return powerCountdownDao;
    }

}
