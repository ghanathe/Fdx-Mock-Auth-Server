package com.mastercard.fdx.mock.oauth2.server.security.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FdxUserDetailsManagerTest {

    @Mock
    FdxUserService userService;

    @InjectMocks
    FdxUserDetailsManager userManager;

    @Test
    void testUserExistValid() {
        FdxUser expUser = new FdxUser("TESTUSER1", "TESTHASH1");
        when(userService.getUser(anyString())).thenReturn(expUser);

        UserDetails user = userManager.loadUserByUsername(expUser.getUserId());
        assertNotNull(user);
        assertEquals(expUser.getUserId(), user.getUsername());
        assertEquals(expUser.getPasswordHash(), user.getPassword());
    }

    @Test
    void testUserDoesExistValid() {
        when(userService.getUser(anyString())).thenReturn(null);
        assertThrows(UsernameNotFoundException.class, () -> userManager.loadUserByUsername("TEST_NON_EXISTING_USER"));
    }

}