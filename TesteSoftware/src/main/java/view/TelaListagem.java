/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;

import model.Contato;
import model.ServicoContatoImpl;
import model.Usuario;

/**
 *
 * @author fabriciogmc
 */
public class TelaListagem extends javax.swing.JFrame {

	/**
	 * Creates new form TelaListagem
	 * 
	 * @param lista
	 */

	Contato contato = new Contato();

	public TelaListagem(List<Contato> lista, Usuario u) {

		initComponents(lista, u);
		// this.list1.add("Fabrício; 22222222; prof.fabriciogmc@gmail.com, Rua do
		// Fabrício");
		// this.list1.add("Pedro; 111111; pedro@pedro.com, Rua do Pedro");

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 * 
	 * @param lista
	 * @param u
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents(List<Contato> lista, Usuario u) {

		jLabel1 = new javax.swing.JLabel();
		list1 = new java.awt.List();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		int i = 0;
		while (i < lista.size()) {
			list1.add(lista.get(i).getNome().toString() + ";" + lista.get(i).getTelefone().toString() + ";"
					+ lista.get(i).getEmail().toString() + ";" + lista.get(i).getEndereco().toString());
			i++;
		}

		jLabel1.setText("Contatos existentes na agenda:");

		list1.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				list1ItemStateChanged(evt, lista);
			}
		});

		jButton1.setText("Editar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt, contato, u);
			}
		});

		jButton2.setText("Excluir");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt, contato, u);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(33, 33, 33)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(jButton1)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton2))
								.addComponent(jLabel1).addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 306,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(41, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(22, 22, 22)
						.addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 218,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(23, 23, 23)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1).addComponent(jButton2))
						.addContainerGap(32, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void list1ItemStateChanged(java.awt.event.ItemEvent evt, List<Contato> lista) {// GEN-FIRST:event_list1ItemStateChanged
		// TODO add your handling code here:
		String escolhido = list1.getSelectedItem();
		String[] separa = escolhido.split(";");
		contato.setNome(separa[0]);
		contato.setTelefone(separa[1]);
		contato.setEmail(separa[2]);
		contato.setEndereco(separa[3]);

	}// GEN-LAST:event_list1ItemStateChanged

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt, Contato contato, Usuario u) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		int verificador = 0;
		TelaCadastro cadastro = new TelaCadastro(contato, u, verificador);
		cadastro.setVisible(true);
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt, Contato contato, Usuario u) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		ServicoContatoImpl excluir = new ServicoContatoImpl(u.getNomeUsuario());
		excluir.removerContato(contato);
	}// GEN-LAST:event_jButton1ActionPerformed

	/**
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private java.awt.List list1;
	// End of variables declaration//GEN-END:variables
}
