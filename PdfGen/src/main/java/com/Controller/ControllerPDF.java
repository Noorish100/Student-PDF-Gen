package com.Controller;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.Entity.Student;
import com.Service.ServiceImpl;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.IOException;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfWriter;

@Controller
public class ControllerPDF {

	@Autowired
	private ServiceImpl impl;

	@Autowired
	private SpringTemplateEngine engine;

	@GetMapping("/")
	public String fillform() {

		return "index";

	}

	@PostMapping("/submit")
	public ResponseEntity<byte[]> generateDocument(@ModelAttribute Student s) throws java.io.IOException {

		try {
			String finalHtml = "";
           String temp="temp1";
           if(!s.getTemp().isEmpty()) {
        	   temp=s.getTemp();
           }
			Context dataContext = impl.setData(s);
			finalHtml = engine.process(temp, dataContext);
			// Convert HTML to PDF
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
			ConverterProperties converterProperties = new ConverterProperties();
			HtmlConverter.convertToPdf(finalHtml, pdfWriter, converterProperties);
			pdfWriter.close();

			// Convert ByteArrayOutputStream to byte array
			byte[] pdfBytes = byteArrayOutputStream.toByteArray();
			byteArrayOutputStream.close();

			// Set response headers
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			// Set the filename for the downloaded file
			headers.setContentDispositionFormData("filename", "studend-Info.pdf");
			headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

			// Send the PDF file bytes as a response
			return ResponseEntity.ok().headers(headers).body(pdfBytes);
		} catch (IOException e) {
			// Handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
