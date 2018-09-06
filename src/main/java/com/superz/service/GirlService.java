package com.superz.service;

import com.superz.pojo.Girl;

import java.util.List;

public interface GirlService {

    void saveGirl(Girl girl) throws Exception;

    void updateGirl(Girl girl);

    void deleteGirl(Integer id);

    Girl queryGirlById(Integer id);

    Girl queryGirlByIdCustom(Integer id);

    List<Girl> queryGirlList();

    List<Girl> queryGirlListPaged(Girl girl, Integer page, int pageSize);

    void saveGirlTransactional(Girl girl);
}
