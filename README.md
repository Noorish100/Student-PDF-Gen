# Student-PDF-Gen

<div>
<h2>Overview</h2>
        <p>This microservice is built using Spring Boot, Thymeleaf, and Bootstrap to accept input data comprising student details, school details, marks, and term. It generates a PDF document as output, providing customizable templates for distinct look and feel variations.</p>
  
        <h2>Features</h2>
        <ul>
            <li>Accepts input data including student details, school details, marks, and term.</li>
            <li>Generates a PDF document based on the provided input data.</li>
            <li>Provides customizable templates using Thymeleaf and Bootstrap for distinct look and feel variations.</li>
        </ul>

        <h2>Technologies Used</h2>
        <ul>
            <li>Spring Boot</li>
            <li>Thymeleaf</li>
            <li>Bootstrap</li>
            <li>PDF generation library (e.g., Apache PDFBox, iText, etc.)</li>
        </ul>

        <h2>Setup Instructions</h2>
        <ol>
            <li>Clone the repository to your local machine.
               <code>git clone &lt;repository_url&gt;</code>
            </li>
            <li>Build the project using Maven or Gradle.</li>
            <li>Run the application.</li>
            <li>The microservice should now be running and ready to accept requests.</li>
        </ol>

        <h2>API Endpoints</h2>
        <ul>
            <li><strong>Endpoint:</strong> /generate-pdf</li>
            <li><strong>Method:</strong> POST</li>
            <li><strong>Request Body:</strong> Student Details, School Details, Marks, Term</li>
            <li><strong>Response:</strong> PDF Document</li>
        </ul>

        <h2>Usage</h2>
        <ol>
            <li>Send a POST request to /generate-pdf with the required input data including student details, school details, marks, and term.</li>
            <li>Receive the generated PDF document in the response.</li>
        </ol>

        <h2>Customization</h2>
        <p>To customize the templates for the PDF documents, modify the Thymeleaf templates and Bootstrap stylesheets located in the project's resources directory. You can change the layout, styling, and content according to your requirements.</p>

        <h2>Acknowledgments</h2>
        <p>Special thanks to the Spring Boot, Thymeleaf, and Bootstrap communities for their valuable contributions.</p>
    </div>
