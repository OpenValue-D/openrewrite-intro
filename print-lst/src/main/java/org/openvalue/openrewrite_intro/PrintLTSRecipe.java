package org.openvalue.openrewrite_intro;

import com.fasterxml.jackson.annotation.JsonCreator;
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
   public String getDisplayName()
   {
      return "PrintLTS";
   }

   @Override
   public String getDescription()
   {
      return "Make use of TreeVisitingPrinter.";
   }

   @Override
   protected TreeVisitor< ?, ExecutionContext > getVisitor()
   {
      return new PrintLTS();
   }

   public class PrintLTS
      extends JavaIsoVisitor< ExecutionContext >
   {
      @Override
      public J.ClassDeclaration visitClassDeclaration( J.ClassDeclaration classDecl, ExecutionContext executionContext )
      {
         System.out.println( TreeVisitingPrinter.printTree( getCursor() ) );
         return classDecl;
      }
   }

}
