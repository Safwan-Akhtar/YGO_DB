# YGO_DB

[Project presentation](https://docs.google.com/presentation/d/1bmL6rqPrNFWL-cw936RD6eQ8AvoLNyhJDqbl7uZS_JE/edit?usp=sharing)

This application to allow users to make their own card database and construct decks from it.
The project make use of various technological tools such as Github, Jenkins, Google Cloud Platform (GCP), MySQL database/ h2 database, SonarQube, Nexus, Java, Spring, Javascript, CSS, HTML, JUnit, and Mockito.

Kanban board can be found on Github attached to this project.

Selenium testing and Surefire reports are yet to be done.

## Set Up.
The following instructions will be allow to use the application.

1. Copy/clone this repository to you desired location.
2. Open project in your desired IDE as a maven project.
3. Set up your deired database within the application.properties file, if using MySQL replace the existing link and change the username and password to what you set up for your database.

## Testing

tests are done using Junit, Mockito, Selenium and TestNG. to run these tests simply right click the com.qa folder within the test folder and click run tests in com.qa with coverage.

## Using the app

![home1](https://user-images.githubusercontent.com/62279242/82425206-1c534f00-9a7e-11ea-87eb-46a7334bf5a7.JPG)

This is the homepage, where you can navigate to your Database or your Decks, Clicking on Deck will navigate you here:

![deckselection1](https://user-images.githubusercontent.com/62279242/82425453-718f6080-9a7e-11ea-939a-4eb4a4b82c2a.JPG)

here you can select the decks you have built or create a new deck, clicking on your deck will navigate you here:

![deck1](https://user-images.githubusercontent.com/62279242/82425594-a0a5d200-9a7e-11ea-9bb2-805d4dd45988.JPG)

Here you can view you deck structure and view its contents,
you may also use the searchbar to serch for a card in you Database and add it to your deck alternatively you may remove cards from your deck.

![addingcards](https://user-images.githubusercontent.com/62279242/82425770-e4004080-9a7e-11ea-9d9c-b7e693f3623d.JPG)

This is the same for adding cards to your database.

## Build Tools

- Maven - Dependency Management
- Jenkins - CI Pipeline Tool
- IntelliJ - IDE
- Java - Code Base
- Github - Project Planning Kanban Board
- JUnit - Testing Tool
- Mockito - Testing Tool
- GCP/H2 - Cloud Host
- SonarQube - Static Analysis Tool
- Nexus - Artefact Repository
- Git - Version Control System
- Selenium - Automation Testing tool

### Coverage
J-Unit/ mockito: 92%

## Authors

* **Safwan Akhtar** - [Safwan-QA](https://github.com/Safwan-Akhtar) - 

## Acknowledgements

- [Nicholas Johnsonh](https://github.com/nickrstewarttds) - Main Trainer.
- [Tadas Vaidotas](https://github.com/tvaidotas) - Trainer for selenium and testing.
- [Savannah](https://github.com/savannahvaith) - Trainers for HTML, CSS, Javascripts (frontend development).
- [felix](https://github.com/Femarleycode) - provided support for code and connecting databases.
- [Christian](https://github.com/Christian-QA) - provided support for code and connecting databases.
