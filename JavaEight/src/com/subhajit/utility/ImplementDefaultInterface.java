package com.subhajit.utility;

import com.subhajit.plain.interfaces.DefaultMethodInterface;
import com.subhajit.plain.interfaces.DefaultMethodInterfaceTwo;

public class ImplementDefaultInterface implements DefaultMethodInterface, DefaultMethodInterfaceTwo{

	
	@Override
	public void getName() {
		DefaultMethodInterface.super.getName();
		DefaultMethodInterfaceTwo.super.getName();
	}

}
