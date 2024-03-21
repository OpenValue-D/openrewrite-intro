package org.openvalue.openrewrite_intro;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.openrewrite.ExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.TreeVisitor;
import org.openrewrite.java.JavaIsoVisitor;

import java.util.Objects;

public class RenameClassFieldRecipe
   extends Recipe
{
   private String before;
   private String after;

   // All recipes must be serializable. This is verified by RewriteTest.rewriteRun() in your tests.
   @JsonCreator
   public RenameClassFieldRecipe(
      @JsonProperty( "before" ) String before,
      @JsonProperty( "after" ) String after )
   {
      this.before = before;
      this.after = after;
   }

   @Override
   public @NotNull String getDisplayName()
   {
      return "RenameField";
   }

   @Override
   public @NotNull String getDescription()
   {
      return "Rename class field.";
   }

   @Override
   public @NotNull TreeVisitor< ?, ExecutionContext > getVisitor()
   {
      return new RenameFieldVisitor();
   }

   @Override
   public boolean equals( final Object o )
   {
      if( this == o ) {
         return true;
      }
      if( getClass() != o.getClass() ) {
         return false;
      }
      if( !super.equals( o ) ) {
         return false;
      }
      final RenameClassFieldRecipe that = (RenameClassFieldRecipe)o;
      return Objects.equals( before, that.before ) && Objects.equals( after, that.after );
   }

   @Override
   public int hashCode()
   {
      return Objects.hash( super.hashCode(), before, after );
   }

   private class RenameFieldVisitor
      extends JavaIsoVisitor< ExecutionContext >
   {
   }
}
