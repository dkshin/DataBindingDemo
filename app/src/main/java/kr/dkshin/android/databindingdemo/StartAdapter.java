package kr.dkshin.android.databindingdemo;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import kr.dkshin.android.databindingdemo.databinding.ItemStartViewBinding;

/**
 * Created by SHIN on 2018. 6. 20..
 */
public class StartAdapter extends RecyclerView.Adapter<StartAdapter.StartViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    private List<User> mList = new ArrayList<>();

    public StartAdapter() {

    }

    @Override
    public int getItemCount() {
        if (mList != null && mList.size() > 0) {
            return mList.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return VIEW_TYPE_NORMAL;
    }

    @Override
    public StartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemStartViewBinding itemStartViewBinding = ItemStartViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new StartViewHolder(itemStartViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull StartViewHolder holder, int position) {
        holder.onBind(position);
    }

    public void addItems(List<User> list) {
        if(mList != null){
            UserDiffCallback userDiffCallback = new UserDiffCallback(mList, list);
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(userDiffCallback);
            mList.clear();
            mList.addAll(list);
            diffResult.dispatchUpdatesTo(this);
        }
    }

    public void clearItems() {
        mList.clear();
    }

    public class StartViewHolder extends RecyclerView.ViewHolder {
        private ItemStartViewBinding mBinding;

        private StartItemViewModel startItemViewModel;

        public StartViewHolder(ItemStartViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void onBind(int position) {
            final User value = mList.get(position);
            startItemViewModel = new StartItemViewModel(value);
            mBinding.setViewModel(startItemViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }

    }

    public class StartItemViewModel {

        public final ObservableField<User> userObservableField;
        User mValue;

        public StartItemViewModel(User value) {
            this.mValue = value;
            userObservableField = new ObservableField<>(mValue);
        }
    }

    public class UserDiffCallback extends DiffUtil.Callback {

        private final List<User> oldPosts, newPosts;

        public UserDiffCallback(List<User> oldPosts, List<User> newPosts) {
            this.oldPosts = oldPosts;
            this.newPosts = newPosts;
        }

        @Override
        public int getOldListSize() {
            return oldPosts.size();
        }

        @Override
        public int getNewListSize() {
            return newPosts.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return oldPosts.get(oldItemPosition) == newPosts.get(newItemPosition);
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return oldPosts.get(oldItemPosition).equals(newPosts.get(newItemPosition));
        }
    }

}