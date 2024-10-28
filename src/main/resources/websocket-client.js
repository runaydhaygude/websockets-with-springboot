// Import the SockJS and STOMP libraries for WebSocket communication
const SockJS = require('sockjs-client'); // Library for fallback WebSocket connections
const Stomp = require('stompjs'); // Library for STOMP protocol over WebSocket

// Create a SockJS connection to the WebSocket server
const socket = new SockJS('http://localhost:8080/runay-chat-app'); // Replace with your WebSocket endpoint
const stompClient = Stomp.over(socket); // Create a STOMP client over the SockJS connection

// Establish the STOMP connection
stompClient.connect({}, (frame) => {
    console.log('Connected: ' + frame); // Log successful connection to the console

    // Subscribe to the '/topic/guest-chats' topic to receive messages
    stompClient.subscribe('/topic/guest-chats', (message) => {
        console.log('Received message: ' + message.body); // Log received message body
    });

    // Sending a message to the '/app/guest-chat' endpoint
    stompClient.send('/app/guest-chat', {}, JSON.stringify({ message: 'Hello, World!' }));
    // The first parameter is the destination for the message,
    // the second parameter is for any headers (empty in this case),
    // and the third parameter is the message payload as a JSON string
}, (error) => {
    console.error('Connection error: ' + error); // Log any connection errors
});

