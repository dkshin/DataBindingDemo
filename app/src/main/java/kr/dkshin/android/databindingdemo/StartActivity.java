package kr.dkshin.android.databindingdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import kr.dkshin.android.databindingdemo.databinding.ActivityStartBinding;

public class StartActivity extends AppCompatActivity {

    private ActivityStartBinding activityStartBinding;
    private StartViewModel startViewModel;
    private StartAdapter startAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startViewModel = ViewModelProviders.of(this).get(StartViewModel.class);
        performDataBinding();
        setInit();
    }

    private void performDataBinding() {
        activityStartBinding = DataBindingUtil.setContentView(this, R.layout.activity_start);
        activityStartBinding.setVariable(BR.viewModel, startViewModel);
        activityStartBinding.executePendingBindings();
    }

    private void setInit() {
        startAdapter = new StartAdapter();
        activityStartBinding.youngJumpRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityStartBinding.youngJumpRecyclerView.setItemAnimator(new DefaultItemAnimator());
        activityStartBinding.youngJumpRecyclerView.setAdapter(startAdapter);
        startViewModel.getUsers().observe(this, users -> startAdapter.addItems(users));
    }
}
