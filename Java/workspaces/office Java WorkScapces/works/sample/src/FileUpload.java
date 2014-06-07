

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

		PrintWriter out=response.getWriter();
		//to get the content type information from JSP Request Header
		String contentType = request.getContentType();
		String location = "/home/praveen/works/sample/WebContent/images/";
		//here we are checking the content type is not equal to Null and  as well as the passed data from mulitpart/form-data is greater than or  equal to 0
		if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
			DataInputStream in = new DataInputStream(request.getInputStream());
			//we are taking the length of Content type data
			int formDataLength = request.getContentLength();
			out.println(formDataLength);
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;

			//this loop converting the uploaded file into byte code
			while (totalBytesRead < formDataLength) 
			{
				byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
				totalBytesRead += byteRead;
			}
			String file = new String(dataBytes);
			//for saving the file name
			//out.println(file.substring(file.indexOf("filename=\"") + 10));
			String saveFile = file.substring(file.indexOf("filename=\"") + 10);
			saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
			saveFile = saveFile.substring(saveFile.lastIndexOf("\\")+1,saveFile.indexOf("\""));
			saveFile = location+saveFile;
			int lastIndex = contentType.lastIndexOf("=");
			String boundary = contentType.substring(lastIndex + 1,contentType.length());
			int pos;
			//extracting the index of file 
			pos = file.indexOf("filename=\"");
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			int boundaryLocation = file.indexOf(boundary, pos) - 4;
			int startPos = ((file.substring(0, pos)).getBytes()).length;
			int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
			// creating a new file with the same name and writing the content in new file
			String extf=saveFile.substring(saveFile.length()-4,saveFile.length());
			String filename1=request.getParameter("name");
			String newfilename=filename1.concat(extf);
			String destpath=location.concat(newfilename);
			FileOutputStream fileOut = new FileOutputStream(destpath);
			fileOut.write(dataBytes, startPos, (endPos - startPos));
			fileOut.flush();
			fileOut.close();
			response.sendRedirect("sample.html");
		}
	}

}
