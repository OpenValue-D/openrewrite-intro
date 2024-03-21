package org.openvalue.openrewrite_intro;

import com.google.errorprone.refaster.annotation.AfterTemplate;
import com.google.errorprone.refaster.annotation.BeforeTemplate;

public class SimplifyTernary
{
   @BeforeTemplate
   boolean before(boolean expr) {
      return expr ? false : true;
   }

   @AfterTemplate
   boolean after(boolean expr) {
      return !(expr);
   }
}
