package mycase.scan;

import javax.annotation.*;

import org.springframework.stereotype.*;

@Component
public class ScannerBean {

	@Resource
	private ReferenceBean referenceBean;
}
