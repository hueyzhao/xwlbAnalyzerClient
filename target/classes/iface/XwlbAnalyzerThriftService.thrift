namespace java com.awesomehuan.xwlbAnalyzer.thrift.iface

include '../base/fb303.thrift'

service XwlbAnalyzerThriftService extends fb303.FacebookService {
	void test();
}