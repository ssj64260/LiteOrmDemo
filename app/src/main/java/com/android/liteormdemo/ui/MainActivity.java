package com.android.liteormdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.liteormdemo.R;
import com.android.liteormdemo.config.Constants;
import com.android.liteormdemo.db.LiteOrmHelper;
import com.android.liteormdemo.model.AttendanceBean;
import com.android.liteormdemo.model.PictureBean;
import com.android.liteormdemo.utils.DateTimeUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvSingle;
    private TextView tvCascade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();

    }

    private void initData() {

    }

    private void initView() {
        tvSingle = (TextView) findViewById(R.id.tv_single);
        tvCascade = (TextView) findViewById(R.id.tv_cascade);

        tvSingle.setOnClickListener(mClick);
        tvCascade.setOnClickListener(mClick);
    }

    private void insertData(boolean isSingle) {
        final String datetime = DateTimeUtils.getEnLongDateTime();

        final ArrayList<PictureBean> pictureList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            final PictureBean picture = new PictureBean();
            picture.setPath(String.valueOf((int) (Math.random() * 1000)));
            picture.setHadUpload(false);
            pictureList.add(picture);
        }

        final AttendanceBean attendance = new AttendanceBean();
        attendance.setLongitude(113.2333);
        attendance.setLatitude(23.33);
        attendance.setDeviceId(Constants.TEST_DEVICE_ID);
        attendance.setUploadType("上班考勤");
        attendance.setOrderNumber("");
        attendance.setRemark("");
        attendance.setPictureType("1");
        attendance.setFieldworkType("考勤");
        attendance.setFieldworkDetail("考勤");
        attendance.setServiceType("测量");
        attendance.setUserId(Constants.TEST_USER_ID);
        attendance.setSignDatetime(datetime);
        attendance.setUploadDatetime(datetime);
        attendance.setCustomerCode(Constants.TEST_CUSTOMER_CODE);
        attendance.setLocationDatetime(datetime);
        attendance.setPictureList(pictureList);

        final LiteOrmHelper dbHelper;
        dbHelper = new LiteOrmHelper(this, isSingle);
        dbHelper.save(attendance);
        dbHelper.closeDB();
    }

    private View.OnClickListener mClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_single:
                    insertData(true);
                    break;
                case R.id.tv_cascade:
                    insertData(false);
                    break;
            }
        }
    };

}
