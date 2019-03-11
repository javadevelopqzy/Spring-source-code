package mycase.resource.impl;

import java.io.*;

import org.jetbrains.annotations.*;
import org.springframework.core.io.*;
import org.springframework.util.*;

public class AbstractResourceImpl extends AbstractResource {

	private String path;

	public AbstractResourceImpl(String path) {
		this.path = path;
	}

	@NotNull
	@Override
	public String getDescription() {
		return "这是自定义的描述信息";
	}

	// 需要实现
	@NotNull
	@Override
	public InputStream getInputStream() throws IOException {
		File file = getFile();
		return new FileInputStream(file);
	}

	// 父类是空实现，需要覆盖
	@Override
	public String getFilename() {
		return StringUtils.getFilename(path);
	}

	// 父类是空实现，需要覆盖
	@NotNull
	@Override
	public File getFile() throws IOException {
		return ResourceUtils.getFile(ClassLoader.getSystemResource(path));
	}
}
