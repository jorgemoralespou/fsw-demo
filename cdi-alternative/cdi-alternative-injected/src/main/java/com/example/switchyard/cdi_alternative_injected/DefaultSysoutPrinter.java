package com.example.switchyard.cdi_alternative_injected;

import com.example.switchyard.cdi_alternative_common.SysoutPrinter;

public class DefaultSysoutPrinter implements SysoutPrinter {

	@Override
	public void printInSysout(String message) {
		System.out.println("DefaultPrinter: " + message);
		
	}

}
