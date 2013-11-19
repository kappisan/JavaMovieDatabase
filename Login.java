import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author All written by William Bergendahl
 */
public class Login extends WriteXml {
    String[] UsernameArray = {"William","Ludwig","Kasper","Jonathan","Nader","Saimonas"};
    String[] PasswordArray = {"Bergendahl","Björk","Wilkosz","Klemetz","Bader","Sileikis"};
    
    public void Login() {
        //Create Xml file.
        try {
            writeLoginInfo();
            
        } catch(ParserConfigurationException parse) {
            System.out.println(parse);
        }
        catch(FileNotFoundException fnfe) {
            System.out.println(fnfe);
            
        } catch(IOException ie) {
            System.out.println(ie);
            
        }
        
        //Send to db
        
        //Get file Returned
        
        //If Username & password = correct; 
        // do something.

    
      
      // Compares the two arrays of Usernames and Passwords and if they match then login.
        if(Arrays.asList(UsernameArray).contains(LoginPanel.Username)&& Arrays.asList(PasswordArray).contains(LoginPanel.Password) && Arrays.asList(UsernameArray).indexOf(LoginPanel.Username) == Arrays.asList(PasswordArray).indexOf(LoginPanel.Password)) {
            LoginPanel.MessageLabel.setText("Success!");
           
            AddMovie add = new AddMovie();
            
             add.setVisible(true); 
            
        } else {
            LoginPanel.MessageLabel.setText("Wrong Username or Password!");
        }
        
    }
    
    public void writeLoginInfo() throws ParserConfigurationException, FileNotFoundException, IOException {
          //DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        //DocumentBuilder
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        //Document
        Document xmlDoc = docBuilder.newDocument();
        
       
        
        Element rootElement = xmlDoc.createElement("LoginInfo");
        
        Element mainElement = xmlDoc.createElement("Login");
        
        
        Text FilmTitle = xmlDoc.createTextNode(LoginPanel.Username);
        Text FilmYear = xmlDoc.createTextNode(LoginPanel.Password);
       
        
        Element LoginUsername = xmlDoc.createElement("Username");
         Element LoginPassword = xmlDoc.createElement("Password");
        
           
        
            // Sets the childs
        LoginUsername.appendChild(FilmTitle);
        LoginPassword.appendChild(FilmYear);
       
        
        // Sets mainElement childs
        mainElement.appendChild(LoginUsername);
         mainElement.appendChild(LoginPassword);
      
        
        rootElement.appendChild(mainElement);
        
        xmlDoc.appendChild(rootElement);
        
        //Set Output
        OutputFormat output = new OutputFormat(xmlDoc);
        output.setIndenting(true);
        
        //Declare File which gets created in source folder.
        File xmlFile = new File("LoginInfo.xml");
        //Declare File Output stream
        FileOutputStream outStream = new FileOutputStream(xmlFile);
        
        //Serialize
        XMLSerializer Serialize = new XMLSerializer(outStream, output);
        
        Serialize.serialize(xmlDoc);
        
    }
}
