/**
 * MVEL 2.0
 * Copyright (C) 2007 The Codehaus
 * Mike Brock, Dhanji Prasanna, John Graham, Mark Proctor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mvel2.ast;

import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;

/**
 * @author Christopher Brock
 */
public class IndexedDeclTypedVarNode extends ASTNode implements Assignment {
  private int register;

  public IndexedDeclTypedVarNode(int register, char[] expr, int start, int offset, Class type, ParserContext pCtx) {
    super(pCtx);
    this.egressType = type;
    this.expr = expr;
    this.start = start;
    this.offset = offset;
    this.register = register;
  }

  public Object getReducedValueAccelerated(Object ctx, Object thisValue, VariableResolverFactory factory) {
    factory.createIndexedVariable(register, null, egressType);
    return ctx;
  }

  public Object getReducedValue(Object ctx, Object thisValue, VariableResolverFactory factory) {
    factory.createIndexedVariable(register, null, egressType);
    return null;
  }

  public String getAssignmentVar() {
    return null;
  }

  public char[] getExpression() {
    return new char[0];
  }

  public boolean isAssignment() {
    return true;
  }

  public boolean isNewDeclaration() {
    return true;
  }

  public void setValueStatement(ExecutableStatement stmt) {
    throw new RuntimeException("illegal operation");
  }
}