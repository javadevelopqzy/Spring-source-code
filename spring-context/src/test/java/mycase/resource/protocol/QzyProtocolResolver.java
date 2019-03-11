package mycase.resource.protocol;

import org.jetbrains.annotations.*;
import org.springframework.core.io.*;

public class QzyProtocolResolver implements ProtocolResolver {

	public static final String QZY_PROTOCOL_PREFIX = "qzy://";

	@Override
	public Resource resolve(@NotNull String location, @NotNull ResourceLoader resourceLoader) {
		// 属于qzy协议，使用自己的方式解析
		if (location.startsWith(QZY_PROTOCOL_PREFIX)) {
			location = location.substring(QZY_PROTOCOL_PREFIX.length());
			return new ClassPathResource(location);
		}
		return null;
	}
}
