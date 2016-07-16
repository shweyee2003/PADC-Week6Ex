package xyz.aungpyaephyo.padc.myanmarattractions.data.models;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import xyz.aungpyaephyo.padc.myanmarattractions.data.agents.AttractionDataAgent;
import xyz.aungpyaephyo.padc.myanmarattractions.data.agents.UserDataAgent;
import xyz.aungpyaephyo.padc.myanmarattractions.data.agents.retrofit.RetrofitDataAgent;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.AttractionVO;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.UserVO;
import xyz.aungpyaephyo.padc.myanmarattractions.events.DataEvent;

/**
 * Created by windows on 7/14/2016.
 */
public class UserModel {
    private static final int INIT_DATA_AGENT_RETROFIT = 4;

    private static UserModel objInstance;

    private List<UserVO> mUserList;

    private UserDataAgent dataAgent;

    private UserModel() {
        mUserList = new ArrayList<>();
        initDataAgent();
        dataAgent.loadRegister();
        dataAgent.loadLogin();
    }

    public static UserModel getInstance() {
        if (objInstance == null) {
            objInstance = new UserModel();
        }
        return objInstance;
    }

    private void initDataAgent()
    {
        dataAgent = RetrofitDataAgent.getInstance();
    }

    public List<UserVO> getUserList() {
        return mUserList;
    }

    public void notifyUsersLoaded(List<UserVO> userList) {
        //Notify that the data is ready - using LocalBroadcast
        mUserList = userList;

        //keep the data in persistent layer.
       // UserVO.saveUsers(mUserList);

         broadcastUserLoadedWithEventBus();
        //broadcastAttractionLoadedWithLocalBroadcastManager();
    }
    public void notifyErrorInLoadingUsers(String message) {

    }
    private void broadcastUserLoadedWithEventBus() {
        EventBus.getDefault().post(new DataEvent.UserDataLoadedEvent("extra-in-broadcast", mUserList));
    }
}
