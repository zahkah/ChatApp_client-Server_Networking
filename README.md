# Chat Application Overview Document
![Chat Application Logo](https://example.com/logo.png "Chat App Logo")


## Project Details

### 1.1 Project Name
Chat Application

### 1.2 Description
A Java-based real-time chat application that enables users to communicate via private and public messages within a networked environment.

### 1.3 Revision History
- **Date:** 2024-08-19
- **Comment:** Initial draft created
- **Author:** Zacharie Gatare

## 1. Purpose
The chat application aims to provide seamless, real-time communication for users, facilitating both public and private interactions efficiently.

## 2. Scope
The project encompasses:
- User authentication
- Message broadcasting to all online users
- Private messaging capabilities
- Basic user management
- Future enhancements include encryption and multithreading to enhance security and performance.

## 2. System Requirements

### 2.1 Functional Requirements
- **R1:** Users must be able to log in with a unique username.
- **R2:** Users must be able to broadcast messages to all online users.
- **R3:** Users must be able to send private messages to selected users.

### 2.2 Non-Functional Requirements
- **Performance:** Support for up to 100 simultaneous users without significant performance degradation.
- **Reliability:** The server should maintain a minimum of 99.9% uptime outside of scheduled maintenance.

### 2.3 Technical Requirements
- **Software:** Developed using Java, leveraging JavaFX for the GUI and Java Sockets for networking.

### 2.4 Security Requirements
- **Authentication:** Basic authentication mechanism using usernames without passwords for simplicity in initial setup.

### 2.5 Estimates
- **Networking setup:** 10 hours
- **JavaFX GUI development:** 15 hours
- **Total:** 25 hours

### 2.6 Traceability Matrix
- **SRS Requirement R1:** Linked to SDD Module 2.3.3, 6.3
- **SRS Requirement R2:** Linked to SDD Module 2.3.1, 6.3

## 3. System Architecture

### 3.1 Overview
The system is based on a client-server architecture where the server handles multiple client connections, authentication, and message routing.

### 3.2 Architectural Diagrams
- **Component Diagram:** Shows components such as Client, Server, and Connection Handler.
- **Sequence Diagram:** Visualizes interactions for a user sending a message.
- **Class Diagram:** Outlines major classes like ChatClient, ChatServer, and UserThread.
- ![Architecture Diagram](images/architecture.png "System Architecture")


## 4. Data Dictionary

### Main Chat Window Components
- **chatListView (ListView):** Displays a list of available chat sessions.
- **messageArea (TextArea):** Area where users type their messages. Editable: true.
- **sendButton (Button):** Sends the message typed in the message area. Text: "Send".
- **messageDisplay (VBox):** Displays the conversation in the current chat. Children: dynamically added Labels.

### User List
- **userList (ListView):** List of users in the current chat session. Items: list of users.

## 6. User Interface Design

### 6.1 User Interface Design Overview
- **Chat Session List (chatListView):** Displays the session name for each chat session.
- **Message Display Area (messageDisplay):** Formats each Message with the sender's name, timestamp, and text content.
- **Message Input Area (messageArea):** Accepts text input from the user for sending messages.
- **Send Button (sendButton):** Sends content from the messageArea to the current ChatSession.
- **User List (userList):** Displays each user's username, allowing initiation of private chats.
- ![Class Diagram](./docs/images/class_diagram.png "Class Diagram")


### Additional UI Elements
- **Notifications:** System notifications for new messages or user activities.
- **User Status Indicator:** Indicates each user's online or offline status.
- **Accessibility Features:** Keyboard shortcuts, support for screen readers, and high-contrast themes.

### Styling and Theming
- **Color Scheme:** A consistent and soothing color palette.
- **Fonts:** Legible fonts with adjustable sizes.
- **Responsive Design:** Adjusts to different screen sizes and resolutions.

### Benefits
- **Knowledge Transfer:** Mitigates the "Bus Factor" by ensuring that essential knowledge is shared among all team members.
- **Clarity and Direction:** Provides a clear, well-defined project plan and scope.
- **Documentation:** Serves as reference material and a historical record of decisions, scope changes, and design rationale.
- **Feedback Loop:** Enables early feedback from stakeholders and identifies potential risks early in the development process.
