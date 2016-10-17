package com.gdpu.his.service;


import com.gdpu.common.domain.BaseDomain;
import com.gdpu.common.service.IBaseService;
import com.gdpu.common.service.IPageService;
import com.gdpu.his.dao.IHISBaseDAO;

/**
 * Created by 郭旭辉 on 2016/3/13.
 */
public interface IHISBaseService<D extends IHISBaseDAO<T>, T extends BaseDomain> extends IBaseService<D, T>, IPageService<D, T> {
}
