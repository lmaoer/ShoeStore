package model;
import java.io.Console;
import java.text.NumberFormat;
import java.util.*;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;

import dal.ProductDAO;

public class Util {
	public Util() {
		
	}
	
	public static double totalPrice(List<Order> list) {
		double s = 0;
		for(Order o: list) {
			double cost = costAfterDiscount(o.getProduct().getCost(), o.getProduct().getDiscount());
			s += o.getQuantity()*cost;
		}
		return s;
	}
	
	public static double costAfterDiscount(int cost, int discount) {
		return cost-cost*discount/100;
	}
	
	public static void sendMail(String recepient, String html) throws MessagingException {
		System.out.println("Sending...");
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String myAccountEmail = "ftvdexc95@gmail.com";
		String password = "olxrinpejjtyxsja";
		
		Session session = Session.getInstance(properties, new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication(){
				
				return new PasswordAuthentication(myAccountEmail, password);
			}
		
		});
		
		
		Message message = prepareMessage(session, myAccountEmail, recepient, html);
	
		Transport.send(message);
		System.out.println("Success sent");
	}
	
	private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String html) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Order Confirmation");
			
			
			message.setContent(html, "text/html; charset=utf-8");
			
			return message;
		} catch (AddressException e) {
			
			e.printStackTrace();
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public static String receiptList(List<Order> list) {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("hn", "vn"));
		String res = "";
		for(Order o: list) {
			int tmp = (int) (o.getQuantity()*(costAfterDiscount(o.getProduct().getCost(),o.getProduct().getDiscount())));
			
			res += "            <li>" + o.getProduct().getName() + " (" + o.getQuantity() + ") " + numberFormat.format(tmp) + "</li>\r\n";
		}
		
		return res;
	}

	public static void main(String[] args) throws MessagingException {
		// Util.sendMail("ftvdexc111@gmail.com", "string html here");
//		ProductDAO productDAO = new ProductDAO();
//		productDAO.tmp2();
//		System.out.println("success");
	}
}
