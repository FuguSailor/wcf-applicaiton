# Getting Started

This was a project created from scratch while reading tutorials and using the Spring.io tool to create the Spring project. The Angular portion was added later also using the Angular tool to create that project.

Due to CORS border issues while running the Spring Boot app on port 8080 and the Angular server on port 4200, I was not able to completely get the client server part to work. Setting up a proxy to fix it is beyond my current skill set. I used to resolve this in other systems by adding a server side service that would make the call to the remote API and return the JSON result to the Ajax caller.

The Angular app can be tested by opening a terminal/command window and navigating to the wcf\src\main\frontend-app\src\app folder and running the "ng serve" command then opening a browser windo at http://localhost:4200

The Spring Boot app can be run by using the IDE's run command on the WcfApplication class then opening a browser window to http://localhost:8080/feature

Again, because of the CORS issue, I didn't fully flush out the PUT method. That would be a TODO item.

Also on the TODO list would be to pretty up the UI for the Angular page and add responsive styling. This would be a few more days of work but is not a big deal to do as well as some data validation for the date filed. I did not require the priority to be unique across requests because users tend to think their request is most important. Another possible add would be to lot allow users to change someone else's request and only give the right to change all to an administrator.

Because this is more of a sample of what I can do, I didn't go too wild and try to cover every possible issue. That could make this a rather large project and since it is said that it should just be a three hour exercise, I kept this simple.
This was also a learning exercise for me. I have not created either a Spring Boot or Angular project from scratch before. In the past, I had only added features to someone else's project.