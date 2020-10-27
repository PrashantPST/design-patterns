/*
As the name implies, a builder pattern is used to build objects.
Another hypothetical example could be creating documents of type pdf or html. Consider the snippet below:

    public IDocument construct(DocumentBuilder documentBuilder) {

        documentBuilder.addTitle("Why use design patterns");
        documentBuilder.addBody("blah blah blah... more blah blah blah");
        documentBuilder.addAuthor("C. H. Afzal");
        documentBuilder.addConclusion("Happy Coding!");

        // Return the document and depending on the concrete
        // implementation of the DocumentBuilder, we could return
        // either a pdf or html document.
        return documentBuilder.buildDocument();

    }
The above method can appear in a director or client code and different document types can be built by varying the concrete type of
the DocumentBuilder passed into the method. We could have a HtmlDocumentBuilder and a PdfDocumentBuilder derive from the abstract class DocumentBuilder.
 */
