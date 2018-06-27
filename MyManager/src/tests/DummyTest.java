package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mymanager.data.models.Additional;
import com.mymanager.data.models.MyModel;
import com.mymanager.data.models.User;

public class DummyTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test() {
		MyModel model = new Additional();

		if (model instanceof MyModel) {
			System.out.println(model instanceof User);
		}
	}

}
