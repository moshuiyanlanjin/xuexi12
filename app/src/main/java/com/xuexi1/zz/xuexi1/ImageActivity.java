package com.xuexi1.zz.xuexi1;

import android.Manifest;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.xuexi1.zz.xuexi1.View.TitleLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by Administrator on 2018-03-08.
 */

public class ImageActivity extends BaesActicity implements EasyPermissions.PermissionCallbacks {

    @BindView(R.id.xuan)
    Button xuan;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.title)
    TitleLayout title;
    private String[] mCustomItems = new String[]{"本地相册", "相机拍照"};
    Uri fileurl;

    String[] premis = new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);
        if (savedInstanceState != null) {
            fileurl = Uri.parse(savedInstanceState.getString("path_file"));
        }
        initView();
    }

    public void initView() {
        title.Titleoperation(new TitleLayout.Advance() {
            @Override
            public void onadvance() {
                Intent intent = new Intent(ImageActivity.this,TranslateAnimationActivity.class);
                startActivity(intent);
            }
        });
    }

    @OnClick(R.id.xuan)
    public void onViewClicked() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(ImageActivity.this);
        dialog.setTitle("请选择：");
        dialog.setItems(mCustomItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        ActionPgone();
                        break;
                    case 1:
                        WritePgon();
                        break;
                }
            }


        });
        dialog.create().show();
    }

    public void WritePgon() {
        if (EasyPermissions.hasPermissions(ImageActivity.this, premis)) {
            write();
        } else {
            EasyPermissions.requestPermissions(ImageActivity.this, "是否开启对应权限", 2, premis);
        }
    }

    private void write() {
        //打开相册
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, 2);
    }

    public void ActionPgone() {
       /* //系统原装
        if(ContextCompat.checkSelfPermission(ImageActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(ImageActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
        }else{
            call();
        }*/

        //测试第三方

        if (EasyPermissions.hasPermissions(ImageActivity.this, premis)) {
            camera();
        } else {
            EasyPermissions.requestPermissions(ImageActivity.this, "是否为应用开启对应权限", 1, premis);
        }
    }

    //拨打电话
    private void call() {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }

    //拍照
    public void camera() {
        //先判断手机是否有sd卡
     /*   String stutas = Environment.getExternalStorageState();
        if(stutas.equals(Environment.MEDIA_MOUNTED)){*/
        //创建file对象，用来存储拍照后的图片
        File outputimage = new File(getExternalCacheDir(), "outputimage.jpg");

        try {
            //判断file对象是否存在
            if (outputimage.exists()) {
                outputimage.delete();
            }
            //创建文件
            outputimage.createNewFile();
            //相机意图
            //  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //判断版本号是否是android7.0及以上
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //如果手机版本大于android7.0，把file转化成一个封装过的uri对象
                fileurl = FileProvider.getUriForFile(ImageActivity.this, "com.xuexi1.zz.xuexi1.ImageActivity", outputimage);
            } else {
                //否则将file转化成uri对象
                fileurl = Uri.fromFile(outputimage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //启动相机程序

        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileurl);
        startActivityForResult(intent, 1);
        // }
    }

    /*  @Override
      public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
          switch (requestCode){
              case 1:
                  if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                      call();
                  }else {
                      Toast.makeText(ImageActivity.this,"请申请权限",Toast.LENGTH_SHORT).show();
                  }
                  break;
          }
      }*/
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // 将结果转发到EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
//显示dialog来提示用户去设置
        new AppSettingsDialog.Builder(this).setRationale("请在设置中开启拨打电话权限").setTitle("权限").build().show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putString("path_file", fileurl.toString());
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    try {
                        //将返回的照片转化为bitmap对象
                        Toast.makeText(ImageActivity.this, fileurl + "", Toast.LENGTH_SHORT).show();
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(fileurl));
                        //将拍摄的照片显示出来
                        img.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                //判断手机版本号
                if (Build.VERSION.SDK_INT >= 19) {
                    //如果大于4.4，则用此方法处理图片
                    Log.d("ssss", "ssss");
                    handleimageOnketKit(data);
                } else {
                    //如果小于4.4，则用此方法处理
                    Log.d("zzzz", "zzzz");
                    handleimageForketKit(data);
                }
                break;
        }
    }

    //版本低于4.4，处理图片
    private void handleimageForketKit(Intent data) {
        Uri uri = data.getData();
        String imagePath = getImagePath(uri, null);
        displayimage(imagePath);
    }

    //版本大于等于4.4，处理图片

    private void handleimageOnketKit(Intent data) {
        String imagepath = null;
        Uri uri = data.getData();
        Log.d("zzzz", uri + "");
        if (DocumentsContract.isDocumentUri(ImageActivity.this, uri)) {
            //如果是document类型的uri则通过 document id处理
            String docid = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                Log.d("zzzz", "1111");
                String id = docid.split(":")[1];//解析出数字格式的id
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagepath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Log.d("zzzz", "2222");
                Uri contenturi = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docid));
                imagepath = getImagePath(contenturi, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            Log.d("zzzz", "3333");
            //如果是content类型的uri,使用普通类型处理
            imagepath = getImagePath(uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            Log.d("zzzz", "4444");
            //如果是file类型的URI，直接获取图片路径即可
            imagepath = uri.getPath();
        } else {
            Log.d("zzzz", "5555");
            imagepath = getImagePath(uri, null);
        }
        //根据图片路径显示图片
        displayimage(imagepath);

    }


    public String getImagePath(Uri uri, String selection) {
        String path = null;
        //通过uri和selection来获取真实的图片路径
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void displayimage(String imagepath) {
        if (imagepath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagepath);
            img.setImageBitmap(bitmap);
            Log.d("bitmap", bitmap + "");
        } else {
            Toast.makeText(ImageActivity.this, "错误", Toast.LENGTH_SHORT).show();
        }
    }
}
