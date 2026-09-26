# Client-Server-Hangman-Game
# Java Hangman Game – Client-Server Application

This project is a GUI-based Hangman game developed in Java, designed using a TCP-based client-server architecture. The application combines interactive graphical interfaces, network communication, database integration, administrative functionality, session management, and game logic to create a complete multiplayer-ready game system.

The project consists of two major components: the server-side application and the client-side application. The server acts as the central communication and data-management layer, accepting TCP connections from clients and processing requests. It manages communication between players, maintains game-related information, handles user sessions, and interacts with the database for persistent data storage.

The server side also includes an administrative interface that allows authorized administrators to manage game data through complete CRUD (Create, Read, Update, Delete) operations. Administrators can add new records, retrieve existing information, update data, and remove unnecessary records. The server is responsible for establishing and managing the database connection while ensuring that client requests are processed appropriately.

The client-side application provides the player experience through a visually interactive Java GUI. Players can connect to the server and participate in Hangman games by guessing letters and attempting to identify the hidden word before their available attempts are exhausted. The graphical interface dynamically displays game progress, guessed letters, incorrect attempts, remaining chances, and the current game status, making the gameplay interactive and easy to follow.

The application also incorporates score maintenance and session management. Player scores can be tracked based on their gameplay, while session information is maintained throughout the client's interaction with the server. This allows the application to preserve relevant player and game information during an active session.

From a software engineering perspective, the project demonstrates practical implementation of Java object-oriented programming, GUI development, TCP socket programming, client-server communication, database connectivity, CRUD operations, session handling, exception handling, and separation of client and server responsibilities.

Overall, this project demonstrates how multiple software components can be integrated into a functional distributed application. It provides practical experience in developing a networked Java application where the client focuses on an interactive user experience while the server manages centralized communication, business logic, persistence, administration, and game-related data.
