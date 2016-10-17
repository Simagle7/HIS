package com.gdpu.his.service;


import com.gdpu.common.domain.BaseDomain;
import com.gdpu.common.service.impl.AbstractPageService;
import com.gdpu.his.dao.IHISBaseDAO;

/**
 * Created by 郭旭辉 on 2016/3/13.
 */

public abstract class AbstractHISPageService<D extends IHISBaseDAO,T extends BaseDomain> extends AbstractPageService<D, T> {

}
