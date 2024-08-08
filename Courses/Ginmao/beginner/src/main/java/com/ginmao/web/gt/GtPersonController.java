package com.ginmao.web.gt;

import com.ginmao.constant.AttributeName;
import com.ginmao.constant.UrlPattern;
import com.ginmao.domain.Gender;
import com.ginmao.domain.GtPerson;
import com.ginmao.domain.GtPerson_;
import com.ginmao.service.GtPersonService;
import com.ginmao.util.ControllerUtils;
import com.ginmao.util.EnumUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("gt/gt-person")
public class GtPersonController extends BaseEntityController<GtPerson, GtPersonService>{

    private static final String[] DISALLOWED_FIELDS = new String[]{
        /*
        *  稽核欄位: 設定資料不綁定，即使 client post 資料也不會做處理
        * */
        GtPerson_.CREATE_ACCOUNT,
        GtPerson_.CREATE_TIME,
        GtPerson_.MODIFY_ACCOUNT,
        GtPerson_.MODIFY_TIME,
    };


    @InitBinder(AttributeName.MAIN)
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields(DISALLOWED_FIELDS);
    }

    /*
    * 準備通用資料
    * */
    @ModelAttribute("genders")
    public Map<String, Gender> getGenders(){
        return EnumUtils.getMap(Gender.class);
    }

    @GetMapping(UrlPattern.EDIT)
    public String update(@PathVariable(AttributeName.ID) String id, ModelMap model) {
        model.put(AttributeName.MAIN, getService().findOne(id));
        return ControllerUtils.getAdminViewInput(getClass());
    }

    @GetMapping(UrlPattern.ADD)
    public String add(ModelMap model) {
        model.put(AttributeName.MAIN, new GtPerson());
        return ControllerUtils.getAdminViewInput(getClass());
    }
}
