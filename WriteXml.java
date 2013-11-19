/**
 *
 * @author All code Written by William Bergendahl
 */
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import java.io.IOException;
import java.net.ProtocolException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

public class WriteXml {
    
    public  void WriteXml() throws ProtocolException, TransformerConfigurationException, TransformerException {
        try {
            this.WriteFilmXml();
            
        } catch(ParserConfigurationException parse) {
            System.out.println(parse);
            
        }catch(FileNotFoundException filenotfound){
             System.out.println(filenotfound);
            
        }catch(IOException ioexception) {
             System.out.println(ioexception);
        
    }
        
    }
    
    public void WriteFilmXml() throws ParserConfigurationException, FileNotFoundException, IOException, ProtocolException, TransformerConfigurationException, TransformerException {
        //DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        //DocumentBuilder
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        //Document
        Document xmlDoc = docBuilder.newDocument();
        
        //Build Xml elements and textnodes
        //<Films>
        //<Film>
        //<FilmTitle> Titanic </FilmTitle>
        //<Year> 1983 </Year>
        //<Actor> Arnold Schwarzenegger </Actor>
        //<Genre> Drama </Genre>
        //<Nudity> </Nudity>
        //<FilmDescription> blablabla </FilmDescription>
        //</Film>
        //</Films>
        
        Element rootElement = xmlDoc.createElement("Films");
        
        Element mainElement = xmlDoc.createElement("Film");
        
        // Adds the variables to the respective elements
        Text FilmTitle = xmlDoc.createTextNode(AddMovie.Title);
        Text FilmYear = xmlDoc.createTextNode(AddMovie.Year);
        Text FilmActor = xmlDoc.createTextNode(AddMovie.Actor);
        Text FilmGenre = xmlDoc.createTextNode(AddMovie.Genre);
        Text FilmNudity = xmlDoc.createTextNode(AddMovie.Nudity);
        Text FilmRating = xmlDoc.createTextNode(AddMovie.Rating);
         Text FilmDescription = xmlDoc.createTextNode(AddMovie.Description);
           
        //Creates the elements that shows what info is in the variables.
        Element FilmTitleValue = xmlDoc.createElement("FilmTitle");
         Element FilmYearValue = xmlDoc.createElement("FilmYear");
          Element FilmActorValue = xmlDoc.createElement("FilmActor");
           Element FilmGenreValue = xmlDoc.createElement("FilmGenre");
            Element FilmNudityValue = xmlDoc.createElement("FilmNudity");
             Element FilmRatingValue = xmlDoc.createElement("FilmRating");
            Element FilmDescriptionValue = xmlDoc.createElement("FilmDescription");
           
        
            // Sets the childs
        FilmTitleValue.appendChild(FilmTitle);
        FilmYearValue.appendChild(FilmYear);
        FilmActorValue.appendChild(FilmActor);
        FilmGenreValue.appendChild(FilmGenre);
        FilmNudityValue.appendChild(FilmNudity);
        FilmRatingValue.appendChild(FilmRating);
        FilmDescriptionValue.appendChild(FilmDescription);
        
        // Sets mainElement childs
        mainElement.appendChild(FilmTitleValue);
         mainElement.appendChild(FilmYearValue);
          mainElement.appendChild(FilmActorValue);
           mainElement.appendChild(FilmGenreValue);
            mainElement.appendChild(FilmNudityValue);
            mainElement.appendChild(FilmRatingValue);
             mainElement.appendChild(FilmDescriptionValue);
        
        rootElement.appendChild(mainElement);
        //Sets Mainelement as child to the rootElement
        xmlDoc.appendChild(rootElement);
        
        //Set Output
        OutputFormat output = new OutputFormat(xmlDoc);
        output.setIndenting(true);
        
        //Declare File which gets created in source folder.
        File xmlFile = new File("NewFilm.xml");
        //Declare File Output stream
        FileOutputStream outStream = new FileOutputStream(xmlFile);
        
        //Serialize
        XMLSerializer Serialize = new XMLSerializer(outStream, output);
        
        Serialize.serialize(xmlDoc);
       
        
      

        
    }
   
}
    
