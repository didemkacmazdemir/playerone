# playerone


There are two players and they are working independent program,

First clone project to your classpath,

Secondly make server setting like "-Xms2G -Xmx2G -Dserver.port=8087", i used intellij idea for creating project and i make this operation following these steps
Run tab -> plus sign -> select Spring Boot-> from Environment tab -> set VM options,

After making playertwo adjustments and then start playertwo application before starting playerone application.

After playertwo starting, you can start playerone application. You can generate random number or you can type an input to play,

You can see the result from command line.


The Challenge

Game of Three - Coding Challenge Goal The Goal is to implement a game with two independent units – the players – communicating with each other using an API. Description When a player starts, it incepts a random (whole) number and sends it to the second player as an approach of starting the game. 

The receiving player can now always choose between adding one of { 1, 0, 1} to get to a number that is divisible by 3. Divide it by three. The resulting whole number is then sent back to the original sender.

The same rules are applied until one player reaches the number 1(after the division). 
For each "move", a sufficient output should get generated (mandatory: the added, and the resulting number). Both players should be able to play automatically without user input. The type of input (manual, automatic) should be optionally adjustable by the player. Notes 

● Each player runs on its own (independent programs, two browsers, web-workers, ...). 

● Communication via an API (REST, Sockets, WebRTC, ...). 

● A player may not be available when the other one starts.

● If you are applying for a frontend position, think of a fancy easily configurable layout. Otherwise terminal output is okay. 

● Please share your project on GitHub and send us the link.

● Try to be platform independent, in other words the project must be runnable easily in every environment. Hints 

● Check configurability 

● Review your concepts from DDD 

● Watch out for the anemic domain model 

● Using events will be considered a plus
