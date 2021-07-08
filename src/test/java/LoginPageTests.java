import org.junit.Assert;
import org.junit.Test;

public class LoginPageTests extends BaseTest{

    //        1. Валидный email и пароль
    @Test
    public void testRegistrationSimple(){
        loginPageObject.clickRegisterButton();
        loginPageObject.typeEmail("bittevamp@yandex.ru");
        loginPageObject.typePassword("bittvamp123");
        loginPageObject.clickSighUpOrSignIn();
        String errorTitle = loginPageObject.getErrorTitleText();
        Assert.assertEquals("Error", errorTitle);
    }

    @Test
    public void testLogInSimple(){
        loginPageObject.clickSignInButton();
        loginPageObject.typeEmail("bittevamp@yandex.ru");
        loginPageObject.typePassword("bittvamp123");
        loginPageObject.clickSighUpOrSignIn();
        String errorTitle = loginPageObject.getErrorTitleText();
        Assert.assertEquals("Error", errorTitle);
    }

    //        2. Валидный email и невалидный пароль
    @Test
    public void testRegistrationBadPassword(){
        loginPageObject.clickRegisterButton();
        loginPageObject.typeEmail("bittevamp@yandex.ru");
        loginPageObject.typePassword("12");
        loginPageObject.clickSighUpOrSignIn();
        loginPageObject.assertSignInPresent();
    }

    //        3. Невалидный email и валидный пароль
    @Test
    public void testRegistrationBadEmail(){
        loginPageObject.clickRegisterButton();
        loginPageObject.typeEmail("bittevamp");
        loginPageObject.typePassword("12euyter");
        loginPageObject.clickSighUpOrSignIn();
        loginPageObject.assertSignInPresent();
    }

    //        4. Пустой email и валидный пароль
    @Test
    public void testRegistrationEmptyEmail(){
        loginPageObject.clickRegisterButton();
        loginPageObject.typePassword("12euyter");
        loginPageObject.clickSighUpOrSignIn();
        loginPageObject.assertSignInPresent();
    }

    //        5. Валидный email и нет пароля
    @Test
    public void testRegistrationNoPassword(){
        loginPageObject.clickRegisterButton();
        loginPageObject.typeEmail("bittevamp@yandex.ru");
        loginPageObject.clickSighUpOrSignIn();
        loginPageObject.assertSignInPresent();
    }

    //        6. Пустой email и Пустой пароль
    @Test
    public void testRegistrationEmptyEmailAndPassword(){
        loginPageObject.clickRegisterButton();
        loginPageObject.clickSighUpOrSignIn();
        loginPageObject.assertSignInPresent();
    }
}
