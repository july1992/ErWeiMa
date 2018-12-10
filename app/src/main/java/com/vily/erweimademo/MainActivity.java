package com.vily.erweimademo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 扫描跳转Activity RequestCode
     */
    public static final int REQUEST_CODE = 111;
    /**
     * 选择系统图片Request Code
     */
    public static final int REQUEST_IMAGE = 112;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  扫描二维码
        findViewById(R.id.btn_scan).setOnClickListener(this);
        //  生成二维码
        findViewById(R.id.btn_create).setOnClickListener(this);
        //  扫描系统二维码
        findViewById(R.id.btn_system).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_scan:
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.btn_system:  //  打开系统图库
                Intent intent3 = new Intent();
                intent3.setAction(Intent.ACTION_PICK);
                intent3.setType("image/*");
                startActivityForResult(intent3, REQUEST_IMAGE);
                break;
            case R.id.btn_create:
                // 二维码页面
                Intent intent2 = new Intent(MainActivity.this , MyZXingActivity.class);
                startActivity(intent2);
                break;

            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case REQUEST_CODE :
                //处理扫描结果（在界面上显示）
                System.out.println("-----------data"+data);
                if (null != data) {
                    System.out.println("-----------data2"+data);
                    Bundle bundle = data.getExtras();
                    if (bundle == null) {
                        return;
                    }
                    if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                        String result = bundle.getString(CodeUtils.RESULT_STRING);
                        System.out.println("-----------data3"+result);

                        Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();

                        if(result.contains("张三")){
                            System.out.println("-----------data4   包含张三");
//                               解析成功
//                               跳转到新页面
                            Intent intent = new Intent(MainActivity.this, BindSucceedActivity.class);
                            intent.putExtra("data",result);
                            startActivity(intent);
                        }


                    } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                        Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case REQUEST_IMAGE :
                if (data != null) {
                    Uri uri = data.getData();
                    try {
                        CodeUtils.analyzeBitmap(ImageUtil.getImageAbsolutePath(this, uri), new CodeUtils.AnalyzeCallback() {
                            @Override
                            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                                Toast.makeText(MainActivity.this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onAnalyzeFailed() {
                                Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;

        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
