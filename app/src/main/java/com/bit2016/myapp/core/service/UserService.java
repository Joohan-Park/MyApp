package com.bit2016.myapp.core.service;

import com.bit2016.myapp.core.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joohan on 2016-12-02.
 */

public class UserService {
    public List<User> fetchUserList(){

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
}
