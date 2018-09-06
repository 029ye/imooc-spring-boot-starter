package com.superz.mapper;

import com.superz.pojo.Girl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GirlMapperCustom{

    List<Girl> queryGirlSimplyInfoById(Integer id);
}