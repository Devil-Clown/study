package com.study.hzk.common.util;

import com.study.hzk.common.bean.Car;

import java.util.Date;

public class CarUtil {
    /**
     * 通行时间：private String passtime;
     * 车牌号：private String carplate;
     * 地点编号：private String locationid;
     * 其他属性均默认：null
     * @return
     */
    public static Car randomCar(){
        String carplate = String.format("%05d",(int)(Math.random()*100000));
        String locationId = String.format("%03d",(int)(Math.random()*1000));

        Car car = new Car();
        car.setPasstime(TimeUtil.format.format(new Date()));
        car.setCarplate(carplate);
        car.setLocationid(locationId);
        return car;
    }

    /**
     * 比较两个Car对象相等否比较其validString，即车牌号和地点编号
     * @param car1
     * @param car2
     * @return
     */
    public static boolean equals(Car car1, Car car2){
        if(car1==null || car2==null) return false;
        return car1.toString().equals(car2.toString());
    }
}
