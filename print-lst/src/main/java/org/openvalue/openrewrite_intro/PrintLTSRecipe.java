package org.openvalue.openrewrite_intro;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.jetbrains.annotations.NotNull;
import org.openrewrite.ExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.TreeVisitor;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.TreeVisitingPrinter;
import org.openrewrite.java.tree.J;

public class PrintLTSRecipe
   extends Recipe
{

   // All recipes must be serializable. This is verified by RewriteTest.rewriteRun() in your tests.
   @JsonCreator
   public PrintLTSRecipe()
   {
   }

   @Override
   public @NotNull String getDisplayName()
   {
      return "PrintLTS";
   }

   @Override
   public @NotNull String getDescription()
   {
      return "Make use of TreeVisitingPrinter.";
   }

   @Override
   public @NotNull TreeVisitor< ?, ExecutionContext > getVisitor()
   {
      return new PrintLTS();
   }

   public static class PrintLTS
      extends JavaIsoVisitor< ExecutionContext >
   {
      @Override
      public J.@NotNull ClassDeclaration visitClassDeclaration( J.@NotNull ClassDeclaration classDecl, @NotNull ExecutionContext executionContext )
      {
         System.out.println( TreeVisitingPrinter.printTree( getCursor() ) );
         return classDecl;
      }
   }

}
