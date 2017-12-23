package com.android.liteormdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * 图片
 */

@Table("Picture")
public class PictureBean implements Parcelable {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private long id;//图片ID
    private String path;//图片路径
    private boolean hadUpload;//图片是否已上传

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isHadUpload() {
        return hadUpload;
    }

    public void setHadUpload(boolean hadUpload) {
        this.hadUpload = hadUpload;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.path);
        dest.writeByte(this.hadUpload ? (byte) 1 : (byte) 0);
    }

    public PictureBean() {
    }

    protected PictureBean(Parcel in) {
        this.id = in.readLong();
        this.path = in.readString();
        this.hadUpload = in.readByte() != 0;
    }

    public static final Creator<PictureBean> CREATOR = new Creator<PictureBean>() {
        @Override
        public PictureBean createFromParcel(Parcel source) {
            return new PictureBean(source);
        }

        @Override
        public PictureBean[] newArray(int size) {
            return new PictureBean[size];
        }
    };
}
