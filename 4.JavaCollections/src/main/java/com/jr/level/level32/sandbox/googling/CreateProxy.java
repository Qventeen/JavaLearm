package com.jr.level.level32.sandbox.googling;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class CreateProxy {
    interface SomeInterface {
        void execute();
        String getName();
    }

    public static class SomeInterfaceImpl implements SomeInterface {
        @Override
        public void execute(){
            System.out.println("My name is ");
        }

        @Override
        public String getName(){
            return Thread.currentThread().getName();
        }
    }

    public static class SomeInvocationHandler implements InvocationHandler{
        private SomeInterface someInterface;
        public SomeInvocationHandler(SomeInterface someInterface){
            this.someInterface = someInterface;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
            System.out.println("InvokeHandler invoke");
            return method.invoke(someInterface,args);
        }
    }

    public static void main(String[] args) {
        SomeInterface i = new SomeInterfaceImpl();
        InvocationHandler h = new SomeInvocationHandler(i);
        SomeInterface proxy = (SomeInterface) Proxy.newProxyInstance(
                SomeInterfaceImpl.class.getClassLoader(),
                SomeInterfaceImpl.class.getInterfaces(),
                h
        );
        proxy.execute();
        System.out.println(proxy.getName());
    }
}
