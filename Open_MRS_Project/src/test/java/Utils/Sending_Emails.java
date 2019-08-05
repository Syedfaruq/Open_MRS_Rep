package Utils;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.annotations.AfterMethod;

public class Sending_Emails {

	@Test(description = "A simple text email")

	// Method to send Simple E mail

	public static void Simple_Email() {
		try {
			Email_Simple();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void Email_Simple() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.yahoo.com");
		email.setSmtpPort(365);
		email.setAuthenticator(new DefaultAuthenticator("syedfaruk0546@yahoo.com", "7013667545"));
		email.setSSLOnConnect(true);
		email.setFrom("syedfaruk0546@yahoo.com");
		email.setSubject("Text Execution Report");
		email.setMsg("This is a test mail...");
		email.addTo("syedfaruq6843@gmail.com");
		email.send();
	}

	@Test(description = "Sending emails with attachments")

	// Method to send Email with attachments

	public static void Email_with_attachments() throws EmailException {
		Email_With_Attachments();
	}

	private static void Email_With_Attachments() throws EmailException {
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("mypictures/john.jpg");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Picture of John");
		attachment.setName("John");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("mail.myserver.com");
		email.addTo("jdoe@somewhere.org", "John Doe");
		email.setFrom("me@apache.org", "Me");
		email.setSubject("The picture");
		email.setMsg("Here is the picture you wanted");

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();
	}

	@Test(description = "Sending HTML formatted email")

	public static void Email_HTML_format() throws EmailException, MalformedURLException {

		// Method to send Email with attachments

		Email_HTML_Format();
	}

	private static void Email_HTML_Format() throws EmailException, MalformedURLException {
		// Create the email message
		HtmlEmail email = new HtmlEmail();
		email.setHostName("mail.myserver.com");
		email.addTo("jdoe@somewhere.org", "John Doe");
		email.setFrom("me@apache.org", "Me");
		email.setSubject("Test email with inline image");

		// embed the image and get the content id
		URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
		String cid = email.embed(url, "Apache logo");

		// set the html message
		email.setHtmlMsg("<html>The apache logo - <img src=\"cid:" + cid + "\"></html>");

		// set the alternative message
		email.setTextMsg("Your email client does not support HTML messages");

		// send the email
		email.send();
	}

	@Test(description = "Sending HTML formatted email with embedded images")
	public static void Email_HTML_format_EmbeddedImages() throws MalformedURLException, EmailException {

		// Method to send Email with Embedded Images

		Email_With_Embedded_Images();
	}

	private static void Email_With_Embedded_Images() throws MalformedURLException, EmailException {
		// load your HTML email template
		String htmlEmailTemplate = ".... <img src=\"http://www.apache.org/images/feather.gif\"> ....";

		// define you base URL to resolve relative resource locations
		URL url = new URL("http://www.apache.org");

		// create the email message
		ImageHtmlEmail email = new ImageHtmlEmail();
		email.setDataSourceResolver(new DataSourceUrlResolver(url));
		email.setHostName("mail.myserver.com");
		email.addTo("jdoe@somewhere.org", "John Doe");
		email.setFrom("me@apache.org", "Me");
		email.setSubject("Test email with inline image");

		// set the html message
		email.setHtmlMsg(htmlEmailTemplate);

		// set the alternative message
		email.setTextMsg("Your email client does not support HTML messages");

		// send the email
		email.send();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Test Execution Started");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Test Execution Ended");

	}

}
