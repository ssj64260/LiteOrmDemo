package com.android.liteormdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.litesuits.orm.db.annotation.Mapping;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;
import com.litesuits.orm.db.enums.Relation;

import java.util.ArrayList;

/**
 * 考勤
 * <p>
 * http://dx.anywellchat.com:8888/anywell_dgchen/upload_android.aspx?
 * TWD=113.41948800000
 * &
 * TJD=23.16794500000
 * &
 * TSBID=XC804-C2D8-L068-R0A8-0268
 * &
 * TSBLB=上班考勤
 * &
 * TSBBZ=
 * &
 * TSBBZ2=
 * &
 * TISOLD=0
 * &
 * WQLB=考勤
 * &
 * WQMX=抵达
 * &
 * FWLB=测量
 * &
 * USERID=Admin
 * &
 * SIGNTIME=2017-12-20 15:30:00
 * &
 * UPLOADTIME=2017-12-20 15:30:00
 * &
 * KHBM=kh1708090001
 * &
 * FSJ=2017-12-20 15:30:00
 */
@Table("Attendance")
public class AttendanceBean implements Parcelable {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private long id;
    private double longitude;//经度
    private double latitude;//纬度
    private String deviceId;//设备ID
    private String uploadType;//上报类别（上班考勤；送货确认；到达客户现场）
    private String orderNumber;//单号
    private String remark;//备注
    private String pictureType;//附图标识（0:一张，1:多张）
    private String fieldworkType;//外勤类别（考勤；销售外勤；服务外勤）
    private String fieldworkDetail;//外勤明细（考勤；抵达；离开；完工确认）
    private String serviceType;//服务类别（测量；安装；铺贴；送货；维修；保养）
    private String userId;//用户ID
    private String signDatetime;//签到时间
    private String uploadDatetime;//上传时间
    private String customerCode;//客户编码
    private String locationDatetime;//定位时间

    private String showAddress;//显示用地址
    private String showDatetime;//显示用日期时间

    @Mapping(Relation.OneToMany)
    private ArrayList<PictureBean> pictureList;//图片列表

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUploadType() {
        return uploadType;
    }

    public void setUploadType(String uploadType) {
        this.uploadType = uploadType;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
    }

    public String getFieldworkType() {
        return fieldworkType;
    }

    public void setFieldworkType(String fieldworkType) {
        this.fieldworkType = fieldworkType;
    }

    public String getFieldworkDetail() {
        return fieldworkDetail;
    }

    public void setFieldworkDetail(String fieldworkDetail) {
        this.fieldworkDetail = fieldworkDetail;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSignDatetime() {
        return signDatetime;
    }

    public void setSignDatetime(String signDatetime) {
        this.signDatetime = signDatetime;
    }

    public String getUploadDatetime() {
        return uploadDatetime;
    }

    public void setUploadDatetime(String uploadDatetime) {
        this.uploadDatetime = uploadDatetime;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getLocationDatetime() {
        return locationDatetime;
    }

    public void setLocationDatetime(String locationDatetime) {
        this.locationDatetime = locationDatetime;
    }

    public String getShowAddress() {
        return showAddress;
    }

    public void setShowAddress(String showAddress) {
        this.showAddress = showAddress;
    }

    public String getShowDatetime() {
        return showDatetime;
    }

    public void setShowDatetime(String showDatetime) {
        this.showDatetime = showDatetime;
    }

    public ArrayList<PictureBean> getPictureList() {
        return pictureList;
    }

    public void setPictureList(ArrayList<PictureBean> pictureList) {
        this.pictureList = pictureList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeDouble(this.longitude);
        dest.writeDouble(this.latitude);
        dest.writeString(this.deviceId);
        dest.writeString(this.uploadType);
        dest.writeString(this.orderNumber);
        dest.writeString(this.remark);
        dest.writeString(this.pictureType);
        dest.writeString(this.fieldworkType);
        dest.writeString(this.fieldworkDetail);
        dest.writeString(this.serviceType);
        dest.writeString(this.userId);
        dest.writeString(this.signDatetime);
        dest.writeString(this.uploadDatetime);
        dest.writeString(this.customerCode);
        dest.writeString(this.locationDatetime);
        dest.writeString(this.showAddress);
        dest.writeString(this.showDatetime);
        dest.writeTypedList(this.pictureList);
    }

    public AttendanceBean() {
    }

    protected AttendanceBean(Parcel in) {
        this.id = in.readLong();
        this.longitude = in.readDouble();
        this.latitude = in.readDouble();
        this.deviceId = in.readString();
        this.uploadType = in.readString();
        this.orderNumber = in.readString();
        this.remark = in.readString();
        this.pictureType = in.readString();
        this.fieldworkType = in.readString();
        this.fieldworkDetail = in.readString();
        this.serviceType = in.readString();
        this.userId = in.readString();
        this.signDatetime = in.readString();
        this.uploadDatetime = in.readString();
        this.customerCode = in.readString();
        this.locationDatetime = in.readString();
        this.showAddress = in.readString();
        this.showDatetime = in.readString();
        this.pictureList = in.createTypedArrayList(PictureBean.CREATOR);
    }

    public static final Creator<AttendanceBean> CREATOR = new Creator<AttendanceBean>() {
        @Override
        public AttendanceBean createFromParcel(Parcel source) {
            return new AttendanceBean(source);
        }

        @Override
        public AttendanceBean[] newArray(int size) {
            return new AttendanceBean[size];
        }
    };
}
