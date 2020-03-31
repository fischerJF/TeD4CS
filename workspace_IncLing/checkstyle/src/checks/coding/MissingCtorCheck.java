////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code for adherence to a set of rules.
// Copyright (C) 2001-2015 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
////////////////////////////////////////////////////////////////////////////////
package checks.coding;

//import gov.nasa.jpf.annotation.Conditional;
import api.DetailAST;
import api.TokenTypes;
import checks.DescendantTokenCheck;
import specifications.Configuration;

/**
 * <p>
 * Checks that classes (except abstract one) define a ctor and don't rely
 * on the default one.
 * </p>
 * <p>
 * An example of how to configure the check is:
 * </p>
 * <pre>
 * &lt;module name="MissingCtor"/&gt;
 * </pre>
 *
 * @author o_sukhodolsky
 */
public class MissingCtorCheck extends DescendantTokenCheck
{
//	@Conditional
//	private static boolean MissingCtor = true;
	public boolean isEnabled() {
		return Configuration.MissingCtor;
	}
    /**
     * A key is pointing to the warning message text in "messages.properties"
     * file.
     */
    public static final String MSG_KEY = "missing.ctor";

    /** Creates new instance of the check. */
    public MissingCtorCheck()
    {
        setLimitedTokens(new String[] {
            TokenTypes.getTokenName(TokenTypes.CTOR_DEF),
        });
        setMinimumNumber(1);
        setMaximumDepth(2);
        setMinimumMessage(MSG_KEY);
    }

    @Override
    public int[] getDefaultTokens()
    {
        return new int[]{TokenTypes.CLASS_DEF};
    }

    @Override
    public int[] getAcceptableTokens()
    {
        return getDefaultTokens();
    }

    @Override
    public void visitToken(DetailAST ast)
    {
        final DetailAST modifiers = ast.findFirstToken(TokenTypes.MODIFIERS);
        if ((modifiers != null)
            && modifiers.branchContains(TokenTypes.ABSTRACT))
        {
            // should apply the check to abstract class
            return;
        }

        super.visitToken(ast);
    }
}
