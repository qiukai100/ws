package com.example.ws.service.impl;

import com.example.ws.domain.Clothes;
import com.example.ws.domain.User;
import com.example.ws.service.WsTestService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@Service
@WebService(serviceName = "wsTestService", targetNamespace = "http://impl.service.ws.example.com",
        endpointInterface = "com.example.ws.service.WsTestService")
public class WsTestServiceImpl implements WsTestService {

    private static List<User> userList = new ArrayList<>();

    static {
        Clothes clothes1 = new Clothes().setColor("红色").setSize("小号");
        Clothes clothes2 = new Clothes().setColor("蓝色").setSize("中号");
        List<Clothes> clothesList = new ArrayList<>();
        clothesList.add(clothes1);
        clothesList.add(clothes2);
        User user1 = new User().setName("赵铁柱").setAge("18").setClothesList(clothesList);
        User user2 = new User().setName("王翠花").setAge("27").setClothesList(clothesList);
        userList.add(user1);
        userList.add(user2);
    }

    @Override
    public List<User> userCall() {
        return userList;
    }

    @Override
    public String getUserName(String name) {
        return name;
    }
}
