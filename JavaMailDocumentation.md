Java Mail Documentation

The Java Mail API allows the developers to add mailing functionalities to their java applications. In this section we will introduce you with the Java Mail API.


Mailing protocols

Generally four protocols are used to send and receive Emails:

Simple Mail Transfer Protocol (SMTP):
SMTP is used to deliver Email to the recipient mail server. Java mail Application communicates with company’s or user’s ISP (Internet service provider) SMTP server, that SMTP Server will transfer the message to recipient SMTP Server.


How does Email works
Posted on: December 19, 2008
Each Internet domain has email Server, when a user sends an Email?
How does Email works



Each Internet domain has email Server, when a user sends an Email…

> Email client Program sends the message to Email server.
> Email server contact to the Recipient’s Email server provided in the Email address.
> Email server checks that user name is valid or not.
> If found valid send email to the address’s email server.
> When recipient log on his mail account, gets his Email.

Mailing protocols

Basically, a protocol represents standard method used at each end of a communication channel, in order to properly transmit information.

Generally four protocols are used to send and receive Emails:

Simple Mail Transfer Protocol (SMTP):
SMTP is used to deliver Email to the recipient mail server. Java mail Application communicates with company’s or user’s ISP (Internet service provider) SMTP server, that SMTP Server will transfer the message to recipient SMTP Server.

POP (Post Office Protocol 3):
This protocol defines a single mailbox for a single user and a standardized way for users to access mailboxes and download messages to their computers as well. This provides facility to users to retrieve e-mail when connected. Once the messages are downloaded from the server, you can disconnect the Internet connection and read your mail.

IMAP (Internet Message Access Protocol):
IMAP is a client/server most advanced protocol in which Email is received and held for user by his Internet server. It supports both connected and disconnected modes of operation, allows multiple clients to access the same mailbox and provides server side searches.



Sending message using Java Mail

A client create new message by using Message subclass. It sets attributes like recipient address and the subject, and inserts the content into the Message object, and inserts the content into the Message object. Finally, it sends the Message by invoking the Transport.send() method.

The Transport class models the transport agent that routes a message to its destination addresses. This class provides methods that send a message to a list of recipients. Invoking the Transport.send() method with a Message object identifies the appropriate transport based on its destination addresses.

Reading message using Java Mail


All messages are stored in Folder objects. A folder can contain folders or messages or both. The Folder class declares methods that fetch, append, copy and delete messages. These are some of the methods used in the program.

System.getProperties() this method get the  system properties.
Session.getDefaultInstance(properties) this method get the default Session object.
session.getStore("pop3") this method get a Store object that implements the pop3 protocol.
store.connect(host, user, password) Connect to the current host using the specified username and password.
store.getFolder("inbox") create a Folder object of the inbox.
folder.open(Folder.READ\_ONLY) open the Folder.
folder.getMessages() get all messages for the folder.


Sending Email with Attachment

A client create new message by using Message subclass. It sets attributes like recipient address and the subject, and inserts the content into the Message object, and inserts the content into the Message object, and add attachment in the content and Finally, it sends the Message by invoking the Transport.send() method.