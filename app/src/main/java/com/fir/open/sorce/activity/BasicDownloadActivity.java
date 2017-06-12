package com.fir.open.sorce.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fir.open.sorce.R;
import com.fir.open.sorce.activity.base.BaseActivity;
import com.fir.open.sorce.util.DownloadController;

import java.io.File;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import zlc.season.rxdownload2.RxDownload;
import zlc.season.rxdownload2.entity.DownloadStatus;
import zlc.season.rxdownload2.function.Utils;

import static android.os.Environment.DIRECTORY_DOWNLOADS;
import static android.os.Environment.getExternalStoragePublicDirectory;

//import zlc.season.rxdownload2.RxDownload;
//import zlc.season.rxdownload2.entity.DownloadStatus;
//import zlc.season.rxdownload2.function.Utils;

/**
 * Created by Administrator on 2017-02-07.
 */
public class BasicDownloadActivity extends BaseActivity implements View.OnClickListener{
    private Disposable mDisposable;
    private TextView status;
    private TextView percent;
    private ProgressBar progress;
    private TextView size;
    private Button action;
    private DownloadController mDownloadController;
    private String url;
    private String saveName;
    private LinearLayout ll_back;

    @Override
    public int getLyout() {
        return R.layout.activity_basic_download;
    }

    @Override
    public void init() {
        url="http://img.oliving365.com/img/apk//c39034ds3d42377b5931ffsbsd0f85/yuemei_yuemei.apk";
//        ;
        saveName="modo_v1.0.1.apk";
//                getIntent().getStringExtra("name")+".apk";
        initView();
//        action.setText("开始");
        mDownloadController = new DownloadController(status, action);
        mDownloadController.setState(new DownloadController.Normal());
//        mRxDownload = RxDownload.getInstance()
//                .maxThread(10)
//                .context(this)      // 自动安装需要Context
//                .autoInstall(true); //下载完成自动安装
        down();
    }
    private void down() {
        RxDownload.getInstance(this)
                .download(url, saveName, null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DownloadStatus>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                        mDownloadController.setState(new DownloadController.Started());
                    }

                    @Override
                    public void onNext(DownloadStatus value) {
//                        //获得下载状态
                        progress.setIndeterminate(value.isChunked);
                        progress.setMax((int) value.getTotalSize());
                        progress.setProgress((int) value.getDownloadSize());
                        percent.setText(value.getPercent());
                        size.setText(value.getFormatStatusString());
                    }
                    @Override
                    public void onError(Throwable e) {
                        //下载出错
                        mDownloadController.setState(new DownloadController.Paused());
                    }
                    @Override
                    public void onComplete() {
                        //下载完成
                        mDownloadController.setState(new DownloadController.Completed());
                        installApk();
                    }
                });
    }


    private void initView() {
        ll_back= (LinearLayout) findViewById(R.id.ll_back);
        status = (TextView) findViewById(R.id.status);
        percent = (TextView) findViewById(R.id.percent);
        progress = (ProgressBar) findViewById(R.id.progress);
        size = (TextView) findViewById(R.id.size);
        action = (Button) findViewById(R.id.action);
        action.setOnClickListener(this);
        ll_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.action:
                mDownloadController.handleClick(new DownloadController.Callback() {
                    @Override
                    public void startDownload() {
                        down();
                    }

                    @Override
                    public void pauseDownload() {
                        pause();
                    }

                    @Override
                    public void cancelDownload() {
                    }

                    @Override
                    public void install() {
//                        installApk();
                        installApk();
                    }
                });
                break;
            case R.id.ll_back:
                finish();
                break;
        }
    }
    private void pause() {
        mDownloadController.setState(new DownloadController.Paused());
        Utils.dispose(mDisposable);
    }

    private String defaultPath = getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS).getPath();
    private void installApk() {
        File apkFile = new File(defaultPath + File.separator + saveName);
        Intent installAPKIntent = new Intent(Intent.ACTION_VIEW);
        installAPKIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//安装完成后打开新的apk
        installAPKIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.N){
            Uri fileUri = FileProvider.getUriForFile(BasicDownloadActivity.this,"me.nereo.multi_image_selector.fileprovider",apkFile);

            installAPKIntent.setDataAndType(fileUri, "application/vnd.android.package-archive");
        }else{
            installAPKIntent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        }

        this.startActivity(installAPKIntent);

    }

}
