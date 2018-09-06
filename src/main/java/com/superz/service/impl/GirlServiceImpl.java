package com.superz.service.impl;

import com.github.pagehelper.PageHelper;
import com.superz.mapper.GirlMapper;
import com.superz.mapper.GirlMapperCustom;
import com.superz.pojo.Girl;
import com.superz.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class GirlServiceImpl implements GirlService {
    @Autowired
    private GirlMapper girlMapper;

    @Autowired
    private GirlMapperCustom girlMapperCustom;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveGirl(Girl girl) throws Exception {

        girlMapper.insert(girl);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateGirl(Girl girl) {

        girlMapper.updateByPrimaryKeySelective(girl);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteGirl(Integer id) {

        girlMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Girl queryGirlById(Integer id) {

        Girl girl = girlMapper.selectByPrimaryKey(id);
        return girl;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Girl queryGirlByIdCustom(Integer id) {
        List<Girl> girlList = girlMapperCustom.queryGirlSimplyInfoById(id);

        if (girlList != null && !girlList.isEmpty()){
            return girlList.get(0);
        }

        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Girl> queryGirlList() {

        List<Girl> girlList = girlMapper.selectAll();
        return girlList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Girl> queryGirlListPaged(Girl girl, Integer page, int pageSize) {

        PageHelper.startPage(page, pageSize);

        Example example = new Example(Girl.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespace(girl.getCupSize())){
            criteria.andLike("cupSize", "%"+girl.getCupSize()+"%");
        }
        example.orderBy("id").asc();
        List<Girl> girlList = girlMapper.selectByExample(example);

        return girlList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveGirlTransactional(Girl girl) {

        girlMapper.insert(girl);

//        int a = 1 / 0;

        girl.setCupSize("C");
        girlMapper.updateByPrimaryKeySelective(girl);
    }
}
