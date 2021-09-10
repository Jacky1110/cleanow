package idv.tfp10207.nowclearnnow0818.cleanplan;


import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import idv.tfp10207.nowclearnnow0818.R;
import idv.tfp10207.nowclearnnow0818.cleanplan.CPorder.OrderConstants;


//  0.上一頁資訊  Bundle
//  1.預估清潔規模
//  2.選擇清潔時間
//  3.上傳照片
//  4.備註
//  5.服務對象資料
//  6.彈跳視窗 :簡單的訂單明細與訂單付款金額
//  7.資料放入Bundle
public class F_CleanPlan_02_Fragment extends Fragment {
    private static final String TAG = "TAG_F_CleanPlan_02_Fragment";
    private static final int REQ_CAP_IMG = 1;
    private Activity activity;

    //  1.預估清潔規模
    private TextView tv_CPscale_11;
    private EditText et_people_11;
    private EditText et_ping_11;
    private TextView tv_clearscale1_1_11;
    private ImageView iv_cp02_noteice_11;

    //  2.選擇清潔時間
    private TextView tv_CPtime_11;
    private RadioGroup rg_CP02time1_11;

    //  3.上傳照片
    private Button bt_CP02_tackpicture_11;
    private ImageView iv_CP02_takepicture_11;

    //  4.備註
    private EditText et_CP02_remark_11;
    private TextView tv_CPremark_11;

    //  5.服務對象資料
    private CheckBox cb_memberinit_11;
    private EditText et_CP02_serviceperson_name_11;
    private EditText et_CP02_serviceperson_phone_11;
    private EditText et_CP02_serviceperson_email_11;
    private EditText et_CP02_serviceperson_address_11;

    //  6.彈跳視窗
    private Button bt_CP02next_11;
    private String etcpmoney;

    //  7.資料放入OrderConstants帶到下一頁
    private OrderConstants orderconstants;

    //next button
    private Button bt_cp02_next;
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
        // 7.實例化Bundle物件
        orderconstants = new OrderConstants();
        return inflater.inflate(R.layout.fragment_f__clean_plan_02_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findview(view);
        handletoolbar(view);

//        handlebutton(view);
        handleCpPersonScale(view);
        handleNotuce(view);
        handleleRadioButton(view);
//相機
        handleTakepictureButton(view);
//其他
        handleRemark(view);
//同會員
        handleMemberCheckBoxes(view);
//彈跳視窗:本次費用
        handleNextBtAlert(view);
        handleCpPayMoney(etcpmoney);
    }




    private void findview(View view) {
        bt_cp02_next = view.findViewById(R.id.bt_CP02next_11);
        et_people_11 = view.findViewById(R.id.et_people_11);
        et_ping_11 = view.findViewById(R.id.et_ping_11);
        tv_clearscale1_1_11 = view.findViewById(R.id.tv_clearscale1_1_11);
        iv_cp02_noteice_11 = view.findViewById(R.id.iv_cp02_noteice_11);
//      時間
        tv_CPtime_11 = view.findViewById(R.id.tv_CPtime_11);
        rg_CP02time1_11 = view.findViewById(R.id.rg_CP02time1_11);
        cb_memberinit_11 = view.findViewById(R.id.cb_memberinit_11);
//      拍照
        bt_CP02_tackpicture_11 = view.findViewById(R.id.bt_CP02_tackpicture_11);
        iv_CP02_takepicture_11 = view.findViewById(R.id.iv_CP02_takepicture_11);
//
        tv_CPremark_11 = view.findViewById(R.id.tv_CPremark_11);
        et_CP02_remark_11 = view.findViewById(R.id.et_CP02_remark_11);
//      checkbutton 同會員資料
        et_CP02_serviceperson_name_11 = view.findViewById(R.id.et_CP02_serviceperson_name_11);
        et_CP02_serviceperson_phone_11 = view.findViewById(R.id.et_CP02_serviceperson_phone_11);
        et_CP02_serviceperson_email_11 = view.findViewById(R.id.et_CP02_serviceperson_email_11);
        et_CP02_serviceperson_address_11 = view.findViewById(R.id.et_CP02_serviceperson_address_11);

//
        bt_CP02next_11 = view.findViewById(R.id.bt_CP02next_11);
    }


    //  1.預估清潔規模
    private void handleCpPersonScale(View view) {

        //直接帶入資料
        tv_clearscale1_1_11.setOnClickListener(v -> {
            et_people_11.setText("1");
            et_ping_11.setText("25");
        });

    }

