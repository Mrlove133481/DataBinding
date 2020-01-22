package com.mrlove.databinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.mrlove.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);  //绑定布局文件，之后binding就可以调用布局文件中的控件而不需要通过findviewbyid
        // myViewModel = ViewModelProviders.of(this).get(MyViewModel.class); //得到一个实现了ViewModel的类
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);  //   ViewModelProviders.of(this)
        binding.setData(this.myViewModel); //为布局文件中的data绑定myViewModel
        binding.setLifecycleOwner(this);  //实现观察者的作用，省略后UI数据不会自动刷新


    }
}
