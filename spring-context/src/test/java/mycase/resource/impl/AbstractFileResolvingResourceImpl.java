package mycase.resource.impl;

import java.io.*;
import java.net.*;

import org.springframework.core.io.*;

public class AbstractFileResolvingResourceImpl extends AbstractFileResolvingResource {

	private String path;

	public AbstractFileResolvingResourceImpl(String path) {
		this.path = path;
	}

	@Override
	public String getDescription() {
		return "自定义资源提示";
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return ClassLoader.getSystemResourceAsStream(path);
	}

	// 父类通过URL解析File，因此这个方法需要实现
	@Override
	public URL getURL() throws IOException {
		return ClassLoader.getSystemResource(path);
	}
}