    private void handleNotuce(View view) {
        iv_cp02_noteice_11.setOnClickListener(v -> {
            new AlertDialog.Builder(getActivity())                    // 實例化AlertDialog.Builder物件
                    .setTitle("計費標準")                                 // 設定標題文字
                    //               用基本費用與規模去做計算
                    .setMessage("主要依據服務人員基本費用(服務者自訂，費用/次)與整理坪數區間費用\n \n坪數區間費用:\n1~30坪(含)：250元/坪\n30~60坪(含)：350元/坪\n60坪以上：500元/坪")             // 設定訊息文字
                    .setCancelable(true)                               // 設定是否可點擊對話框以外之處離開對話框
                    .show();
        });
    }


    //  2.選擇清潔時間   RadioButton

    private void handleleRadioButton(View view) {
        rg_CP02time1_11.setOnCheckedChangeListener((group, checkedId) -> {
            final RadioButton rb_CP02time1_11 = group.findViewById(checkedId);
//            textView待修改為bundle，以將檔案傳送至下一頁
//            textView.setText("(RadioButton) " + rb_CP01gender_11.getText());

            // 7-1取得資料
            String etTime = rb_CP02time1_11.getText().toString().trim();
            // 7-2資料放入Bundle物件
            orderconstants.setTime(etTime);
            //7-3測試
            Log.d("TAG_Time=", orderconstants.getTime());
        });


    }

    //3.上傳照片

    private void handleTakepictureButton(View view) {
        ActivityResultLauncher<Void> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.TakePicturePreview(), bitmap -> iv_CP02_takepicture_11.setImageBitmap(bitmap)
        );

        bt_CP02_tackpicture_11.setOnClickListener(v -> activityResultLauncher.launch(null));

