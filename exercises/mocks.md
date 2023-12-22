# Mocks to the rescue

The classes `SSLSocket`, `TLSProtocol` and `TLSSocketFactory` are included in the `sockets` package of the [`tp3-ssl`](../code/tp3-ssl) project.

The test class `TLSSocketFactoryTest` tests `TLSSocketFactory` and manually builds stubs and mocks for SSLSocket objects.

Rewrite these tests with the help of Mockito.

The initial tests fail to completely test the `TLSSockeetFactory`. In fact, if we *entirely* remove the code inside the body of `prepareSocket` no test case fails.

Propose a solution to this problem in your new Mockito-based test cases.

# Answer

Grâce à Mockito, nous pouvons vérifier (à l'aide de `verify `si une méthode est appelée ou non. Nous utilisons donc cette fonctionnalité afin de vérifier dans `typical `si `setEnabledProtocols` est appelée dans le cas normal, et si elle ne l'est pas lorsque les Protocols sont nuls. On s'assure donc que la méthode n'est pas vide, dans le cas où les Protocols sont nuls, la méthode va effectivement échouer dans tous les cas, mais dans le cas contraire, s'assurer d'un appel de `setEnabledProtocols` permet de s'assurer que la méthode n'est pas vide.

## PS :

Les codes sont trouvables dans le dossier code puis dans le dossier correspondant à la question.
