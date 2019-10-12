package com.hzk.mydap.dict.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 表结构
 DMLB                                      NOT NULL VARCHAR2(6)
 DM                                        NOT NULL VARCHAR2(32)
 DMSM                                      NOT NULL VARCHAR2(60)
 BZ                                                 VARCHAR2(500)
 XH                                                 NUMBER(8)
 SFSY                                               VARCHAR2(2)
 YBH                                       NOT NULL VARCHAR2(20)
 */
@Setter
@Getter
@ToString
public class DictBean{
    /**
     * 代码类别
     * 运编号
     * 代码说明
     * == 一般：以 代码类别_运编号 作key，dmsm作值
     * == 样例：261002_1,事故逃逸车辆
     *
     * 备注、序号（从1-n）、是否使用
     */
    private String dmlb;
    private String ybh;
    private String dmsm;

    private String bz;
    private long xh;
    private String sfsy;


    public DictBean(){}
    public DictBean(String dmlb, String ybh, String dmsm, String bz, long xh, String sfsy) {
        this.dmlb = dmlb;
        this.ybh = ybh;
        this.dmsm = dmsm;
        this.bz = bz;
        this.xh = xh;
        this.sfsy = sfsy;
    }
}
