package kr.dkshin.android.databindingdemo;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import kr.dkshin.android.databindingdemo.databinding.ActivityStartBinding;

public class StartActivity extends AppCompatActivity implements StartViewModel.StartListener {
    public final ObservableList<User> observableArrayList = new ObservableArrayList<>();

    private ActivityStartBinding activityStartBinding;
//    private StartViewModel startViewModel;
    private List<User> mList = new ArrayList<>();
    private StartAdapter startAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        startViewModel = new StartViewModel(this);
        performDataBinding();
        setInit();
    }

    private void performDataBinding() {
        activityStartBinding = DataBindingUtil.setContentView(this, R.layout.activity_start);
        activityStartBinding.setVariable(BR.userList, observableArrayList);
        activityStartBinding.executePendingBindings();
    }

    private void setInit() {
        startAdapter = new StartAdapter(mList);
        activityStartBinding.youngJumpRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityStartBinding.youngJumpRecyclerView.setItemAnimator(new DefaultItemAnimator());
        activityStartBinding.youngJumpRecyclerView.setAdapter(startAdapter);
        activityStartBinding.addButton.setOnClickListener(view -> onClickAddButton());

        activityStartBinding.removeButton.setOnClickListener(view -> onClickRemoveButton());
    }

    @Override
    public void onClickAddButton() {
        android.util.Log.e("SHIN","activity onClickAddButton");
        User user = new User(startAdapter.getItemCount()+1, "조아윤", "2");
//        startViewModel.addStringItemsToList(user);
        observableArrayList.add(user);
    }

    @Override
    public void onClickRemoveButton() {
        android.util.Log.e("SHIN","activity onClickRemoveButton");
//        startViewModel.removeStringItemsToList(user);
        observableArrayList.remove(startAdapter.getItemCount()-1);
    }
}
