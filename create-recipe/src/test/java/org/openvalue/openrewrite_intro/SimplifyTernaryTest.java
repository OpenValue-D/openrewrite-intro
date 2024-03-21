package org.openvalue.openrewrite_intro;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.java.Assertions.java;

public class SimplifyTernaryTest implements RewriteTest
{
   @Test
   void test()
   {
      rewriteRun(
         recipeSpec -> recipeSpec.recipe( new SimplifyTernaryRecipe() ),
         java(
            """
            package my.test;

            class A
            {
               boolean trueCondition = false ? false : true;
            }
            """,
            """
            package my.test;

            class A
            {
               boolean trueCondition = true;
            }
            """
         )
      );
   }
}
