package com.jr.level.level14.task1417;

public class USD extends Money {
	public USD(double amount){
		super(amount);
	}

	@Override
	public String getCurrencyName() {
		return getClass().getSimpleName();
	}
}
