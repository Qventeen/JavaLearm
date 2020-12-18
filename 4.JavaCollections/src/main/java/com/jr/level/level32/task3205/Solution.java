package com.jr.level.level32.task3205;

import java.lang.reflect.Proxy;

/*
Создание прокси-объекта
*/
public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {
        //Создать экземпляр интефрейса
        SomeInterfaceWithMethods someInterfaceWithMethods = new SomeInterfaceWithMethodsImpl();
        //Вызвать статический метод построения прокси
        return (SomeInterfaceWithMethods) Proxy.newProxyInstance(
                //Передать загрузчик для проксируемого класса
                SomeInterfaceWithMethodsImpl.class.getClassLoader(),
                //Передать интерфейсы для проксируемого класса
                SomeInterfaceWithMethodsImpl.class.getInterfaces(),
                //Передать подготовленный обработчик вызовов
                new CustomInvocationHandler(someInterfaceWithMethods)
        );
    }
}
