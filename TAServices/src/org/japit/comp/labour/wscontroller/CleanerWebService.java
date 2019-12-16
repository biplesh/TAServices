package org.japit.comp.labour.wscontroller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.japit.comp.labour.service.FetchKeyService;

/*import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.util.UriComponentsBuilder;

import com.techhub.common.spring.beans.EmailDetailsBean;
import com.techhub.common.spring.beans.ProductKeyResponse;

import com.techhub.common.spring.utility.WebServiceUtility;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;




@RestController
@Scope("request")
public class CleanerWebService {
	
	//public static Logger logger = Logger.getLogger(CleanerWebService.class);
	@Autowired private FetchKeyService fetchKeyService;
	
	@Autowired
    public JavaMailSender emailSender;
	
	private String senderId=null;
	private String RecevierId=null;
	private String BccId=null;
	
	@RequestMapping(value = "/ActivationProductKey/{RequestNo}", method = RequestMethod.GET)
    public ResponseEntity<ProductKeyResponse> fetchActivationKey( @PathVariable String RequestNo,@RequestHeader(value="authorization", defaultValue="auth") String userAuth) {
		RequestResponseBodyMethodProcessor a=null;
		//Map<String, String> response=new HashMap<>();
		ProductKeyResponse response=null;			
		int dataTransferStatus =-1;
			try {
			if (WebServiceUtility.isUserAuthenticated(userAuth)) {
				if( !RequestNo.equals("") && RequestNo!=null){				
					int result=fetchKeyService.fecthActivationKey(RequestNo);
					if(result==1){
						dataTransferStatus=1;
					}					
			     }
				}
			else
				dataTransferStatus=409;
				
				switch (dataTransferStatus) {
				case -1:
					response = new ProductKeyResponse(dataTransferStatus, "Wrong Request Id Provided");
					//response.put("test", "test");
					break;
		
				case 1:
					response = new  ProductKeyResponse(dataTransferStatus,"Success");
					//response.put("test", "test");
					break;
				case 409:
					//response.put("test", "test");
					response = new ProductKeyResponse(dataTransferStatus,"Sorry ! User Authentication failed.");
					break;
				default:
					break;
				}
			 }
			catch(Exception e){
				System.out.println("Error occured while fetching key details!!");
				e.printStackTrace();
				//response.put("test", "test");
				response = new ProductKeyResponse(dataTransferStatus, "Error occured while fetching key details!!");
			}
			/*ObjectMapper mapper = new ObjectMapper();
			String jsonInString="";
			try {
				jsonInString = mapper.writeValueAsString(response);
			} catch (JsonGenerationException e1) {
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//logger.info("Response : Single Window CAF fetchLicenseDetails : "+jsonInString);
			System.out.println("Response : Single Window fetchLicenseDetails : "+jsonInString);
			*/
		    return new ResponseEntity<ProductKeyResponse>(response, HttpStatus.OK);
			//return response;
	}
	
	
	@RequestMapping(value = "/updateValidateKeyStatus/{RequestNo}", method = RequestMethod.GET)
    public ResponseEntity<ProductKeyResponse> updateValidateKeyStatus( @PathVariable String RequestNo ,@RequestHeader(value="authorization", defaultValue="auth") String userAuth) {
		
		ProductKeyResponse response=null;		
		int dataTransferStatus =-1;
			try {
			if (WebServiceUtility.isUserAuthenticated(userAuth)) {
				if( !RequestNo.equals("") && RequestNo!=null){				
					int result=fetchKeyService.updateValidateKeyStatus(RequestNo,1);
					if(result==1){
						dataTransferStatus=1;
					}					
			     }
				}
			else
				dataTransferStatus=409;
				
				switch (dataTransferStatus) {
				case -1:
					response = new ProductKeyResponse(dataTransferStatus, "Wrong  Request Id Provided");
					break;
		
				case 1:
					response = new  ProductKeyResponse(dataTransferStatus,"Success");
					break;
				case 409:
					response = new ProductKeyResponse(dataTransferStatus,"Sorry ! User Authentication failed.");
					break;
				default:
					break;
				}
			 }
			catch(Exception e){
				System.out.println("Error occured while updating  key status !!");
				e.printStackTrace();
				response = new ProductKeyResponse(dataTransferStatus, "Error occured while fetching details!!");
			}
			/*ObjectMapper mapper = new ObjectMapper();
			String jsonInString="";
			try {
				jsonInString = mapper.writeValueAsString(response);
			} catch (JsonGenerationException e1) {
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//logger.info("Response : Single Window CAF fetchLicenseDetails : "+jsonInString);
			System.out.println("Response : Single Window fetchLicenseDetails : "+jsonInString);*/
			
		 return new ResponseEntity<ProductKeyResponse>(response, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getProductKey", method = RequestMethod.GET)
    public ResponseEntity<ProductKeyResponse> getProductKey(@RequestHeader(value="authorization", defaultValue="auth") String userAuth) {
		
		ProductKeyResponse response=null;
		String result=null;		
		int dataTransferStatus =-1;
			try {
			if (WebServiceUtility.isUserAuthenticated(userAuth)) {								
					 result=fetchKeyService.fetchNewActivationKey();
					if(result!=null){
						dataTransferStatus=1;
						}	  
				}
			else
				dataTransferStatus=409;
				
				switch (dataTransferStatus) {
				case -1:
					response = new ProductKeyResponse(dataTransferStatus, "Please contact with Admin");
					break;
		
				case 1:
					response = new  ProductKeyResponse(dataTransferStatus,result);
					break;
				case 409:
					response = new ProductKeyResponse(dataTransferStatus,"Sorry ! User Authentication failed.");
					break;
				default:
					break;
				}
			 }
			catch(Exception e){
				System.out.println("Error occured while updating  key status !!");
				e.printStackTrace();
				response = new ProductKeyResponse(dataTransferStatus, "Error occured while fetching details!!");
			}
			/*ObjectMapper mapper = new ObjectMapper();
			String jsonInString="";
			try {
				jsonInString = mapper.writeValueAsString(response);
			} catch (JsonGenerationException e1) {
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//logger.info("Response : Single Window CAF fetchLicenseDetails : "+jsonInString);
			System.out.println("Response : Single Window fetchLicenseDetails : "+jsonInString);*/
			
		 return new ResponseEntity<ProductKeyResponse>(response, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/getProductKeyInEmail", method = RequestMethod.POST)
    public ResponseEntity<ProductKeyResponse>getProductKeyInEmail(@RequestBody EmailDetailsBean emailDetailsBean, UriComponentsBuilder ucBuilder, @RequestHeader(value="authorization", defaultValue="auth") String userAuth) {
		senderId="noreply.aozoratechnology@gmail.com";
		BccId="";
		ProductKeyResponse response=null;
		String result=null;		
		int dataTransferStatus =-1;
			try {
			if (WebServiceUtility.isUserAuthenticated(userAuth)) {
				if( emailDetailsBean.getRecevierId()!=null ) {
					//System.out.println("emailId:"+emailId);					
					RecevierId=emailDetailsBean.getRecevierId();
					 result=fetchKeyService.fetchNewActivationKey();
						if(result!=null){
							String body	= "<p><span class=\"style2\"><em><strong>Dear User,</strong></em></span></p>\r\n" + 
									"<p><em><br /></em><em>Welcome to the Shinrai family ! By making this purchase,you've taken <br/>"
									+ "an important step towards securing and optimizing your PC.<br/>Please find below details of your purchase along with the key which you would need to activate your purchase.</em></p>" + 
									"<p><em><br/><em>Your OC cleaner License key -  <strong>" +result+ "</strong> <br /></em><br /></p>\r\n" + 
									"<p><em>In case of any queries, please write to: <a href=\"#\">ordinateurcleaner@gmail.com</a></em><br /><br /></p>\r\n" + 
									"<p><strong><span class=\"style2\">Regards,<br />Shinrai Online Business Pvt. Ltd</span></strong><br /></p>\r\n" + 
									"<br /><br />\r\n" + 
									"<p style=\"font-size:12px;\"><strong>NOTE:-</strong>This is a system generated email.Please do not reply to this email.</p>";
							try {
								int status=sendMailhtml(senderId,RecevierId, "Welcome to Shinrai Family", body,BccId);
								if(status==200) {
									fetchKeyService.updateValidateKeyStatus(result,2,RecevierId);
									dataTransferStatus=1;
								}
								
							} catch (Exception e) {
								e.printStackTrace();
								dataTransferStatus=-3;
							   }
							
							}
				}
				else {
					dataTransferStatus=-2;
				    }
						  
				}
			else
				dataTransferStatus=409;
				
				switch (dataTransferStatus) {
				case -1:
					response = new ProductKeyResponse(dataTransferStatus, "Please contact with Admin");
					break;
				case -2:
					response = new ProductKeyResponse(dataTransferStatus, "Invalid parameter provided.Please check the parameter");
					break;
				case -3:
					response = new ProductKeyResponse(dataTransferStatus, "Email not sent kindly contact to Admin");
					break;
				case 1:
					response = new  ProductKeyResponse(dataTransferStatus,result);
					break;
				case 409:
					response = new ProductKeyResponse(dataTransferStatus,"Sorry ! User Authentication failed.");
					break;
				default:
					break;
				}
			 }
			catch(Exception e){
				System.out.println("Error occured while updating  key status !!");
				e.printStackTrace();
				response = new ProductKeyResponse(dataTransferStatus, "Error occured while fetching details!!");
			}
			/*ObjectMapper mapper = new ObjectMapper();
			String jsonInString="";
			try {
				jsonInString = mapper.writeValueAsString(response);
			} catch (JsonGenerationException e1) {
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//logger.info("Response : Single Window CAF fetchLicenseDetails : "+jsonInString);
			System.out.println("Response : Single Window fetchLicenseDetails : "+jsonInString);*/
			
		 return new ResponseEntity<ProductKeyResponse>(response, HttpStatus.OK);
	}
	
	//@GetMapping("/checkCurrentVersion/{version}")
	@RequestMapping(value = "/checkCurrentVersion/{version}", method = RequestMethod.GET)
    public ResponseEntity<ProductKeyResponse> checkCurrentVersion( @PathVariable int version,@RequestHeader(value="authorization", defaultValue="auth") String userAuth) {
		//Map<String, String> response=new HashMap<>();
		ProductKeyResponse response=null;			
		int dataTransferStatus =-1;
		int currentVersion=3;
			try {
			if (WebServiceUtility.isUserAuthenticated(userAuth)) {
				if( version !=0){	
					if(version < currentVersion)						
						dataTransferStatus=1;				
			     }
				}
			else
				dataTransferStatus=409;
				
				switch (dataTransferStatus) {
				case -1:
					response = new ProductKeyResponse(dataTransferStatus, "Wrong Version Provided");
					
					break;
		
				case 1:
					response = new  ProductKeyResponse(WebServiceUtility.fetchCurrentVersion(),"Success");
					
					break;
				case 409:
					response = new ProductKeyResponse(dataTransferStatus,"Sorry ! User Authentication failed.");
					
					break;
				default:
					break;
				}
			 }
			catch(Exception e){
				System.out.println("Error occured while fetching key details!!");
				e.printStackTrace();
				//response.put("kjhjk", "asdasd");
				response = new ProductKeyResponse(dataTransferStatus, "Error occured while fetching key details!!");
			}
			/*ObjectMapper mapper = new ObjectMapper();
			String jsonInString="";
			try {
				jsonInString = mapper.writeValueAsString(response);
			} catch (JsonGenerationException e1) {
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		//	logger.info("Response : Single Window CAF fetchLicenseDetails : "+jsonInString);
			System.out.println("Response : Single Window fetchLicenseDetails : "+jsonInString);*/
	    //return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
		return new ResponseEntity<ProductKeyResponse>(response, HttpStatus.OK);
			//return response;
	}
	
	/*public void sendMailWithBCC(String senderId, String recieverId, String subject, String messageBody,String bccId) {
		
		SimpleMailMessage message = new SimpleMailMessage();	
		message.setFrom(senderId);
		message.setTo(recieverId);
		message.setSubject(subject);
		message.setBcc(bccId);
		message.setText(messageBody);
		emailSender.send(new MimeMessagePreparator(){
			public void prepare(MimeMessage mimeMessage) throws MessagingException {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8"); 	
				message.setFrom(from);
				message.setTo(to);
				message.setSubject(sub);
				message.setText(msgbody, true);
				//message.setText(plainText, htmlText);
				
				System.out.println("message set properly");
				}
			});
		System.out.println("Message sent successfully!!!");
	
	}*/
	
	
	public int sendMailhtml(String senderId, String recieverId, String subject, String messageBody,String ccId) {
		final String from=senderId;
		final String to=recieverId;
		final String sub=subject;
		final String msgbody= messageBody;
		//final String cc= ccId;
		int status=0;
		System.out.println("in sendMailhtml");
		try {
			emailSender.send(new MimeMessagePreparator(){
			public void prepare(MimeMessage mimeMessage) throws MessagingException {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8"); 	
				message.setFrom(from);
				message.setTo(to);
				//message.setBcc(cc);
				message.setSubject(sub);
				message.setText(msgbody, true);
				//message.setText(plainText, htmlText);
				
				System.out.println("message set properly");
				}
			});
			status=200;
		} catch (MailException e) {
			e.printStackTrace();
			status=-200;
		}
		System.out.println("Message sent successfully!!!");
		return status;
	}


	public String getSenderId() {
		return senderId;
	}


	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}


	public String getRecevierId() {
		return RecevierId;
	}


	public void setRecevierId(String recevierId) {
		RecevierId = recevierId;
	}


	public String getBccId() {
		return BccId;
	}


	public void setBccId(String bccId) {
		BccId = bccId;
	}


}
