User
- id
- name
- email
- password
- Profile
- List<User> connections
- List<Message> inbox
- List<Message> sentMessages
- List<Notification> notifications
- List<ConnectionRequest> requests

AccountManager
- login(String email, String password)
- register(String email, String name, String password)
- logout()
- updateProfile()

Profile
- pic: URL
- headline
- summary
- List<Experience> 
- Educational
- List<Skill>

Experience
- title
- company
- startYear
- endYear


Education
- startYear
- endYear
- institution
- degree
- stream

Skill
- name

ConnectionRequest
- sender
- receiver

Message
- sender
- receiver
- title
- description

enum ConnectionResponseType
- ACCEPT
- REJECT

Job:
- company
- title 
- description
- requirement
- location
- List<User> appliedBy

Notification
- id
- type
- content
- userId
- isRead : bool
- createdAt

NotificationType
- CONNECTION_REQUEST
- MESSAGE
- JOB_POSTING

Linkedin
- Map<String, User> userMap
- Map<String, List<User>> connectionsGraph
- search()

ConnectionManager
- sendConnectionRequest(User sender, User user)
- respondConnectionRequest(ConnectionRequest request, User user, ConnectionResponseType responseType);


Requirements

User Registration and Authentication:

Users should be able to create an account with their professional information, such as name, email, and password.
Users should be able to log in and log out of their accounts securely.
User Profiles:

Each user should have a profile with their professional information, such as profile picture, headline, summary, experience, education, and skills.
Users should be able to update their profile information.
Connections:

Users should be able to send connection requests to other users.
Users should be able to accept or decline connection requests.
Users should be able to view their list of connections.
Messaging:

Users should be able to send messages to their connections.
Users should be able to view their inbox and sent messages.
Job Postings:

Employers should be able to post job listings with details such as title, description, requirements, and location.
Users should be able to view and apply for job postings.
Search Functionality:

Users should be able to search for other users, companies, and job postings based on relevant criteria.
Search results should be ranked based on relevance and user preferences.
Notifications:

Users should receive notifications for events such as connection requests, messages, and job postings.
Notifications should be delivered in real-time.
Scalability and Performance:

The system should be designed to handle a large number of concurrent users and high traffic load.
The system should be scalable and efficient in terms of resource utilization.

====================================================

1. LinkedInService

Fields: List users, List jobPostings, List connections, List notifications
Methods: registerUser(User), addConnection(User, User), postJob(JobPosting), sendMessage(User, User, String), sendNotification(Notification), searchUsers(String), searchJobs(String), etc.
2. User

Fields: int id, String name, Profile profile, List connections, List messages, List notifications
Methods: sendConnectionRequest(User), acceptConnection(Connection), sendMessage(User, String), addSkill(Skill), addEducation(Education), addExperience(Experience), etc.
3. Profile

Fields: List skills, List education, List experience
4. Connection

Fields: int id, User user1, User user2, boolean isAccepted
5. JobPosting

Fields: int id, String title, String description, User postedBy
6. Message

Fields: int id, User sender, User receiver, String content
7. Notification

Fields: int id, User recipient, String message, NotificationType type
8. NotificationType (enum)

Values: CONNECTION_REQUEST, JOB_MATCH, MESSAGE, etc.
9. Skill

Fields: String name
10. Education

Fields: String institution, String degree, String fieldOfStudy, int startYear, int endYear
11. Experience

Fields: String company, String title, int startYear, int endYear