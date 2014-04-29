package com.example.switchyard.cdi_alternative_injected;

import javax.enterprise.inject.Alternative;

import com.example.switchyard.cdi_alternative_common.SysoutPrinter;

@Alternative
public class AlternativeSysoutPrinter implements SysoutPrinter {

	@Override
	public void printInSysout(String message) {
		System.out.println("AternativePrinter: " + message);
		
	}

}
