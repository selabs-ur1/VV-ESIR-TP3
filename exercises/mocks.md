# Mocks to the rescue

The classes `SSLSocket`, `TLSProtocol` and `TLSSocketFactory` are included in the `sockets` package of the [`tp3-ssl`](../code/tp3-ssl) project.

The test class `TLSSocketFactoryTest` tests `TLSSocketFactory` and manually builds stubs and mocks for SSLSocket objects.

Rewrite these tests with the help of Mockito.

The initial tests fail to completely test the `TLSSockeetFactory`. In fact, if we *entirely* remove the code inside the body of `prepareSocket` no test case fails.

Propose a solution to this problem in your new Mockito-based test cases.

## Answer

Grâce aux mocks, lorsqu'on retire le code de la fonction `prepareSocket`, les tests ne passent plus car il manque des appels de fonction. Mockito permet donc de réellement tester les appels de fonction et donc de ne pas faire passer des tests même lorsqu'on retire le code des fonctions.
