package fr.istic.vv;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class TLSSocketFactoryTestMocks {
  /**
   * Test quand tout est nul (cas limite)
   */
  @Test
  public void preparedSocket_NullProtocols()  {
    SSLSocket mock = mock(SSLSocket.class);

    when(mock.getSupportedProtocols()).thenReturn(null);
    when(mock.getEnabledProtocols()).thenReturn(null);

    TLSSocketFactory f = new TLSSocketFactory();
    f.prepareSocket(mock);

    // On check que setEnabledProtocols n'est pas appelée
    verify(mock, never()).setEnabledProtocols(any(String[].class));
  }

  /**
   * Test qui check les valeurs + si y'a appel
   */
  @Test
  public void typical() {
    TLSSocketFactory tlsSocketFactory = new TLSSocketFactory();
    SSLSocket mock = mock(SSLSocket.class);

    when(mock.getSupportedProtocols()).thenReturn(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});
    when(mock.getEnabledProtocols()).thenReturn(new String[]{"SSLv3", "TLSv1"});
    tlsSocketFactory.prepareSocket(mock);

    ArgumentCaptor<String[]> argument = ArgumentCaptor.forClass(String[].class);
    // Check que c'est appelé cette fois
    verify(mock).setEnabledProtocols(argument.capture());
    String[] capturedProtocols = argument.getValue();

    //Check des bonnes valeurs
    assertTrue(Arrays.equals(capturedProtocols, new String[]{"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"}));
  }


}
