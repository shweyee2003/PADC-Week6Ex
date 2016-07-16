package xyz.aungpyaephyo.padc.myanmarattractions.events;

import java.util.List;

import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.AttractionVO;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.UserVO;

/**
 * Created by aung on 7/9/16.
 */
public class DataEvent {

    public static class AttractionDataLoadedEvent {
        private String extraMessage;
        private List<AttractionVO> attractionList;


        public AttractionDataLoadedEvent(String extraMessage,List<AttractionVO> attractionlist) {
            this.extraMessage = extraMessage;
            this.attractionList=attractionlist;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<AttractionVO> getAttractionList() {
            return attractionList;
        }
    }

    public static class UserDataLoadedEvent{
        private String extraMessage;
        private List<UserVO> userList;

        public UserDataLoadedEvent(String extraMessage,List<UserVO> userList) {
            this.extraMessage = extraMessage;
            this.userList=userList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<UserVO> getUserList() {
            return userList;
        }
    }
}