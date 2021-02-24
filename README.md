# TradeRevTasks
# Here are the steps on how I execute my automation:
# step 1 : Create Maven project on Intellij IDE
# Step 2 : Go to pom.XML , and import dependencies such as seleniumhq,bonigarcia(Webdrivermanager),testNG etc.
# Step 3 : Reload the maven project to make sure everything is up and running.
# Step 4 : Create folder and class for test scenarios.
# Step 5 : I created before/after annotation and Test annotation by using TestNG to make my test scenarios organised.
# Step 6 : In total there are 3 scenarios from requirement. However I created the 4th scenario for "log the total available positions listed ".
# Step 7 : I located all the related web elements, used forEach loop for retrieving the data from UI 
# Step 8 : I used TestNG Assertion to validate the expected result to match with the actual result. 

# Test Result: 
#   There are four scenarios in total and 1 falied 3 passed. First scenario did not pass because after you click on “Canadian Opportunities”, 
#   the new window pops up. It should only show all canadian job opportunities but instead, it shows all jobs including the ones from US; So I found a bug .
#   Rest of the test scenarios passed. 
 
