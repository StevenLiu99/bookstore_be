package com.lwt.bookstore_be.controller;

import com.lwt.bookstore_be.constant.Constant;
import com.lwt.bookstore_be.entity.UserAuthEntity;
import com.lwt.bookstore_be.service.UserService;
import com.lwt.bookstore_be.utils.msgutils.Msg;
import com.lwt.bookstore_be.utils.msgutils.MsgCode;
import com.lwt.bookstore_be.utils.msgutils.MsgUtil;
import com.lwt.bookstore_be.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    //public Msg login(@RequestParam(Constant.USERNAME) String username, @RequestParam(Constant.PASSWORD) String password, @RequestParam(Constant.REMEMBER_ME) Boolean remember){
    public Msg login(@RequestBody Map<String, String> params){
        String username = params.get(Constant.USERNAME);
        String password = params.get(Constant.PASSWORD);
        UserAuthEntity auth = userService.checkUser(username, password);



        if(auth != null){

            if(auth.getUserState() == 1){
                return MsgUtil.makeMsg(MsgCode.LOGIN_USER_BANNED);
            }
            JSONObject obj = new JSONObject();
            obj.put(Constant.USER_ID, auth.getUserId());
            obj.put(Constant.USERNAME, auth.getUsername());
            obj.put(Constant.USER_TYPE, auth.getUserType());
            SessionUtil.setSession(obj);

            JSONObject data = JSONObject.fromObject(auth);
            data.remove(Constant.PASSWORD);

            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, data);
        }
        else{
            return MsgUtil.makeMsg(MsgCode.LOGIN_USER_ERROR);
        }
    }

    @RequestMapping("/logout")
    public Msg logout(){
        Boolean status = SessionUtil.removeSession();

        if(status){
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGOUT_SUCCESS_MSG);
        }
        return MsgUtil.makeMsg(MsgCode.ERROR, MsgUtil.LOGOUT_ERR_MSG);
    }

    /**
     * @Description: getSession
     * @Param: null
     * @return: Msg
     * @Author: thunderBoy
     */
    @RequestMapping("/checkSession")
    public Msg checkSession(){
        JSONObject auth = SessionUtil.getAuth();

        if(auth == null){
            return MsgUtil.makeMsg(MsgCode.NOT_LOGGED_IN_ERROR);
        }
        else{
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, auth);
        }
    }



}