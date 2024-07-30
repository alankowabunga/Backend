package com.pure_springboot.web.gt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("gt/gt-person")
public class GtPersonController {

    @GetMapping
    public String toGtPersonPage(Model model) {
        System.out.println("== to main page ===");
        model.addAttribute("message", "Hello, Pebble!");
        return "gt/gt-person/gt-person-index"; // 將使用 templates/example.html 視圖
    }
//
//    private static final String[] DISALLOWED_FIELDS = new String[]{
//        GtDistrict_.CHILDREN,
//        GtDistrict_.CREATE_ACCOUNT,
//        GtDistrict_.CREATE_TIME,
//        GtDistrict_.MODIFY_ACCOUNT,
//        GtDistrict_.MODIFY_TIME,
//    };
//
//
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.setDisallowedFields(DISALLOWED_FIELDS);
//    }
//
//    @ModelAttribute("cities")
//    public List<GtDistrict> getCities() {
//        return getService().findByType(GtDistrictType.CITY);
//    }
//
//    @GetMapping(UrlPattern.EDIT)
//    public String update(@PathVariable(AttributeName.ID) String id, ModelMap model) {
//        model.put(AttributeName.MAIN, getService().findOne(id));
//        return ControllerUtils.getAdminViewInput(getClass());
//    }
//
//    @GetMapping(UrlPattern.ADD)
//    public String add(ModelMap model) {
//        model.put(AttributeName.MAIN, new GtDistrict());
//        return ControllerUtils.getAdminViewInput(getClass());
//    }
}
