package com.study.hzk.common.bean;

public class Car {
    @Override
    public String toString(){
        return carplate + "," + locationid;
        //        return passtime + "," + carplate + "," + locationid;
//        return version + "," + passtime + "," + carstate + "," + carplate + "," + platetype + ","
//                + cloud_platetype + "," + speed + "," + platecolor + "," + locationid + "," + driveway + ","
//                + cloud_driveway + "," + drivedir + "," + cloud_drivedir + "," + capturedir + "," + carcolor + ","
//                + carbrand + "," + tgsid + "," + cloud_tgsid + "," + platecoord + "," + cabcoord + ","
//                + imgid1 + "," + imgid2 + "," + imgid3 + "," + imgid4 + "," + imgid5;
    }
    /**
     * 版本号
     */
    private String version;
    /**
     * 通行时间
     */
    private String passtime;
    /**
     * 车辆状态
     */
    private String carstate;
    /**
     * 车牌号
     */
    private String carplate;
    /**
     * 号牌种类
     */
    private String platetype;

    /**
     * 号牌种类云编号
     */
    private String cloud_platetype;
    /**
     * 速度
     */
    private String speed;
    /**
     * 车牌颜色
     */
    private String platecolor;
    /**
     * 地点编号
     */
    private String locationid;
    /**
     * 车道编码
     */
    private String driveway;
    /**
     * 车道云编号
     */
    private String cloud_driveway;
    /**
     * 行驶方向
     */
    private String drivedir;
    /**
     * 行驶方向云编号
     */
    private String cloud_drivedir;
    /**
     * 抓拍方向
     */
    private String capturedir;
    /**
     * 车身颜色
     */
    private String carcolor;
    /**
     * 车辆品牌
     */
    private String carbrand;
    /**
     * 卡口编号
     */
    private String tgsid;
    /**
     * 卡口云编号
     */
    private String cloud_tgsid;
    /**
     * 车牌坐标
     */
    private String platecoord;
    /**
     * 驾驶室坐标
     */
    private String cabcoord;
    /**
     * 图片文件名1
     */
    private String imgid1;
    /**
     * 图片文件名2
     */
    private String imgid2;
    /**
     * 图片文件名3
     */
    private String imgid3;
    /**
     * 主驾驶
     */
    private String imgid4;
    /**
     * 副驾驶
     */
    private String imgid5;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPasstime() {
        return passtime;
    }

    public void setPasstime(String passtime) {
        this.passtime = passtime;
    }

    public String getCarstate() {
        return carstate;
    }

    public void setCarstate(String carstate) {
        this.carstate = carstate;
    }

    public String getCarplate() {
        return carplate;
    }

    public void setCarplate(String carplate) {
        this.carplate = carplate;
    }

    public String getPlatetype() {
        return platetype;
    }

    public void setPlatetype(String platetype) {
        this.platetype = platetype;
    }

    public String getCloud_platetype() {
        return cloud_platetype;
    }

    public void setCloud_platetype(String cloud_platetype) {
        this.cloud_platetype = cloud_platetype;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getPlatecolor() {
        return platecolor;
    }

    public void setPlatecolor(String platecolor) {
        this.platecolor = platecolor;
    }

    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    public String getDriveway() {
        return driveway;
    }

    public void setDriveway(String driveway) {
        this.driveway = driveway;
    }

    public String getCloud_driveway() {
        return cloud_driveway;
    }

    public void setCloud_driveway(String cloud_driveway) {
        this.cloud_driveway = cloud_driveway;
    }

    public String getDrivedir() {
        return drivedir;
    }

    public void setDrivedir(String drivedir) {
        this.drivedir = drivedir;
    }

    public String getCloud_drivedir() {
        return cloud_drivedir;
    }

    public void setCloud_drivedir(String cloud_drivedir) {
        this.cloud_drivedir = cloud_drivedir;
    }

    public String getCapturedir() {
        return capturedir;
    }

    public void setCapturedir(String capturedir) {
        this.capturedir = capturedir;
    }

    public String getCarcolor() {
        return carcolor;
    }

    public void setCarcolor(String carcolor) {
        this.carcolor = carcolor;
    }

    public String getCarbrand() {
        return carbrand;
    }

    public void setCarbrand(String carbrand) {
        this.carbrand = carbrand;
    }

    public String getTgsid() {
        return tgsid;
    }

    public void setTgsid(String tgsid) {
        this.tgsid = tgsid;
    }

    public String getCloud_tgsid() {
        return cloud_tgsid;
    }

    public void setCloud_tgsid(String cloud_tgsid) {
        this.cloud_tgsid = cloud_tgsid;
    }

    public String getPlatecoord() {
        return platecoord;
    }

    public void setPlatecoord(String platecoord) {
        this.platecoord = platecoord;
    }

    public String getCabcoord() {
        return cabcoord;
    }

    public void setCabcoord(String cabcoord) {
        this.cabcoord = cabcoord;
    }

    public String getImgid1() {
        return imgid1;
    }

    public void setImgid1(String imgid1) {
        this.imgid1 = imgid1;
    }

    public String getImgid2() {
        return imgid2;
    }

    public void setImgid2(String imgid2) {
        this.imgid2 = imgid2;
    }

    public String getImgid3() {
        return imgid3;
    }

    public void setImgid3(String imgid3) {
        this.imgid3 = imgid3;
    }

    public String getImgid4() {
        return imgid4;
    }

    public void setImgid4(String imgid4) {
        this.imgid4 = imgid4;
    }

    public String getImgid5() {
        return imgid5;
    }

    public void setImgid5(String imgid5) {
        this.imgid5 = imgid5;
    }
}
