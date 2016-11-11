package com.gdpu.controller.category;

import com.gdpu.common.exception.BizException;
import com.gdpu.common.utils.ERRORCODE;
import com.gdpu.common.utils.RETURNCODE;
import com.gdpu.common.utils.User.UserContext;
import com.gdpu.his.param.sys.CategoryParam;
import com.gdpu.his.service.sys.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 郭旭辉 on 2016/11/10.
 * 分类标签控制类
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * 进入医护人员页面列表页面
     *
     * @return 返回，模型与视图
     */
    @RequestMapping(value = "/list")
    public ModelAndView queryPage(CategoryParam param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return categoryService.queryPage(param, pageNo, pageSize);
    }

    /**
     * 进入分类标签添加页面
     *
     * @return 返回，视图
     */
    @RequestMapping(value = "/add")
    public String loadAddBounced() {
        return "category/add";
    }

    /**
     * 保存分类标签
     *
     * @param param 保存参数
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addCategory(CategoryParam param) {
        return categoryService.addCategory(param, UserContext.getCurrentUser());
    }

    /**
     * 获取标签更新视图
     *
     * @param id 标签主键id
     * @return 返回，视图与数据
     */
    @RequestMapping(value = "update")
    public ModelAndView update(Long id) {
        return categoryService.update(id);
    }

    /**
     * 更新标签
     *
     * @param param 更新参数
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
    public String updateCategory(CategoryParam param) {
        return categoryService.updateCategory(param, UserContext.getCurrentUser());
    }

    /**
     * 启用、停用分类标签
     *
     * @param param 更新参数
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/disabledOrEnabled")
    public String disabledOrEnabled(CategoryParam param) {
        return categoryService.disabledOrEnabled(param, UserContext.getCurrentUser());
    }

    /**
     * 删除一个标签
     * @param id    标签主键
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(Long id){
        if(categoryService.deleteById(id) > 0){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }
}
