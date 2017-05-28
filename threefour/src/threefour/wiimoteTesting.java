package threefour;

import java.util.ArrayList;
import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;

public class wiimoteTesting extends javax.swing.JFrame {

	static ArrayList<Wiimote> motes = new ArrayList<>();
	static boolean[] ledOff = {false, false, false, false};

	MoteFinder finder = MoteFinder.getMoteFinder();

	static MoteFinderListener listener = new MoteFinderListener() {
		
		@Override
		public void moteFound(Mote mote) {
			mote.rumble(1000l);
			Wiimote m = new Wiimote(mote);
			motes.add(m);
			m.addAccelListener();
			m.addButtonListener();

			boolean[] playerLed = ledOff;
			playerLed[motes.indexOf(m)] = true;
			mote.setPlayerLeds(playerLed);
		}
	};

	/**
	 * Creates new form wiimoteTesting
	 */
	public wiimoteTesting() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                disconnectButton = new javax.swing.JButton();
                discoverButton = new javax.swing.JToggleButton();
                runButton = new javax.swing.JButton();
                input1button = new javax.swing.JToggleButton();
                axisLabel = new javax.swing.JLabel();
                buttonLabel = new javax.swing.JLabel();
                discoverButton2 = new javax.swing.JToggleButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                disconnectButton.setText("Disconnect");
                disconnectButton.setEnabled(false);
                disconnectButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                disconnectButtonActionPerformed(evt);
                        }
                });

                discoverButton.setText("Toggle Discovery");
                discoverButton.setEnabled(false);
                discoverButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                discoverButtonActionPerformed(evt);
                        }
                });

                runButton.setText("Run");
                runButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                runButtonActionPerformed(evt);
                        }
                });

                input1button.setText("Player 1 Input");
                input1button.setEnabled(false);
                input1button.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                input1buttonActionPerformed(evt);
                        }
                });

                axisLabel.setText("0,0,0");

                buttonLabel.setText("none");

                discoverButton2.setText("Toggle Discovery 2");
                discoverButton2.setEnabled(false);
                discoverButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                discoverButton2ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(discoverButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(discoverButton2))
                                        .addComponent(runButton)
                                        .addComponent(input1button)
                                        .addComponent(axisLabel)
                                        .addComponent(buttonLabel)
                                        .addComponent(disconnectButton))
                                .addContainerGap(130, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(runButton)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(discoverButton)
                                        .addComponent(discoverButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(disconnectButton)
                                .addGap(18, 18, 18)
                                .addComponent(input1button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(axisLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonLabel)
                                .addContainerGap(109, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void discoverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discoverButtonActionPerformed
		if (discoverButton.isSelected()) {
			finder.startDiscovery();
		}
		else {
			finder.stopDiscovery();
		}
        }//GEN-LAST:event_discoverButtonActionPerformed

        private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
		finder.addMoteFinderListener(listener);
		discoverButton.setEnabled(true);
		discoverButton2.setEnabled(true);
		disconnectButton.setEnabled(true);
		input1button.setEnabled(true);
        }//GEN-LAST:event_runButtonActionPerformed

        private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
		for (int k = 0; k < motes.size(); k++) {
			Wiimote wm = motes.get(k);
			Mote m = wm.getMote();
			wm.removeAccelListener();
			wm.removeButtonListener();
			m.setPlayerLeds(ledOff);
			m.disconnect();
		}
        }//GEN-LAST:event_disconnectButtonActionPerformed

        private void input1buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input1buttonActionPerformed
		if (input1button.isSelected()) {
			//TODO: read input from wiimote
		}
		else {
			//TODO: stop reading
		}
        }//GEN-LAST:event_input1buttonActionPerformed

        private void discoverButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discoverButton2ActionPerformed
		if (discoverButton2.isSelected()) {
			//TODO: get two wiimotes to connect
		}
		else {
			// somehow
		}
        }//GEN-LAST:event_discoverButton2ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(wiimoteTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(wiimoteTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(wiimoteTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(wiimoteTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new wiimoteTesting().setVisible(true);
			}
		});

	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel axisLabel;
        private javax.swing.JLabel buttonLabel;
        private javax.swing.JButton disconnectButton;
        private javax.swing.JToggleButton discoverButton;
        private javax.swing.JToggleButton discoverButton2;
        private javax.swing.JToggleButton input1button;
        private javax.swing.JButton runButton;
        // End of variables declaration//GEN-END:variables
}
