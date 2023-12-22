# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

Nous sommes sur Apache Commons Math, on execute la commande suivante :

`pmd check -d ./ -R category/java/bestpractices.xml/JUnitUseExpected -r checkStyle.txt`

Ce qui a créé un fichier `checkStyle.txt` avec tous les test smells `JUnitUseExpected`.
Dans le checkStyle, on trouve 801 lignes de l'emplacement du test smell suivi de `JUnitUseExpected:	In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions`.
Afin de fixer cet avertissement, il faut ajouter `@Test(expected = <type d'exception attendu>)` là où on a des tests.

Un exemple de correction serait le suivant : 

Code d'origine :

```java
    // MATH-1151
    @Test
    public void testLazyEvaluationPrecondition() {
        final RealVector dummy = new ArrayRealVector(new double[] { 0 });

        // "ValueAndJacobianFunction" is required but we implement only
        // "MultivariateJacobianFunction".
        final MultivariateJacobianFunction m1 = new MultivariateJacobianFunction() {
                @Override
                public Pair<RealVector, RealMatrix> value(RealVector notUsed) {
                    return new Pair<>(null, null);
                }
            };

        try {
            // Should throw.
            LeastSquaresFactory.create(m1, dummy, dummy, null, null, 0, 0, true, null);
            Assert.fail("Expecting MathIllegalStateException");
        } catch (MathIllegalStateException e) {
            // Expected.
        }

        final MultivariateJacobianFunction m2 = new ValueAndJacobianFunction() {
                @Override
                public Pair<RealVector, RealMatrix> value(RealVector notUsed) {
                    return new Pair<>(null, null);
                }
                @Override
                public RealVector computeValue(final double[] params) {
                    return null;
                }
                @Override
                public RealMatrix computeJacobian(final double[] params) {
                    return null;
                }
            };

        // Should pass.
        LeastSquaresFactory.create(m2, dummy, dummy, null, null, 0, 0, true, null);
    }

```

Code corrigé :


```java
    // MATH-1151
    @Test(expected = MathIllegalStateException.class)
    public void testLazyEvaluationPrecondition() {
        final RealVector dummy = new ArrayRealVector(new double[] { 0 });

        // "ValueAndJacobianFunction" is required but we implement only
        // "MultivariateJacobianFunction".
        final MultivariateJacobianFunction m1 = new MultivariateJacobianFunction() {
            @Override
            public Pair<RealVector, RealMatrix> value(RealVector notUsed) {
                return new Pair<>(null, null);
            }
        };

        // Should throw.
        LeastSquaresFactory.create(m1, dummy, dummy, null, null, 0, 0, true, null);


        final MultivariateJacobianFunction m2 = new ValueAndJacobianFunction() {
                @Override
                public Pair<RealVector, RealMatrix> value(RealVector notUsed) {
                    return new Pair<>(null, null);
                }
                @Override
                public RealVector computeValue(final double[] params) {
                    return null;
                }
                @Override
                public RealMatrix computeJacobian(final double[] params) {
                    return null;
                }
            };

        // Should pass.
        LeastSquaresFactory.create(m2, dummy, dummy, null, null, 0, 0, true, null);
    }

```

On passe bien de 801 violations à 800 violations en appliquant cette modification.
