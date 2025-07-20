package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private ApplicationContext applicationContext;

    @Mock
    private Environment environment;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(applicationContext);
    }

    @Test
    void testFindUsers_shouldReturnUserWithCorrectValues() {
        // Given
        when(applicationContext.getEnvironment()).thenReturn(environment);
        when(applicationContext.getBeanDefinitionNames()).thenReturn(new String[]{"bean1", "bean2"});

        // When
        User result = userService.findUsers("123");

        // Then
        assertNotNull(result);
        assertEquals("Sanjana", result.getName());
        assertEquals(19, result.getAge());

        verify(applicationContext).getEnvironment();
        verify(applicationContext).getBeanDefinitionNames();
    }

    @Test
    void testSayHi_shouldReturnHello() {
        assertEquals("hello", userService.sayHi());
    }
}
