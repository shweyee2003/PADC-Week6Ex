package xyz.aungpyaephyo.padc.myanmarattractions.adapters;

import android.view.LayoutInflater;

import java.util.List;

import xyz.aungpyaephyo.padc.myanmarattractions.MyanmarAttractionsApp;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.AttractionVO;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.UserVO;
import xyz.aungpyaephyo.padc.myanmarattractions.views.holders.AttractionViewHolder;

/**
 * Created by windows on 7/16/2016.
 */
public class UserAdapter {
    private LayoutInflater mInflater;
    private List<UserVO> mUserList;

    public UserAdapter(List<UserVO> userList) {
        mInflater = LayoutInflater.from(MyanmarAttractionsApp.getContext());
        mUserList = userList;

    }

    public void setNewData(List<UserVO> newUserList) {
        mUserList = newUserList;

    }
}
