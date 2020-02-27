package com.codegym.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InterfaceAddress;

public class CustomInvocationHandler implements InvocationHandler {
    SomeInterfaceWithMethods someInterfaceWithMethods;
    public CustomInvocationHandler(SomeInterfaceWithMethods someInterfaceWithMethods) {
        this.someInterfaceWithMethods = someInterfaceWithMethods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
        Object obj = method.invoke(someInterfaceWithMethods,args);
        System.out.println(method.getName() + " out");

        return obj;
    }

}
