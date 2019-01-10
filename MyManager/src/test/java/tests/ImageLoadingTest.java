package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mymanager.config.AppIcon;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class ImageLoadingTest {

	private Object obj;

	@Before
	public void setUp() throws Exception {

		obj = new AppIcon();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testLoading1() {
		AppIcon.getIcon(AppIcon.adressIcon);
		System.out.println("-getIcon() is working");
		AppIcon.getImageIcon(AppIcon.adressIcon);
		System.out.println("-getImageIcon() is working");
		AppIcon.getImage(AppIcon.adressIcon);
		System.out.println("-getImage() is working");
	}

	@Test
	public final void testLoading2() {
		obj = new AppIcon();
		AppIcon.getIcon(this, AppIcon.testIcon);
		System.out.println("-getIcon(obj) is working");
		AppIcon.getImageIcon(this, AppIcon.testIcon);
		System.out.println("-getImageIcon(obj) is working");
		AppIcon.getImage(this, AppIcon.testIcon);
		System.out.println("-getImage(obj) is working");
	}

}
