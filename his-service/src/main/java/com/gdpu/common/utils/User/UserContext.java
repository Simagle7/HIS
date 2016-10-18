package com.gdpu.common.utils.User;


import com.gdpu.common.domain.AccountDto;
import com.gdpu.common.exception.BizException;
import com.gdpu.common.system.filter.HISRequestFilter;
import com.gdpu.common.utils.ERRORCODE;
import com.gdpu.his.domain.sys.Rescuer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 郭旭辉 on 2016/3/21.
 * 用户上下文
 */
public class UserContext {



    /**
     * 更新当前用户
     * @return
     */
    public static AccountDto refreshUser(){
        return null;
    }

    /**
     * 获取当前用户
     * @return 返回 AccountDto
     */
    public static AccountDto getCurrentUser(){
        HttpServletRequest request = HISRequestFilter.getRequest();
        HttpSession session = request.getSession();
        Rescuer rescuer = (Rescuer) session.getAttribute("USER");
        if(rescuer == null){
            throw new BizException(ERRORCODE.TOKEN_INVALID.getCode(), ERRORCODE.TOKEN_INVALID.getMessage());
        }
        return setAccount(rescuer);
    }

    /**
     * 设置当前用户
     * @param user
     */
//    public static void setCurrentUser(AccountDto user){
//        //缓存记录
//        context.set(user);
//    }

    /**
     * 移除当前用户
     */
//    public static void removeCurrentUser(){
//        context.remove();
//    }

    private static AccountDto setAccount(Rescuer user){
        AccountDto accountDto = new AccountDto();
        accountDto.setUid(user.getCode());
        accountDto.setUsername(user.getUsername());
        accountDto.setName(user.getName());
        accountDto.setJobNumber(user.getJobNumber());
        return accountDto;
    }
}
