package generator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PdfGenerator {

    public static void main(String[] args) {
        try {
            // Especifica o tamanho máximo do arquivo em KB
            int maxSizeInKb = 4096; // Altere este valor conforme necessário

            // Cria um novo documento PDF
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            // Carrega uma fonte padrão
            // Substitua "/Helvetica.ttf" pelo caminho correto da fonte no seu projeto
            PDType0Font font = PDType0Font.load(document, new FileInputStream("C:/Users/Gabriel_Macedo/Downloads")); // Exemplo de caminho

            // Cria uma stream de conteúdo para escrever na página
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // Define a fonte e o tamanho
                contentStream.setFont(font, 12);
                contentStream.setNonStrokingColor(new PDColor(new float[]{0.0f, 0.0f, 0.0f}, PDDeviceRGB.INSTANCE));

                // Adiciona algum texto à página como exemplo
                contentStream.beginText();
                contentStream.newLineAtOffset(50, 700); // Posição inicial do texto
                contentStream.showText("Exemplo de texto");
                contentStream.endText();

                // Fecha a stream de conteúdo
                contentStream.close();
            }

            // Salva o documento
            File outputFile = new File("large_pdf_2.pdf");
            document.save(outputFile.getAbsolutePath());

            // Fecha o documento
            document.close();

            System.out.println("PDF criado com sucesso: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erro ao criar o PDF: " + e.getMessage());
        }
    }
}


