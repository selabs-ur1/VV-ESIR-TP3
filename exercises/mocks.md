# Mocks to the rescue

The classes `SSLSocket`, `TLSProtocol` and `TLSSocketFactory` are included in the `sockets` package of the [`tp3-ssl`](../code/tp3-ssl) project.

The test class `TLSSocketFactoryTest` tests `TLSSocketFactory` and manually builds stubs and mocks for SSLSocket objects.

Rewrite these tests with the help of Mockito.

The initial tests fail to completely test the `TLSSockeetFactory`. In fact, if we *entirely* remove the code inside the body of `prepareSocket` no test case fails.

Propose a solution to this problem in your new Mockito-based test cases.

# Answer

Pour adapter ces tests à l'utilisation de Mockito, nous allons recourir à des objets simulés (mocks) pour reproduire le comportement des objets SSLSocket. Cela nous permettra de contrôler les interactions entre TLSSocketFactory et SSLSocket sans être liés à l'implémentation concrète de SSLSocket.

```java
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.*;

public class TLSSocketFactoryTestMocks {

    @Test
    public void preparedSocket_NullProtocols() {
        // Création du mock SSLSocket
        SSLSocket mockSSLSocket = mock(SSLSocket.class);
        when(mockSSLSocket.getSupportedProtocols()).thenReturn(null);
        when(mockSSLSocket.getEnabledProtocols()).thenReturn(null);

        // Création de l'instance TLSSocketFactory à tester
        TLSSocketFactory tlsSocketFactory = new TLSSocketFactory();

        // Appel de la méthode à tester avec le mock
        tlsSocketFactory.prepareSocket(mockSSLSocket);

        // Vérification qu'aucune méthode de SSLSocket n'a été appelée
        verify(mockSSLSocket, never()).setEnabledProtocols(any());
    }

    @Test
    public void typical() {
        // Création du mock SSLSocket avec les protocoles supportés et activés
        SSLSocket mockSSLSocket = mock(SSLSocket.class);
        when(mockSSLSocket.getSupportedProtocols()).thenReturn(shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
        when(mockSSLSocket.getEnabledProtocols()).thenReturn(shuffle(new String[]{"SSLv3", "TLSv1"}));

        // Création de l'instance TLSSocketFactory à tester
        TLSSocketFactory tlsSocketFactory = new TLSSocketFactory();

        // Appel de la méthode à tester avec le mock
        tlsSocketFactory.prepareSocket(mockSSLSocket);

        // Vérification que la méthode setEnabledProtocols a été appelée avec les protocoles attendus
        verify(mockSSLSocket).setEnabledProtocols(new String[]{"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"});
    }

    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }
}
```

Dans ces scénarios de test, l'utilisation de Mockito se traduit par la création de simulacres (mocks) pour l'interface SSLSocket. Ensuite, nous définissons le comportement de ces mocks à l'aide de la méthode when. Enfin, la méthode verify est employée pour vérifier les appels de méthodes sur les mocks. Cette approche permet d'isoler TLSSocketFactory des particularités de l'implémentation de SSLSocket.
