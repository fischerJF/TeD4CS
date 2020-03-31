// $Id: ActionClassDiagram.java 127 2010-09-25 22:23:13Z marcusvnac $
// Copyright (c) 1996-2008 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies.  This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason.  IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

package org.argouml.uml.ui;

//#if defined(LOGGING)
//@#$LPS-LOGGING:GranularityType:Import
import org.apache.log4j.Logger;
//#endif
import org.argouml.model.Model;
import org.argouml.specifications.Configuration;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramFactory;
import org.argouml.uml.diagram.DiagramSettings;

/**
 * Action to trigger creation of new class diagram.
 */
public class ActionClassDiagram extends ActionAddDiagram {
    //#if defined(LOGGING)
    //@#$LPS-LOGGING:GranularityType:Field
    private static final Logger LOG =
                Logger.getLogger(ActionClassDiagram.class);
    //#endif
    /**
     * Constructor.
     */
    public ActionClassDiagram() {
        super("action.class-diagram");
    }

    /*
     * @see org.argouml.uml.ui.ActionAddDiagram#createDiagram(Object)
     */
    @SuppressWarnings("deprecation")
    @Override
    public ArgoDiagram createDiagram(Object ns) {
        if (isValidNamespace(ns)) {
            return DiagramFactory.getInstance().createDiagram(
                    DiagramFactory.DiagramType.Class,
                    ns,
                    null);
        }
        //#if defined(LOGGING)
        //@#$LPS-LOGGING:GranularityType:Statement
        if(Configuration.LOGGING) {
        	LOG.error("No namespace as argument");
        	LOG.error(ns);
        }
        //#endif
        throw new IllegalArgumentException(
            "The argument " + ns + "is not a namespace.");
    }
    
    /*
     * @see org.argouml.uml.ui.ActionAddDiagram#createDiagram(Object)
     */
    @Override
    public ArgoDiagram createDiagram(Object ns, DiagramSettings settings) {
        if (isValidNamespace(ns)) {
            return DiagramFactory.getInstance().create(
                    DiagramFactory.DiagramType.Class,
                    ns,
                    settings);
        }
        //#if defined(LOGGING)
        //@#$LPS-LOGGING:GranularityType:Statement
        if(Configuration.LOGGING) {
        	LOG.error("No namespace as argument");
        	LOG.error(ns);
        }
        //#endif
        throw new IllegalArgumentException(
            "The argument " + ns + "is not a namespace.");
    }

    
    /*
     * @see org.argouml.uml.ui.ActionAddDiagram#isValidNamespace(Object)
     */
    public boolean isValidNamespace(Object handle) {
        return Model.getFacade().isANamespace(handle);
    }

    /**
     * The UID.
     */
    private static final long serialVersionUID = 2415943949021223859L;
}