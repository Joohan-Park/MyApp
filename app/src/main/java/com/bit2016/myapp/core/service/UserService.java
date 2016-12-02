package com.bit2016.myapp.core.service;

import com.bit2016.android.network.JSONResult;
import com.bit2016.myapp.core.domain.User;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joohan on 2016-12-02.
 */

public class UserService {
    public List<User> fetchUserList(){
        String url = "http://192.168.1.82:8088/myapp-api/api/user/list";
        HttpRequest httpRequest = HttpRequest.get(url);
        httpRequest.contentType(HttpRequest.CONTENT_TYPE_JSON);
        httpRequest.accept(HttpRequest.CONTENT_TYPE_JSON);
        httpRequest.connectTimeout(3000);
        httpRequest.readTimeout(3000);

        int responseCode = httpRequest.code();
        if(responseCode != HttpURLConnection.HTTP_OK){
            throw new RuntimeException("HTTP Response:" + responseCode);
        }

        JSONResultUserList jsonResultUserList = fromJSON(httpRequest, JSONResultUserList.class);

        return jsonResultUserList.getData();
    }
    public List<User> fetchUserMockList(){

        List<User> list = new ArrayList<User>();

        User user = new User();
        user.setId( 1L );
        user.setName( "박주한" );
        user.setPhone( "010-3551-4188" );
        user.setEmail( "qkrwngks91@nate.com" );
        user.setProfilePic("https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/547832_446612385410109_420187517_n.jpg?oh=703de95ea4f502c30729173ea6b23a0a&oe=58CB1BA0" );
        user.setStatus( 1 );
        list.add( user );

        return list;
    }

    private class JSONResultUserList extends JSONResult<List<User>>{

    }
    /*
    * Json 문자열을 자바 객체로 변환
    * @param request
    * @param target
    * @param <V>
    * @return
    * */
    protected <V> V fromJSON( HttpRequest request, Class<V> target ) {
        V v = null;

        try {
            Gson gson = new GsonBuilder().create();

            Reader reader = request.bufferedReader();
            v = gson.fromJson(reader, target);
            reader.close();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return v;
    }

}
