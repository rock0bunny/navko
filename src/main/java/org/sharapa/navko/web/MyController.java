package org.sharapa.navko.web;

import org.sharapa.navko.model.Category;
import org.sharapa.navko.model.MenuItem;
import org.sharapa.navko.model.Product;
import org.sharapa.navko.model.Translation;
import org.sharapa.navko.repository.MenuItemRepository;
import org.sharapa.navko.service.NavkoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;

@Controller
public class MyController {

    private NavkoService navkoService;

    @Autowired
    public MyController(NavkoService navkoService) {
        this.navkoService = navkoService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createDB(){
        System.out.println("DB creation called!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        Translation ua = new Translation();
        ua.setLang("ua");
        ua.setTitle("Установка АС33 для зварювання прямолінійних швів");
        ua.setText("Текст опису для Установка АС777777 для зварювання прямолінійних швів");
        ua.setDefaultLang(false);

        Translation ru = new Translation();
        ru.setLang("ru");
        ru.setTitle("Установка АС33 для сварки прямолинейных швов");
        ru.setText("Текст описания для Установка АС77777 для сварки прямолинейных швов");
        ru.setDefaultLang(true);

        Translation en = new Translation();
        en.setLang("en");
        en.setTitle("Installing AC33 for welding longitudinal seams");
        en.setText("Text for Installing AC77777 for welding longitudinal seams");
        en.setDefaultLang(false);

        Category c1 = navkoService.getCategories().get(0);

        Product item = new Product();
        item.setCategory(c1);

        item.addTranslation(ua);
        item.addTranslation(ru);
        item.addTranslation(en);

        navkoService.saveProduct(item);

        return "/";
    }
}
