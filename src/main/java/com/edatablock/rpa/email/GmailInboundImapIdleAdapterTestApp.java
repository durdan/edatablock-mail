/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.edatablock.rpa.email;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class GmailInboundImapIdleAdapterTestApp {
	//private static Log logger = LogFactory.getLog(GmailInboundImapIdleAdapterTestApp.class);


//	public static void main (String[] args) throws Exception {
//		@SuppressWarnings("resource")
//		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
//				"/META-INF/spring/integration/gmail-imap-idle-config.xml");
//		DirectChannel inputChannel = ac.getBean("receiveChannel", DirectChannel.class);
//		inputChannel.subscribe(new MessageHandler() {
//			@Override
//			public void handleMessage(Message<?> message) throws MessagingException {
//				logger.info("Message: " + message);
//			}
//		});
//	}

	private static final Log LOGGER = LogFactory.getLog(GmailInboundImapIdleAdapterTestApp.class);

	private static final String HORIZONTAL_LINE =
			"\n=========================================================";

	private GmailInboundImapIdleAdapterTestApp() { }

	/**
	 * Load the Spring Integration Application Context
	 *
	 * @param args - command line arguments
	 */
	public static void main(final String... args) {

		LOGGER.info(HORIZONTAL_LINE
				+ "\n"
				+ "\n          Welcome to Spring Integration!                 "
				+ "\n"
				+ "\n    For more information please visit:                   "
				+ "\n    http://www.springsource.org/spring-integration       "
				+ "\n"
				+ HORIZONTAL_LINE );

		final AbstractApplicationContext ac =
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/integration/gmail-imap-idle-config.xml");
//		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
// 				"/META-INF/spring/integration/gmail-imap-idle-config.xml");

		ac.registerShutdownHook();

		final Scanner scanner = new Scanner(System.in);


		LOGGER.info(HORIZONTAL_LINE
				+ "\n"
				+ "\n    Please press 'q + Enter' to quit the application.    "
				+ "\n"
				+ HORIZONTAL_LINE );

	//	DirectChannel inputChannel = ac.getBean("inboundChannel", DirectChannel.class);
		System.out.println("*88888888");

//		inputChannel.subscribe(new MessageHandler() {
//			@Override
//			public void handleMessage(Message<?> message) throws MessagingException {
//				System.out.println("Message:****************** " + message);
//				LOGGER.info("Message:888888888888888888Moore112017 " + message);
//
//			}
//		});
//		inputChannel.subscribe(new MessageHandler() {
//
//			@Override
//			public void handleMessage(Message<?> message) throws MessagingException {
//				LOGGER.info("Message: " + message);
//				System.out.println("Message: " + message);
//				final List<EmailFragment> emailFragments = new ArrayList<EmailFragment>();
//				final MimeMessage mailMessage = (MimeMessage) message;
//
//					//final MimeMessage mailMessage = wiserMessage.getMimeMessage();
//					EmailParserUtils.handleMessage(null, mailMessage, emailFragments);
//
//				for (EmailFragment emailFragment : emailFragments) {
//					System.out.println(emailFragment.getFilename());
//				}
//
//
//
//			}
//		});
		while (true) {

			final String input = scanner.nextLine();

			if("q".equals(input.trim())) {
				break;
			}

		}

		LOGGER.info("Exiting application...bye.");

		scanner.close();
		ac.close();

	}



}
