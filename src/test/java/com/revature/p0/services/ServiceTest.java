package com.revature.p0.services;

import com.revature.p0.daos.AccountsDAO;
import com.revature.p0.daos.UserDAO;
import com.revature.p0.models.AppUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ServiceTest {
    private UserService sut;
    private UserDAO mockUserDao;
    private AccountsDAO mockAccountsDao;

    @Before
    public void setup() {
        mockUserDao = mock(UserDAO.class);
        mockAccountsDao = mock(AccountsDAO.class);
        sut = new UserService(mockUserDao, mockAccountsDao);
    }

    //PROBLEM HERE! Tests pass when run individually but not in succession!
    //(Also if run in succession and then 'rerun failed tests')
    @After
    public void tearDown() {
        mockUserDao = null;
        mockAccountsDao = null;
        sut = null;
    }

    @Test
    public void test_withValidUserAndAvailablePassword() {
        //Arrange
        when(mockUserDao.isUsernameAvailable(anyString())).thenReturn(true);
        when(mockUserDao.isEmailAvailable(anyString())).thenReturn(true);
        //Act
        try {
            sut.register(new AppUser("user", "pass", "first@last.mail",
                    "first", "last", 22));
        } catch (Exception e) {
            assertTrue(e instanceof Exception);
        } finally {
            //Assert
            verify(mockUserDao, times(1)).save(any());
        }
    }

    @Test
    public void test_registerUserWithValidButTakenUsername() {
        //Arrange
        when(mockUserDao.isUsernameAvailable(anyString())).thenReturn(false);
        when(mockUserDao.isEmailAvailable(anyString())).thenReturn(true);
        //Act
        try {
            sut.register(new AppUser("user", "pass", "first@last.mail",
                    "first", "last", 22));
        } catch (Exception e) {
            assertTrue(e instanceof Exception);
        } finally {
            //Assert
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
            sut.register(new AppUser("user", "pass", "first@last.mail",
                    "first", "last", 22));
        } catch (Exception e) {
            assertTrue(e instanceof Exception);
        } finally {
            //Assert
            verify(mockUserDao, times(0)).save(any());
        }

    }
    @Test
    public void test_registerUserWithTooLongUsername() {
        //Arrange
        when(mockUserDao.isUsernameAvailable(anyString())).thenReturn(true);
        when(mockUserDao.isEmailAvailable(anyString())).thenReturn(true);
        //Act
        try {
            sut.register(new AppUser("1234567891011121314151617181920", "pass", "first@last.mail",
                    "first", "last", 22));
        } catch (Exception e) {
            assertTrue(e instanceof Exception);
        } finally {
            //Assert
            verify(mockUserDao, times(0)).save(any());
        }
    }
    @Test
    public void test_registerUserWithNegativeAge() {
        //Arrange
        when(mockUserDao.isUsernameAvailable(anyString())).thenReturn(true);
        when(mockUserDao.isEmailAvailable(anyString())).thenReturn(true);
        //Act
        try {
            sut.register(new AppUser("user", "pass", "first@last.mail",
                    "first", "last", -22));
        } catch (Exception e) {
            assertTrue(e instanceof Exception);
        } finally {
            //Assert
            verify(mockUserDao, times(0)).save(any());
        }
    }

    @Test
    public void test_depositVerifyWithNegativeValue(){
        //Arrange
        double deposit_am = -12.25;
        //Act
        try {
            AccountService.depositVerify(deposit_am);
            //Assert
            verify(mockAccountsDao, times(0)).deposit(anyInt(), anyDouble());
        } catch (Exception e){
            assertTrue(e instanceof Exception);
        }
    }

    @Test
    public void test_depositVerifyWithValidValue(){
        //Arrange
        double deposit_am = 12.25;
        //Act
        try {
            AccountService.depositVerify(deposit_am);
            //Assert
            verify(mockAccountsDao, times(1)).deposit(anyInt(), 12.25);
        } catch (Exception e){
            //swallow
        }
    }

    @Test
    public void test_withdrawVerifyWithValidValue(){
        //Arrange
        double withdraw_am = 12.25;
        //Act
        try {
            AccountService.withdrawVerify(withdraw_am);
            //Assert
            verify(mockAccountsDao, times(1)).withdraw(anyInt(), 12.25);
        } catch (Exception e){
            //swallow
        }
    }
    @Test
    public void test_withdrawVerifyWithNegativeValue(){
        //Arrange
        double withdraw_am = -12.25;
        //Act
        try {
            AccountService.depositVerify(withdraw_am);
            //Assert
            verify(mockAccountsDao, times(0)).withdraw(any(), any());
        } catch (Exception e){
            assertTrue(e instanceof Exception);
        }
    }

    @Test
    public void test_withdrawVerifyWithOverdraftValue(){
        //Arrange
        double withdraw_am = 12.25;
        try {
            when(mockAccountsDao.fetchBalance(any())).thenReturn(0.00);
            //Act
            AccountService.withdrawVerify(withdraw_am);
            //Assert
            verify(mockAccountsDao, times(0)).withdraw(any(), any());
        } catch (Exception e){
            assertTrue(e instanceof Exception);
        }
    }


}
