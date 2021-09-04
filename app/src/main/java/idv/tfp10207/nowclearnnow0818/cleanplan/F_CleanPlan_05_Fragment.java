package idv.tfp10207.nowclearnnow0818.cleanplan;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import idv.tfp10207.nowclearnnow0818.R;

public class F_CleanPlan_05_Fragment extends Fragment {
    private static final String TAG = "TAG_F_CleanPlan_05_Fragment";
    private Activity activity;

    //  1.訂單詳情
    private TextView tv_CP04_order_number2_11;

    private  TextView tv_CP05_orderscale1_11;
    private  TextView tv_CP05_orderscale2_11;
    private  TextView tv_CP05_orderscale3_11;
    private  TextView tv_CP05_orderscale4_11;
    private  TextView tv_CP05_orderscale5_11;

    private TextView tv_CP05_orderpay1_11;
    private TextView tv_CP05_orderpay2_11;
    private TextView tv_CP05_orderpay3_11;
    private TextView tv_CP05_orderpay4_11;

    private TextView tv_CP05_orderpayway1_11;
    private TextView tv_CP05_orderpayway2_11;

    private TextView tv_CP05_orderclient1_11;
    private TextView tv_CP05_orderclient2_11;
    private TextView tv_CP05_orderclient3_11;
    private TextView tv_CP05_orderclient4_11;


    //Toolbar
    private ImageView righthomeicon;
    private ImageView leftarrowicon;
    private TextView tvprojectname;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        return inflater.inflate(R.layout.fragment_f__clean_plan_05_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findview(view);
//        handlebutton();
        handleOrder(view);
        handletoolbar(view);

    }

    private void findview(View view) {

        tv_CP05_orderscale1_11 = view.findViewById(R.id.tv_CP05_orderscale1_11);
        tv_CP05_orderscale2_11 = view.findViewById(R.id.tv_CP05_orderscale2_11);
        tv_CP05_orderscale3_11 = view.findViewById(R.id.tv_CP05_orderscale3_11);
        tv_CP05_orderscale4_11 = view.findViewById(R.id.tv_CP05_orderscale4_11);
        tv_CP05_orderscale5_11 = view.findViewById(R.id.tv_CP05_orderscale5_11);

        tv_CP05_orderpay1_11 = view.findViewById(R.id.tv_CP05_orderpay1_11);
        tv_CP05_orderpay2_11 = view.findViewById(R.id.tv_CP05_orderpay2_11);
        tv_CP05_orderpay3_11 = view.findViewById(R.id.tv_CP05_orderpay3_11);
        tv_CP05_orderpay4_11 = view.findViewById(R.id.tv_CP05_orderpay4_11);

        tv_CP05_orderpayway1_11 = view.findViewById(R.id.tv_CP05_orderpayway1_11);
        tv_CP05_orderpayway2_11 = view.findViewById(R.id.tv_CP05_orderpayway2_11);

        tv_CP05_orderclient1_11 = view.findViewById(R.id.tv_CP05_orderclient1_11);
        tv_CP05_orderclient2_11 = view.findViewById(R.id.tv_CP05_orderclient2_11);
        tv_CP05_orderclient3_11 = view.findViewById(R.id.tv_CP05_orderclient3_11);
        tv_CP05_orderclient4_11 = view.findViewById(R.id.tv_CP05_orderclient4_11);
    }


//顯示訂單
    private void handleOrder(View view) {
        //寫死 媒合詳情
        tv_CP05_orderscale1_11.setText("預估清潔規模："+"1"+"人");
        tv_CP05_orderscale2_11.setText("預估清潔規模："+"22"+"坪");
        tv_CP05_orderscale3_11.setText("清潔時間："+"早上");
        tv_CP05_orderscale4_11.setText("備註："+"家中有養狗，清理時請注意，謝謝!");
        tv_CP05_orderscale5_11.setText("家事者："+"黃永珠");
        //寫死 付款人 帶入會員資料
        tv_CP05_orderpay1_11.setText("付款人姓名："+"王大明");
        tv_CP05_orderpay2_11.setText("付款人手機："+"0922222222");
        tv_CP05_orderpay3_11.setText("付款人信箱："+"aaa@gmail.com");
        tv_CP05_orderpay4_11.setText("付款人地址："+"台北市中山區吉林路");
        //寫死 付款資訊 帶入會員資料
        tv_CP05_orderpayway1_11.setText("繳費方式："+"Googlepay");
        tv_CP05_orderpayway2_11.setText("繳費金額："+"7450元");
        //寫死 服務對象 帶入會員資料
        tv_CP05_orderclient1_11.setText("服務對象姓名："+"王大明");
        tv_CP05_orderclient2_11.setText("服務對象手機："+"0922222222");
        tv_CP05_orderclient3_11.setText("服務對象信箱："+"aaa@gmail.com");
        tv_CP05_orderclient4_11.setText("服務對象地址："+"台北市中山區吉林路");
    }



    //    客製Toolbar
    private void handletoolbar(View view) {
//    抓按鍵
        leftarrowicon = view.findViewById(R.id.iv_arrow_back_11);
        righthomeicon = view.findViewById(R.id.iv_home_11);
//    改標題
        tvprojectname = view.findViewById(R.id.tv_project_name_11);


//    按鍵(需更改導覽路線的ID)

        leftarrowicon.setOnClickListener(v -> {
            Navigation.findNavController(view).popBackStack(R.id.f_CleanPlan_05_Fragment, true);
        });


        righthomeicon.setOnClickListener(v -> {
            Navigation.findNavController(v).popBackStack(R.id.homePageFragment072, false);
        });

//    標題
        tvprojectname.setText("清潔計畫");

    }



}