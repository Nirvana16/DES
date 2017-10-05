package des;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException; 
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;
 
public class EncriptaDecriptaDES{
 
 
       public static void main(String[] argv) {
 
             try{
 
                 KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
                 SecretKey chaveDES = keygenerator.generateKey();
                 System.out.println("Chave DES:"+ chaveDES);
                 
                 Cipher cifraDES;
 
                 // Cria a cifra 
                 cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
 
                 // Inicializa a cifra para o processo de encriptação
                 cifraDES.init(Cipher.ENCRYPT_MODE, chaveDES);
 
                 // Texto puro
                 String textoInformado = JOptionPane.showInputDialog("Informe o Texto: ");
                 byte[] textoPuro = textoInformado.getBytes();
               
                 System.out.println("Texto Puro : " + new String(textoPuro));
                 JOptionPane.showMessageDialog(null,"Chave DES gerada automaticamente: \n"+ chaveDES);
                 // Texto encriptado
                 byte[] textoEncriptado = cifraDES.doFinal(textoPuro);
 
                 System.out.println("Texto Encriptado : " + textoEncriptado);
                 JOptionPane.showMessageDialog(null,"Texto Encriptado apos o DES: \n"+ textoEncriptado);
                 
                 // Inicializa a cifra também para o processo de decriptação
                 JOptionPane.showMessageDialog(null,"Descriptografando dados: "+ textoEncriptado + "\nCom a chave: " + chaveDES);
                 cifraDES.init(Cipher.DECRYPT_MODE, chaveDES);
 
                 // Decriptografa o texto
                 byte[] textoDecriptografado = cifraDES.doFinal(textoEncriptado);
                
                 System.out.println("Texto Decriptografado : " + new String(textoDecriptografado));
                 JOptionPane.showMessageDialog(null,"Texto Decriptografado: \n"+ new String(textoDecriptografado));
 
             }catch(NoSuchAlgorithmException e){
                    e.printStackTrace();
             }catch(NoSuchPaddingException e){
                    e.printStackTrace();
             }catch(InvalidKeyException e){
                    e.printStackTrace();
             }catch(IllegalBlockSizeException e){
                    e.printStackTrace();
             }catch(BadPaddingException e){
                    e.printStackTrace();
             } 
 
       }
       
}