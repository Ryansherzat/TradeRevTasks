# TradeRevTasks
# Here is step how to execute my automation:
# step 1 : Create Maven project on Intellij IDE
# Step 2 : Go to pom.XML , and import dependencied such as seleniumhq,bonigarcia(Webdrivermanager),  testNG etc.
# Step 3 : Reload the maven project, make sure everything is up and running.
# Step 4 : Create folder and class for test scenario
# Step 5 : I created before/after annotation and Test annotation by using TestNG to make my test scenarios organised.Selenium as my web driver
# Step 6 : There are totally 3 scenarios from requirement. However I create 4th scenario for "log the total available positions listed ".
# Step 7 : I located related web elements, used forEach loop for retrieving the data from UI 
# Step 8 : I used TestNG Assertion to validate the expected result match with actual result. 

# Test Resutl: 
#   There are total four scenarios : 1 falied 3 passed. First scenario did not pass, because after you click on “Canadian Opportunities”, 
#   the new window pop up. It should only show all canadian job opportunities, but it shows all jobs even from US. So I found a bug .
#   Rest of the test scenarios passed. 
 
