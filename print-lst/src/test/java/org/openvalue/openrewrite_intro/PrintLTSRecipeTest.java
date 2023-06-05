package org.openvalue.openrewrite_intro;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.java.Assertions.java;

public class PrintLTSRecipeTest implements RewriteTest
{
   @Override
   public void defaults( final RecipeSpec spec )
   {
      spec.recipe( new PrintLTSRecipe() );
   }

   @Test
   void printLTS() {
      rewriteRun( java( """
                        package my.test;
                        
                        class A
                        {
                           int add(final int a, final int b)
                           {
                              return a+b;
                           }
                        }
                        """) );
   }
}
