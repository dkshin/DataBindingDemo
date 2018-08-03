package kr.dkshin.android.databindingdemo;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by SHIN on 2018. 7. 26..
 */
public class StartViewModel extends ViewModel {

    private MutableLiveData<List<User>> users;

    public StartViewModel() {
        users = new MutableLiveData<>();
        loadUsers();
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    private void loadUsers() {
        Log.e("SHIN", "loadUsers");
        List<User> userList = new ArrayList<>();
        userList.add(new User(0, "신동규", "31"));
        users.setValue(userList);
    }

    public void addUser() {
        Log.e("SHIN", "addUser");
        List<User> userList = users.getValue();
        userList.add(new User(userList.get(userList.size()-1).getId() + 1, "신동규", "31"));
        users.setValue(userList);
    }

    public void removeUser() {
        Log.e("SHIN", "removeUser");
        List<User> userList = users.getValue();
        User user = userList.get(userList.size()-1);
        userList.remove(user);
        users.setValue(userList);
    }

    @Override
    protected void onCleared() {
        Log.e("SHIN", "onCleared");
        super.onCleared();
    }
}
