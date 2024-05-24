# JAPAN TIME

The goal of the task is to:
- BACKEND
  - implement a backend service that deliver the current date and time in Japan as a json string
  - At least unit test the service

- FRONTEND
    - One screen displaying hours in 2 timezones
      - The one coming from server (JAPAN)
      - The browser's time zone         
    - At least unit test the screen

- MORE
    - put in one git repository
    - write docker files for both backend end frontend
    - write a README explaining how all of this work and the encountered problems
    - provide a link to a github repository with the code

###  THE SOLUTION
The source code can be found here: [https://github.com/paulwontcheu/japantime](https://github.com/paulwontcheu/japantime)
- BACKEND
    - Technologies: 
      - SPRING BOOT
      - JUNIT  
      - GRADLE
    - E2E tested (no unit test done, since the main use case was covered by the e2e tests)      
    - Dockerfile provided

- FRONTEND
    - Technologies: 
      - VUE 3 with 100% Composition API and Typescript
      - TAILWINDCSS 
      - Jest
      - Cypress        
    - TESTS
      - E2E Tested with cypress    
      - Unit tested using jest 
    - Dockerfile provided

#### HOW TO LAUNCH
- move the repository root directory
- build the jar file with gradle
  - install gradle (at least version 6.8) if necessary
  - move to the folder "backend"
  - gradle bootJar    
- execute the command: `docker-compose up`
- open the browser and navigate to (http://localhost/)


#### HOW TO RUN THE TEST
- BACKEND
  - run the gradle task "test": `gradle test`
- FRONTEND  
  - E2E
    - move to test/e2e
    - execute `npm run test`
  - UNIT TEST
      - execute this command from the project directory `npm run test`
    
- build the jar file with gradle
    - install gradle (at least version 6.8) if necessary
    - move to the folder "backend"
    - gradle bootJar
- execute the command: `docker-compose up`
- open the browser and navigate to (http://localhost/)


#### Encountered Difficulties
It took me my sunday to resolve it  :-D. No major issues were encountered.  
