package com.hzk.mydap.mapper.master;

import com.hzk.mydap.dict.model.DictBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DictMapper {
    List<DictBean> queryAll();
}
