package kr.dkshin.android.databindingdemo;///*

//*  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
// *
// *  Licensed under the Apache License, Version 2.0 (the "License");
// *  you may not use this file except in compliance with the License.
// *  You may obtain a copy of the License at
// *
// *      https://mindorks.com/license/apache-v2
// *
// *  Unless required by applicable law or agreed to in writing, software
// *  distributed under the License is distributed on an "AS IS" BASIS,
// *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// *  See the License for the specific language governing permissions and
// *  limitations under the License
// */


import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by amitshekhar on 11/07/17.
 */

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"startAdapter"})
    public static void addStartItems(RecyclerView recyclerView, List<User> list) {
        StartAdapter adapter = (StartAdapter) recyclerView.getAdapter();
        if (adapter != null) {
//            adapter.clearItems();
            adapter.addItems(list);
        }
    }

//    @BindingAdapter({"myAdapter"})
//    public static void addMyItems(RecyclerView recyclerView, List<Sakidol> sakidolList) {
//        MyAdapter adapter = (MyAdapter) recyclerView.getAdapter();
//        if (adapter != null) {
//            adapter.addItems(sakidolList);
//        }
//    }
//
//    @BindingAdapter({"detailAdapter"})
//    public static void addDetailItems(RecyclerView recyclerView, List<SakidolVideo> sakidolVideos) {
//        DetailAdapter adapter = (DetailAdapter) recyclerView.getAdapter();
//        if (adapter != null) {
//            adapter.addItems(sakidolVideos);
//        }
//    }



//
//    @BindingAdapter({"jumpAdapter"})
//    public static void addJumpItems(RecyclerView recyclerView, List<Package> packages) {
//        JumpAdapter adapter = (JumpAdapter) recyclerView.getAdapter();
//        if (adapter != null) {
//            //adapter.clearItems();
//            adapter.addItems(packages);
//        }
//    }
//
//    @BindingAdapter({"myAdapter"})
//    public static void addMyItems(RecyclerView recyclerView, List<Package> packages) {
//        MyAdapter adapter = (MyAdapter) recyclerView.getAdapter();
//        if (adapter != null) {
//            //adapter.clearItems();
//            adapter.addItems(packages);
//        }
//    }
//
//    @BindingAdapter({"detailAdapter"})
//    public static void addDetailItems(RecyclerView recyclerView, List<Video> videos) {
//        DetailAdapter adapter = (DetailAdapter) recyclerView.getAdapter();
//        if (adapter != null) {
//            //adapter.clearItems();
//            adapter.addItems(videos);
//        }
//    }
//
//    @BindingAdapter({"adapter"})
//    public static void addVideoItems(RecyclerView recyclerView, List<Video> videos) {
//        DashBoardAdapter adapter = (DashBoardAdapter) recyclerView.getAdapter();
//        if (adapter != null) {
//            adapter.clearItems();
//            adapter.addItems(videos);
//        }
//    }
//
//    @BindingAdapter({"adapter"})
//    public static void addOpenSourceItems(RecyclerView recyclerView, List<OpenSourceItemViewModel> openSourceItems) {
//        OpenSourceAdapter adapter = (OpenSourceAdapter) recyclerView.getAdapter();
//        if (adapter != null) {
//            adapter.clearItems();
//            adapter.addItems(openSourceItems);
//        }
//    }
//
//    @BindingAdapter({"adapter", "action"})
//    public static void addQuestionItems(SwipePlaceHolderView mCardsContainerView, List<QuestionCardData> mQuestionList, int mAction) {
//        if (mAction == MainViewModel.ACTION_ADD_ALL) {
//            if (mQuestionList != null) {
//                mCardsContainerView.removeAllViews();
//                for (QuestionCardData question : mQuestionList) {
//                    if (question != null && question.options != null && question.options.size() == 3) {
//                        mCardsContainerView.addView(new QuestionCard(question));
//                    }
//                }
//                ViewAnimationUtils.scaleAnimateView(mCardsContainerView);
//            }
//        }
//    }
//

}
