package desktopsearcher;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import specifications.Configuration;


public class Index_History_Selector extends Dialog {
	private static final long serialVersionUID = 1L;

	public JRadioButton historyRadioButton;
	public JPanel historyGroupBox;
	public JList historyList;

	public JRadioButton browseRadioButton;
	public JPanel browseGroupBox;
	public JButton startBrowseButton;
	public JTextField newRootTextField;

	public JButton okButton;
	public JButton abortButton;

	public String selectedPath = "";
	private Container container;
	private GridBagConstraints constraints_Container;

	public Index_History_Selector(JFrame parents, String[] history_list)
			throws HeadlessException {
		super(parents, true);
		if (Configuration.GUI) {
			if (Configuration.INDEX_HISTORY) {
				this.setTitle("Index Selection");
				this.setMinimumSize(new Dimension(300, 350));

				ArrayList path = ((MainFrame) parents).index_History;
				String[] path_StringAr = new String[path.size()];

				for (int i = 0; i < path_StringAr.length; i++) {
					path_StringAr[i] = (String) path.get(i);
				}

				history_list = path_StringAr;

				container = this;
				container.setLayout(new GridBagLayout());

				History_Indexer his_indexer = new History_Indexer(this, null);

				// RadioButtons
				historyRadioButton = new JRadioButton("", true);
				historyRadioButton.setName("radioHistory"); //INSERTED CODE
				browseRadioButton = new JRadioButton("", false);
				browseRadioButton.setName("radioBrowse"); //INSERTED CODE
				historyRadioButton.addActionListener(his_indexer);
				browseRadioButton.addActionListener(his_indexer);
				ButtonGroup bgroup = new ButtonGroup();
				bgroup.add(historyRadioButton);
				bgroup.add(browseRadioButton);

				// init GUI
				buildGUI(his_indexer, history_list);

				// init enable....
				historyRadioButton.doClick();

				show();
			}
		}
	}

	void buildGUI(History_Indexer his_indexer, String[] history_List) {
		if (Configuration.GUI) {
			if (Configuration.INDEX_HISTORY) {
				createGroupBoxHistory(his_indexer, history_List);
				createGroupBoxBrowse(his_indexer);
				createGroupBoxOK(his_indexer);
			}
		}
	}

	public void createGroupBoxHistory(History_Indexer his_indexer,
			String[] history_List) {
		if (Configuration.GUI) {
			if (Configuration.INDEX_HISTORY) {
				// CreateGroupBox History
				historyGroupBox = makeGroupBox("History", 20, Color.BLACK);
				// add historyList to historyGroupBox
				historyList = new JList(history_List);
				constraints_Container = new GridBagConstraints(); // "reset Constraints"
				constraints_Container.weightx = 1.0; // need to fill with
														// horizontal
														// complete
				constraints_Container.weighty = 1.0; // need to fill with
														// vertical
														// complete
				constraints_Container.fill = GridBagConstraints.BOTH; // fill
																		// horizontal
																		// and
																		// vertical
																		// (set
																		// weightx
																		// +
																		// weighty!!!)
				historyGroupBox.add(historyList, constraints_Container);

				JPanel historyPanel = new JPanel(); // historyRadioButton +
													// historyGroupBox
				historyPanel.setLayout(new GridBagLayout());

				// add historyRadioButton to historyPanel
				constraints_Container = new GridBagConstraints(); // "reset Constraints"
				constraints_Container.anchor = GridBagConstraints.NORTHWEST; // position
																				// upper
																				// left
				historyPanel.add(historyRadioButton, constraints_Container);

				// add historyGroupBox to historyPanel
				constraints_Container = new GridBagConstraints(); // "reset Constraints"
				constraints_Container.weightx = 1.0; // need to fill with
														// horizontal
														// complete
				constraints_Container.weighty = 1.0; // need to fill with
														// vertical
														// complete
				constraints_Container.fill = GridBagConstraints.BOTH; // fill
																		// horizontal
																		// and
																		// vertical
																		// (set
																		// weightx
																		// +
																		// weighty!!!)
				historyPanel.add(historyGroupBox, constraints_Container);

				// add historyPanel
				constraints_Container = new GridBagConstraints();
				constraints_Container.weightx = 1.0; // need to fill with
														// horizontal
														// complete
				constraints_Container.weighty = 1.0; // need to fill with
														// vertical
														// complete
				constraints_Container.fill = GridBagConstraints.BOTH; // fill
																		// horizontal
																		// and
																		// vertical
																		// (set
																		// weightx
																		// +
																		// weighty!!!)
				constraints_Container.anchor = GridBagConstraints.PAGE_START; // position
																				// on
																				// top
				constraints_Container.gridwidth = GridBagConstraints.REMAINDER; // end
																				// row
																				// ->
																				// next
																				// element
																				// in
																				// next
																				// row
				container.add(historyPanel, constraints_Container);
			}
		}
	}

