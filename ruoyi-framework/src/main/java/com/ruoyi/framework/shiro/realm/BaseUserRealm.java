package com.ruoyi.framework.shiro.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.realm.AuthorizingRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: com.ruoyi.framework.shiro.realm
 * @Description: ******
 * @author: andy-hao
 * @version: V1.0
 * @Date: 2020/7/17 10:38
 **/
public abstract class BaseUserRealm extends AuthorizingRealm {
    private static Logger logger = LoggerFactory.getLogger(BaseUserRealm.class);

    /**
     * 清理缓存权限
     */
    public abstract void clearCachedAuthorizationInfo();
//    {
////        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
//    }
}
