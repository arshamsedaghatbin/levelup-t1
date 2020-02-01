level-up_task_1

A command line program that accepts the string and post it to the endpoint (e.g https://jsonplaceholder.typicode.com/)
        - The string can contain markdown/html and you have to sanitize it  
        - The string can contain Invalid character (e.g !@#$%^&*) and you have to sanitize it
build project
mvn package -Dmaven.test.skip=true
run project
java -jar -Dthird-party-url="https://jsonplaceholder.typicode.com/posts" -Dhtml-text="[sample text]" target/tesk1-0.0.1-SNAPSHOT.jar arsham
