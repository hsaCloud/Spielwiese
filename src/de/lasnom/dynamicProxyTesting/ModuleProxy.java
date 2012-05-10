package de.lasnom.dynamicProxyTesting;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ModuleProxy<T> implements InvocationHandler {
	final T underlying;
	final ISecurity security;

	public ModuleProxy(T underlying, ISecurity security) {
		this.underlying = underlying;
		this.security = security;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("SecurityProxy verifying request for.. " + method.getName() + " -> " + security.verifyRequest());
		
		security.verifyRequest();
		
		StringBuffer sb = new StringBuffer();
		sb.append(method.getName());
		sb.append("(");
		for (int i = 0; args != null && i < args.length; i++) {
			if (i != 0)
				sb.append(", ");
			sb.append(args[i]);
		}
		sb.append(")");
		Object ret = method.invoke(underlying, args);
		if (ret != null) {
			sb.append(" -> ");
			sb.append(ret);
		}
		System.out.println(sb);
		
		return ret;
	}

}
