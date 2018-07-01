package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mymanager.config.AppIcon;

public class ImageLoadingTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testIconLoading() {
		AppIcon.getIcon(AppIcon.adressIcon);
		System.out.println("-getIcon() is working");
		AppIcon.getImageIcon(AppIcon.adressIcon);
		System.out.println("-getImageIcon() is working");
	}

	@Test
	public final void testImageLoading() {
		AppIcon.getImage(AppIcon.adressIcon);
		System.out.println("-getImage() is working");
	}

}