        // 7-1取得資料
        // 7-2資料放入物件
        orderconstants.setPicture("null");
        //7-3測試
        Log.d("TAG_Picture", orderconstants.getPicture());
    }

    //4.其他備註
    private void handleRemark(View view) {
        tv_CPremark_11.setOnClickListener(v -> {
            et_CP02_remark_11.setText("家中有養狗，清理時請注意，謝謝!");

        });

        // 7-1取得資料
        String etRemark = et_CP02_remark_11.getText().toString().trim();
        // 7-2資料放入Bundle物件
        orderconstants.setRemark(etRemark);

    }

    //5.同會員資料
    private void handleMemberCheckBoxes(View view) {
        final CompoundButton.OnCheckedChangeListener listener = (checkBox, isChecked) -> {
            //帶入會員資料 寫死
            et_CP02_serviceperson_name_11.setText("王大明");
            et_CP02_serviceperson_phone_11.setText("0922222222");
            et_CP02_serviceperson_email_11.setText("aaa@gmail.com");
            et_CP02_serviceperson_address_11.setText("台北市中山區吉林路");

        };

        // 7-1取得資料
        String etServicename = et_CP02_serviceperson_name_11.getText().toString().trim();
        String etServicephone = et_CP02_serviceperson_phone_11.getText().toString().trim();
        String etServiceemail = et_CP02_serviceperson_email_11.getText().toString().trim();
        String etServiceaddress = et_CP02_serviceperson_address_11.getText().toString().trim();


        // 7-2資料放入Bundle物件
        orderconstants.setServicename(etServicename);
        orderconstants.setServicephone(etServicephone);
        orderconstants.setServiceemail(etServiceemail);
        orderconstants.setServiceaddress(etServiceaddress);


        // 4-2測試
        Log.d("TAG_servicename=", orderconstants.getServicename());
        Log.d("TAG_servicephone=", orderconstants.getServicephone());
        Log.d("TAG_serviceemail=", orderconstants.getServiceemail());
        Log.d("TAG_serviceaddress=", orderconstants.getServiceaddress());

        cb_memberinit_11.setOnCheckedChangeListener(listener);

    }


    //6.彈跳視窗 :簡單的訂單明細與訂單付款金額
    private void handleNextBtAlert(View view) {
        bt_CP02next_11.setOnClickListener(v -> {
            // 7-1取得資料
            String etPeople = et_people_11.getText().toString().trim();
            String etPing = et_ping_11.getText().toString().trim();

            // 7-2資料放入Bundle物件
            orderconstants.setPeoplenumber(etPeople);
            orderconstants.setPing(etPing);

            //7-3測試
            Log.d("TAG_People=", orderconstants.getPeoplenumber());
            Log.d("TAG_Ping=", orderconstants.getPing());

            handleMemberCheckBoxes(view);
            handleRemark(view);

            activity = getActivity();

            //判斷不可為空值
            if (et_people_11.getText().toString().trim().isEmpty() ||
                    et_ping_11.getText().toString().trim().isEmpty() ||
                    orderconstants.getTime() == null ||
                    et_CP02_serviceperson_name_11.getText().toString().trim().isEmpty() ||
                    et_CP02_serviceperson_phone_11.getText().toString().trim().isEmpty() ||
                    et_CP02_serviceperson_email_11.getText().toString().trim().isEmpty() ||
                    et_CP02_serviceperson_address_11.getText().toString().trim().isEmpty()
            ) {
                et_people_11.setError("預估人數不可為空");
                et_ping_11.setError("坪數不可為空");
                tv_CPtime_11.setError("預約時間不可為空");
                et_CP02_serviceperson_name_11.setError("服務對象姓名不可為空");
                et_CP02_serviceperson_phone_11.setError("服務對象手機不可為空");
                et_CP02_serviceperson_email_11.setError("服務對象信箱不可為空");
                et_CP02_serviceperson_address_11.setError("服務對象地址不可為空");
                return;
            }

            handleCpPayMoney(etcpmoney);


            new AlertDialog.Builder(getActivity())                    // 實例化AlertDialog.Builder物件
                    .setTitle("訂單金額")                                 // 設定標題文字
                    //               用基本費用與規模去做計算
                    .setMessage("本次清潔服務費用共計" + orderconstants.getCppaymoney() + "元")             // 設定訊息文字
                    // 有點不懂這段後面的參數在fragment該怎麼設置
                    // 設定確定按鈕-顯示文字及監聽器
                    .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // 4-2測試
                            Log.d("TAG_people=", orderconstants.getPeoplenumber());
                            Log.d("TAG_ping=", orderconstants.getPing());
                            Log.d("TAG_time=", orderconstants.getTime());
                            Log.d("TAG_picture=", orderconstants.getPicture());
                            Log.d("TAG_remark=", orderconstants.getRemark());
                            Log.d("TAG_servicename=", orderconstants.getServicename());
                            Log.d("TAG_servicephone=", orderconstants.getServicephone());
                            Log.d("TAG_serviceemail=", orderconstants.getServiceemail());
                            Log.d("TAG_serviceaddress=", orderconstants.getServiceaddress());
                            Log.d("TAG_pay=", orderconstants.getCppaymoney());


                            Navigation.findNavController(view).navigate(R.id.f_CleanPlan_03_Fragment);
                            dialog.dismiss();
                        }
                    })
                    // 設定否定按鈕-顯示文字及監聽器
                    //                    .setNegativeButton("取消", (dialog, which) -> dialog.dismiss())
                    // 設定不決定按鈕-顯示文字及監聽器
                    .setNeutralButton("取消", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setCancelable(true)                               // 設定是否可點擊對話框以外之處離開對話框
                    .show();
        });
    }

    //    服務費用計算
    private String handleCpPayMoney(String etcpmoney) {
//        //用bundle把使用者填的資料帶入
//        // 取得Bundle物件
//        Bundle bundle = getArguments();
//        if (bundle != null) {
//            // 取出資料
//            final int userping = (int) bundle.getInt("ping");
//            // 7-2測試
////            Log.d("ping=", userping);
//        }

//        待調整用物件去計算，並轉型
        int personpay;  //bundle
        int areapay;
        personpay = 1200;
        areapay = 25 * 250;

        // 7-1取得資料
        String etCpmoney = Integer.toString(personpay + areapay);
        // 7-2資料放入Bundle物件
        orderconstants.setCppaymoney(etCpmoney);

        Log.d("TAG_pay=", orderconstants.getCppaymoney());

        return etcpmoney;
//        Charge.setText("本次服務共"+pay+"元");
    }


    //客製Toolbar
    private void handletoolbar(View view) {
//    抓按鍵
        leftarrowicon = view.findViewById(R.id.iv_arrow_back_11);
        righthomeicon = view.findViewById(R.id.iv_home_11);
//    改標題
        tvprojectname = view.findViewById(R.id.tv_project_name_11);


//    按鍵(需更改導覽路線的ID)

        leftarrowicon.setOnClickListener(v -> {
            Navigation.findNavController(view).popBackStack(R.id.f_CleanPlan_02_Fragment, true);
        });


        righthomeicon.setOnClickListener(v -> {
            Navigation.findNavController(v).popBackStack(R.id.homePageFragment072, false);
        });

//    標題
        tvprojectname.setText("清潔計畫");

    }


}