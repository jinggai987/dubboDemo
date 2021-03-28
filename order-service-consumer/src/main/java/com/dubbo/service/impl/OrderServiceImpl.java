package com.dubbo.service.impl;

import com.dubbo.bean.UserAddress;
import com.dubbo.service.OrderService;
import com.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 2）、配置服务提供者
 * <p>
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 * <p>
 * 3.dubbo配置覆盖策略
 * 3.1 jvm启动-D [-Ddubbo.protocol.port=20882]
 * 3.2 application.properties
 * 3.3 dubbo.properties
 * <p>
 * 4.所有属性的配置优先级，以timeout为例
 * 4.1 消费者method方法上timeout配置
 * 4.2 提供者method方法上timeout配置
 * 4.3 消费者接口上timeout配置
 * 4.4 提供者接口上timeout配置
 * 4.5 消费者xml全局配置<dubb0:consumer timeout=""></dubb0:consumer>
 * 4.6 提供者xml全局配置<dubb0:provider timeout=""></dubb0:consumer>
 * 总结：方法级优先，接口级次之，全局配置再次之；如果级别一样，则消费方优先，提供方次之。
 *
 * 5.retries重试次数设置
 *  retries="":重试次数，不包含第一次调用，0代表不重试
 * 	幂等（设置重试次数）【查询、删除、修改】、非幂等（不能设置重试次数）【新增】
 *
 * @author lfy
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        // TODO Auto-generated method stub
        System.out.println("用户id：" + userId);
        //1、查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        for (UserAddress userAddress : addressList) {
            System.out.println(userAddress.getUserAddress());
        }
        return addressList;
    }

}
