package mycase.resource;

import org.springframework.core.io.AbstractResource;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AbstractResourceImpl extends AbstractResource {

	private String path;

	public AbstractResourceImpl(String path) {
		this.path = path;
	}

	@Override
	public String getDescription() {
		return "这是自定义的描述信息";
	}

	// 子类需要实现
	@Override
	public InputStream getInputStream() throws IOException {
		File file = getFile();
		return new FileInputStream(file);
	}

	// 父类是空实现
	@Override
	public String getFilename() {
		return StringUtils.getFilename(path);
	}

	// 父类是空实现，需要手动实现
	@Override
	public File getFile() throws IOException {
		return ResourceUtils.getFile(path);
	}
}
