
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Trix
 */
public class CampoTextoHint extends javax.swing.JPanel implements Serializable{
    private String hint ="{(CampoTextoHint)}";
    private Color gris = new Color(102,102,102);
    public enum tipoCampo{CADENA,NUMERICO}
    tipoCampo tipo = tipoCampo.CADENA;
    
    
    /**
     * Creates new form CampoTextHint
     */
    
    public void setTipoCampo(tipoCampo tipo){
        this.tipo = tipo;
    }
    
    public tipoCampo getTipoCampo(){
        return tipo;
    }
    
    public void setHint(String texto){
        hint=texto;
        jTextField1.setText(hint);
    }
    public String getHint(){
        return hint;
    }
    public CampoTextoHint() {
        initComponents();
        jTextField1.setText(hint);
        jTextField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //Cuando gana el foco
                if(jTextField1.getText().equals(hint)){
                    jTextField1.setText("");
                    jTextField1.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                //Cuando piered el foco
                if(jTextField1.getText().isEmpty()){
                    jTextField1.setText(hint);
                }
            }
        });
        
        jTextField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //Cuando escribes, es decir que aparece una letra en el campo de texto.
                char tecla = e.getKeyChar();
                
                if(tipo == tipoCampo.NUMERICO){
                    if((tecla<48)||((tecla>57)) && (tecla!='\b')){
                        e.consume(); //Evita el evento.
                        
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
