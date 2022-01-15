import adavance.AdvanceConfig;
import dto.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AdvanceConfig {

  @Test
    public void loginTest(){

        boolean isFabPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("john001@gmail.com")
                .fillPassword("")
                .clickLoginButton()
                .skipWizard()
                .isFabAddButtonPresent();

        Assert.assertTrue(isFabPresent);
    }

   @Test
    public void loginTest2(){

        boolean isFabPresent = new LoginScreen(driver)
                .fillEmail("john111@gmail.com")
                .fillPassword("Jj123456$")
                .clickLoginButton()
                .skipWizard()
                .isFabAddButtonPresent();

        Assert.assertTrue(isFabPresent);
    }

  @Test
    public void loginComplex(){
        Credentials credentials = Credentials.builder()
                .email("john111@gmail.com")
                .password("Jj123456$")
                .build();

        boolean isFabPresent =
                new LoginScreen(driver)
                        .loginComplex(credentials)
                        .skipWizard()
                        .isFabAddButtonPresent();

        Assert.assertTrue(isFabPresent);


    }

}
