package com.jr.level.level26.task2613;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static final Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() { /*NonInstantiable Utility class*/}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        return map.computeIfAbsent(currencyCode.toUpperCase(), CurrencyManipulator::new);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return Collections.unmodifiableCollection(map.values());
    }

}
