package com.Service;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.Entity.Student;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfWriter;

@Service
public class ServiceImpl implements ServicesMethod {
	
	
	 public Context setData(Student stud) {
		 
		 Context context= new Context();
		 
		 Map<String, Object> data=new HashMap<>();
		 
		 data.put("students",stud);
		 
		 context.setVariables(data);
		 
		 return context;
		
	}
	

}