	public void createGroupBoxBrowse(History_Indexer his_indexer) {
		if (Configuration.GUI) {
			if (Configuration.INDEX_HISTORY) {
				browseGroupBox = makeGroupBox("Browse", 20, Color.BLACK);
				// BrowseBox fuellen
				newRootTextField = new JTextField();
				newRootTextField.setFont(new Font("", Font.ITALIC, 15));
				newRootTextField.setEditable(false);
				constraints_Container = new GridBagConstraints();
				constraints_Container.fill = GridBagConstraints.HORIZONTAL; // Horihzontal
																			// fuellen...
																			// ->
																			// weightx
																			// muss
																			// angegeben
																			// werden
				constraints_Container.weightx = 1.0;
				browseGroupBox.add(newRootTextField, constraints_Container);
				startBrowseButton = new JButton("Search");
				startBrowseButton.addActionListener(his_indexer);
				startBrowseButton.setFont(new Font("", Font.ITALIC, 15));
				constraints_Container = new GridBagConstraints();
				constraints_Container.anchor = GridBagConstraints.EAST;
				browseGroupBox.add(startBrowseButton, constraints_Container);

				JPanel searchPanel = new JPanel(); // browseRadioButton +
													// browseGroupBox
				searchPanel.setLayout(new GridBagLayout());

				constraints_Container = new GridBagConstraints();
				constraints_Container.fill = GridBagConstraints.NONE;
				constraints_Container.anchor = GridBagConstraints.NORTHWEST;
				searchPanel.add(browseRadioButton, constraints_Container);

				constraints_Container = new GridBagConstraints();
				constraints_Container.fill = GridBagConstraints.HORIZONTAL;
				constraints_Container.weightx = 1.0;
				searchPanel.add(browseGroupBox, constraints_Container);

				// adde searchPanel
				constraints_Container = new GridBagConstraints();
				constraints_Container.weightx = 1.0;
				constraints_Container.fill = GridBagConstraints.HORIZONTAL;
				constraints_Container.anchor = GridBagConstraints.NORTH;
				constraints_Container.gridwidth = GridBagConstraints.REMAINDER; // end
																				// row
				container.add(searchPanel, constraints_Container);
			}
		}
	}

	public void createGroupBoxOK(History_Indexer his_indexer) {
		if (Configuration.GUI) {
			if (Configuration.INDEX_HISTORY) {
				JPanel panel = new JPanel();
				panel.setLayout(new GridBagLayout());

				okButton = new JButton("OK");
				okButton.addActionListener(his_indexer);
				okButton.setFont(new Font("", Font.ITALIC, 15));

				constraints_Container = new GridBagConstraints();
				panel.add(okButton, constraints_Container);

				abortButton = new JButton("Abort");
				abortButton.addActionListener(his_indexer);
				abortButton.setFont(new Font("", Font.ITALIC, 15));

				constraints_Container = new GridBagConstraints();
				panel.add(new Label("  "), constraints_Container);
				constraints_Container = new GridBagConstraints();
				panel.add(abortButton, constraints_Container);

				constraints_Container = new GridBagConstraints();
				constraints_Container.anchor = GridBagConstraints.PAGE_END;
				container.add(panel, constraints_Container);
			}
		}
	}

	public JPanel makeGroupBox(String title, int fontSize, Color color) {
		JPanel panel = new JPanel();
		if (Configuration.GUI) {
			if (Configuration.INDEX_HISTORY) {
				Border blackline = BorderFactory.createLineBorder(color);
				panel.setLayout(new GridBagLayout());

				TitledBorder border = BorderFactory.createTitledBorder(
						blackline, title, TitledBorder.DEFAULT_JUSTIFICATION,
						TitledBorder.CENTER,
						new Font("", Font.ITALIC, fontSize));// /.createTitledBorder(blackline,title);
				panel.setBorder(border);
			}
		}
		return panel;
	}
}
