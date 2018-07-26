package kr.dkshin.android.databindingdemo;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

/**
 * Created by SHIN on 2018. 7. 26..
 */
public class StartViewModel {
    public final ObservableList<User> observableArrayList = new ObservableArrayList<>();
    StartListener startListener;

    public StartViewModel(StartListener startListener) {
        this.startListener = startListener;
    }

    public void addStringItemsToList(User user) {
        android.util.Log.e("SHIN","addStringItemsToList");
        observableArrayList.add(user);
//        observableArrayList.addAll(list);
    }

    public void removeStringItemsToList(User user) {
        android.util.Log.e("SHIN","removeStringItemsToList");
        observableArrayList.remove(user);
//        observableArrayList.addAll(list);
    }

    public ObservableList<User> getObservableArrayList() {
        return observableArrayList;
    }

    public void onItemAddClick(){
        android.util.Log.e("SHIN","onItemAddClick");
        startListener.onClickAddButton();
    }

    public void onItemRemoveClick(){
        android.util.Log.e("SHIN","onItemRemoveClick");
        startListener.onClickRemoveButton();
    }

    public interface StartListener{
        void onClickAddButton();
        void onClickRemoveButton();
    }

}
