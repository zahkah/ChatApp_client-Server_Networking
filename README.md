# ChatApp: Client-Server Networking

## Section 1 - Project Description

### Project Details

- **1.1 Project Name:** Chat Application
- **1.2 Description:** A Java-based real-time chat application that enables users to communicate via private and public messages within a networked environment.
- **1.3 Revision History:**
  - **Date:** 2024-07-30
  - **Comment:** Initial draft created
  - **Author:** Zacharie Gatare

## Section 2 - Overview

### 2.1 Purpose
The module aims to provide seamless real-time communication for users.


### 2.2 Scope
The project will include user authentication, message broadcasting, private messaging, and basic user management.
Future: Encryption , Multithreading

### 2.3 Requirements

#### 2.3.1 Functional Requirements
- **R1:** Users must be able to log in with a unique username.
- **R2:** Users must be able to broadcast messages to all online users.
- **R3:** Users must be able to send private messages to selected users.

#### 2.3.2 Non-Functional Requirements
- **Performance:** Support for up to 100 simultaneous users without significant performance degradation.
- **Reliability:** The server should maintain a minimum of 99.9% uptime outside of scheduled maintenance.

#### 2.3.3 Technical Requirements
- **Software:** Developed using Java, leveraging JavaFX for the GUI and Java Sockets for networking.

#### 2.3.4 Security Requirements
- **Authentication:** Basic authentication mechanism using usernames without passwords for simplicity in initial setup.

#### 2.3.5 Estimates
- **Description:** Set up server and client networking - **Time(Hrs):** 10
- **Description:** Develop and integrate JavaFX GUI - **Time(Hrs):** 15
- **Total:** 25

#### 2.3.6 Traceability Matrix
- **SRS Requirement:** R1 - **SDD Module:** 2.3.3, 6.3
- **SRS Requirement:** R2 - **SDD Module:** 2.3.1, 6.3

## Section 3 - System Architecture

### 3.1 Overview
The system is based on a client-server architecture where the server handles multiple client connections, authentication, and message routing.

### 3.2 Architectural Diagrams
- **Component Diagram:** Shows components such as Client, Server, and Connection Handler.
- **Sequence Diagram:** Visualizes interactions for a user sending a message.
- **Class Diagram:** Outlines major classes like ChatClient, ChatServer, and UserThread.

## Section 4 - Data Dictionary

### Main Chat Window Components

- **chatListView:** `ListView` - Displays a list of available chat sessions.
- **messageArea:** `TextArea` - Area where users type their messages. Editable: true.
- **sendButton:** `Button` - Sends the message typed in the message area. Text: "Send".
- **messageDisplay:** `VBox` - Displays the conversation in the current chat. Children: dynamically added Labels.

### User List (for group chats or multi-user chats)

- **userList:** `ListView` - List of users in the current chat session. Items: list of users.

## Section 6 - User Interface Design

### 6.1 User Interface Design Overview

#### Main Chat Window
- **Components:**
  - **Chat Session List (`chatListView`):**
    - **Type:** ListView
    - **Data Binding:** Binds to the ChatSessions collection, displaying the sessionName for each session.
    - **Interaction:** Selecting an item updates the messageDisplay to show messages from the selected chat session.
    - **Design:** Minimalist design, allowing users to quickly switch between different chat sessions.

  - **Message Display Area (`messageDisplay`):**
    - **Type:** VBox
    - **Data Binding:** Dynamically binds to the Messages collection of the selected ChatSession.
    - **Display:** Formats each Message with the sender's name, timestamp, and text content.
    - **Design:** Clean layout with distinct areas for each message, enhancing readability.

  - **Message Input Area (`messageArea`):**
    - **Type:** TextArea
    - **Data Handling:** Accepts text input from the user.
    - **Interaction:** Users type their messages here; the content is sent upon clicking the sendButton.
    - **Design:** Expansive area to accommodate multi-line text, featuring a simple and intuitive interface.

  - **Send Button (`sendButton`):**
    - **Type:** Button
    - **Action Handling:** Creates a Message object with the content from messageArea and sends it to the current ChatSession.
    - **Interaction:** Ensures messageArea is not empty before sending; clears the area after sending.
    - **Design:** Prominently placed next to the messageArea to facilitate ease of use.

#### User List
- **Components:**
  - **User List (`userList`):**
    - **Type:** ListView
    - **Data Binding:** Binds to the participants of the selected ChatSession, displaying each User's username.
    - **Interaction:** Allows users to initiate private chats or access user profiles from the context menu.
    - **Design:** Streamlined interface that lists users clearly, with indicators for online/offline status.

### Additional UI Elements
- **Notifications:** System notifications for new messages or user activities.
- **User Status Indicator:** A small icon or text near the user’s name in the user list, indicating their online or offline status.
- **Accessibility Features:** Keyboard shortcuts for navigating the chat UI, support for screen readers, and high-contrast themes for users with visual impairments.

### Styling and Theming
- **Color Scheme:** A consistent and soothing color palette that reduces eye strain during extended use.
- **Fonts:** Legible fonts with adjustable sizes to cater to users with different visual preferences.
- **Responsive Design:** The UI adjusts gracefully to different screen sizes and resolutions, ensuring a uniform experience across devices.

### Benefits

#### Knowledge Transfer:
- **Mitigate the "Bus Factor":** Ensures work continuity if a key member is unavailable.
- **Onboarding New Members:** Provides essential background for new team members.

#### Learning and Development
- **Educational Resource:** Serves as a learning tool for all team members.
- **Mentorship Opportunity:** Allows senior engineers to mentor less experienced team members.

#### Clarity and Direction
- **Clear Plan:** Reduces ambiguity with a well-defined project plan.
- **Defined Scope:** Manages expectations.
- **Collaborative Input:** Encourages team input, addressing ideas and concerns early.

#### Documentation
- **Reference Material**
- **Historical Record:** Keeps a record of decisions, scope changes, and design rationale.

#### Feedback Loop
- **Early Feedback:** Enables early feedback from stakeholders and team members.
- **Risk Mitigation:** Identifies potential risks and strategies early in the process.
