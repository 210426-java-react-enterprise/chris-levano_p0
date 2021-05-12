package com.revature.p0.util;

import com.revature.p0.daos.AccountsDAO;
import com.revature.p0.daos.UserDAO;
import com.revature.p0.exceptions.InvalidRequestException;
import com.revature.p0.models.AppUser;
import com.revature.p0.services.UserService;
import com.revature.p0.services.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ServiceTest {
    private UserService sut;
    private UserDAO mockUserDao;
    private AccountsDAO mockAccountDao;

    @Before
    public void setup() {
        mockUserDao = mock(UserDAO.class);
        mockAccountDao = mock(AccountsDAO.class);
        sut = new UserService(mockUserDao, mockAccountDao);
    }

    @After
    public void tearDown() {
        mockUserDao = null;
        mockAccountDao = null;
        sut = null;
    }

    @Test
    public void test_withValidUserAndAvailablePassword() {
        //Arrange
        AppUser expectedResult = new AppUser("username", "password", "user@name.mail",
                "first", "last", 22);

        String user = expectedResult.getUsername();
        String pass = expectedResult.getPassword();
        String email = expectedResult.getEmail();
        String first = expectedResult.getFirstName();
        String last = expectedResult.getLastName();
        int age = expectedResult.getAge();

        //Act
        AppUser actualResult = new AppUser(user, pass, email, first, last, age);

        //Assert

    }
    @Test
    public void test_registerUserWithValidButTakenUsername() {
        //Arrange
        when(mockUserDao.isUsernameAvailable(anyString())).thenReturn(false);
        when(mockUserDao.isEmailAvailable(anyString())).thenReturn(true);
        //Act
        try {
            sut.register(new AppUser("un", "pw", "something@mail.com",
                    "fn", "ln", 23));
        } catch (Exception e) {
            assertTrue(e instanceof Exception);
        } finally {
            verify(mockUserDao, times(0)).save(any());
        }
    }
    @Test
    public void test_registerUserWithTakenButValidUsername() {
        //Arrange
        when(mockUserDao.isUsernameAvailable(anyString())).thenReturn(true);
        when(mockUserDao.isEmailAvailable(anyString())).thenReturn(false);
        //Act
        try {
            sut.register(new AppUser("un", "pw", "something@mail.com",
                    "fn", "ln", 23));
        } catch (Exception e) {
            assertTrue(e instanceof Exception);
        } finally {
            verify(mockUserDao, times(0)).save(any());
        }

    }
    /*
    @Test
    public void test_registerUserWithTooLongUsername() {
        try {
            sut.register(new AppUser("un", "pw", "something@mail.com",
                    "fn", "ln", 22));
            UserService.isUserValid();
        } catch (Exception e) {
            assertTrue(e instanceof Exception);
    }

     */
}
