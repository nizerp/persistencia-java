import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {
    public static void main(String[] args) {
        try {
            // gravar();
            
            for (Pessoa p : ler()) {
                System.out.println(p.getNome());
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Pessoa> ler() {
        List<Pessoa> result = new ArrayList<Pessoa>();

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("pessoas.bin"))) {
            Pessoa p = null;
            while ((p = (Pessoa) inputStream.readObject()) != null) {
                result.add(p);
            }
        }         
        catch (EOFException ex) { }
        catch (Exception e) {
            e.printStackTrace();
        } 

        return result;
    }
    
    public static void gravar() {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("pessoas.bin"))) {            
            Pessoa p1 = new Pessoa();
            p1.setNome("Philippe");
            p1.setEmail("pnizer@gmail.com");
            outputStream.writeObject(p1);

            Pessoa p2 = new Pessoa();
            p2.setNome("Isabela");
            p2.setEmail("isaxagfd@gmail.com");
            outputStream.writeObject(p2);
            
        } catch (IOException e) {
            e.printStackTrace();
        }     
    }
}
