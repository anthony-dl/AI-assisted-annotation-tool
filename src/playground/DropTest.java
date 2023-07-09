/*
* DropTest.java
* A simple drop tester application
*/
import java.awt.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class DropTest extends JFrame {
    DropTarget dt;
    JTextArea ta;
    public DropTest( ) {
	super("Drop Test");
	setSize(300,300);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	// Make a quick label for instructions and create the
	// text area component
	getContentPane( ).add(
			      new JLabel("Drop a list from your file chooser here:"),
			      BorderLayout.NORTH);
	ta = new JTextArea( );
	getContentPane( ).add(ta, BorderLayout.CENTER);
	// Set up our text area to recieve drops.
	// This class handles drop events.
	dt = new DropTarget(ta, new DebugDropListener( ));
	setVisible(true);
    }
    public class DebugDropListener implements DropTargetListener {
	// For now, we'll just report ancilliary events to the console,
	// including dragEnter, dragExit, dragOver, and dropActionChanged.
	public void dragEnter(DropTargetDragEvent dtde) {
	    System.out.println("Drag Enter");
	}
	public void dragExit(DropTargetEvent dte) {
	    System.out.println("Drag Exit");
	}
	public void dragOver(DropTargetDragEvent dtde) {
	    System.out.println("Drag Over");
	}
	public void dropActionChanged(DropTargetDragEvent dtde) {
	    System.out.println("Drop Action Changed");
	}
	public void drop(DropTargetDropEvent dtde) {
	    try {
		// Get the dropped object and try to figure out what it is.
		Transferable tr = dtde.getTransferable( );
		DataFlavor[] flavors = tr.getTransferDataFlavors( );
		for (int i = 0; i < flavors.length; i++) {
		    System.out.println("Possible flavor: " + flavors[i].getMimeType( ));
		    // Check for file lists specifically.
		    if (flavors[i].isFlavorJavaFileListType( )) {
			// Great! Accept copy drops.
			dtde.acceptDrop(DnDConstants.ACTION_COPY);
			ta.setText("Successful file list drop.\n\n");
			// Add the list of filenames to our text area.
			java.util.List list =
			    (java.util.List)tr.getTransferData(flavors[i]);
			for (int j = 0; j < list.size( ); j++) {
			    ta.append(list.get(j) + "\n");
			    
			}
			// If we made it this far, everything worked.
			dtde.dropComplete(true);
			return;
		    }
		}
		// Hmm, the user must not have dropped a file list.
		System.out.println("Drop failed: " + dtde);
		dtde.rejectDrop( );
	    } catch (UnsupportedFlavorException e) {
		e.printStackTrace( );
		dtde.rejectDrop( );
	    } catch (InvalidDnDOperationException e) {
		e.printStackTrace( );
		dtde.rejectDrop( );
	    } catch (IOException e) {
		e.printStackTrace( );
		dtde.rejectDrop( );
	    }
	}
    }
    public static void main(String args[]) {
	new DropTest( );
    }
}
