package fr.istic.vv;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mock.*;
import org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TLSSocketFactoryTestMocks {

    // @Mock
    // SSLSocket s;
    // TLSSocketFactory f;

    
    TLSSocketFactory f = mock(TLSSocketFactory.class);
    SSLSocket s = mock(SSLSocket.class);
    
    @Test
    public void preparedSocket_NullProtocols() {

        f = new TLSSocketFactory();

        when(s.getEnabledProtocols()).thenReturn(null);
        when(s.getSupportedProtocols()).thenReturn(null);
        verify(s, never()).setEnabledProtocols(any(String[].class));
    }

    @Test
    public void typical() {

        f = new TLSSocketFactory();

        when(s.getEnabledProtocols()).thenReturn(TLSSocketFactoryTest.shuffle(new String[] { "SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2" }));
        when(s.getSupportedProtocols()).thenReturn(TLSSocketFactoryTest.shuffle(new String[] { "SSLv3", "TLSv1" }));
        verify(s, times(1)).setEnabledProtocols(any(String[].class));
    }

}