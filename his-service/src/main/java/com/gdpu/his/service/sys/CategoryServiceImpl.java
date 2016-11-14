/*
{*****************************************************************************
{  设备管理 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：分类标签，用户职务标签，专业标签如科室标签，医生专业标签等											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-11-10  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package com.gdpu.his.service.sys;

import com.gdpu.common.domain.AccountDto;
import com.gdpu.common.exception.BizException;
import com.gdpu.common.utils.DataStatusEnum;
import com.gdpu.common.utils.ERRORCODE;
import com.gdpu.common.utils.PageUtils;
import com.gdpu.common.utils.RETURNCODE;
import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.dao.sys.ICategoryDAO;
import com.gdpu.his.domain.sys.Category;
import com.gdpu.his.param.sys.CategoryParam;
import com.gdpu.his.service.AbstractHISPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

;

/**
 * 《分类标签，用户职务标签，专业标签如科室标签，医生专业标签等》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("CategoryServiceImpl")
public class CategoryServiceImpl extends AbstractHISPageService<IHISBaseDAO<Category>, Category> implements ICategoryService<IHISBaseDAO<Category>,Category>{
    @Autowired
    private ICategoryDAO categoryDAO;

    @Override
    public IHISBaseDAO<Category> getDao() {
        return categoryDAO;
    }


     @Override
     public ModelAndView queryPage(CategoryParam param, int pageNo, int pageSize) {

         List<Category> data = categoryDAO.queryPageEx(param.toMap(), (pageNo - 1) * pageSize, pageSize);
         int records = categoryDAO.countEx(param.toMap());
         ModelAndView mav = new ModelAndView();
         mav.setViewName("category/list");
         mav.addObject("data", PageUtils.toBizData4Page(data, pageNo, pageSize, records));
         return mav;
     }

     @Override
     public String addCategory(CategoryParam param, AccountDto currentUser) {
         if(this.findOne(CategoryParam.F_Name, param.getName()) != null){
             throw new BizException(ERRORCODE.CATEGORY_NAME_EXISTS.getCode(), ERRORCODE.CATEGORY_NAME_EXISTS.getMessage());
         }
         param.setCreator(currentUser.getUid());
         param.setCreateDate(System.currentTimeMillis());
         param.setStatus(DataStatusEnum.ENABLED.getValue());
         if (this.insertMap(param.toMap()) > 0){
             return RETURNCODE.ADD_COMPLETE.getMessage();
         }
         throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
     }

    @Override
    public ModelAndView update(Long id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("category/update");
        mav.addObject("item", findOne(CategoryParam.F_ID, id));
        return mav;
    }

    @Override
    public String updateCategory(CategoryParam param, AccountDto currentUser) {
        Category category = this.findOne(CategoryParam.F_Name, param.getName());
        if( category != null && !category.getId().equals(param.getId())){
            throw new BizException(ERRORCODE.CATEGORY_NAME_EXISTS.getCode(), ERRORCODE.CATEGORY_NAME_EXISTS.getMessage());
        }
        param.setLastModDate(System.currentTimeMillis());
        param.setLastModifier(currentUser.getUid());
        if(this.updateMap(param.toMap()) > 0){
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String disabledOrEnabled(CategoryParam param, AccountDto currentUser) {
        param.setLastModDate(System.currentTimeMillis());
        param.setLastModifier(currentUser.getUid());
        if(this.updateMap(param.toMap()) > 0){
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }
}