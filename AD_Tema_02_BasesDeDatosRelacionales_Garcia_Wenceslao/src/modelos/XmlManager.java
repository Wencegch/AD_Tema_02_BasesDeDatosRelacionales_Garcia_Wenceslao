package modelos;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Wence
 */
public class XmlManager {
    private static Transformer xFormer;
    private static Source source;
    private static Result result;
    private  String nomAlu, codCurso, nomCurso, notaMedia;
    public XmlManager() {
    }
    
    public void CrearXML(String codAlu, ArrayList<Matricula> numRegistros) {
        try {
            // Crear un objeto DocumentBuilderFactory
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();

            // Crear un objeto DocumentBuilder
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Crear un documento XML
            Document doc = docBuilder.newDocument();
            // Crear el elemento raíz y asignar un atributo "nombre" al elemento raíz
            Element rootElement = doc.createElement("matriculas");
            rootElement.setAttribute("nombre", "Matriculas");
            doc.appendChild(rootElement);
            
            for (Matricula numRegistro : numRegistros) {
                codAlu = numRegistro.getCodAlu();
                nomAlu = numRegistro.getNomAlu();
                codCurso = numRegistro.getCodCurso();
                nomCurso = numRegistro.getNomCurso();
                notaMedia = String.valueOf(numRegistro.getNotaMedia());

                // Añadimos los elementos hijos
                Element matricula = doc.createElement("matricula");
                rootElement.appendChild(matricula);

                Element codigoAlumno = doc.createElement("codigo_alumno");
                codigoAlumno.appendChild(doc.createTextNode(codAlu));
                matricula.appendChild(codigoAlumno);

                Element nomAlumno = doc.createElement("nombre_alumno");
                nomAlumno.appendChild(doc.createTextNode(nomAlu));
                matricula.appendChild(nomAlumno);

                Element codigoCurso = doc.createElement("codigo_curso");
                codigoCurso.appendChild(doc.createTextNode(codCurso));
                matricula.appendChild(codigoCurso);

                Element nombreCurso = doc.createElement("nombre_curso");
                nombreCurso.appendChild(doc.createTextNode(nomCurso));
                matricula.appendChild(nombreCurso);

                Element notaMediaElement = doc.createElement("nota_media");
                notaMediaElement.appendChild(doc.createTextNode(notaMedia));
                matricula.appendChild(notaMediaElement);
            }

            // Configurar la transformación
            xFormer = TransformerFactory.newInstance().newTransformer();
            xFormer.setOutputProperty(OutputKeys.METHOD, "xml");
            xFormer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Crear la fuente del documento
            source = new DOMSource(doc);

            // Especificar la ubicación del archivo XML de salida
            result = new StreamResult(new File("Matriculas.xml"));

            // Realizar la transformación y escribir el archivo XML
            xFormer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException ex) {}
    }
}