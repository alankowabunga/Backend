package com.ginmao;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("com.ginmao")
@IncludeTags("fast")
public class FastTestSuite {
}
