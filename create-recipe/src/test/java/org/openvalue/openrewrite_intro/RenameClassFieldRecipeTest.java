package org.openvalue.openrewrite_intro;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.java.Assertions.java;

public class RenameClassFieldRecipeTest
   implements RewriteTest
{
   @Test
   void renameFieldRenamesFoundField()
   {
      rewriteRun(
         recipeSpec -> recipeSpec.recipe( new RenameClassFieldRecipe( "x", "y" ) ),
         java(
            """
            package my.test;

            class A
            {
               private final String x = "A";
               int add(final int x, final int y)
               {
                  return x+y;
               }
            }
            """,
            """
            package my.test;

            class A
            {
               private final String y = "A";
               int add(final int x, final int y)
               {
                  return x+y;
               }
            }
            """
         )
      );
   }
}
