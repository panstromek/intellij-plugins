// Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.angular2.lang.expr.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.lang.javascript.psi.JSType;
import com.intellij.lang.javascript.psi.JSVariable;
import com.intellij.lang.javascript.psi.ecmal4.JSAttributeList;
import com.intellij.lang.javascript.psi.impl.JSVariableImpl;
import com.intellij.lang.javascript.psi.stubs.JSVariableStub;
import org.angular2.codeInsight.Angular2TemplateBindingsContextResolver;
import org.angular2.lang.expr.parser.Angular2ElementTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Angular2TemplateVariableImpl extends JSVariableImpl<JSVariableStub<JSVariable>, JSVariable> {

  public Angular2TemplateVariableImpl(ASTNode node) {
    super(node);
  }

  public Angular2TemplateVariableImpl(JSVariableStub<JSVariable> stub) {
    super(stub, Angular2ElementTypes.TEMPLATE_BINDING_VARIABLE);
  }

  @Nullable
  @Override
  protected JSType doGetType() {
    return Angular2TemplateBindingsContextResolver.getVariableType(this);
  }

  @Override
  public boolean isLocal() {
    return true;
  }

  @NotNull
  @Override
  protected JSAttributeList.AccessType calcAccessType() {
    return JSAttributeList.AccessType.PUBLIC;
  }

  @Override
  protected boolean useTypesFromJSDoc() {
    return false;
  }


}
