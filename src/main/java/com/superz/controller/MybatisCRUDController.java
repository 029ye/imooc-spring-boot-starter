package com.superz.controller;

import com.superz.pojo.Girl;
import com.superz.pojo.IMoocJSONResult;
import com.superz.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mybatis")
public class MybatisCRUDController {

    @Autowired
    private GirlService girlService;

    @RequestMapping("/saveGirl")
    public IMoocJSONResult saveGirl() throws Exception {

        Girl girl = new Girl();
        girl.setAge(22);
        girl.setCupSize("E");

        girlService.saveGirl(girl);

        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/updateGirl")
    public IMoocJSONResult updateGirl(){

        Girl girl = new Girl();
        girl.setId(10);
        girl.setAge(20);
        girl.setCupSize("D");

        girlService.updateGirl(girl);

        return IMoocJSONResult.ok("更新成功");
    }

    @RequestMapping("/deleteGirl")
    public IMoocJSONResult deleteGirl(){

        girlService.deleteGirl(11);

        return IMoocJSONResult.ok("删除成功");
    }

    @RequestMapping("/queryGirlById")
    public IMoocJSONResult queryGirlById(){

        Girl girl = girlService.queryGirlById(6);

        return IMoocJSONResult.ok(girl);
    }

    @RequestMapping("/queryGirlListPaged")
    public IMoocJSONResult queryGirlListPaged(Integer page){

        if(page == null){
            page = 1;
        }

        int pageSize = 10;

        Girl girl = new Girl();

        List<Girl> girlList = girlService.queryGirlListPaged(girl, page, pageSize);

        return IMoocJSONResult.ok(girlList);
    }

    @RequestMapping("/queryGirlByIdCustom")
    public IMoocJSONResult queryGirlByIdCustom(Integer id){

        return IMoocJSONResult.ok(girlService.queryGirlByIdCustom(id));
    }

    @RequestMapping("/saveGirlTransactional")
    public IMoocJSONResult saveGirlTransactional(){

        Girl girl = new Girl();
        girl.setAge(20);
        girlService.saveGirlTransactional(girl);

        return IMoocJSONResult.ok("事务完成");
    }
}
